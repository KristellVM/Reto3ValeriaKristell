package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Categoria;
import clases.PedidoProducto;
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
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
		return precioTotal;
	}

}
