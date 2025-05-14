package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clases.Producto;
import dao.ProductoDAO;
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
				BuscarProductos(sc);
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
	
	public static void BuscarProductos(Scanner sc) {
		System.out.println("Introduce nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce talla: ");
		String talla = sc.nextLine();
		System.out.println("Introduce color: ");
		String color = sc.nextLine();
		List<Producto> lista = ProductoDAO.BuscarProducto(nombre, talla, color);
		if(lista.isEmpty()) {
			System.out.println("no se encontraron productos");
		} else {
			for (Producto producto : lista) {
				System.out.println(producto);
			}
		}
	}
}

