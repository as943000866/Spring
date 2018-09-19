package com.lmg.Spring.jdbc;

public class StudentClass {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentClass() {
		super();
	}
	public StudentClass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "StudentClass [id=" + id + ", name=" + name + "]";
	}
	
	
}
