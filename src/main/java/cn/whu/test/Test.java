package cn.whu.test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    @Before("execution(* cn.whu.controller.IndexController.*(..))")
    public void beforeMethod(){
        System.out.println("before...");
        logger.info("before log");
    }
    @After("execution(* cn.whu.controller.IndexController.*(..))")
    public void afterMethod(){
        System.out.println("after...");
        logger.info("after log");
    }

}
