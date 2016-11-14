package com.iamtek.contextaware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware{

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private ApplicationContext context = null;
    private String name;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public void draw() {
        System.out.println("Triangle drawn.");
        System.out.println("Point A(" + this.getPointA().getX() + ", " + this.getPointA().getY() +")");
        System.out.println("Point B(" + this.getPointB().getX() + ", " + this.getPointB().getY() +")");
        System.out.println("Point C(" + this.getPointC().getX() + ", " + this.getPointC().getY() +")");
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
        System.out.println("Get points from context");
        this.setPointA((Point) context.getBean("pointZero"));
        this.setPointB((Point) context.getBean("point2"));
        this.setPointC((Point) context.getBean("point3"));
    }

    public void setBeanName(String name) {
        this.name = name;
        System.out.println("Bean name is : " + this.name);
    }

}
