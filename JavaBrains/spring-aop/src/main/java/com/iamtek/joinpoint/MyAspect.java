package com.iamtek.joinpoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component @Aspect
public class MyAspect {

    @Before("allTriangle()")
    public void myAdvice1(JoinPoint joinPoint){
        Triangle triangle = (Triangle) joinPoint.getTarget();
        System.out.println("Advice1: " + triangle.getName());
        triangle.setName("Aspect Triangle");
    }

    @Before("args(arg)")
    public void myAdvice2(String arg){
        System.out.println("Advice2: method(String) called, arg = "+ arg);
    }

    @Pointcut("execution(* get*(..))")
    public void allGet(){
    }

    @Pointcut("within(com.iamtek.joinpoint.Triangle)")
    public void allTriangle(){
    }

}
