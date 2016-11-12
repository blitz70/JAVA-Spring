package com.iamtek.innerbean;

public class Triangle {

    private Point PointA;
    private Point PointB;
    private Point PointC;

    public Point getPointA() {
        return PointA;
    }

    public void setPointA(Point pointA) {
        this.PointA = pointA;
    }

    public Point getPointB() {
        return PointB;
    }

    public void setPointB(Point pointB) {
        this.PointB = pointB;
    }

    public Point getPointC() {
        return PointC;
    }

    public void setPointC(Point pointC) {
        this.PointC = pointC;
    }

    public void draw() {
        System.out.println("Triangle drawn.");
        System.out.println("Point A(" + this.getPointA().getX() + ", " + this.getPointA().getY() +")");
        System.out.println("Point B(" + this.getPointB().getX() + ", " + this.getPointB().getY() +")");
        System.out.println("Point C(" + this.getPointC().getX() + ", " + this.getPointC().getY() +")");
    }

}
