package com.iamtek.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-innerbean.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();
        triangle = (Triangle) context.getBean("NameOfTriangle!");
        triangle.draw();
        triangle = (Triangle) context.getBean("[Alias Of Triangle!]");
        triangle.draw();

    }

}
