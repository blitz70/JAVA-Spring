package com.iamtek.lifecylecallback;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle implements Lifecycle, InitializingBean, DisposableBean, BeanNameAware {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private String beanName;

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

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean method called");
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean method called");
    }

    public void myStart() {
        System.out.println(beanName+".myStart method called");
    }

    public void myEnd() {
        System.out.println(beanName+".myEnd method called");
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
