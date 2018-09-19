package com.lmg.Spring.aop.supplement;

import org.springframework.stereotype.Component;

@Component("arithmeticCalulater")
public class ArithmeticCalulaterImpl implements ArithmeticCalulater {

	public int add(int i, int j) {
		int result = i + j;
		System.out.println(result);
		return result;
	}

	public int sub(int i, int j) {
		int result = i - j;
		System.out.println(result);
		return result;
	}

	public int mul(int i, int j) {
		int result = i * j;
		System.out.println(result);
		return result;
	}

	public int div(int i, int j) {
		int result = i / j;
		System.out.println(result);
		return result;
	}

}
