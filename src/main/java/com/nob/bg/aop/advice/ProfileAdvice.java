/*
 * ProfileAdvide.java
 *
 * Created on March 16, 2007, 10:41 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.aop.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author jorismelchior
 */
@Aspect()
public class ProfileAdvice {
    
    /** Creates a new instance of ProfileAdvice */
    public ProfileAdvice() {
    }
    
    @Around("com.nob.bg.aop.pointcut.BLConcerns.service()")
    public Object aroundMethodCallProfile(ProceedingJoinPoint pj) throws Throwable {
        Throwable t = null;
        String method = pj.getSignature().getName();
        Class<? extends Object> target = pj.getTarget().getClass();
        Object result = null;
        long after;
        long before = System.currentTimeMillis();
        try {
            result = pj.proceed();
        } catch (Throwable e) {
            t = e;
        } finally {
            after = System.currentTimeMillis();
        }
        Log log = LogFactory.getLog(target);
        log.info("call " + method + ": " + (after - before) + " ms");
        if(t != null) {
            throw t;
        }
        return result;
    }
}
