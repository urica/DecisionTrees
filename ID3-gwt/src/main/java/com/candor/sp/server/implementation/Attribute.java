package com.candor.sp.server.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Attribute {

    // Field name: name of the attribute
    private String name;

    // Field values: values. Store all values for the Attribute
    private List<String> values;

    public Attribute(String name, List<String> values) {
        // Initialize name
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> list) {
        this.values = list;
    }

    public String toString() {
        return "@Attribute Name: " + name + "; @Attribute Values: " + values;
    }
}