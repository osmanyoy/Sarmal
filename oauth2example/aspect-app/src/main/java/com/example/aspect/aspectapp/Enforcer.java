package com.example.aspect.aspectapp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Enforcer {
    @Before("execution(* com.example.aspect.aspectapp.Callee.*(..)) && args(str)")
    public void beforeMethod(JoinPoint joinPoint,String str){

        System.out.println("before calisti : " + str + " jp : " + joinPoint.toLongString());
    }

    @After("execution(* com.example.aspect.aspectapp.Callee.*(..))")
    public void afterMethod(){
        System.out.println("afterMethod calisti");
    }

    @Around("execution(* com.example.aspect.aspectapp.Callee.*(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        try {
            String str = (String)proceedingJoinPoint.proceed();
            str += " around eklendi";
            return str;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
