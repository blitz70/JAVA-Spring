package com.iamtek.lifecylecallback;

import org.springframework.beans.factory.BeanNameAware;

public class Point implements Lifecycle, BeanNameAware{

    private int x;
    private int y;
    private String beanName;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
