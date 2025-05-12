package main;

import java.util.Scanner;

import util.Funciones;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		
		do {
			opcion = Funciones.dimeEntero("Elige una opcion, selecciona 0 para salir", sc);
			switch (opcion) {
			case 1:
				//FuncionMantenimientos();
				break;

			case 2:
				//FuncionCatalogoProductos();
				break;

			case 3:
				//FuncionPedidos():
				break;

			case 4:
				//FuncionInformes();				
				break;

			default:
				break;
			}
		} while (opcion != 0);

	}
	
	
	
	
	
	
}
