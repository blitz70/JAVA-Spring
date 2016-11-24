package com.iamtek.after;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-after.xml");
        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
        try {
            shapeService.getCircle().setName("New Circle");
        } catch (Exception e) {
        }
        shapeService.getTriangle().setName("New Triangle");
        shapeService.getTriangle().setName2("New2 Triangle");

    }

}
