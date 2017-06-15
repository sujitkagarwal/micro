package com.test;

/**
 * Created by sujitagarwal on 24/03/17.
 */
public class TestLambda {


    public static void main(String[] args) {
        Runnable r1=() -> System.out.println("i am in runnable");

        Thread th=new Thread(r1);
        th.start();

        Addition addition=(a,b) -> a + b;
        System.out.println(addition.add(10,6));

    }
}
