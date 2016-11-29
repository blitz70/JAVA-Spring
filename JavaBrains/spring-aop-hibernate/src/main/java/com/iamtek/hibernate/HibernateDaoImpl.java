package com.iamtek.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class HibernateDaoImpl implements Dao{

    @Resource
    private SessionFactory sessionFactory;

    private Session session;
    private String hql;

    public void insertCircle(Circle circle){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(circle);
        session.getTransaction().commit();
        session.close();
    }

    public Circle getCircle (int id){
        hql = "FROM Circle where id = :id";
        session = sessionFactory.openSession();
        session.beginTransaction();
        Circle  circle = session.get(Circle.class, id);
        session.getTransaction().commit();
        session.close();
        return circle;
    }

    public void updateCircle(Circle circle){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(circle);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCircle(Circle circle) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(circle);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCircles(int start, int end) {
        hql = "DELETE FROM Circle WHERE id >= :start AND id <= :end";
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("start", start).setParameter("end", end).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

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

    public int getCircleCount(){
        hql = "FROM Circle";
        session = sessionFactory.openSession();
        session.beginTransaction();
        int result = session.createQuery(hql).list().size();    //not good....
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
