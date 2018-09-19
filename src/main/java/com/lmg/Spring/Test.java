package com.lmg.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		
		Person person1 = (Person) ctx.getBean("person1");
		System.out.println(person1);
		
		Person1 person2 = (Person1) ctx.getBean("person2");
		System.out.println(person2);
		
		Person1 person3 = (Person1) ctx.getBean("person3");
		System.out.println(person3);
		
		Person2 person4 = (Person2) ctx.getBean("person4");
		System.out.println(person4);
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
		
		Person person5 = (Person) ctx.getBean("person5");
		System.out.println(person5);
		
	}
}
