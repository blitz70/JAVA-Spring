package com.iamtek.jdbctemplate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-jdbctemplate.xml");
        context.registerShutdownHook();
        JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

        //Pure JDBC
        dao.test();
        System.out.println("getCircle: " + dao.getCircle(1).getName());

        //Spring JDBC, queryForObject
        System.out.println("getCircleCount " + dao.getCircleCount());

        //queryForObject with param
        System.out.println("getCircleName: " + dao.getCircleName(1));
        System.out.println("getCircle1: " + dao.getCircle1(1).getName());

    }

}
