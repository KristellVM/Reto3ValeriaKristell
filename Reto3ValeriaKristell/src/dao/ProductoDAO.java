package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import clases.Categoria;
import clases.Producto;
import util.Conexion;

public class ProductoDAO {
	//FUNCION 1
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
			Categoria categoria =new Categoria(rs.getInt("idcategoria"),rs.getString("nombre"));//int idcategoria, String nombre
			Producto producto=new Producto(rs.getInt("idProducto"),categoria,rs.getString("nombre"),
					rs.getDouble("precio"),rs.getString("descripcion"),rs.getString("color"),rs.getString("talla"),
					rs.getInt("stock"));

			listaProductos.add(producto);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return listaProductos;
	}
	
	//FUNCION 2
	
	public static List<Producto> FuncionBuscarProductos(String nomProducto,String talla,String color)
	{
		List<Producto> listaProductos = new ArrayList<Producto>();
		try {
			//abro bd
			Connection con = Conexion.abreConexion();
			//creo el statement
			PreparedStatement pst = con.prepareStatement("\r\n"
					+ "	select * from productos\r\n"
					+ "	where productos.nombre=% and talla=% and color=%;\r\n"
					+ "\r\n"
					+ "");
			pst.setString(1,nomProducto);
			pst.setString(2,talla);
			pst.setString(3,color);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
			Categoria categoria =new Categoria(rs.getInt("idcategoria"),rs.getString("nombre"));//int idcategoria, String nombre
			Producto producto=new Producto(rs.getInt("idProducto"),categoria,rs.getString("nombre"),
					rs.getDouble("precio"),rs.getString("descripcion"),rs.getString("color"),rs.getString("talla"),
					rs.getInt("stock"));

			listaProductos.add(producto);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Conexion.cierraConexion();
		}
		return listaProductos;
	}
	
}
