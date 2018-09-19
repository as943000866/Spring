package com.lmg.Spring.aop.supplement.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class ValidationAspect {
	
	public void vlidationMethod(JoinPoint joinPoint){
		System.out.println("vilitation :" + Arrays.asList(joinPoint.getArgs()));
	}
}
