package com.nob.bg.aop.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.dao.DataAccessException;

@Aspect
public class LoggingAdvice {
    @Before("com.nob.bg.aop.pointcut.BLConcerns.service()")
    public void beforeMethodCallLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName().toString();
        Object[] args = joinPoint.getArgs();
        StringBuffer logInfo = new StringBuffer(methodName + ": ");
        for (int i = 0; i < args.length; i++) {
            if(i == args.length - 1) {
                logInfo.append(args[i]);
            } else {
                logInfo.append(args[i] + ", ");
            }
        }
        Log log = LogFactory.getLog(joinPoint.getTarget().getClass());
        log.info(logInfo.toString());
    }
    
    @AfterThrowing(pointcut="com.nob.bg.aop.pointcut.BLConcerns.dao()", throwing="ex")
    public void afterThrowingLog(JoinPoint joinPoint, DataAccessException ex) {
        String methodName = joinPoint.getSignature().getName().toString();
        Object[] args = joinPoint.getArgs();
        StringBuffer logInfo = new StringBuffer("Exception thrown calling " + methodName + ": ");
        for (int i = 0; i < args.length; i++) {
            if(i == args.length - 1) {
                logInfo.append(args[i]);
            } else {
                logInfo.append(args[i] + ", ");
            }
        }
        logInfo.append(" - ").append(ex.getMessage());
        Log log = LogFactory.getLog(joinPoint.getTarget().getClass());
        log.fatal(logInfo.toString());
    }
}
