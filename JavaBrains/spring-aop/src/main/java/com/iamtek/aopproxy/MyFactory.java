package com.iamtek.aopproxy;

public class MyFactory {


    public <T> T getBean(String beanName) {

        T bean = null;
        if (beanName.equals("shapeService")) bean = (T) new ShapeServiceProxy();
        if (beanName.equals("circle")) bean = (T) new Circle();
        if (beanName.equals("triangle")) bean = (T) new Triangle();
        return bean;

    }

}
