package com.iamtek.jdbctemplate;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class JdbcDaoImpl {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    String sql;

    public String getCircleName(int id){
        sql = "SELECT name FROM circle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, new Object[]{id});
    }

    public int getCircleCount(){
        sql = "SELECT COUNT(*) FROM circle";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public Circle getCircle1(int id){
        sql = "SELECT name FROM circle WHERE id = ?";
        String name = jdbcTemplate.queryForObject(sql, String.class, new Object[]{id});
        return new Circle(id, name);
    }

    public Circle getCircle(int id){
        Circle circle = null;
        try {
            sql = "SELECT * FROM circle WHERE id = ?";
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

    public void test(){
        try {
            System.out.println("Connecting");
            conn = dataSource.getConnection();
            System.out.println("Connection success!");
        } catch (Exception e) {
            System.out.println("Connection failed!");
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

}
