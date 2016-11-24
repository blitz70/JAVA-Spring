package com.iamtek.after;

public class Circle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        this.name = name;
        System.out.println("Circle setter");
        throw (new Exception());
    }

}
