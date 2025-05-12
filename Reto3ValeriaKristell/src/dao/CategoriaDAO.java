package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import clases.Categoria;
import util.Conexion;

public class CategoriaDAO {
	public static void inserta(Categoria categoria) {
		try {
			//abro conexion
			Connection con=Conexion.abreConexion();
			//creo select
			PreparedStatement pst=con.prepareStatement("INSERT into categorias(idcategoria, nombre) values(?,?);");
			pst.setInt(1, categoria.getIdcategoria());
			pst.setString(2, categoria.getNombre());
			pst.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
	}
}
