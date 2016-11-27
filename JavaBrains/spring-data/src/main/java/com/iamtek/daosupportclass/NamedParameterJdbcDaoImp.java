package com.iamtek.daosupportclass;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NamedParameterJdbcDaoImp extends NamedParameterJdbcDaoSupport{

    String sql;

    private class CircleMapper implements RowMapper<Circle> {
        public Circle mapRow(ResultSet resultSet, int i) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt(1));
            circle.setName(resultSet.getString(2));
            return circle;
        }
    }
    public List<Circle> getAllCircles(){
        sql = "SELECT * FROM circle";
        return getNamedParameterJdbcTemplate().query(sql, new CircleMapper());
    }

}
