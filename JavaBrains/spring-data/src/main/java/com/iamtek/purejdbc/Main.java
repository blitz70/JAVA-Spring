package com.iamtek.purejdbc;

//no spring
public class Main {

    public static void main(String[] args) {

        //pure jdbc connection
        JdbcDaoImpl dao = new JdbcDaoImpl();
        dao.test();

        Circle circle = dao.getCircle(1);
        System.out.println(circle.getName());

    }

}
