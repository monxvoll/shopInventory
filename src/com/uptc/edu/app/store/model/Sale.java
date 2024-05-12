package com.uptc.edu.app.store.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sale {
	
	//Se inicializan las variables
	private String productCode;
	private String total;
	
	//Se inicializa la fecha con la fecha del sistema
	LocalDate fechaActual = LocalDate.now();
	LocalTime hora= LocalTime.now();
	
	//Getters y Setters
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public LocalDate getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}
	
	
	//Constructor de la clase
	
	@Override
	public String toString() {
		return "Sale [productCode=" + productCode + ", total=" + total + ", fechaActual=" + fechaActual + ", hora="
				+ hora + "]";
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public Sale(String productCode, String total, LocalDate fechaActual, LocalTime hora) {
		this.productCode = productCode;
		this.total = total;
		this.fechaActual = fechaActual;
		this.hora = hora;
	}
	/*//Metodo ToString
		@Override
	    public String toString() {
	        return "CodigoProducto: " + productCode + " " +
	               "Precio  " + total + " " +
	               "Price: " + price + " " +
	               "Amount: " + amount;
	    }*/

}
