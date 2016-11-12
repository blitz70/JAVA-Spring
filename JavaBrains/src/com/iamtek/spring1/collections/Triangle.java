package com.iamtek.spring1.collections;

import java.util.List;

public class Triangle {

    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void draw() {
        System.out.println("Triangle drawn.");
        for (Point point : points) {
            System.out.println("(" + point.getX() + ", " + point.getY() +")");
        }
    }

}
