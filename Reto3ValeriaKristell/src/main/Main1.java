package main;

import java.util.Scanner;

import clases.Categoria;
import dao.CategoriaDAO;
import util.Funciones;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		
		do {
			opcion = Funciones.dimeEntero("Elige una opcion: 0-Salir 1-GestionCategorias:, 2-GestionProductos 3-GestionClientes ", sc);
			switch (opcion) {
			case 1:
				gestionCategorias(sc);
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
	
	public static void gestionCategorias(Scanner sc) {
		String nombre=Funciones.dimeString("Introduce nombre de categoria nueva: ", sc);
		Categoria c = new Categoria(nombre);
		CategoriaDAO.inserta(c);
	}

}
