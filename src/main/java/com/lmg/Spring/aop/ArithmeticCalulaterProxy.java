package com.lmg.Spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalulaterProxy {
	private ArithmeticCalulater targer;
	
	public ArithmeticCalulaterProxy(ArithmeticCalulater targer) {
		this.targer = targer;
	}
	
	public ArithmeticCalulater getProxy(){
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader = targer.getClass().getClassLoader();
		//代理对对象的类型,即其中有哪些方法
		Class[] interfaces = targer.getClass().getInterfaces();
		//当调用代理对象其中的方法时, 该执行的代码
		InvocationHandler handler = new InvocationHandler() {
			/**
			 * proxy: 正在返回的那个代理对象.一般情况下,在 invoke 方法中都不使用该对象.
			 * method: 正在被调用的方法
			 * args:调用方法时,传入的参数
			 */
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result =  null;
				//前置通知
				System.out.println("AOP The Method "+method.getName()+" begin with "+Arrays.asList(args));
				try {
					result = (Integer) method.invoke(targer, args);
					//返回通知
					System.out.println("AOP The Method "+method.getName()+" begin with "+ result);
				} catch (Exception e) {
					//异常通知
					System.out.println("AOP The Method"+method.getName()+" occur "+ e);
					throw new RuntimeException(e);
				}
				//后置通知
				System.out.println("AOP The Method "+method.getName()+" end with "+result);
				return result;
			}
		};
		ArithmeticCalulater proxy = (ArithmeticCalulater) Proxy.newProxyInstance(loader, interfaces , handler);
		return proxy;
	}
}
