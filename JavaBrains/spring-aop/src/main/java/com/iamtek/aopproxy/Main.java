package com.iamtek.aopproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //custom factory
        MyFactory factory = new MyFactory();
        ShapeService shapeService = factory.getBean("shapeService");

        shapeService.getCircle();

    }

}
