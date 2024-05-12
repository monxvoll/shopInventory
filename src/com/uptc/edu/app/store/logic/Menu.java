package com.uptc.edu.app.store.logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.uptc.edu.app.store.enums.EtypeFile;
import com.uptc.edu.app.store.model.Product;
import com.uptc.edu.app.store.model.Sale;
import com.uptc.edu.app.store.persistence.managementPersistenceProduct;

public class Menu {
	static Scanner sc= new Scanner(System.in);
	Map <String, Product> products = new HashMap<>();
	List<String> shoppingElements = new ArrayList<>();
	
	
	
	//Metodo que añade productos 
	
	public void add() {
	    boolean inputValid = false;

	    System.out.println("Escriba el nombre del producto");
	    String descripcion = sc.next();
	    
	    
	    while (!inputValid) {
	        try {
	            System.out.println("Escriba el codigo del producto");
	            int code = sc.nextInt();
	            sc.nextLine();

	            System.out.println("Escriba el precio /u");
	            String price = sc.next();
	            sc.nextLine();

	            System.out.println("Escriba el stock del producto");
	            int stock = sc.nextInt();
	            sc.nextLine();

	            Product aux = new Product();
	            aux.setDescription(descripcion);
	            aux.setCode(String.valueOf(code));
	            aux.setPrice(price);
	            aux.setAmount(String.valueOf(stock));

	            // Se añade el producto . Key - Value
	            products.put(String.valueOf(code), aux);

	            System.out.println("Producto añadido con éxito");
	            inputValid = true;
	        } catch (InputMismatchException InpEx) {
	            System.out.println("Ingrese un precio válido (número)");
	            sc.nextLine();
	        }
	    }
	    
	    // Entra a la persistencia solo si se agrego con exito
	    if (inputValid) {
	        managementPersistenceProduct per = new managementPersistenceProduct();
	        per.setProducts(products);
	        per.dumpFile(EtypeFile.XML);
	    }
	}
	
	

	
	//Metodo que muestra los productos ya añadidos imprimiendolos con un String builder
	public void showProducts() {
		if (products.isEmpty()) {
			System.out.println("Usted aun no tiene productos registrados");
		}else {
			//itera los valores del map y los imprime
			products.values().forEach(System.out::println);
		}
		
	}
	
	
	
	//Metodo para comprar productos
	public void shoppingCart() {
		
	    if (products.isEmpty()) {
	        System.out.println("No tenemos productos en venta");
	    } else {
	        System.out.println("Los productos que tenemos son :");
	        // Itera los valores del map y realiza las instrucciones 
	        products.values().forEach(product -> {
	            System.out.println("Name: " + product.getDescription());
	            System.out.println("Price: " + product.getPrice());
	            System.out.println("Codigo: " + product.getCode());
	            System.out.println();
	        });
	        System.out.println("Por favor ingrese el codigo del producto que desee añadir");
	        String code = sc.next();
	        Product product = products.get(code);
	        if ( product != null) {
	        	shoppingElements.add(product.getPrice());
	            System.out.println("Producto añadido al carrito con exito");
	            product.setAmount(String.valueOf(Integer.parseInt(product.getAmount())-1));
	            Sale sale= new Sale(product.getCode(),product.getPrice(), LocalDate.now(), LocalTime.now());
	            List<Sale> sales= new ArrayList<Sale>();
	            managementPersistenceProduct mana= new managementPersistenceProduct();
	            sales.add(sale);
	            mana.setSales(sales);
	            mana.dumpFile(EtypeFile.PLAIN);
	            System.out.println(sales.toString());
	        } else {
	            System.out.println("Codigo de producto no encontrado");
	           
	        }
	        
	    }
	}
	
	
	//Metodo que calcula el total de compra
	public void totalPurchase() {
		double totalSum =0;
		if(shoppingElements.isEmpty()) {
			System.out.println("Carrito de compras vacio");
		}else {
			//Recorre la lista de precios y va sumando
			 for (String precios : shoppingElements) {
				 	totalSum = totalSum + Integer.parseInt(precios);
				 
			}
			 
			 System.out.println("Su compra se realizo por el valor de : $"+ totalSum +" cop");	
			 totalSum=0;
			 shoppingElements.clear();
		} 
	}
}
		

