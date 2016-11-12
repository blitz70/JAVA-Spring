package com.iamtek.spring1.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/iamtek/spring1/spring-applicationcontext.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();

    }

}
