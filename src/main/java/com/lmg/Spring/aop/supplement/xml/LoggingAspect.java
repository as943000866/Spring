package com.lmg.Spring.aop.supplement.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
public class LoggingAspect {
	
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("the method "+methodName+" start with" + Arrays.asList(args));
	}
	
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " end ");
	}
	
	public void afterReturningMethod(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " result: "+result);
	}
	
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " occur " + e);
	}
	
	public Object aroundMethod(ProceedingJoinPoint pjp){
		Object result = null;
		//获取方法名
		String methodName = pjp.getSignature().getName();
		//获取参数列表
		Object[] args = pjp.getArgs();
		try {
			//前置通知
			System.out.println("the method "+methodName+" start with" + Arrays.asList(args));

			result = pjp.proceed();
		
			System.out.println("the method " + methodName + " result: "+result);
			
		} catch (Throwable e) {
			//异常通知
//			e.printStackTrace();
			System.out.println("the method " + methodName + " occur " + e);
			throw new RuntimeException(e);
		}
		//后置通知  无法获取 result 对象,由于方法可能在执行中发生异常
		System.out.println("the method " + methodName + " end ");
		return result;
	}
}
