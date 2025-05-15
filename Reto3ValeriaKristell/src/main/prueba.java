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

		int opcion = 1;

		do {
<<<<<<< HEAD

			if (opcion == 1) {
				if (cont != 0) {
					opcion = Funciones.dimeEntero("¿Quieres seguir añadiendo productos, 1- Si , 2-No?", sc);
				}
=======
			opcion = Funciones.dimeEntero("¿Quieres seguir añadiendo productos, 1- Si , 2-No?", sc);
			if (opcion == 1) {
>>>>>>> branch 'main' of https://github.com/KristellVM/Reto3ValeriaKristell.git

				do {
					nomProd = Funciones.dimeString("Introduce el nombre del producto que quieres", sc);
					productoEncontrado = dao.ProductoDAO.BuscarProductonombre(nomProd);
					
				} while (productoEncontrado == null);

			}

		} while (opcion != 2);
		
		do {
			opcion = Funciones.dimeEntero("¿Quieres seguir añadiendo productos, 1- Si , 2-No?", sc);
			if(opcion!=2) {
				do {
					if(productoEncontrado!=null) {
						
					}
					nomProd = Funciones.dimeString("Introduce el nombre del producto que quieres", sc);
					productoEncontrado = dao.ProductoDAO.BuscarProductonombre(nomProd);
					
				} while (productoEncontrado == null);
			}
		} while(opcion!=2);

	}

	public static void main(String[] args) {
		crearPedido();

	}
}