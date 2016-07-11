package com.project.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Aspect
public class LogAspact extends HandlerInterceptorAdapter {
	static Log log = LogFactory.getLog(LogAspact.class);
	@Pointcut("execution(public * com.project.*.dao.*.*(..))")
	public void dao() {
		
	}
	
	@Pointcut("execution(public * com.project.*.service.*.*(..))")
	public void service() {
		
	}
	
	@Before("dao() || service()")
	public void before(JoinPoint jp) {
		Log log = LogFactory.getLog(jp.getTarget().getClass());
		log.info("### " + jp.getSignature().getName()
						+ "("
						+ Arrays.toString(jp.getArgs())
						+ ")"
						+ " START");
	}
	
	@After("dao() || service()")
	public void after(JoinPoint jp) {
		Log log = LogFactory.getLog(jp.getTarget().getClass());
		log.info("### " + jp.getSignature().getName()
						+ "("
						+ Arrays.toString(jp.getArgs())
						+ ")"
						+ " END");
	}

    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("======================================          START         ======================================");
            log.debug(" Request URI \t:  " + request.getRequestURI());
        }
        return super.preHandle(request, response, handler);
    }
     
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("======================================           END          ======================================\n");
        }
    }

}
