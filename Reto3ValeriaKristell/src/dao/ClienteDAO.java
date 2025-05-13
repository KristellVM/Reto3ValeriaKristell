package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import clases.Categoria;
import clases.Cliente;
import util.Conexion;

public class ClienteDAO {
	public static void inserta(Cliente cliente) {
		try {
			//abro conexion
			Connection con=Conexion.abreConexion();
			//creo select
			PreparedStatement pst=con.prepareStatement("INSERT into clientes(nombre, direccion, codigo) values(?,?,?);", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getDireccion());
			pst.setInt(3, cliente.getCodigo());
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
				cliente.setIdcliente(rs.getInt(1));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
	}
	
	public static Cliente buscar(int codigo) {
		Cliente c = null;
		try {
			//abro conexion
			Connection con=Conexion.abreConexion();
			//creo select
			PreparedStatement pst=con.prepareStatement("select * from clientes where codigo=?;");
			pst.setInt(1, codigo);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				 c = new Cliente(rs.getInt("idCliente"),rs.getInt("codigo"),rs.getString("nombre"),rs.getString("direccion"));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
		return c;
	}
	
	public static void actualiza(Cliente cliente, int codigo, String nombre, String direccion) {
		try {
			Connection con=Conexion.abreConexion();
			PreparedStatement pst=con.prepareStatement("update clientes set codigo=?, nombre=?, direccion=? where idCliente=?;");
			pst.setInt(1, codigo);
			pst.setString(2, nombre);
			pst.setString(3, direccion);
			pst.setInt(4, cliente.getIdcliente());
			pst.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
	}
	
}
