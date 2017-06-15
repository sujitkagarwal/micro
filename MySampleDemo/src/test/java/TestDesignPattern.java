import com.test.design.abstractfactory.PCFactory;
import com.test.design.abstractfactory.ServerFactory;
import com.test.design.factory.Computer;
import com.test.design.factory.ComputerFactory;
import com.test.design.prototype.Employees;
import org.junit.Test;

import java.util.List;

/**
 * Created by sujitagarwal on 04/04/17.
 */
public class TestDesignPattern {

    @Test
    public void factoryDesign()
    {
        Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
        Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
        System.out.println("Factory PC Config::"+pc);
        System.out.println("Factory Server Config::"+server);

    }
    @Test
    public void abstractFactoryDesign()
    {
        com.test.design.abstractfactory.Computer pc = com.test.design.abstractfactory.ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
        com.test.design.abstractfactory.Computer server = com.test.design.abstractfactory.ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);

    }
    @Test
    public void builderPatterndesign()
    {

        com.test.design.builder.Computer comp = new com.test.design.builder.Computer.ComputerBuilder(
                "500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

    }
    @Test
    public void protoTypeDesign()throws Exception
    {

        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);
    }


}
