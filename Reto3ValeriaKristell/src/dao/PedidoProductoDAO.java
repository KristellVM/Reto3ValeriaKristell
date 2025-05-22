package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Categoria;
import clases.Cliente;
import clases.Pedido;
import clases.PedidoProducto;
import clases.Producto;
import util.Conexion;

public class PedidoProductoDAO {
	
	public static void insertar(PedidoProducto pedidoProducto) {
		try {
			//abro conexion
			Connection con=Conexion.abreConexion();
			//creo select
			PreparedStatement pst=con.prepareStatement("INSERT INTO pedidoproducto(idpedido, idproducto, unidades, precio) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, pedidoProducto.getPedido().getIdPedido());
			pst.setInt(2, pedidoProducto.getProducto().getIdProducto());
			pst.setInt(3, pedidoProducto.getUnidades());
			pst.setDouble(4, pedidoProducto.getPrecio());
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
				pedidoProducto.setIdPedidoProducto(rs.getInt(1));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
	}
	
	public static double precioTotal(int idpedido) {
		double precioTotal = 0;
		try {
			//abro conexion
			Connection con=Conexion.abreConexion();
			//creo select
			PreparedStatement pst=con.prepareStatement("SELECT SUM(unidades*precio) FROM pedidoproducto where idpedido=?");
			pst.setInt(1, idpedido);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				precioTotal=rs.getDouble(1);
				return precioTotal;
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
		return 0;
	}
	
	public static List<PedidoProducto> PorIdPedido(Pedido pedido) {
		List<PedidoProducto> lista = new ArrayList<PedidoProducto>();
		try {
			// abro conexion
			Connection con = Conexion.abreConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement(
					"SELECT c.idcategoria, c.nombre, p.idproducto,p.nombre, p.precio, p.descripcion, p.color, p.talla, p.stock, \r\n"
					+ "	from pedidos pe \r\n"
					+ "	inner join clientes cl on pe.idcliente = cl.idcliente"
					+ " where month(pe.fecha)= month(curdate());");
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				//Categoria c = new Categoria(rs.getInt("idCategoria"),rs.getString(2));
				//Producto producto = new Producto(rs.getInt("idproducto"),c, rs.getString(4), rs.getDouble("precio"), rs.getString("descripcion"), rs.getString("color"),rs.getString("talla"), rs.getInt("stock"));
				//Pedido pedido = new Pedido(rs.getInt("idpedido"), cliente, rs.getInt("precioTotal"), rs.getString("direccionEnvio"), rs.getDate("fecha"));
				//PedidoProducto pp = new PedidoProducto(rs.getInt("idpedidoproducto"),pedido, producto, rs.getInt("unidades"), producto.getPrecio());
				//lista.add(pp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// O en el try abrir la conexion
			Conexion.cierraConexion();
		}
		return lista;
		
	}

	public static List<PedidoProducto> listaPorPedido(Pedido pedido) {
		List<PedidoProducto> lista = new ArrayList<PedidoProducto>();
		try {
			Connection con = Conexion.abreConexion();
			PreparedStatement pst = con.prepareStatement(
		            "SELECT pp.idpedidoproducto, pp.unidades, pp.precio, " +
		                    "p.idproducto, p.nombre, p.precio, p.descripcion, p.color, p.talla, p.stock, " +
		                    "c.idcategoria, c.nombre " +
		                    "from pedidoproducto pp " +
		                    "inner join productos p on pp.idproducto = p.idproducto " +
		                    "inner join categorias c on p.idcategoria = c.idcategoria " +
		                    "where pp.idpedido = ?");
			pst.setInt(1, pedido.getIdPedido());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Categoria c = new Categoria(rs.getInt("idCategoria"),rs.getString(12));
				Producto producto = new Producto(rs.getInt("idproducto"),c, rs.getString(5), rs.getDouble(6), rs.getString("descripcion"), rs.getString("color"),rs.getString("talla"), rs.getInt("stock"));
				PedidoProducto pp = new PedidoProducto(rs.getInt("idpedidoproducto"),pedido, producto, rs.getInt("unidades"), rs.getDouble(3));
				lista.add(pp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return lista;
	}
	
	
	/*public static List<Integer> PorIdPedido(Pedido pedido) {
		List<Integer> lista = new ArrayList<Integer>();
		try {
			// abro conexion
			Connection con = Conexion.abreConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement(
					"SELECT idpedidoproducto"
					+ "	from pedidos pe \r\n"
					+ "	inner join clientes cl on pe.idcliente = cl.idcliente"
					+ " where month(pe.fecha)= month(curdate());");
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				//Categoria c = new Categoria(rs.getInt("idCategoria"),rs.getString(2));
				//Producto producto = new Producto(rs.getInt("idproducto"),c, rs.getString(4), rs.getDouble("precio"), rs.getString("descripcion"), rs.getString("color"),rs.getString("talla"), rs.getInt("stock"));
				//Pedido pedido = new Pedido(rs.getInt("idpedido"), cliente, rs.getInt("precioTotal"), rs.getString("direccionEnvio"), rs.getDate("fecha"));
				//PedidoProducto pp = new PedidoProducto(rs.getInt("idpedidoproducto"),pedido, producto, rs.getInt("unidades"), producto.getPrecio());
				//lista.add(pp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// O en el try abrir la conexion
			Conexion.cierraConexion();
		}
		return lista;
		
	}*/

}
