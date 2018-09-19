package com.lmg.Spring.aop;
/**
 * 普通的日志实现方式优两个缺点
 * ①代码混乱:业务代码和日志代码混合在一起,不利于维护
 * ②代码分散:
 * @author Administrator
 *
 */
public class ArithmeticCalulaterLoggingImpl implements ArithmeticCalulater {

	public int add(int i, int j) {
		System.out.println("AOP The Method begin with add ["+i+","+j+"]");
		int result = i + j;
		System.out.println("AOP The Method end with add " + result);
		return result;
	}

	public int sub(int i, int j) {
		System.out.println("AOP The Method begin with sub ["+i+","+j+"]");
		int result = i - j;
		System.out.println("AOP The Method end with sub " + result);
		return result;
	}

	public int mul(int i, int j) {
		System.out.println("AOP The Method begin with mul ["+i+","+j+"]");
		int result = i * j;
		System.out.println("AOP The Method end with mul " + result);
		return result;
	}

	public int div(int i, int j) {
		System.out.println("AOP The Method begin with div ["+i+","+j+"]");
		int result = i / j;
		System.out.println("AOP The Method end with div " + result);
		return result;
	}

}
