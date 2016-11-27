package com.iamtek.hibernate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-hibernate.xml");
        context.registerShutdownHook();
        HibernateDaoImpl dao = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);

        /*//create table circle
        dao.createCircle();

        //populate db
        dao.insertCircle1(new Circle(1, "First Circle"));
        dao.insertCircle1(new Circle(2, "Second Circle"));
        dao.insertCircle1(new Circle(3, "Third Circle"));
        dao.insertCircle2(new Circle(4, "Fourth Circle"));
        dao.insertCircle2(new Circle(5, "Fifth Circle"));*/

        //display db
        for (Circle circle:dao.getAllCircles()) {
            System.out.println("id: "+ circle.getId() + ", name: " + circle.getName());
        }
    }

}
