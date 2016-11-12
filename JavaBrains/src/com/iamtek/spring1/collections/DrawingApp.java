package com.iamtek.spring1.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/iamtek/spring1/spring-collections.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();

    }

}
