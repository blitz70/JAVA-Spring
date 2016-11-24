package com.iamtek.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component @Aspect
public class MyAspect {

    @Around("allGet()")
    public Object myAdvice1(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {
            System.out.println("@Around Advice: Before");
            obj = joinPoint.proceed();
            System.out.println("@Around Advice: AfterReturning");
        } catch (Throwable throwable) {
            System.out.println("@Around Advice: AfterThrowing");
        } finally {
            System.out.println("@Around Advice: After");
        }
        return obj;
    }

    @After("args(arg)")
    public void myAdvice2(String arg){
        System.out.println("@After Advice, name = "+ arg);
    }

    @Pointcut("within(com.iamtek.after.Circle)")
    public void withinCircle(){
    }

    @Pointcut("within(com.iamtek.after.Triangle)")
    public void withinTriangle(){
    }

    @Pointcut("execution(* get*())")
    private void allGet(){
    }
}
