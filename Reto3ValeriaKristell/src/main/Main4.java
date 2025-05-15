package main;

import java.util.List;
import java.util.Scanner;

import clases.Producto;
import dao.ProductoDAO;
import util.Funciones;

public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			opcion = Funciones.dimeEntero("Elige una opcion:\n0-Salir\n1-GestionCategorias\n2-GestionProductos\n3-GestionClientes", sc);

			switch (opcion) {
			case 1:
				bajoStock(sc);
				break;
			case 2:
				//gestionProductos(sc);
				break;
			case 3:
				//gestionClientes(sc);
				break;
			case 0:
				System.out.println("Saliendo de mantenimientos");
				break;
			default:
				System.out.println("Opcion no valida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);
	}
	
	public static void bajoStock(Scanner sc) {
		List<Producto> listaBajoStock = ProductoDAO.mostrarProductos();
		
		for (Producto producto : listaBajoStock) {
			if(producto.getStock()<5) {
				System.out.println(producto);
			}
		}
		
	}

}
