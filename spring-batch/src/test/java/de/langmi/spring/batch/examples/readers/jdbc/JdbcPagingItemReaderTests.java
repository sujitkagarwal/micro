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
package de.langmi.spring.batch.examples.readers.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.HsqlPagingQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 * Some tests to grok the behaviour of the {@link JdbcPagingItemReader}.
 *
 * @author Michael R. Lange <michael.r.lange@langmi.de>
 */
public class JdbcPagingItemReaderTests {

    private static final String DROP_TEST_TABLE = "DROP TABLE TEST IF EXISTS;";
    private static final String CREATE_TEST_TABLE = "CREATE TABLE TEST (ID INTEGER GENERATED BY DEFAULT AS IDENTITY, NAME VARCHAR (100))";
    private static final String INSERT = "INSERT INTO TEST (NAME) VALUES (?)";
    private static final int EXPECTED_COUNT = 20;
    private BasicDataSource dataSource;

    @Test
    public void testWithoutFactory() throws Exception {
        // setup queryProvider
        HsqlPagingQueryProvider queryProvider = new HsqlPagingQueryProvider();
        queryProvider.setSelectClause("select ID, NAME");
        queryProvider.setFromClause("from TEST");
        queryProvider.setWhereClause("where NAME <> 'foo'");
        queryProvider.setSortKey("ID");
        // call init to imitate spring context startup behaviour
        queryProvider.init(dataSource);

        // setup reader
        JdbcPagingItemReader<String> reader = new JdbcPagingItemReader<String>();
        reader.setDataSource(dataSource);
        reader.setQueryProvider(queryProvider);
        reader.setRowMapper(new ParameterizedRowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("NAME");
            }
        });
        reader.setPageSize(2);

        // needed call, normally done at spring application context startup
        reader.afterPropertiesSet();

        reader.open(MetaDataInstanceFactory.createStepExecution().getExecutionContext());
        // read
        try {
            int count = 0;
            String line;
            while ((line = reader.read()) != null) {
                assertEquals(String.valueOf(count), line);
                count++;
            }
            assertEquals(EXPECTED_COUNT, count);
        } catch (Exception e) {
            throw e;
        } finally {
            reader.close();
        }
    }

    @Test
    public void testWithFactory() throws Exception {
        // setup queryProviderFactory
        SqlPagingQueryProviderFactoryBean factory = new SqlPagingQueryProviderFactoryBean();
        factory.setDataSource(dataSource);
        factory.setDatabaseType("HSQL");
        factory.setSelectClause("select ID, NAME");
        factory.setFromClause("from TEST");
        factory.setWhereClause("where NAME <> 'foo'");
        factory.setSortKey("ID");        
        PagingQueryProvider queryProvider = (PagingQueryProvider) factory.getObject();
        // call init to imitate spring context startup behaviour        
        queryProvider.init(dataSource);
        
        // setup reader
        JdbcPagingItemReader<String> reader = new JdbcPagingItemReader<String>();
        reader.setDataSource(dataSource);
        reader.setQueryProvider(queryProvider);
        reader.setRowMapper(new ParameterizedRowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("NAME");
            }
        });
        reader.setPageSize(2);

        // needed call, normally done at spring application context startup
        reader.afterPropertiesSet();

        reader.open(MetaDataInstanceFactory.createStepExecution().getExecutionContext());
        // read
        try {
            int count = 0;
            String line;
            while ((line = reader.read()) != null) {
                assertEquals(String.valueOf(count), line);
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
     * Setup Datasource and create table for test.
     *
     * @throws Exception 
     */
    @Before
    public void setUp() throws Exception {
        // DataSource Setup, apache commons 
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        
        // drop table if exists
        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        st.execute(DROP_TEST_TABLE);
        conn.commit();
        st.close();
        conn.close();

        // create table
        conn = dataSource.getConnection();
        st = conn.createStatement();
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
     * Shutdown HSQLDB properly.
     *
     * @throws Exception 
     */
    @After
    public void tearDown() throws Exception {
        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        st.execute("SHUTDOWN");
        conn.commit();
        st.close();
    }
}
