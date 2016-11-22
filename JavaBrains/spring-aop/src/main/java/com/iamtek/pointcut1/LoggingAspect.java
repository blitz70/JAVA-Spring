package com.iamtek.pointcut1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016-11-22.
 */
@Component @Aspect
public class LoggingAspect {

    @Before("execution(public String com.iamtek.pointcut1.Circle.getName())")
    public void advice1(){
        System.out.println("Circle get name advice");
    }

    @Before("execution(public String com.iamtek.pointcut1.Triangle.getName())")
    public void advice2(){
        System.out.println("Triangle get name advice");
    }

    @Before("allGetters()")
    public void advice3(){
        System.out.println("First all getter advice");
    }

    @Before("allGetters()")
    public void advice4(){
        System.out.println("Second all getter advice");
    }

    @Before("allGetters()")
    public void advice5() {
        System.out.print("Advice: ");
    }

    @Pointcut("execution(* get*(..))")
    public void allGetters(){
    }

}
