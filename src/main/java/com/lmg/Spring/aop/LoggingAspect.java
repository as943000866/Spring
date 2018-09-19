package com.lmg.Spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


//把这个类声明成一个切面: 需要把该类放到 IOC 容器中、再声明为一个切面
@Aspect
@Component
public class LoggingAspect {
	
	//声明该方法是一个前置通知: 在目标方法开始之前执行
	//@Before("execution(public int com.lmg.Spring.aop.ArithmeticCalulaterImpl.add(int,int))")
	//execution(* com.lmg.Spring.aop.ArithmeticCalulaterImpl.*.*(int,int))
	//匹配 所有权限 所有返回值在 com.lmg.Spring.aop.ArithmeticCalulaterImpl 包下所有类 所有参数为(int,int)方法
	@Before("execution(* com.lmg.Spring.aop.*.*(int,int))")
	public void beforeMethod(JoinPoint joinpoint){
		//通过JoinPoint获取方法的细节
		String methodName = joinpoint.getSignature().getName();
		List<Object> asList = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method begin with " + methodName +","+asList);
	}
	//后置通知: 在目标方法执行后(无论是否发生异常),执行的通知
	//在后置通知中还不能访问目标方法执行的结果
	@After("execution(* com.lmg.Spring.aop.*.*(int,int))")
	public void afterMethod(JoinPoint joinpoint){
		String methodName = joinpoint.getSignature().getName();
		System.out.println("The method end " + methodName );
	}
}
