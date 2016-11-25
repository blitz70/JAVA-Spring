package com.iamtek.purejdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDaoImpl {

    String driver = "org.apache.derby.jdbc.ClientDriver";
    String jdbcUrl = "jdbc:derby://localhost:1527/db;create=true";
    Connection conn;
    PreparedStatement ps;
    String sql;
    ResultSet rs;

    public void test(){
        try {
            System.out.println("Connecting to : " + jdbcUrl);
            Class.forName(driver);
            conn = DriverManager.getConnection(jdbcUrl);
            System.out.println("Connection success!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection failed!");
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    public JdbcDaoImpl() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
        }
    }

    public Circle getCircle(int id){
        Circle circle = null;
        try {
            sql = "SELECT * FROM circle where id = ?";
            conn = DriverManager.getConnection(jdbcUrl);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                circle = new Circle(id, name);
            }
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return circle;
    }

}
