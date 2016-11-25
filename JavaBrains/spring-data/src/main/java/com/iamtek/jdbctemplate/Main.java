package com.iamtek.jdbctemplate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-jdbctemplate.xml");
        context.registerShutdownHook();
        JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
        dao.test();

        System.out.println(dao.getCircle(1).getName());
        System.out.println(dao.getCircleCount());

    }

}
