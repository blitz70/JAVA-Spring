package com.iamtek.after;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component @Aspect
public class MyAspect {

    @After("args(arg)")
    public void myAdvice2(String arg){
        System.out.println("@After Advice, name = "+ arg);
    }

    @AfterThrowing(pointcut = "args(arg) && allCircle()", throwing = "exceptionValue")
    public void myAdvice3(String arg, Exception exceptionValue){
        System.out.println("@AfterThrowing Advice, name = " + arg + ", exception =" + exceptionValue);
    }

    @AfterReturning(pointcut = "args(arg) && allTriangle()", returning = "returnValue")
    public void myAdvice4(String arg, String returnValue){
        System.out.println("@AfterReturning Advice, name = " + arg + ", return = "+ returnValue);
    }

    @Pointcut("within(com.iamtek.after.Circle)")
    public void allCircle(){
    }

    @Pointcut("within(com.iamtek.after.Triangle)")
    public void allTriangle(){
    }

}
