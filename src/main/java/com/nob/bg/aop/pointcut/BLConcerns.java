package com.nob.bg.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BLConcerns {
    @Pointcut("execution(public * com.nob.bg.service.*.*(..))")
    public void service() {}
    
    @Pointcut("execution(public * com.nob.bg.dao.*.*(..))")
    public void dao() {}
}
