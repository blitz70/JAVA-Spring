package com.iamtek.contextaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-contextaware.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();

    }

}
