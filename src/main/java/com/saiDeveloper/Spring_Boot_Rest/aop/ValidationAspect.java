package com.saiDeveloper.Spring_Boot_Rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.saiDeveloper.Spring_Boot_Rest.service.JobService.getJob(..)) && args(postId)   ")
    public Object validateInput(ProceedingJoinPoint jp, int postId) throws Throwable {
        if(postId<0){
            postId=postId*-1;
            System.out.print(postId);
            LOGGER.info("Provided JobID is negative");
        }

        return jp.proceed(new Object[]{postId});
    }

}
