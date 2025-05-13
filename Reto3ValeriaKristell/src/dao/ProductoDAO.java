package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import clases.Categoria;
import clases.Cliente;
import clases.Producto;
import util.Conexion;

public class ProductoDAO {
	// FUNCION 1
	public static List<Producto> FuncionListaProductos(String categoriaNombre) {
		List<Producto> listaProductos = new ArrayList<Producto>();
		try {
			// abro bd
			Connection con = Conexion.abreConexion();
			// creo el statement
			PreparedStatement pst = con.prepareStatement("select categorias.idcategoria,categorias.nombre,"
					+ "productos.nombre,productos.idproducto from productos -- \r\n"
					+ "inner join categorias on productos.idcategoria=categorias.idcategoria\r\n"
					+ "where categorias.nombre='?';");
			pst.setString(1, categoriaNombre);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idcategoria"), rs.getString("nombre"));// int
																										// idcategoria,
																										// String nombre
				Producto producto = new Producto(rs.getInt("idProducto"), categoria, rs.getString("nombre"),
						rs.getDouble("precio"), rs.getString("descripcion"), rs.getString("color"),
						rs.getString("talla"), rs.getInt("stock"));

				listaProductos.add(producto);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return listaProductos;
	}

	// FUNCION 2

	public static Producto BuscarProducto(String nombre, String talla, String color ) {
		try {
			// abro bd
			Connection con = Conexion.abreConexion();
			// creo el statement
			PreparedStatement pst = con.prepareStatement("select * from productos"
					+ "where productos.nombre like ? and talla like ? and color like ?");
			pst.setString(1, "%"+nombre +"%");
			pst.setString(2,"%"+ talla+"%");
			pst.setString(3,"%"+ color+"%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idcategoria"), rs.getString("nombre"));// int// idcategoria,
																										// String nombre
				Producto producto = new Producto(rs.getInt("idProducto"), categoria, rs.getString("nombre"),
						rs.getDouble("precio"), rs.getString("descripcion"), rs.getString("color"),
						rs.getString("talla"), rs.getInt("stock"));
				/*
				 * Buscar productos: pediremos por consola un nombre, una talla y un color. El
				 * usuario puede no introducir nada en alguna de esas preguntas (pulsa intro sin
				 * escribir nada). Buscaremos los productos que cumplan el filtro introducido y 
				 * los mostraremos por consola.
				 *
				 * Ejemplo: si introduce sólo nombre, buscaremos los que tengan ese nombre
				 * contenido, no tiene que ser igual (usamos % en el valor del argumento que
				 * pasamos, no en el ?). Si introducen sólo en talla y color, los que tengan esa
				 * talla y ese color.
				 */		
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return producto;
		
	}
	
	
	//FUNCION 3 -> BSUCAR PRODUCTO X NOMBRE
	public static Producto BuscarProductonombre(String nombre) {
		try {
			// abro bd
			Connection con = Conexion.abreConexion();
			// creo el statement
			PreparedStatement pst = con.prepareStatement("select * from productos"
					+ "where productos.nombre = ? ");
			pst.setString(1, nombre );

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idcategoria"), rs.getString("nombre"));// int// idcategoria,
																										// String nombre
				Producto producto = new Producto(rs.getInt("idProducto"), categoria, rs.getString("nombre"),
						rs.getDouble("precio"), rs.getString("descripcion"), rs.getString("color"),
						rs.getString("talla"), rs.getInt("stock"));
			
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return producto;
		
	}
	
	

}
