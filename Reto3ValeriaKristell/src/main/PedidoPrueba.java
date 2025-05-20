package main;

import java.time.LocalDate;
import java.util.Scanner;

import clases.Cliente;
import clases.Pedido;
import clases.PedidoProducto;
import clases.Producto;
import dao.PedidosDAO;
import util.Funciones;

public class PedidoPrueba {
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
		
		Pedido pedido = new Pedido(clienteEncontrado, 0,"dir1",Funciones.convierte_LocalDate_a_Date(LocalDate.now()));
		PedidosDAO.insertar(pedido);
		Producto productoEncontrado = null;
		String nomProd;

		int opcion = 0, cantProd=0;

		do {
			opcion = Funciones.dimeEntero("¿Quieres seguir agregando productos, 1- Si , 2-No?", sc);
			if (opcion == 1) {

				do {
					nomProd = Funciones.dimeString("Introduce el nombre del producto que quieres", sc);
					productoEncontrado = dao.ProductoDAO.BuscarProductonombre(nomProd);
					if(productoEncontrado!=null) {
						//dao de crear pedido pasadole el idproducto y la cantidad de stock
						cantProd = Funciones.dimeEntero("Cuantas unidades quieres del producto?", sc);
						if(productoEncontrado.getStock()<cantProd) {
							cantProd= productoEncontrado.getStock();
						}
							/*
							 * private int idPedidoProducto;
								private Pedido pedido;
								private Producto producto;
								private int unidades;
								private double precio;
							 * */
							PedidoProducto pp = new PedidoProducto(pedido, productoEncontrado, cantProd, productoEncontrado.getPrecio());
							
						
					}
				} while (productoEncontrado == null);

			}

		} while (opcion != 2);

	}
	public static void main(String[] args) {
		
	}
}
