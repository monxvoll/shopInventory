package com.uptc.edu.app.store.logic;

public class Product {
	
	//Se inicializan las variables
	private int code;
	private String description;
	private double price;
	private int amount;
	
	
	//Getters and Setters
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	//Constructor de la clase
	
	public Product(int code, String description, double price, int amount) {
		this.code = code;
		this.description = description;
		this.price = price;
		this.amount = amount;
	}

}
