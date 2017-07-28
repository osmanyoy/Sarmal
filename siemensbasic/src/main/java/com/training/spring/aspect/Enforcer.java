package com.training.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
public class Enforcer {

    @Pointcut("execution(* com.training.spring.aspect.Called.*(..))")
    public void pointcutMethod(){
    }

    @After("pointcutMethod() && args(str)")
    public void afterMethod(String str){
        System.out.println("Method cağrıldı " + str);
    }

    @Before("pointcutMethod()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("Method Info :" + joinPoint.toLongString());
    }

    @AfterReturning(value ="pointcutMethod() && args(str)",returning = "retStr")
    public void afterMethod(String str,String retStr){
        System.out.println("Method cağrıldı " + str + " Method dönüşü : " + retStr);
    }

    @AfterThrowing(value ="pointcutMethod() && args(str)",throwing = "ex")
    public void afterMethod(String str,Exception ex){
        System.out.println("Method cağrıldı " + str + " Exception : " + ex.getMessage());
    }

//    @Around(value ="pointcutMethod()")
//    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
//        try {
//            Object proceed = proceedingJoinPoint.proceed();
//            if (proceed instanceof String){
//                String str = (String)proceed;
//                str += " Around ile çevrelendi.";
//                return  str;
//            }
//            return proceed;
//        }
//        catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return null;
//    }

    @Around(value ="@within(com.training.spring.aspect.*) && @annotation(sec)")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint,Security sec){
        try {
            Object proceed = proceedingJoinPoint.proceed();
            if (proceed instanceof String){
                String str = (String)proceed;
                str += " Around ile çevrelendi.";
                return  str;
            }
            return proceed;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
