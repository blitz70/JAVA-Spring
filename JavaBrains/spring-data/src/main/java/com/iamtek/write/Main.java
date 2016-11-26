package com.iamtek.write;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-write.xml");
        context.registerShutdownHook();
        JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);


        /*System.out.println(dao.insertCircle(new Circle(3,"New Circle")));

        System.out.println(dao.getCircleCount());

        //query with RowMap
        for (Circle circle:dao.getAllCircles()) {
            System.out.println("id: "+ circle.getId() + ", name: " + circle.getName());
        }*/

        dao.createTriangle();

    }

}
