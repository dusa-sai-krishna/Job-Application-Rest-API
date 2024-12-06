package com.saiDeveloper.Spring_Boot_Rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type classname.methodname(args || ..)
    @Before("execution(* com.saiDeveloper.Spring_Boot_Rest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info(jp.getSignature().getName()+" Method is called");
    }

}
