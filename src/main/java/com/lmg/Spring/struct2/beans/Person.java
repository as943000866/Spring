package com.lmg.Spring.struct2.beans;

public class Person {
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void hello(){
		System.out.println("My Name is " + username);
	}
}
