package main;

import java.util.Scanner;

import clases.Categoria;
import clases.Cliente;
import dao.CategoriaDAO;
import dao.ClienteDAO;
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
	
	public static void gestionClientes(Scanner sc) {
		int codigo = Funciones.dimeEntero("Introduce codigo de cliente: ", sc);
		Cliente cliente1 = ClienteDAO.buscar(codigo);
		if(cliente1!=null) {
			cliente1.toString();
			
		} else {
			System.out.println("no existe un cliente con el codigo "+codigo);
		}
	}

}
