package com.iamtek.xmlaop;

public class ShapeService {

    private Circle circle;
    private Triangle triangle;

    public Circle getCircle() {
        System.out.println("ShapeService Circle getter");
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
        System.out.println("ShapeService Circle setter");
    }

    public Triangle getTriangle() {
        System.out.println("ShapeService Triangle getter");
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
        System.out.println("ShapeService Triangle setter");
    }

}
