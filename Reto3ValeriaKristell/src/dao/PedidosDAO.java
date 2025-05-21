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
					+ " where month(pe.fecha)= month(curdate()) order by pe.fecha desc;");
			
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
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// O en el try abrir la conexion
			Conexion.cierraConexion();
		}
	
	}
	
	public static void eliminarPedidoVacio(int idPedido) {
		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement("DELETE from pedidos where idpedido=?");
			pst.setInt(1, idPedido);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			Conexion.cierraConexion();
		}
	}
	
	public static List<Pedido> PedidosPorCliente(Cliente cliente) { // nunca scanner en los daos-> main
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		// busco los pedidos de ese cliente
		try {
			// abro conexion
			Connection con = Conexion.abreConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement("select * from pedidos \r\n"
					+ "inner join clientes on clientes.idcliente=pedidos.idcliente\r\n" + "where clientes.codigo=?;");
			pst.setInt(1, cliente.getCodigo());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Pedido pedido = new Pedido(rs.getInt("idpedido"), cliente, rs.getDouble("precioTotal"),
						rs.getString("direccionEnvio"), rs.getDate("fecha"));
				
				listaPedidos.add(pedido);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return listaPedidos;
	}
}


