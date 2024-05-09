package com.uptc.edu.app.store.runner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.uptc.edu.app.store.enums.EtypeFile;
import com.uptc.edu.app.store.model.Product;
import com.uptc.edu.app.store.persistence.managementPersistence;


public class Main {
	static Scanner sc= new Scanner(System.in);
	public static void main (String [] args) {
		
	System.out.println("BIENVENIDO");
	System.out.println("*********************");
	System.out.println("Menu: ");
	System.out.println("1. Agregar productos");
	System.out.println("2. Mostrar productos");
	System.out.println("3. Comprar productos");
	System.out.println("4. Monitoreo");
	System.out.println("5. Salir");
	int op = sc.nextInt();
	do {
	switch (op) {
	case 1:
		
		break;
	case 2: 
		
		break;
	case 3:
		
		break;
		
	case 4:
		
		break;
	}
	}while (op>1 | op<5);
	
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
		aux.setPrice(sc.nextDouble());
		System.out.println("Escriba la cantidad de productos disponibles");
		aux.setPrice(sc.nextDouble());
		products.put(code, aux);	
	}
	managementPersistence per= new managementPersistence();
	per.setproductos(products);
	per.dumpFile(EtypeFile.XML);
	
}

}

