package com.test.design.abstractfactory;

/**
 * Created by sujitagarwal on 04/04/17.
 */
public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
