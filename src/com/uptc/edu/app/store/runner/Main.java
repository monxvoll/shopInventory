package com.uptc.edu.app.store.runner;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.uptc.edu.app.store.enums.EtypeFile;
import com.uptc.edu.app.store.model.Product;
import com.uptc.edu.app.store.persistence.managementPersistenceProduct;


public class Main {
	static Scanner sc= new Scanner(System.in);
	public static void main (String [] args) {
		
		//Menu inicial
	while (true) {
	
	System.out.println("BIENVENIDO");
	System.out.println("*********************");
	System.out.println("Menu: ");
	System.out.println("1. Agregar productos");
	System.out.println("2. Mostrar productos");
	System.out.println("3. Comprar productos");
	System.out.println("4. Monitoreo");
	System.out.println("5. Salir");
	String op = sc.nextLine();
	
	
		try {
			
	int option = Integer.parseInt(op);
	
	switch (option) {
	case 1:
		
		break;
	case 2: 
		
		break;
	case 3:
		
		break;
		
	case 4:
		
		break;
	case 5:
		System.exit(0);
		
		//Default que se ejecuta si la opcion es un dato int diferente de (1 a 5)
	default:
		System.out.println("Por favor digite una opcion valida");
			break;
	}
	    //Se maneja la excepcion
		}catch(NumberFormatException e) {
			System.out.println("Por favor digite una opcion valida");
		}
	}
}

	
public void add() {
	Map <String, Product> products = new HashMap<>();
	System.out.println("¿Cuantos productos desea agregar?");
	int j= sc.nextInt();
	String code;
	for (int i=0; i<j; i++) {
		Product aux= new Product();
		System.out.println("Escriba el codigo del producto");
		code = sc.next();
		aux.setCode(code);
		System.out.println("Escriba el nombre del producto");
		aux.setDescription(sc.next());
		System.out.println("Escriba el precio /u");
		aux.setPrice(sc.nextLine());
		System.out.println("Escriba el stock del producto");
		aux.setAmount(sc.nextLine());
		products.put(code, aux);	
	}
	managementPersistenceProduct per = new managementPersistenceProduct();
	per.setProducts(products);
	per.dumpFile(EtypeFile.XML);
	
}

}

