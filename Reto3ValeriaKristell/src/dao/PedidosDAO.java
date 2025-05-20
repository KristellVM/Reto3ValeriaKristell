package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	 /* 3.1. Crear pedido: pediremos el código de un cliente hasta que exista,
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
	public static void insertar(Pedido pedido) {
		try {
			// abro conexion
			Connection con = Conexion.abreConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement("INSERT INTO pedidos(idcliente,precioTotal, direccionEnvio, fecha) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, pedido.getCliente().getIdcliente());
			pst.setDouble(2, pedido.getPrecioTotal());
			pst.setString(3, pedido.getDireccionEnvio());
			pst.setDate(4, Funciones.convierteFecha(pedido.getFecha()));
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
				pedido.setIdPedido(rs.getInt(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// O en el try abrir la conexion
			Conexion.cierraConexion();
		}
	}
	// FUNCION 2
	public static List<Pedido> verPedidos() {
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		try {
			// abro conexion
			Connection con = Conexion.abreConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement(
					"SELECT pe.idpedido,pe.precioTotal, pe.direccionEnvio, pe.fecha, cl.idcliente, cl.codigo, cl.nombre, cl.direccion\r\n"
					+ "	from pedidos pe \r\n"
					+ "	inner join clientes cl on pe.idcliente = cl.idcliente"
					+ " where month(pe.fecha)= month(curdate());");
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt("idcliente"), rs.getInt("codigo"), rs.getString(7),rs.getString("direccion"));
				Pedido pedido = new Pedido(rs.getInt("idpedido"), cliente, rs.getInt("precioTotal"), rs.getString("direccionEnvio"), rs.getDate("fecha"));
				listaPedidos.add(pedido);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// O en el try abrir la conexion
			Conexion.cierraConexion();
		}
		return listaPedidos;
	}

	public static void actualizaDirPrecio(Pedido pedido, String direccion, Double precio) {
		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement("update pedidos\r\n"
					+ "set precioTotal = ?,\r\n"
					+ "direccionEnvio = ?\r\n"
					+ "where idpedido=?;");
			pst.setDouble(1, precio);
			pst.setString(2, direccion);
			pst.setInt(3, pedido.getIdPedido());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// O en el try abrir la conexion
			Conexion.cierraConexion();
		}
	
	}
}


