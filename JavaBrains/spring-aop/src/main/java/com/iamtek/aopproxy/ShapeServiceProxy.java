package com.iamtek.aopproxy;

public class ShapeServiceProxy extends ShapeService{

    @Override
    public Circle getCircle() {
        new MyAspect().myAdvice();
        return super.getCircle();
    }

}
