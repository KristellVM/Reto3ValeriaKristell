package main;

import java.util.Scanner;

import util.Funciones;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		
		do {
			opcion = Funciones.dimeEntero("Elige una opcion: 0-Salir\n1-Listar Productos Por Categoria:\n2-Buscar productos", sc);
			switch (opcion) {
			case 1:
				ProductosPorCategoria(sc);
				break;
			case 2:
				break;
			case 0:
				System.out.println("Saliendo de catálogo de productos");
				break;
			default:
				System.out.println("Opción inválida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);

	}
	
	public static void ProductosPorCategoria(Scanner sc) {
		
	}
}

