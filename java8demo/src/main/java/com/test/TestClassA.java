package com.test;

/**
 * Created by sujitagarwal on 31/03/17.
 */
public class TestClassA {
    //TestClassA a=new TestClassA();
    public int show()
    {
        return (true ? 1 : 0);
    }

    public static void main(String[] args) {
        TestClassA testClassA=new TestClassA();
        testClassA.show();
    }

}
