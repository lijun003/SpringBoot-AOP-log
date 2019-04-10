package com.example.aop.annotation;

import com.example.aop.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.example.aop.annotation.SysLog)")
    public void logPointCut() {}

    @Before("logPointCut()")
    public void before(JoinPoint joinPoint) {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog annotation = method.getAnnotation(SysLog.class);
        String value = annotation.value();
        Object[] args = joinPoint.getArgs();
        try {
            logService.log(beginTime, "before " + method.getName());
        } catch (Exception e) {
        }
    }


    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog annotation = method.getAnnotation(SysLog.class);
        String value = annotation.value();
        Object[] args = joinPoint.getArgs();
        Object object = joinPoint.proceed(args);
        try {
            logService.log(beginTime, "around " + method.getName());
        } catch (Exception e) {
        }

        return object;
    }

    @After("logPointCut()")
    public void after(JoinPoint joinPoint) {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog annotation = method.getAnnotation(SysLog.class);
        String value = annotation.value();
        Object[] args = joinPoint.getArgs();
        try {
            logService.log(beginTime, "after " + method.getName());
        } catch (Exception e) {
        }
    }

    @AfterReturning("logPointCut()")
    public void afterReturning(JoinPoint joinPoint) {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog annotation = method.getAnnotation(SysLog.class);
        String value = annotation.value();
        Object[] args = joinPoint.getArgs();
        try {
            logService.log(beginTime, "after returning " + method.getName());
        } catch (Exception e) {

        }
    }

    @AfterThrowing("logPointCut()")
    public void afterThrowing(JoinPoint joinPoint) {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog annotation = method.getAnnotation(SysLog.class);
        String value = annotation.value();
        Object[] args = joinPoint.getArgs();
        try {
            logService.log(beginTime, "after throwing " + method.getName());
        } catch (Exception e) {

        }
    }
}
