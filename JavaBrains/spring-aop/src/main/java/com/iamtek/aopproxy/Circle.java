package com.iamtek.aopproxy;

public class Circle {

    private String name;

    public String getName() {
        System.out.println("Circle name getter");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Circle name setter");
    }

}
