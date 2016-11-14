package com.iamtek.beandefinherit;

import java.util.List;

public class Triangle2 {

    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void draw() {
        System.out.println("Triangle with list drawn.");
        for (Point point: points) {
            System.out.println("Point A(" + point.getX() + ", " + point.getY() +")");
        }
    }

}
