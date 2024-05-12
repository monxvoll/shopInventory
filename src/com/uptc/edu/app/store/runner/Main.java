
package com.uptc.edu.app.store.runner;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.uptc.edu.app.store.logic.Menu;


public class Main {
	static Scanner sc= new Scanner(System.in);
	public static void main (String [] args) {
	 Menu menu = new Menu();
	
	
		//Menu inicial
	while (true) {
	
	System.out.println("BIENVENIDO");
	System.out.println("*********************");
	System.out.println("Menu: ");
	System.out.println("1. Agregar productos al inventario");
	System.out.println("2. Mostrar productos del inventario");
	System.out.println("3. Añadir productos al carrito de compras");
	System.out.println("4. Finalizar compra");
	System.out.println("5. Salir");
	System.out.print("Digita aqui: ");
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
			menu.shoppingCart();
			break;
		case 4:
			menu.totalPurchase();
			break;
		case 5:
			System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
			System.exit(0);

			//Default que se ejecuta si la opcion es una variable int diferente de (1 a 5)
		default:
			System.out.println("Por favor digite una opcion valida ");
				break;
		}
	    //Se maneja la excepcion del parseo
		} catch (InputMismatchException | NumberFormatException nmbr) {
		    System.out.println("Por favor digite una opción válida (número)");
		}
		}
	}
}

