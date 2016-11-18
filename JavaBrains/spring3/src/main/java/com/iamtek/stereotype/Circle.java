package com.iamtek.stereotype;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
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
