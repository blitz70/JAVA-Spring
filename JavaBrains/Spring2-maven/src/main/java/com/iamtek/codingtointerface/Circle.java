package com.iamtek.codingtointerface;

public class Circle implements Shape{

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    private Point center;

    public void draw() {
        System.out.println("Circle drawn.");
        System.out.println("Center point (" + this.center.getX() + ", " + this.center.getY() +")");
    }

}
