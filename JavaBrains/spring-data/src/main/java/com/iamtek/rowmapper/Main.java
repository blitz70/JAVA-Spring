package com.iamtek.rowmapper;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-rowmapper.xml");
        context.registerShutdownHook();
        JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

        //Spring JDBC, queryForObject with RowMap
        System.out.println("getCircle2: " + dao.getCircle2(2).getName());

        //query with RowMap
        for (Circle circle:dao.getAllCircles()) {
            System.out.println(circle.getName());
        }

    }

}
