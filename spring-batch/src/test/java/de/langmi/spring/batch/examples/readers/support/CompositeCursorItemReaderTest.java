/**
 * Copyright 2011 Michael R. Lange <michael.r.lange@langmi.de>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.langmi.spring.batch.examples.readers.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.batch.item.ExecutionContext;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.batch.item.database.AbstractCursorItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.jdbc.core.RowMapper;

/**
 * CompositeItemStreamReaderTest with JdbcCursorItemReaders.
 *
 * @author Michael R. Lange <michael.r.lange@langmi.de>
 */
public class CompositeCursorItemReaderTest {

    private final CompositeCursorItemReader<String> reader = new CompositeCursorItemReader<String>();
    private static final String CREATE_TEST_TABLE = "CREATE TABLE TEST (ID INTEGER GENERATED BY DEFAULT AS IDENTITY, NAME VARCHAR (100))";
    private static final String SELECT = "SELECT NAME as name FROM TEST";
    private static final String INSERT = "INSERT INTO TEST (NAME) VALUES (?)";
    private static final int EXPECTED_COUNT = 20;
    private DataSource dataSource1;
    private DataSource dataSource2;

    @Test
    public void testRestart() throws Exception {
        // reader names
        final String readerName1 = "reader1";
        final String readerName2 = "reader2";

        // setup composite reader
        reader.setUnifyingMapper(new DefaultUnifyingStringItemsMapper());
        reader.setCursorItemReaders(new ArrayList<AbstractCursorItemReader<?>>() {

            {
                add(createJdbcCursorItemReader(dataSource1, readerName1));
                add(createJdbcCursorItemReader(dataSource2, readerName2));
            }
        });

        // open, provide "mock" ExecutionContext and fake restart scenario, 
        // it works because the name of reader is made distinct
        int alreadyRead = 2;
        ExecutionContext ec = new ExecutionContext();
        ec.put(readerName1 + "." + "read.count", alreadyRead);
        ec.put(readerName2 + "." + "read.count", alreadyRead);
        reader.open(ec);
        // read
        try {
            // this makes sure we test a restart scenario, first read item
            // should be alreadyRead, for my example files this is a "2" and
            // not the first line a "0"
            int count = alreadyRead;
            String line;
            while ((line = reader.read()) != null) {
                assertEquals(String.valueOf(count) + String.valueOf(count), line);
                count++;
            }
            // read count includes the alreadyRead items too
            assertEquals(EXPECTED_COUNT, count);
        } catch (Exception e) {
            throw e;
        } finally {
            reader.close();
        }
    }

    @Test
    public void testRead() throws Exception {
        // setup composite reader
        reader.setUnifyingMapper(new DefaultUnifyingStringItemsMapper());
        reader.setCursorItemReaders(new ArrayList<AbstractCursorItemReader<?>>() {

            {
                add(createJdbcCursorItemReader(dataSource1, "readerName1"));
                add(createJdbcCursorItemReader(dataSource2, "readerName2"));
            }
        });

        // open, provide "mock" ExecutionContext
        reader.open(MetaDataInstanceFactory.createStepExecution().getExecutionContext());
        // read
        try {
            int count = 0;
            String line;
            while ((line = reader.read()) != null) {
                assertEquals(String.valueOf(count) + String.valueOf(count), line);
                count++;
            }
            assertEquals(EXPECTED_COUNT, count);
        } catch (Exception e) {
            throw e;
        } finally {
            reader.close();
        }
    }

    /**
     * Helpermethod to create a JdbcCursorItemReader, sets the name too, to make restart
     * scenario possible - otherwise one reader would overwrite the restart data from
     * the other.
     * 
     * @param dataSource
     * @param name for restart
     * @return
     * @throws Exception 
     */
    private AbstractCursorItemReader<String> createJdbcCursorItemReader(DataSource dataSource, String name) throws Exception {
        JdbcCursorItemReader<String> jcir = new JdbcCursorItemReader<String>();
        jcir.setDataSource(dataSource);
        jcir.setSql(SELECT);
        jcir.setRowMapper(new RowMapper() {

            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
        jcir.setName(name);
        jcir.setSaveState(true);
        // jcir.afterPropertiesSet(); not mandatory yet, just checks dataSource

        return jcir;
    }

    /**
     * Setup Datasources and create table for test.
     *
     * @throws Exception 
     */
    @Before
    public void setUp() throws Exception {
        dataSource1 = createDataSource("jdbc:hsqldb:mem:foodb");
        createTableWithTestData(dataSource1);

        dataSource2 = createDataSource("jdbc:hsqldb:mem:bardb");
        createTableWithTestData(dataSource2);
    }

    /**
     * Shutdown HSQLDB properly.
     *
     * @throws Exception 
     */
    @After
    public void tearDown() throws Exception {
        tearDownDataSource(dataSource1);
        tearDownDataSource(dataSource2);
    }

    /**
     * Create a HSQLDB in-memory based datasource.
     *
     * @param url
     * @return 
     */
    private DataSource createDataSource(final String url) {
        // DataSource Setup with apache commons 
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl(url);
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }

    /**
     * Create a table and fill with some test data.
     *
     * @param dataSource
     * @throws Exception 
     */
    private void createTableWithTestData(final DataSource dataSource) throws Exception {
        // create table
        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        st.execute(CREATE_TEST_TABLE);
        conn.commit();
        st.close();
        conn.close();

        // fill with values
        conn = dataSource.getConnection();
        // prevent auto commit for batching
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement(INSERT);
        // fill with values
        for (int i = 0; i < EXPECTED_COUNT; i++) {
            ps.setString(1, String.valueOf(i));
            ps.addBatch();
        }
        ps.executeBatch();
        conn.commit();
        ps.close();
        conn.close();
    }

    /**
     * Properly tears down a HSQLDB in-memory database.
     *
     * @param dataSource
     * @throws Exception 
     */
    private void tearDownDataSource(final DataSource dataSource) throws Exception {
        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        st.execute("SHUTDOWN");
        conn.commit();
        st.close();
    }
}
