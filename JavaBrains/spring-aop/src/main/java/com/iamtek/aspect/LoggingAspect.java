package com.iamtek.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Administrator on 2016-11-22.
 */
@Aspect
public class LoggingAspect {

    @Before("execution(public String getName())")
    public void loggingAdvice(){
        System.out.println("Advice run. Get method called");
    }

}
