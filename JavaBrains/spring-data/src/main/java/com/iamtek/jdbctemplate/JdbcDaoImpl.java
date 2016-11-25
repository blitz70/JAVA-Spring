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
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Resource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    Connection conn;
    PreparedStatement ps;
    String sql;
    ResultSet rs;

    public int getCircleCount(){
        sql = "SELECT COUNT(*) FROM circle";
        return jdbcTemplate.queryForObject(sql, Integer.class);
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

}
