package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Categoria;
import util.Conexion;

public class CategoriaDAO {
	public static void inserta(Categoria categoria) {
		try {
			//abro conexion
			Connection con=Conexion.abreConexion();
			//creo select
			PreparedStatement pst=con.prepareStatement("INSERT into categorias(nombre) values(?);", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, categoria.getNombre());
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
				categoria.setIdcategoria(rs.getInt(1));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
	}
	
	public static List<Categoria> lista() {
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			//abro conexion
			Connection con=Conexion.abreConexion();
			//creo select
			PreparedStatement pst=con.prepareStatement("SELECT * FROM categorias");
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				lista.add(new Categoria(rs.getInt("idcategoria"),rs.getString("nombre")));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
		return lista;
	}
}
