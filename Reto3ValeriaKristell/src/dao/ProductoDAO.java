package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clases.Categoria;
import clases.Cliente;
import clases.Producto;
import util.Conexion;

public class ProductoDAO {
	
	// FUNCION 1
	public static List<Producto> FuncionListaProductos(int idCategoria) {
		List<Producto> listaProductos = new ArrayList<Producto>();
		try {
			// abro bd
			Connection con = Conexion.abreConexion();
			// creo el statement
			PreparedStatement pst = con.prepareStatement("select c.idcategoria, c.nombre, p.idproducto, p.nombre, p.precio, p.descripcion, p.color, p.talla, p.stock from productos p\r\n"
					+ "inner join categorias c on p.idcategoria = c.idcategoria\r\n"
					+ "where c.idcategoria=?;");
			pst.setInt(1, idCategoria);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idcategoria"), rs.getString(2));// int
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
	public static List<Producto> BuscarProducto(String nombre, String talla, String color ) {
		List<Producto> listaProductos = new ArrayList<Producto>();
	
		try {
			// abro bd
			Connection con = Conexion.abreConexion();
			// creo el statement
			PreparedStatement pst = con.prepareStatement("select p.idproducto, c.idcategoria,c.nombre, p.nombre, p.precio, p.descripcion, p.color, p.talla, p.stock from productos p\r\n"
					+ "inner join categorias c on p.idcategoria=c.idcategoria\r\n"
					+ "where (p.talla=? or ?='') and (p.color=? or ?='') and (p.nombre like ? or ?='');");
			pst.setString(1,talla);
			pst.setString(2,talla);
			pst.setString(3, color);
			pst.setString(4, color);
			pst.setString(5, "%"+nombre +"%");
			pst.setString(6, nombre);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idcategoria"),rs.getString(3));// int// idcategoria,
																										// String nombre
				 Producto p = new Producto(rs.getInt("idProducto"), categoria, rs.getString(4),
						rs.getDouble("precio"), rs.getString("descripcion"), rs.getString("color"),
						rs.getString("talla"), rs.getInt("stock"));
				 listaProductos.add(p);
			}
			rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Conexion.cierraConexion();
			}
		return listaProductos;
	}

	
	//FUNCION 3 -> BUCAR PRODUCTO X NOMBRE
	public static Producto BuscarProductonombre(String nombre) {
		Producto producto = null;
		try {
			// abro bd
			Connection con = Conexion.abreConexion();
			// creo el statement
			PreparedStatement pst = con.prepareStatement("select p.idproducto, c.idcategoria,c.nombre, p.nombre, p.precio, p.descripcion, p.color, p.talla, p.stock from productos p inner join categorias c on p.idcategoria=c.idcategoria "
					+ "where p.nombre = ? ");
			pst.setString(1, nombre );

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idcategoria"), rs.getString(3));// int// idcategoria,
																										// String nombre
				 producto = new Producto(rs.getInt("idProducto"), categoria, rs.getString(4),
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
	
	public static List<Producto> mostrarProductos() {
		List<Producto> lista = new ArrayList<Producto>();
		try {
			// abro bd
			Connection con = Conexion.abreConexion();
			// creo el statement
			PreparedStatement pst = con.prepareStatement("select p.idproducto, c.idcategoria,c.nombre, p.nombre, p.precio, p.descripcion, p.color, p.talla, p.stock from productos p inner join categorias c on p.idcategoria = c.idcategoria;");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idcategoria"), rs.getString(3));// int// idcategoria,
																										// String nombre
				 Producto producto = new Producto(rs.getInt("idProducto"), categoria, rs.getString(4),
						rs.getDouble("precio"), rs.getString("descripcion"), rs.getString("color"),
						rs.getString("talla"), rs.getInt("stock"));
				 lista.add(producto);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return lista;
		
	}
	
	public static void updateStock(Producto producto, int cant) {
		try {
			Connection con = Conexion.abreConexion();
			// creo el statement
			PreparedStatement pst = con.prepareStatement("UPDATE productos set stock = ? WHERE idproducto=?;");
			pst.setInt(1, cant);
			pst.setInt(2, producto.getIdProducto());
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conexion.cierraConexion();
		}
	}
	

}
