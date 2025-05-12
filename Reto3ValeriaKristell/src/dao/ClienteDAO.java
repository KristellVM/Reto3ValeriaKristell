package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import clases.Categoria;
import clases.Cliente;
import util.Conexion;

public class ClienteDAO {
	public static void inserta(Cliente cliente) {
		try {
			//abro conexion
			Connection con=Conexion.abreConexion();
			//creo select
			PreparedStatement pst=con.prepareStatement("INSERT into clientes(idcliente, nombre, direccion, codigo) values(?,?,?,?);");
			pst.setInt(1, cliente.getIdcliente());
			pst.setString(2, cliente.getNombre());
			pst.setString(3, cliente.getDireccion());
			pst.setInt(4, cliente.getCodigo());
			pst.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
	}
}
