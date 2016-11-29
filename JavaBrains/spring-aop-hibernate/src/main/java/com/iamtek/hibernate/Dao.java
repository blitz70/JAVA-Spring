package com.iamtek.hibernate;

import java.util.List;

public interface Dao {

    void insertCircle(Circle circle);

    Circle getCircle(int id);

    void updateCircle(Circle circle);

    void deleteCircle(Circle circle);

    void deleteCircles(int start, int end);

    List<Circle> getAllCircles();

    int getCircleCount();

}
