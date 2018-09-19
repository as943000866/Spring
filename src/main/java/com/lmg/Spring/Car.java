package com.lmg.Spring;

public class Car {
	private String brand;
	private String crop;
	private double price;
	private int maxSpeed;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCrop() {
		return crop;
	}
	public void setCrop(String crop) {
		this.crop = crop;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	
	public Car() {
		super();
	}
	public Car(String brand, String crop, int maxSpeed) {
		super();
		this.brand = brand;
		this.crop = crop;
		this.maxSpeed = maxSpeed;
	}
	public Car(String brand, String crop, double price) {
		super();
		this.brand = brand;
		this.crop = crop;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", crop=" + crop + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
	}
	
	
}
