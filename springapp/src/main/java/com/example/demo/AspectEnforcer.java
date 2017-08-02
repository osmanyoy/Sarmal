package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Aspect
@Component
public class AspectEnforcer {

    @Pointcut("execution(* com.example.demo.MyRest.mello(..)) && args(str)")
    public void method(String str) {
    }

    @After("method(str)")
    public void afterMethodCall(JoinPoint joinPoint,
                                String str) {
        System.out.println("MyRest method çağrıldı : " + joinPoint.getSignature()
                                                                  .toLongString());
    }

    @Before("method(str)")
    public void beforeMethodCall(JoinPoint joinPoint,
                                 String str) {
        System.out.println("MyRest method çağrılaccak : " + joinPoint.getSignature()
                                                                     .toLongString());
    }

    @AfterReturning(value = "method(str)", returning = "retStr")
    public void afterReturning(String str,
                               String retStr) {
        System.out.println("After Returning input : " + str + " output : " + retStr);
    }

    @AfterThrowing(value = "method(str)", throwing = "ex")
    public void afterReturning(String str,
                               Exception ex) {
        System.out.println("After Throwing input : " + str + " exception : " + ex.getMessage());
    }

    @Around("execution(* com.example.demo.MyRest.mello(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Object proceed = proceedingJoinPoint.proceed();
            if (proceed instanceof String) {
                String strRet = (String) proceed + " Around enforced";
                return strRet;
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Around("within(com.example.demo.MyRest) && @annotation(myAnno)")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint,MySecurity myAnno) {
        try {
            Object proceed = proceedingJoinPoint.proceed();
            if (proceed instanceof String) {
                String strRet = (String) proceed + " Around enforced";
                return strRet;
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
