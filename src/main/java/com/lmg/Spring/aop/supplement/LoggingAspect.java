package com.lmg.Spring.aop.supplement;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 可以使用 @Order 注解指定切面的优先级,值越小优先级越高
 * @author Administrator
 *
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * 定义一个方法, 用于声明切入点表达式. 一般的, 该方法中不需要添加入其他代码.
	 * 使用 @Pointcut 来声明切入点表达式.
	 * 后面的其他通知直接使用方法名来引用当前的切入点表达式
	 */
	@Pointcut("execution(public int com.lmg.Spring.aop.supplement.*.*(..))")
	public void declarePointExpression(){}
	
	/**
	 * 在 com.lmg.Spring.aop.supplement 包中每一个实现类的每一个方法开始之前执行一段代码
	 * @param joinPoint
	 */
	@Before("declarePointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("the method "+methodName+" start with" + Arrays.asList(args));
	}
	/**
	 * 在方法执行之后添加的代码. 无论该方法是否出现异常
	 * @param joinPoint
	 */
	@After("declarePointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " end ");
	}
	/**
	 * 在方法正常结束后执行的代码
	 * 返回通知是可以访问到方法的返回值的
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(returning="result",value="declarePointExpression()")
	public void afterReturningMethod(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " result: "+result);
	}
	/**
	 * 在目标方法出现异常时会执行的代码
	 * 可以访问到异常对象; 且可以在指定在出现特定异常时执行通知代码
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(throwing = "e",value="declarePointExpression()")
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method " + methodName + " occur " + e);
	}
	/**
	 * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
	 * 环绕通知类似于动态代理的过程: ProcessdingJoinPoint 类型的参数可以决定是否执行目标方法.
	 * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
	 * @param pjp
	 * @return
	 */
//	@Around("execution(public int com.lmg.Spring.aop.supplement.*.*(..))")
//	public Object aroundMethod(ProceedingJoinPoint pjp){
//		Object result = null;
//		//获取方法名
//		String methodName = pjp.getSignature().getName();
//		//获取参数列表
//		Object[] args = pjp.getArgs();
//		try {
//			//前置通知
//			System.out.println("the method "+methodName+" start with" + Arrays.asList(args));
//
//			result = pjp.proceed();
//		
//			System.out.println("the method " + methodName + " result: "+result);
//			
//		} catch (Throwable e) {
//			//异常通知
////			e.printStackTrace();
//			System.out.println("the method " + methodName + " occur " + e);
//			throw new RuntimeException(e);
//		}
//		//后置通知  无法获取 result 对象,由于方法可能在执行中发生异常
//		System.out.println("the method " + methodName + " end ");
//		return result;
//	}
}
