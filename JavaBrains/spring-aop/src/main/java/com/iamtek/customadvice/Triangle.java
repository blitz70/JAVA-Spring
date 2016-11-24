package com.iamtek.customadvice;

public class Triangle {

    private String name;

    @CustomAdvice
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Triangle setter");
    }

}
