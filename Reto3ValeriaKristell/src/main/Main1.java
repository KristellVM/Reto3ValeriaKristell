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
				gestionClientes(sc);
				break;
			case 0:
				System.out.println("Saliendo de mantenimientos");
			default:
				System.out.println("Opción inválida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);

	}
	
	public static void gestionCategorias(Scanner sc) {
		String nombre=Funciones.dimeString("Introduce nombre de categoria nueva: ", sc);
		Categoria c = new Categoria(nombre);
		CategoriaDAO.inserta(c);
	}
	
	public void gestionProductos(Scanner sc) {
		
	}
	
	public static void gestionClientes(Scanner sc) {
		int opcion;
		
		do {
			opcion = Funciones.dimeEntero("Elige una opcion:\n0-Salir\n1-Buscar por codigo\n2-Dar alta a nuevo cliente", sc);
			switch (opcion) {
			case 1:
				busquedaPorCodigo(sc);
				break;

			case 2:
				insertarCliente(sc);
				break;
			case 0:
				System.out.println("Saliendo de gestión clientes");
			default:
				System.out.println("Opción inválida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);
	}
	
	public static void insertarCliente(Scanner sc) {
		Cliente c = new Cliente(Funciones.dimeEntero("Introduce codigo: ", sc),Funciones.dimeString("Introduce nombre: ", sc),Funciones.dimeString("Introduce direccion: ", sc));
		ClienteDAO.inserta(c);
	}
	
	public static void busquedaPorCodigo(Scanner sc) {
		int codigo = Funciones.dimeEntero("Introduce codigo de cliente: ", sc);
		Cliente cliente1 = ClienteDAO.buscar(codigo);
		if(cliente1!=null) {
			cliente1.toString();
			System.out.println("Datos nuevos: ");
			int nuevoCodigo = Funciones.dimeEntero("Introduce codigo: ", sc);
			String nombre = Funciones.dimeString("Introduce nombre: ", sc);
			String direccion = Funciones.dimeString("Introduce direccion: ", sc);
			ClienteDAO.actualiza(cliente1, nuevoCodigo, nombre, direccion);
		} else {
			System.out.println("no existe un cliente con el codigo "+codigo);
		}
	}

}
