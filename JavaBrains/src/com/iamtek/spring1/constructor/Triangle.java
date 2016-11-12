package com.iamtek.spring1.constructor;

public class Triangle {

    private String type;
    private int height;

    public String getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }

    public void draw() {
        System.out.println(this.getType() + " Triangle drawn of height " + this.getHeight());
    }

    public Triangle(String type) {
        this.type = type;
    }

    public Triangle(int height) {
        this.height = height;
    }

    public Triangle(String type, int height) {
        this.type = type;
        this.height = height;
    }
}
