package com.test;

import java.io.Serializable;

/**
 * Created by sujitagarwal on 25/03/17.
 */
public class Child extends Parent implements Serializable {

    static{
        System.out.println("static child");
    }

    {
        System.out.println("blanck child");
    }

    public Child()
    {

        super();
        System.out.println("child");
    }
}
