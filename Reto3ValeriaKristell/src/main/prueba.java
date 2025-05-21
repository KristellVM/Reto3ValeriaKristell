package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import clases.Cliente;
import clases.Pedido;
import clases.PedidoProducto;
import clases.Producto;
import dao.ClienteDAO;
import dao.PedidoProductoDAO;
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
		
		Pedido pedido = new Pedido(clienteEncontrado, 0,clienteEncontrado.getDireccion(),Funciones.convierte_LocalDate_a_Date(LocalDate.now()));
		PedidosDAO.insertar(pedido);
		Producto productoEncontrado = null;
		String nomProd, nuevaDir;

		int opcion = 0, cantProd=0, stockNuevo=0;
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
							stockNuevo=productoEncontrado.getStock()-cantProd;
							PedidoProducto pp = new PedidoProducto(pedido, productoEncontrado, cantProd, productoEncontrado.getPrecio());
							PedidoProductoDAO.insertar(pp);
							ProductoDAO.updateStock(productoEncontrado, stockNuevo);
					}
				} while (productoEncontrado == null);
			}
		} while (opcion != 2);
		int opcNuevaDir = Funciones.dimeEntero("Usar: '"+clienteEncontrado.getDireccion()+"' como  direccion de envio? 1-si 2-no", sc);
		if (opcNuevaDir == 2) {
			nuevaDir = Funciones.dimeString("Introduce direccion de envio: ", sc); 
		} else {
			nuevaDir = clienteEncontrado.getDireccion();
		}
		double precioFinal = PedidoProductoDAO.precioTotal(pedido.getIdPedido());
		PedidosDAO.actualizaDirPrecio(pedido, nuevaDir, precioFinal);
		System.out.println("Pedido guardado. El precio final es: "+precioFinal);
	}

	public static void main(String[] args) {
		
		crearPedido();

	}
}