package com.iamtek.pointcut2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016-11-22.
 */
@Component @Aspect
public class MyAspect {


    @Before("allGetters()")
    public void myAdvice1(){
        System.out.println("First all getter advice");
    }

    @Before("allGetters()")
    public void myAdvice2(){
        System.out.println("Second all getter advice");
    }

    @Before("allCircleMethod()")
    public void myAdvice3(){
        System.out.print("All circle methods: ");
    }

    @Before("allTriangleMethod()")
    public void myAdvice4(){
        System.out.print("All triangle methods: ");
    }

    @Pointcut("execution(* get*(..))")
    public void allGetters(){
    }

    @Pointcut("execution(* com.iamtek.pointcut2.Circle.*(..))")
    public void allCircleMethod(){
    }

    @Pointcut("within(com.iamtek.pointcut2.Triangle)")
    public void allTriangleMethod(){
    }

}
