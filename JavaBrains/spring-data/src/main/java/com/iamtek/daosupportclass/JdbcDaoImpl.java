package com.iamtek.daosupportclass;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcDaoImpl {

    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private class CircleMapper implements RowMapper<Circle>{
        public Circle mapRow(ResultSet resultSet, int i) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt(1));
            circle.setName(resultSet.getString(2));
            return circle;
        }
    }
    private String sql;

    public String getCircleName(int id){
        sql = "SELECT name FROM circle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, new Object[]{id});
    }

    public int getCircleCount(){
        sql = "SELECT COUNT(*) FROM circle";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public Circle getCircle(int id){
        sql = "SELECT * FROM circle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CircleMapper());
    }

    public List<Circle> getAllCircles(){
        sql = "SELECT * FROM circle";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

    public int insertCircle1(Circle circle){
        sql = "INSERT INTO circle VALUES (?, ?)";
        Object[] args = new Object[]{circle.getId(), circle.getName()};
        return jdbcTemplate.update(sql, args);
    }

    public int insertCircle2(Circle circle){
        sql = "INSERT INTO circle VALUES (:id, :name)";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", circle.getId());
        paramMap.put("name", circle.getName());
        return namedParameterJdbcTemplate.update(sql, paramMap);
    }

    public void createCircle(){
        sql = "CREATE TABLE circle (id integer, name char(50))";
        jdbcTemplate.execute(sql);
    }
}
