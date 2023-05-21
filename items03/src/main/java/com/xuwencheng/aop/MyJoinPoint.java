package com.xuwencheng.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class MyJoinPoint {

    @Pointcut("execution(* com.xuwencheng.service.DeptService.*(..))")
    public void pt() {
    }


    /*
    * 前置通知
    *
    * 其他通知需要实现org.aspectj.lang.JoinPoint
    * */
    @Before("pt()")
    public void before(JoinPoint joinPoint) {

        log.info("before -------------------------");
    }

    /*
    * 环绕通知
    *   要获取信息
    *   需要ProceedingJoinPoint
    * */
    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        //1.获取 目标对象的类名

        log.info("目标对象的类名： " + joinPoint.getTarget().getClass().getName());

        //2.获取 目标方法的方法名
        log.info("目标方法的方法名： " + joinPoint.getSignature().getName());

        //3.获取 目标方法运行时传入的参数
        log.info("目标方法的参数： " + Arrays.toString(joinPoint.getArgs()));

        //4.放行 目标方法执行
        Object result = joinPoint.proceed();
        //5.获取 目标方法运行的返回值
        log.info("目标方法运行的返回值: " + result);

        return null;
    }
}
