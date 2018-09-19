package com.lmg.Spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
//		ArithmeticCalulater calulater = new ArithmeticCalulaterLoggingImpl();
		ArithmeticCalulater calulater = new ArithmeticCalulaterImpl();
		ArithmeticCalulater proxy = new ArithmeticCalulaterProxy(calulater).getProxy();
				  
		
		int result = proxy.add(1, 2);
		System.out.println();
		result = proxy.div(4, 0);
		System.out.println("---------------");
		//1.创建 Sping 的 IOC 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-aop.xml");
		
		//2.从 IOC 容器中获取 bean 的实例
		calulater = (ArithmeticCalulater) ctx.getBean("arithmeticCalulaterImpl");
		
		//使用 bean
		result = calulater.add(3, 3);
	}
}
