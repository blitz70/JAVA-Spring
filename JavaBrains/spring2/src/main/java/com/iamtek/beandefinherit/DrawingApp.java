package com.iamtek.beandefinherit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beandefinherit.xml");
        Triangle triangle = (Triangle) context.getBean("triangle1");
        triangle.draw();
        /*triangle = (Triangle) context.getBean("triangle2");
        triangle.draw();*/
        Triangle2 triangle3 = (Triangle2) context.getBean("triangle3");
        triangle3.draw();

    }

}
