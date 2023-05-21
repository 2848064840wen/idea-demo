package com.xuwencheng.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
* AOP演示
*       1.需要交给IOC管理
*       2.声明不是一个普通类
* */
@Slf4j
@Component
//@Aspect//AOP类
public class TimeAspect {

    @Around("execution(* com.xuwencheng.service.*.*(..))")//切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //记录开始时间
        long begin = System.currentTimeMillis();
        //调用原始方法运行
        Object result = joinPoint.proceed();

        //记录结束时间，计算方法执行耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法执行的耗时：{}ms ",end - begin);
        return result;
    }
}
