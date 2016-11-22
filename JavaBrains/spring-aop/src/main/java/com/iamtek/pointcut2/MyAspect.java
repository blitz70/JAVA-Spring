package com.iamtek.pointcut2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component @Aspect
public class MyAspect {

    @Before("pointAllGet()")
    public void myAdvice1(){
        System.out.println("First all getter advice");
    }

    @Before("pointAllGet()")
    public void myAdvice2(){
        System.out.println("Second all getter advice");
    }

    @Before("pointAllCircle() OR pointAllTriangle()")
    public void myAdvice3(){
        System.out.print("All shape methods: ");
    }

    @Before("pointAllCircle()")
    public void myAdvice4(){
        System.out.print("All circle methods: ");
    }

    @Before("pointAllTriangle()")
    public void myAdvice5(){
        System.out.print("All triangle methods: ");
    }

    @Pointcut("execution(* get*(..))")
    public void pointAllGet(){
    }

    @Pointcut("execution(* com.iamtek.pointcut2.Circle.*(..))")
    public void pointAllCircle(){
    }

    @Pointcut("within(com.iamtek.pointcut2.Triangle)")
    public void pointAllTriangle(){
    }

}
