package com.iamtek.xmlaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-xmlaop.xml");
        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
        System.out.println(shapeService.getCircle().getName());

    }

}
