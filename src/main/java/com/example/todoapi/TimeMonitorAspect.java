package com.example.todoapi;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logtime(ProceedingJoinPoint joinPoint) throws Throwable  {
        long startTime = System.currentTimeMillis();

       try{
           joinPoint.proceed();


        }catch (Throwable e){
           System.out.println("Time Monitor Error");
       }finally {
           long endTime = System.currentTimeMillis();
           long elapsedTime = endTime - startTime;
           System.out.println("Elapsed Time: " + elapsedTime);
       }



    }
}
