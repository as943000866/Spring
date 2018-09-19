package com.lmg.Spring.aop.supplement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aopSupplement.xml");
		ArithmeticCalulater arithmeticCalulater = (ArithmeticCalulater) ctx.getBean("arithmeticCalulater");
		arithmeticCalulater.add(1, 2);
		System.out.println();
		arithmeticCalulater.div(100, 0);
	}
}
