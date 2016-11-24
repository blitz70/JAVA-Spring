package com.iamtek.after;

public class Triangle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Triangle setter");
    }

    public String setName2(String name) {
        this.name = name;
        System.out.println("Triangle setter2");
        return this.name;
    }

}
