package com.iamtek.joinpoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component @Aspect
public class MyAspect {

    @Before("pointAllTriangle()")
    public void myAdvice1(JoinPoint joinPoint){
        /*System.out.println("Advice run. Get Method called.");*/
        System.out.println("Advice run.");
        Triangle triangle = (Triangle) joinPoint.getTarget();
        triangle.setName("Aspect Triangle");
    }

    @Pointcut("execution(* get*(..))")
    public void pointAllGet(){
    }

    @Pointcut("within(com.iamtek.joinpoint.Triangle)")
    public void pointAllTriangle(){
    }

}
