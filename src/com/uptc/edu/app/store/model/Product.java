package com.uptc.edu.app.store.model;

public class Product {
	
	//Se inicializan las variables
	private String code;
	private String description;
	private double price;
	private int amount;
	
	public Product() {
		
	}
	//Getters and Setters
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
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
	
	public Product(String code, String description, double price, int amount) {
		this.code = code;
		this.description = description;
		this.price = price;
		this.amount = amount;
	}

}
