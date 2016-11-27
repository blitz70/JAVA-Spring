package com.iamtek.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HibernateDaoImpl{

    @Resource
    private SessionFactory sessionFactory;

    private Session session;
    private String hql;

    public List<Circle> getAllCircles(){
        hql = "FROM Circle";
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        List<Circle> circles = query.list();
        session.getTransaction().commit();
        session.close();
        return circles;
    }

    /*private class CircleMapper implements RowMapper<Circle>{
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
    }*/
}
