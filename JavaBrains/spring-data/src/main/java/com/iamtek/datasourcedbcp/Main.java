package com.iamtek.datasourcedbcp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context-datasourcedbcp.xml");
        context.registerShutdownHook();
        JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
        dao.test();

        Circle circle = dao.getCircle(1);
        System.out.println(circle.getName());

    }

}
