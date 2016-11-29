package com.iamtek.hibernate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-hibernate.xml");
        context.registerShutdownHook();
        HibernateAopDaoImpl dao = context.getBean("hibernateAopDaoImpl", HibernateAopDaoImpl.class);

        //C. populate db, auto create circle
        for (int i = 0; i < 21 ; i++) {
            dao.insertCircle(new Circle(i, i + " Circle"));
        }

        {
            //R. get a circle
            Circle circle = dao.getCircle(5);
            System.out.println("id: "+ circle.getId() + ", name: " + circle.getName());
            System.out.println("Count: " + dao.getCircleCount());
            //U. update a circle
            circle.setName("Edited!");
            dao.updateCircle(circle);
        }


        {
            //D. delete a circle, circles
            Circle circle = dao.getCircle(7);
            dao.deleteCircle(circle);
            dao.deleteCircles(11, 16);
        }

        //display db
        for (Circle circle:dao.getAllCircles()) {
            System.out.println("id: "+ circle.getId() + ", name: " + circle.getName());
        }
    }

}
