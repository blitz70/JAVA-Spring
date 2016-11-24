package com.iamtek.aopproxy;

public class MyFactory {


    public Object getBean(String beanName) {

        Object bean = null;
        if(beanName.equals("shapeService")) bean = new ShapeService();
        if(beanName.equals("circle")) bean = new Circle();
        if(beanName.equals("triangle")) bean = new Triangle();
        if (beanName.equals("myAspect")) bean = new MyAspect();
        return bean;

    }

}
