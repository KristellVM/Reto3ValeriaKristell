package main;

import java.util.List;
import java.util.Scanner;

import clases.Categoria;
import clases.Cliente;
import clases.Producto;
import dao.CategoriaDAO;
import dao.ClienteDAO;
import dao.ProductoDAO;
import util.Funciones;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			opcion = Funciones.dimeEntero("Elige una opcion:", sc);
			System.out.println("0-Salir");
			System.out.println(" 1-GestionCategorias");
			System.out.println(" 2-GestionProductos");
			System.out.println("lientes");

			switch (opcion) {
			case 1:
				gestionCategorias(sc);
				break;
			case 2:
				gestionProductos(sc);
				break;
			case 3:
				gestionClientes(sc);
				break;
			case 0:
				System.out.println("Saliendo de mantenimientos");
				break;
			default:
				System.out.println("Opci�n inv�lida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);

	}

	public static void gestionCategorias(Scanner sc) {
		String nombre = Funciones.dimeString("Introduce nombre de categoria nueva: ", sc);
		Categoria c = new Categoria(nombre);
		CategoriaDAO.inserta(c);
	}

	public static void gestionProductos(Scanner sc) {
		/*
		 * Producto(Categoria categoria, String nombre, double precio, String
		 * descripcion, String color, String talla, int stock)
		 */
		/*
		 * String nombre = Funciones.dimeString("Introduce nombre: ", sc); double precio
		 * = Funciones.dimeDouble("Introduce precio: ", sc); String desc =
		 * Funciones.dimeString("Introduce descripci�n: ", sc); String color =
		 * Funciones.dimeString("Introduce color: ", sc); String talla =
		 * Funciones.dimeString("Introduce talla: ", sc); int stock =
		 * Funciones.dimeEntero("Introduce stock: ", sc);
		 */
		List<Categoria> categorias = CategoriaDAO.lista();
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}
		int idCategoria = -1;
		do {
			idCategoria = Funciones.dimeEntero("Selecciona idCategoria: ", sc);
		} while (idCategoria < 0 || idCategoria >= categorias.size());

		Producto p = new Producto(categorias.get(idCategoria - 1), Funciones.dimeString("Introduce nombre: ", sc),
				Funciones.dimeDouble("Introduce precio: ", sc), Funciones.dimeString("Introduce descripci�n: ", sc),
				Funciones.dimeString("Introduce color: ", sc), Funciones.dimeString("Introduce talla: ", sc),
				Funciones.dimeEntero("Introduce stock: ", sc));
		ProductoDAO.insertar(p);
	}

	public static void gestionClientes(Scanner sc) {
		int opcion;

		do {
			opcion = Funciones.dimeEntero("Elige una opcion:\n0-Salir\n1-Buscar por codigo\n2-Dar alta a nuevo cliente",
					sc);
			switch (opcion) {
			case 1:
				busquedaPorCodigo(sc);
				break;

			case 2:
				insertarCliente(sc);
				break;
			case 0:
				System.out.println("Saliendo de gesti�n clientes");
			default:
				System.out.println("Opci�n inv�lida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);
	}

	public static void insertarCliente(Scanner sc) {
		Cliente c = new Cliente(Funciones.dimeEntero("Introduce codigo: ", sc),
				Funciones.dimeString("Introduce nombre: ", sc), Funciones.dimeString("Introduce direccion: ", sc));
		ClienteDAO.inserta(c);
	}

	public static void busquedaPorCodigo(Scanner sc) {
		int codigo = Funciones.dimeEntero("Introduce codigo de cliente: ", sc);
		Cliente cliente1 = ClienteDAO.buscar(codigo);
		if (cliente1 != null) {
			cliente1.toString();
			System.out.println("Datos nuevos: ");
			int nuevoCodigo = Funciones.dimeEntero("Introduce codigo: ", sc);
			String nombre = Funciones.dimeString("Introduce nombre: ", sc);
			String direccion = Funciones.dimeString("Introduce direccion: ", sc);
			ClienteDAO.actualiza(cliente1, nuevoCodigo, nombre, direccion);
		} else {
			System.out.println("no existe un cliente con el codigo " + codigo);
		}
	}

}
