package com.iamtek.customadvice;

public class ShapeService {

    private Circle circle;
    private Triangle triangle;

    @CustomAdvice
    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

}
