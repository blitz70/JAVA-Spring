package com.iamtek.rowmapper;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcDaoImpl {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private class CircleMapper implements RowMapper<Circle>{
        public Circle mapRow(ResultSet resultSet, int i) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt(1));
            circle.setName(resultSet.getString(2));
            return circle;
        }
    }
    private String sql;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


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

    public Circle getCircle2(int id){
        sql = "SELECT * FROM circle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CircleMapper());
    }

    public List<Circle> getAllCircles(){
        sql = "SELECT * FROM circle";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

}
