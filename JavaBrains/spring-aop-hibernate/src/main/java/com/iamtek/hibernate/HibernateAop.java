package com.iamtek.hibernate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component @Aspect
public class HibernateAop {

    //how to take out boiler plate code?
    @Around("@annotation(com.iamtek.hibernate.Hib)")
    public Object hibernate(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("before");
            result = joinPoint.proceed();
            System.out.println("after return");
        } catch (Throwable throwable) {
            System.out.println("after throw");
        } finally {
            System.out.println("after");
            return result;
        }
    }
}
