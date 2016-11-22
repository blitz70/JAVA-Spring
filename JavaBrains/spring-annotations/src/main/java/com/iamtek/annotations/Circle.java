package com.iamtek.annotations;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape{

    private Point center;

    public Point getCenter() {
        return center;
    }

    @Required
    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw() {
        System.out.println("Circle drawn.");
        System.out.println("Center point (" + this.center.getX() + ", " + this.center.getY() +")");
    }

}
