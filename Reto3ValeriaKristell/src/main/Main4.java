package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clases.Categoria;
import clases.Cliente;
import clases.Pedido;
import clases.Producto;
import dao.ClienteDAO;
import dao.ProductoDAO;
import util.Conexion;
import util.Funciones;

public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			opcion = Funciones.dimeEntero(
					"Elige una opcion:\n0-Salir\n1-GestionCategorias\n2-GestionProductos\n3-GestionClientes", sc);

			switch (opcion) {
			case 1:
				bajoStock(sc);
				break;
			case 2:
				int cod = Funciones.dimeEntero("Introduce el codigo de un cliente", sc);
				Cliente cliente = ClienteDAO.buscar(cod);
				if (cliente == null) {
					System.out.println("El cliente no existe");
				} else {
					PedidosPorCliente(cliente);
				}
				break;
			case 3:
				ProductosMasVendido();
				break;
			case 0:
				System.out.println("Saliendo de mantenimientos");
				break;
			default:
				System.out.println("Opcion no valida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);
	}

	public static void bajoStock(Scanner sc) {
		List<Producto> listaBajoStock = ProductoDAO.mostrarProductos();
		for (Producto producto : listaBajoStock) {
			if (producto.getStock() < 5) {
				System.out.println(producto);
			}
		}
		for (Producto producto : listaBajoStock) {
			if (producto.getStock() < 5) {
				int cant = 0;
				do {
					cant = Funciones.dimeEntero("En cuantas unidades quieres aumentar el stock de "+producto.getNombre(), sc);
					if(cant>0) {
						int stockNuevo=producto.getStock()+cant;
						ProductoDAO.updateStock(producto, stockNuevo);
					}
				} while (cant<=0);
			}
		}

	}

	public static List<Pedido> PedidosPorCliente(Cliente cliente) { // nunca scanner en los daos-> main
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		// busco los pedidos de ese cliente
		try {
			// abro conexion
			Connection con = Conexion.abreConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement("select * from pedidos \r\n"
					+ "inner join clientes on clientes.idcliente=pedidos.idcliente\r\n" + "where clientes.codigo=?;");
			pst.setInt(1, cliente.getCodigo());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Pedido pedido = new Pedido(rs.getInt("idpedido"), cliente, rs.getDouble("precioTotal"),
						rs.getString("direccionEnvio"), rs.getDate("fecha"));
				listaPedidos.add(pedido);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return listaPedidos;
	}
	// 4.3 Productos más vendido: mostraremos el producto del que se hayan comprado
	// más unidades. Si hay
	// empate se mostrarán todos los empatados.

	public static List<Producto> ProductosMasVendido() { // nunca scanner en los daos-> main
		List<Producto> listaProductoMasVendido = new ArrayList<Producto>();
		// busco los pedidos de ese cliente
		try {
			// abro conexion
			Connection con = Conexion.abreConexion();
			// creo select
			PreparedStatement pst = con.prepareStatement("\r\n"
					+ "select productos.nombre, SUM(pedidoproducto.unidades) as total_unidades\r\n"
					+ "from pedidoproducto \r\n"
					+ "join productos  on pedidoproducto.idproducto = productos.idproducto\r\n"
					+ "group by  pedidoproducto.idproducto\r\n" + "having total_unidades = (\r\n"
					+ "select MAX(unidades_totales)\r\n" + "from (\r\n" + "select SUM(unidades) as unidades_totales\r\n"
					+ "from pedidoproducto\r\n" + "group by idproducto\r\n" + ") AS subconsulta\r\n" + ");\r\n" + "");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idcategoria"), rs.getString("nombre"));

				Producto producto = new Producto(rs.getInt("idProducto"), categoria, rs.getString("nombre"),
						rs.getDouble("precio"), rs.getString("descripcion"), rs.getString("color"),
						rs.getString("talla"), rs.getInt("stock"));
				listaProductoMasVendido.add(producto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cierraConexion();
		}
		return listaProductoMasVendido;
	}

}
