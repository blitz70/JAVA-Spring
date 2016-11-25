package com.iamtek.datasourcedbcp;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class JdbcDaoImpl {

    @Resource
    private DataSource dataSource;

    Connection conn;
    PreparedStatement ps;
    String sql;
    ResultSet rs;


    public void test(){
        try {
            System.out.println("Connecting");
            conn = dataSource.getConnection();
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

    public Circle getCircle(int id){
        Circle circle = null;
        try {
            sql = "SELECT * FROM circle where id = ?";
            conn = dataSource.getConnection();
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
