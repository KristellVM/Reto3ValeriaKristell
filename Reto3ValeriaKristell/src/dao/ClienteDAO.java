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
}
