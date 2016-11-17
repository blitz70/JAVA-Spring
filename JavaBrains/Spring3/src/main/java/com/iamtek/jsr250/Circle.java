package com.iamtek.jsr250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Circle implements Shape {

    @Resource(name = "pointZero")
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

    @PostConstruct
    public void initCircle() {
        System.out.println("Init of Circle");
    }

    @PreDestroy
    public void destroyCircle() {
        System.out.println("Destroy of Circle");
    }

}
