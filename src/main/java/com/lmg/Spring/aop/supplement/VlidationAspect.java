package com.lmg.Spring.aop.supplement;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class VlidationAspect {
	
	@Before("LoggingAspect.declarePointExpression()")
	public void vlidationMethod(JoinPoint joinPoint){
		System.out.println("vilitation :" + Arrays.asList(joinPoint.getArgs()));
	}
}
