package main;

import java.util.Scanner;

import util.Funciones;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		
		do {
			opcion = Funciones.dimeEntero("Elige una opcion: 0-Salir 1-GestionCategorias:, 2-GestionProductos 3-GestionClientes ", sc);
			switch (opcion) {
			case 1:
				//GestionCategorias();
				break;

			case 2:
				//GestionProductos();
				break;

			case 3:
				//GestionClientes():
				break;

			default:
				break;
			}
		} while (opcion != 0);

	}

}
