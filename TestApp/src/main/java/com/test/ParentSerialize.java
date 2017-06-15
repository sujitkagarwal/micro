package com.test;

import java.io.Serializable;

/**
 * Created by sujitagarwal on 25/03/17.
 */
public class ParentSerialize implements Serializable {

    static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public ParentSerialize() {
        System.out.println("ParentSerialize");
    }

}
