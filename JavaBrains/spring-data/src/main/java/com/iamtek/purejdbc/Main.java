package com.iamtek.purejdbc;

public class Main {

    public static void main(String[] args) {

        //connection test
        JdbcDaoImpl dao = new JdbcDaoImpl();
        dao.test();

        Circle circle = dao.getCircle(1);
        System.out.println(circle.getName());

    }

}
