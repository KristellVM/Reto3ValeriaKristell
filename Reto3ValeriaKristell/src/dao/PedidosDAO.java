package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import clases.Categoria;
import clases.Cliente;
import clases.Pedido;
import clases.PedidoProducto;
import clases.Producto;
import util.Conexion;
import util.Funciones;

public class PedidosDAO {

	// FUNCION 1
	/*public static PedidoProducto crearPedido() {
		Scanner sc = new Scanner(System.in);

		PedidoProducto pedido = new PedidoProducto();

	

			// mostrar direccion del cliente
			System.out.println(clienteEncontrado.getDireccion());
			// cambiar direccion
			String respuesta = Funciones.dimeString("¿Quieres cambiar la direccion de envio?)", sc);
			if (respuesta == "si") {
				// pido nuevos
				System.out.println("Nueva dirección");
				String nuevaDireccion = sc.nextLine();
				clienteEncontrado.setDireccion(nuevaDireccion);

				ClienteDAO.actualiza(clienteEncontrado, codigo, clienteEncontrado.getNombre(), nuevaDireccion);
				System.out.println("Datos actualizados");
				System.out.println("El precio total del pedido es: " + pedido.getPrecio());
			}

		} // si existe
		return pedido;

	}/*

	/*
	 * 3.1. Crear pedido: pediremos el código de un cliente hasta que exista,
	 * mostrando a continuación el nombre del cliente con ese código. Luego haremos
	 * un bucle en el que vayamos pidiendo nombres de productos. Buscamos en la base
	 * de datos si hay algún producto con ese nombre y si existe, pediremos cuántas
	 * unidades queremos de ese producto. Si hay suficiente stock lo añadiremos al
	 * pedido. Si no hay stock suficiente se comprarán todos los que haya en stock.
	 * Así hasta que terminemos de añadir productos (establecer cómo queréis que
	 * termine, si al pedir el código introduce un -1, o nada, o lo que digáis). Una
	 * vez que ya hemos seleccionado los productos a comprar, se mostrará la
	 * dirección del cliente que habíamos seleccionado antes y preguntaremos si
	 * usamos esa dirección como dirección de envío o no. Si nos dicen que no
	 * pediremos la nueva y pondremos esa como dirección de envío. Guardaremos el
	 * pedido en la base de datos mostrando “Pedido guardado “, e indicaremos el
	 * precio total.
	 */

	// FUNCION 2
	public static List<Pedido> verPedidos() {
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		try {
			// abro conexion
			Connection con = Conexion.abreConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement("select * from pagos where fechapago like '%-05-%'");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				Cliente cliente = new Cliente(rs.getInt("idcliente"), rs.getInt("codigo"), rs.getString("nombre"),
						rs.getString("direccion"));// int idcliente, int codigo, String nombre, String direccion

				Pedido pedido = new Pedido(rs.getInt("idcliente"), cliente, rs.getInt("precioTotal"),
						rs.getString("direccionEnvio"), rs.getDate("fecha"));

				listaPedidos.add(pedido);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// O en el try abrir la conexion
			Conexion.cierraConexion();
		}
		return listaPedidos;

		/* 3.2. Ver pedidos: mostraremos todos los pedidos del mes en el que estamos */

	}

}
