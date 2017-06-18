package com.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sujitagarwal on 18/06/17.
 */
public class Test {
    public static void main(String[] args) {

        Employee employee=new Employee();
        employee.setName("a");
        Employee employee1=new Employee();
        employee1.setName("b");
        Employee employee2=new Employee();
        employee2.setName("c");

        Map<String,Employee> empMap=new HashMap<String, Employee>() ;
        empMap.put("a",employee);
        empMap.put("b",employee1);
        empMap.put("c",employee2);

       Collection<Employee> employeeCollections =empMap.values();

        Employee[] empArray= employeeCollections.toArray(new Employee[empMap.size()]);
        for (int i=0;i<empArray.length;i++)
        {
            System.out.println(empArray[i].getName());
        }


    }
}
