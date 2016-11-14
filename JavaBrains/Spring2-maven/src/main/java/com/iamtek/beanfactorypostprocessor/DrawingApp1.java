package com.iamtek.beanfactorypostprocessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp1 {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-beanfactorypostprocessor1.xml");
        context.registerShutdownHook();
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();

    }

}
