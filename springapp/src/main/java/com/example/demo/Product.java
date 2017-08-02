package com.example.demo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Osman on 1.08.2017.
 */
@XmlRootElement
public class Product {
    private String name;
    private String vesion;
    private int intVal;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getVesion() {
        return vesion;
    }

    public Product setVesion(String vesion) {
        this.vesion = vesion;
        return this;
    }

    public int getIntVal() {
        return intVal;
    }

    public Product setIntVal(int intVal) {
        this.intVal = intVal;
        return this;
    }
}
