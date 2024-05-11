
package com.uptc.edu.app.store.runner;

import java.util.HashMap;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.uptc.edu.app.store.enums.EtypeFile;
import com.uptc.edu.app.store.logic.Menu;
import com.uptc.edu.app.store.model.Product;
import com.uptc.edu.app.store.persistence.managementPersistenceProduct;


public class Main {
	static Scanner sc= new Scanner(System.in);
	public static void main (String [] args) {
	 Menu menu = new Menu();
	
	
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
		menu.add();
		break;
	case 2: 
		menu.showProducts();
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

	


}

