package com.iamtek.spring2.contextaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/iamtek/spring2/spring-contextaware.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();

    }

}
