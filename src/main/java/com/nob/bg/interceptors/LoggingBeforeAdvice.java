/*
 * LoggingBefore.java
 *
 * Created on September 6, 2006, 10:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.interceptors;

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author jorismelchior
 */
public class LoggingBeforeAdvice implements MethodBeforeAdvice {
    
    /** Creates a new instance of LoggingBefore */
    public LoggingBeforeAdvice() {
        System.out.println("WE BE LOGGING ********");
    }
    
    public void before(Method method, Object[] args, Object target) throws Throwable {
        Log log = LogFactory.getLog(target.getClass());
        String stringArgs = "";
        if(args != null && args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                if(args[i] == null) {
                    stringArgs += "null ";
                } else {
                    stringArgs += "[" + i + "]" + args[i].getClass().getName() + " - "+ args[i].toString() + ": ";
                }
            }
        }
        log.info("calling method: " + method.getName() + " args: " + stringArgs);
    }
    
}
