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

    public Attribute(String name, List<String> values) throws IOException {
        // Initialize name
        this.name = name;
        this.values = values;
    }

    // unit test
    public static void main(String[] args) throws IOException {
        String s1 = "Service_type";
        String s2 = "Fund,Loan,CD,Bank_Account,Mortgage";
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(s2.split(",")));
        Attribute test = new Attribute(s1, list);
        System.out.println(test);
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