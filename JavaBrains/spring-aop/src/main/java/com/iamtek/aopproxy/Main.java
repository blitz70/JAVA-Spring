package com.iamtek.aopproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        /*ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aopproxy.xml");*/
        MyFactory factory = new MyFactory();
        ShapeService shapeService = (ShapeService) factory.getBean("shapeService");
        shapeService.getCircle();
        System.out.println(shapeService.getCircle().getName());

    }

}
