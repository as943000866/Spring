package com.lmg.Spring.autowire;

public class Car {
	private String brand;
	private double price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Car() {
		super();
		System.out.println("Car construct...");
	}
	@Override
	public String toString() {
		return "Car [barnd=" + brand + ", price=" + price + "]";
	}
	
	
}
