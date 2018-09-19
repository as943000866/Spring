package com.lmg.Spring.hibernate.entities;

public class Account {
	private Integer id;
	private String username;
	private int balance;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Account(Integer id, String username, int balance) {
		super();
		this.id = id;
		this.username = username;
		this.balance = balance;
	}
	public Account() {
		super();
	}
	
	
}
