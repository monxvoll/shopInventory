package com.uptc.edu.app.store.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.uptc.edu.app.store.enums.EtypeFile;
import com.uptc.edu.app.store.model.Product;
import com.uptc.edu.app.store.persistence.managementPersistenceProduct;

public class Menu {
	static Scanner sc= new Scanner(System.in);
	Map <String, Product> products = new HashMap<>();
	
	
	//Metodo que añade productos 
	public void add() {
		
			
	
		try {
		System.out.println("¿Cuantos productos desea agregar?");
			
		String  cuantity = sc.next();
		int lenght = Integer.parseInt(cuantity);
		
		String code;
		for (int i=0; i<lenght; i++) {
			Product aux= new Product();
			System.out.println("Escriba el codigo del producto");
			code = sc.next();
			aux.setCode(code);
			System.out.println("Escriba el nombre del producto");
			aux.setDescription(sc.next());
			System.out.println("Escriba el precio /u");
			aux.setPrice(sc.next());
			System.out.println("Escriba el stock del producto");
			aux.setAmount(sc.next());
			products.put(code, aux);	
		}
		}catch(NumberFormatException exp) {
			System.out.println("Por favor digite una cantidad valida");
		}
		
		managementPersistenceProduct per = new managementPersistenceProduct();
		per.setProducts(products);
		per.dumpFile(EtypeFile.XML);
		
	}

	//Metodo que muestra los productos ya añadidos
	public void showProducts() {
		if (products.isEmpty()) {
			System.out.println("Uste aun no tiene productos registrados");
		}else {
			System.out.println(products.toString());
		}
		
	}
}