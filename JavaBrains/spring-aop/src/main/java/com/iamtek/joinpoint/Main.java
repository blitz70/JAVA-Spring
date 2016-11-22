package com.iamtek.joinpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016-11-22.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-joinpoint.xml");
        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
        System.out.println(shapeService.getTriangle().getName());
        shapeService.getTriangle().setName("New Triangle");
        System.out.println(shapeService.getTriangle().getName());

    }

}
