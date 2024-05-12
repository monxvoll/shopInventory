package com.uptc.edu.app.store.logic;


import java.text.DecimalFormat;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;



import com.uptc.edu.app.store.enums.EtypeFile;
import com.uptc.edu.app.store.model.Product;
import com.uptc.edu.app.store.model.Sale;
import com.uptc.edu.app.store.persistence.FilePlain;
import com.uptc.edu.app.store.persistence.managementPersistenceProduct;

public class Menu {
	static Scanner sc= new Scanner(System.in);
	Map <String, Product> products = new HashMap<>();
	List<Double> shoppingElements = new ArrayList<>();
	FilePlain file = new FilePlain();
	
	
	//Metodo que añade productos 
	
	public void add() {
		
	    boolean inputValid = false;

	    while (!inputValid) {
	        try {
	            System.out.println("Escriba el nombre del producto");
	            String description = sc.nextLine();

	            System.out.println("Escriba el código del producto");
	            int code = Integer.parseInt(sc.nextLine());

	            System.out.println("Escriba el precio /u");
	            String priceInput = sc.nextLine();

	            // Reemplazar punto  del precio con  una coma
	            priceInput = priceInput.replace('.', ',');
	            
	            // Formatear precio
	            DecimalFormat df = new DecimalFormat("#,###.###");
	            double price = df.parse(priceInput).doubleValue();

	            System.out.println("Escriba el stock del producto");
	            int stock = Integer.parseInt(sc.nextLine());

	            Product aux = new Product();
	            aux.setDescription(description);
	            aux.setCode(String.valueOf(code));
	            aux.setPrice(String.valueOf(price)); // Se mantiene como String
	            aux.setAmount(String.valueOf(stock));

	            // Se añade el producto. Key - Value
	            products.put(String.valueOf(code), aux);

	            System.out.println("Producto añadido con éxito");
	            inputValid = true;
	        } catch (Exception ex) {
	            System.out.println("Por favor ingrese un formato válido para el (código, precio y stock).");
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
	
	
	
	// Método para comprar productos
	public void shoppingCart() {
	    if (products.isEmpty()) {
	        System.out.println("No tenemos productos en venta");
	    } else {
	        System.out.println("Los productos que tenemos son :");
	        // Itera los valores del mapa y muestra los productos
	        products.values().forEach(product -> {
	            System.out.println("Name: " + product.getDescription());
	            System.out.println("Price: " + product.getPrice());
	            System.out.println("Codigo: " + product.getCode());
	            System.out.println();
	        });
	        System.out.println("Por favor ingrese el código del producto que desee añadir");
	        String code = sc.nextLine();
	        Product product = products.get(code);
	        
	        if (product != null) {
	            double price = Double.parseDouble(product.getPrice());
	            shoppingElements.add(price);
	            System.out.println("Producto añadido al carrito con éxito");
	            product.setAmount(String.valueOf(Integer.parseInt(product.getAmount()) - 1));
	            Sale sale = new Sale(product.getCode(), product.getPrice(), LocalDate.now(), LocalTime.now());
	            List<Sale> sales = new ArrayList<Sale>();
	            managementPersistenceProduct mana = new managementPersistenceProduct();
	            System.out.println(file.alertStock(product));
	            sales.add(sale);
	            mana.setSales(sales);
	            
	            mana.dumpFile(EtypeFile.PLAIN);
	        } else {
	            System.out.println("Código de producto no encontrado");
	        }
	    }
	
	}
	
	
	// Método que calcula el total de compra
	public void totalPurchase() {
	    double totalSum = 0;
	    if (shoppingElements.isEmpty()) {
	        System.out.println("Carrito de compras vacío");
	    } else {
	        // Recorre la lista de precios y va sumando
	        for (Double price : shoppingElements) {
	            totalSum += price;
	        }

	        System.out.println("Su compra se realizó por el valor de: $" + totalSum + " cop");
	        shoppingElements.clear();
	    }
	}
	
	
	

}
		

