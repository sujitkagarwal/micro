package com.test;

import java.io.Serializable;

/**
 * Created by sujitagarwal on 25/03/17.
 */
public class Parent  {

    static{
        System.out.println("static parent");
    }

    {
        System.out.println("blanck parent");
    }
    public Parent()
    {
        System.out.println("Parent");
    }
}
