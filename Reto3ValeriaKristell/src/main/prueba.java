package main;

import java.util.List;
import java.util.Scanner;

import clases.Cliente;
import clases.Pedido;
import clases.PedidoProducto;
import clases.Producto;
import dao.ClienteDAO;
import dao.PedidosDAO;
import dao.ProductoDAO;
import util.Funciones;

public class prueba {
	public static void crearPedido() {

		Scanner sc = new Scanner(System.in);
		Cliente clienteEncontrado = null;
		int codigo;

		do {
			codigo = Funciones.dimeEntero("Introduce el codigo de un cliente", sc);
			clienteEncontrado = dao.ClienteDAO.buscar(codigo);
			if (clienteEncontrado != null) {
				System.out.println(clienteEncontrado.getNombre());
			}
		} while (clienteEncontrado == null);

		Producto productoEncontrado = null;
		String nomProd;
		int cont = 0;

		int opcion = 0;

		do {

			if (opcion != 2) {
				if (cont != 0) {

					opcion = Funciones.dimeEntero("¿Quieres seguir añadiendo productos, 1- Si , 2-No?", sc);

				}

				do {
					nomProd = Funciones.dimeString("Introduce el nombre del producto que quieres", sc);
					productoEncontrado = dao.ProductoDAO.BuscarProductonombre(nomProd);

				} while (productoEncontrado == null);
				cont++;
			}

		} while (opcion != 2);

	}

	public static void main(String[] args) {
		crearPedido();

	}
}