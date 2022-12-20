package com.example.springboot.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class LoggingAspect
{
    private static final Logger l = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.springboot.services.EquipeService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        l.info("In method " + name + " : ");
    }
    /**
     *
     * @param joinPoint
     */
    @After("execution(* com.example.springboot.services.EquipeService.addTeam(..))")
    public void logMethodExit(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        l.info("Exit of method "+name+" :");
    }

    @Around("execution(* com.example.springboot.services.EquipeService.*(..))")
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();

        Object obj = proceedingJoinPoint.proceed();

        long elapsedTime = System.currentTimeMillis() - start;

        l.info("Method execution time: " + elapsedTime + " milliseconds.");

        return obj;
    }

}
