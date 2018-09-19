package com.lmg.Spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lmg.Spring.autowire.Car;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		car = (Car) ctx.getBean("car");
		System.out.println(car);
	}
}
