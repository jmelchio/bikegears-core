/*
 * ThrowsDataAccessExceptionAdvice.java
 *
 * Created on September 10, 2006, 2:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.nob.bg.interceptors;

import java.lang.reflect.Method;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author jorismelchior
 */
public class ThrowsDataAccessExceptionAdvice implements ThrowsAdvice{
    
    /** Creates a new instance of ThrowsDataAccessExceptionAdvice */
    public ThrowsDataAccessExceptionAdvice() {
    }
    
    public void afterThrowing(Method method, Object[] args, Object target, DataAccessException ex) {
        Log log = LogFactory.getLog(target.getClass());
        String stringArgs = "";
        if(args != null && args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                stringArgs += "[" + i + "]" + args[i].getClass().getName() + " - "+ args[i].toString() + ": ";
            }
        }
        log.error(ex.getMessage() + " calling method: " + method.getName() + " args: " + stringArgs);
    }
    
}
