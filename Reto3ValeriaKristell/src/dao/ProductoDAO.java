package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Categoria;
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
			PreparedStatement pst = con.prepareStatement("select c.idcategoria, c.nombre, p.idproducto, p.nombre, p.precio, p.descripcion, p.color, p.talla, p.stock from productos p\r\n"
					+ "inner join categorias c on p.idcategoria = c.idcategoria\r\n"
					+ "where c.idcategoria=?;");
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

	public static List<Producto> FuncionBuscarProductos(String nomProducto, String talla, String color) {
		List<Producto> listaProductos = new ArrayList<Producto>();
		try {
			// abro bd
			Connection con = Conexion.abreConexion();
			// creo el statement
			PreparedStatement pst = con.prepareStatement("select * from productos"
					+ "where productos.nombre like ? and talla like ? and color like ?");
			pst.setString(1, "%"+nomProducto +"%");
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
	public static void insertar(Producto producto) {
		try {
			//abro conexion
			Connection con=Conexion.abreConexion();
			//creo select
			PreparedStatement pst=con.prepareStatement("INSERT into productos(idcategoria, nombre, precio, descripcion, color, talla, stock) values(?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, producto.getCategoria().getIdcategoria());
			pst.setString(2, producto.getNombre());
			pst.setDouble(3, producto.getPrecio());
			pst.setString(4, producto.getDescripcion());
			pst.setString(5, producto.getColor());
			pst.setString(6, producto.getTalla());
			pst.setInt(7, producto.getStock());
			pst.execute();
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()) {
				producto.setIdProducto(rs.getInt(1));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {//O en el try abrir la conexion
				Conexion.cierraConexion();
			}
	}
}
