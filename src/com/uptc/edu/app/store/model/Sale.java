package com.uptc.edu.app.store.model;

import java.time.LocalDate;

public class Sale {
	
	//Se inicializan las variables
	private int productCode;
	private double total;
	
	//Se inicializa la fecha con la fecha del sistema
	LocalDate fechaActual = LocalDate.now();
	
	//Getters y Setters
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDate getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}
	
	//Constructor de la clase
	
	public Sale(int productCode, double total, LocalDate fechaActual) {
		this.productCode = productCode;
		this.total = total;
		this.fechaActual = fechaActual;
	}
	

}
