package com.xuwencheng.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect {

    /*
    * 当切入点表达式相同时可以抽取
    *   其切面类也可以是使用
    *   范围与修饰符有关
    * */
    @Pointcut("execution(* com.xuwencheng.service.DeptService.*(..))")
    public void pt(){}

    //环绕通知
    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        //开始前时间
        long begin = System.currentTimeMillis();

        //调用原始方法
        Object proceed = joinPoint.proceed();

        //统计后时间
        long end =  System.currentTimeMillis();
        log.info(joinPoint.getSignature() + " 方法运行时间为： {} ms" ,end - begin);
        return proceed;
    }

    //前置通知
    @Before("pt()")
    public void before(){
        log.info("before -------------------------");
    }

    //后置通知
    @After("pt()")
    public void after(){
        log.info("after````````````````````````");
    }

    //返回后通知
    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("afterReturning.............................");
    }

    //异常通知
    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("afterThrowing/////////////////////////////////");
    }
}
