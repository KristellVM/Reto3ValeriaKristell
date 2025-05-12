package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import clases.Producto;
import util.Conexion;

public class ProductoDAO {
	public static List<Producto> FuncionListaProductos(String categoriaNombre)
	{
		List<Producto> listaProductos = new ArrayList<Producto>();
		try {
			//abro bd
			Connection con = Conexion.abreConexion();
			//creo el statement
			PreparedStatement pst = con.prepareStatement("select categorias.idcategoria,categorias.nombre,"
					+ "productos.nombre,productos.idproducto from productos -- \r\n"
					+ "inner join categorias on productos.idcategoria=categorias.idcategoria\r\n"
					+ "where categorias.nombre='?';");
			pst.setString(1,categoriaNombre);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Producto producto=new Producto();
				lista.add(new AlumnoCurso(new Alumno(rs.getString("nombre"),rs.getString("apellidos")),rs.getDouble("notamedia")));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return lista;
	}
}
