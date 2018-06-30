package com.haley.spring0to1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class.getName());

//    @Before("execution(public * com.haley.spring0to1.web.controller.TestController.*(..))")
//    public void doBefore(){
//        System.out.println("1111111");
//    }
//
//    @After("execution(public * com.haley.spring0to1.web.controller.TestController.*(..))")
//    public void doAfter(){
//        System.out.println("2222222");
//    }

    //上面这个写法execution依然会存在重复代码的情况，座位一个合格的程序员肯定是不允许干这么low的事情,可以使用Pointcut进行提取

    @Pointcut("execution(public * com.haley.spring0to1.web.controller.TestController.*(..))")
    public void doSomething() {

    }

    @Before("doSomething()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}", request.getRequestURL());
        logger.info("method={}", request.getMethod());
        logger.info("ip={}", request.getRemoteAddr());
        logger.info("classMethod={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("doSomething()")
    public void doAfter() {
        logger.info("22222222");
    }

    @AfterReturning(returning = "object", pointcut = "doSomething()")
    public void doAfterRetuning(Object object) {
        logger.info("Object={}", object.toString());
    }


}
