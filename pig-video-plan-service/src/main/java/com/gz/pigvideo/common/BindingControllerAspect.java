package com.gz.pigvideo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.exceptions.ExceptionHandler;

@Aspect
@Component
@Order(-99)
public class BindingControllerAspect {
	
	@Pointcut("execution(public * com.gz.pigvideo.controller.*.*(..))")
	public void BindingController() {
	}
	
    @Around("BindingController()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        CommonResult<?> result;
        try {
            result = (CommonResult<?>) joinPoint.proceed();
        } catch (Throwable e) {
        	result = ExceptionHandler.handlerException(e);
        }
        return result;
    }
	
}
