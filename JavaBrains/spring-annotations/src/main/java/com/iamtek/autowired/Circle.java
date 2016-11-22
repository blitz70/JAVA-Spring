package com.iamtek.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {

    @Autowired
    @Qualifier("circleRelated")
    private Point center;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw() {
        System.out.println("Circle drawn.");
        System.out.println("Center point (" + this.center.getX() + ", " + this.center.getY() +")");
    }

}
