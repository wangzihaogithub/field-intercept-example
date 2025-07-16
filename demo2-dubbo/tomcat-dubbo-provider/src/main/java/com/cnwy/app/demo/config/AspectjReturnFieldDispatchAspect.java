package com.cnwy.app.demo.config;

import com.github.fieldintercept.ReturnFieldDispatchAop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectjReturnFieldDispatchAspect extends ReturnFieldDispatchAop<JoinPoint> {

    @Before(value = "@annotation(com.cnwy.app.demo.annotation.CnwyFieldAop)")
    protected void aopBefore() {
        before();
    }

    @After(value = "@annotation(com.cnwy.app.demo.annotation.CnwyFieldAop)")
    protected void aopAfter() {
        after();
    }

    @AfterReturning(value = "@annotation(com.cnwy.app.demo.annotation.CnwyFieldAop)", returning = "result")
    protected void aopReturningAfter(JoinPoint joinPoint, Object result) {
        returningAfter(joinPoint, result);
    }

}