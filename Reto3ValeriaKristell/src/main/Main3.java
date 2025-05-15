package main;

import java.util.Scanner;

import clases.Cliente;
import clases.PedidoProducto;
import clases.Producto;
import dao.PedidosDAO;
import util.Funciones;

public class Main3 {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);

	
	int opcion;

	do {
		opcion = Funciones.dimeEntero("Elige una opcion:\n0-Salir\n1-Crear pedido\n2-Ver pedidos", sc);

		switch (opcion) {
		case 1:
		PedidosDAO.crearPedido();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		
		default:
			System.out.println("Opcion inválida. Seleccionar otra vez");
			break;
		}
	} while (opcion != 0);
	
	}
	
	public static void crearPedido(Scanner sc) {
		Cliente clienteEncontrado = null;
		int codigo;

		do {
			codigo = Funciones.dimeEntero("Introduce el codigo de un cliente", sc);
			clienteEncontrado = dao.ClienteDAO.buscar(codigo);
			if(clienteEncontrado!=null) {
				System.out.println(clienteEncontrado.getNombre());
			}
		} while (clienteEncontrado == null);
		
		Producto productoEncontrado = null;
		String nomProd;
		
		do {
			nomProd = Funciones.dimeString("Introduce el nombre del producto que quieres", sc);
			productoEncontrado = dao.ProductoDAO.BuscarProductonombre(nomProd);
		} while (productoEncontrado == null);
		
		int cantProd = Funciones.dimeEntero("Cuantas unidades quieres del producto?", sc);
		// si mi el stock del producto>=esa cant
		if (productoEncontrado.getStock() >= cantProd) {
			//pedido.anadirProducto(productoEncontrado);
		}
		// si no hay suficiente stock-> los que tenga
		else {
			for (int i = 0; i < cantProd; i++) {
				//pedido.anadirProducto(productoEncontrado);
			}
		} // else
		
	}

}
