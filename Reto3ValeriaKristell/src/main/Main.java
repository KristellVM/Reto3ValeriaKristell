package main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import clases.Categoria;
import clases.Cliente;
import clases.Pedido;
import clases.PedidoProducto;
import clases.Producto;
import dao.CategoriaDAO;
import dao.ClienteDAO;
import dao.PedidoProductoDAO;
import dao.PedidosDAO;
import dao.ProductoDAO;
import util.Funciones;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		
		do {
			opcion = Funciones.dimeEntero("Elige una opcion:\n0-Salir\n1-Mantenimiento\n2-Catalogo de productos\n3-Pedidos\n4-Informes", sc);
			
			switch (opcion) {
			case 1:
				System.out.println("Entrando al menú de Mantenimiento");
				funcionMantenimiento(sc);
				break;

			case 2:
				System.out.println("Entrando al menú catalogo productos");
				funcionCatalogoProducto(sc);
				break;

			case 3:
				System.out.println("Entrando al menú Pedidos");
				funcionPedidos(sc);
				break;

			case 4:
				funcionInformes(sc);				
				break;

			case 0:
				System.out.println("Saliendo del programa");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (opcion != 0);

	}
	
	public static void funcionMantenimiento(Scanner sc) {
		int opcion=-1;
		do {
			opcion = Funciones.dimeEntero("Elige una opcion:\n0-Salir\n1-GestionCategorias\n2-GestionProductos\n3-GestionClientes", sc);

			switch (opcion) {
			case 1:
				gestionCategorias(sc);
				break;
			case 2:
				gestionProductos(sc);
				break;
			case 3:
				gestionClientes(sc);
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
	
	public static void gestionCategorias(Scanner sc) {
		String nombre = Funciones.dimeString("Introduce nombre de categoria nueva: ", sc);
		Categoria c = new Categoria(nombre);
		CategoriaDAO.inserta(c);
	}
	public static Categoria estaCategoria(int idCategoria, List<Categoria> categorias) {
		Categoria categoriaEncontrada=null;
		for (Categoria categoria : categorias) {
			if(categoria.getIdcategoria()==idCategoria) {
				categoriaEncontrada = categoria;
				return categoriaEncontrada;
			}
		}
		return null;
	}
	public static void gestionProductos(Scanner sc) {
		List<Categoria> categorias = CategoriaDAO.lista();
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}
		
		Categoria categoriaEncontrada = null;
		int idCategoria;
		do {
			idCategoria = Funciones.dimeEntero("Selecciona idCategoria: ", sc);
			categoriaEncontrada = estaCategoria(idCategoria, categorias);
		} while (categoriaEncontrada==null);

		Producto p = new Producto(categorias.get(idCategoria - 1), Funciones.dimeString("Introduce nombre: ", sc),
				Funciones.dimeDouble("Introduce precio: ", sc), Funciones.dimeString("Introduce descripciï¿½n: ", sc),
				Funciones.dimeString("Introduce color: ", sc), Funciones.dimeString("Introduce talla: ", sc),
				Funciones.dimeEntero("Introduce stock: ", sc));
		ProductoDAO.insertar(p);
	}

	public static void gestionClientes(Scanner sc) {
		int opcion;

		do {
			opcion = Funciones.dimeEntero("Elige una opcion:\n0-Salir\n1-Buscar por codigo\n2-Dar alta a nuevo cliente",
					sc);
			switch (opcion) {
			case 1:
				busquedaPorCodigo(sc);
				break;

			case 2:
				insertarCliente(sc);
				break;
			case 0:
				System.out.println("Saliendo de gestion clientes");
			default:
				System.out.println("Opcion no valida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);
	}

	public static void insertarCliente(Scanner sc) {
		int codigo = 1;
		do {
			codigo = Funciones.dimeEntero("Introduce codigo: ", sc);
		} while (ClienteDAO.buscar(codigo)!=null);
		
		Cliente c = new Cliente(codigo,
				Funciones.dimeString("Introduce nombre: ", sc), Funciones.dimeString("Introduce direccion: ", sc));
		ClienteDAO.inserta(c);
	}

	public static void busquedaPorCodigo(Scanner sc) {
		int codigo = Funciones.dimeEntero("Introduce codigo de cliente: ", sc);
		Cliente cliente1 = ClienteDAO.buscar(codigo);
		if (cliente1 != null) {
			System.out.println(cliente1.toString());
			System.out.println("Datos nuevos: ");
			int nuevoCodigo = 1;
			do {
				nuevoCodigo = Funciones.dimeEntero("Introduce codigo: ", sc);
			} while (ClienteDAO.buscar(nuevoCodigo)!=null);
			String nombre = Funciones.dimeString("Introduce nombre: ", sc);
			String direccion = Funciones.dimeString("Introduce direccion: ", sc);
			ClienteDAO.actualiza(cliente1, nuevoCodigo, nombre, direccion);
		} else {
			System.out.println("no existe un cliente con el codigo " + codigo);
		}
	}
	
	public static void funcionCatalogoProducto(Scanner sc) {
		int opcion;
		
		do {
			opcion = Funciones.dimeEntero("Elige una opcion:\n0-Salir\n1-Listar Productos Por Categoria:\n2-Buscar productos", sc);
			switch (opcion) {
			case 1:
				ProductosPorCategoria(sc);
				
				break;
			case 2:
				BuscarProductos(sc);
				break;
			case 0:
				System.out.println("Saliendo de catálogo de productos");
				break;
			default:
				System.out.println("Opción inválida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);
	}
	
	public static void ProductosPorCategoria(Scanner sc) {
		List<Categoria> categorias = CategoriaDAO.lista();
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}		
		Categoria categoriaEncontrada = null;
		int idCategoria;
		do {
			idCategoria = Funciones.dimeEntero("Selecciona idCategoria: ", sc);
			categoriaEncontrada = estaCategoria(idCategoria, categorias);
			if(categoriaEncontrada==null) {
				System.out.println("No existe una categoria con ese id");
			}
		} while (categoriaEncontrada==null);
		
		List<Producto> listaProductos = ProductoDAO.FuncionListaProductos(idCategoria);
		for (Producto producto : listaProductos) {
			System.out.println(producto);
		}
	}
	
	public static void BuscarProductos(Scanner sc) {
		System.out.println("Introduce nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce talla: ");
		String talla = sc.nextLine();
		System.out.println("Introduce color: ");
		String color = sc.nextLine();
		List<Producto> lista = ProductoDAO.BuscarProducto(nombre, talla, color);
		if(lista.isEmpty()) {
			System.out.println("no se encontraron productos");
		} else {
			for (Producto producto : lista) {
				System.out.println(producto.getCategoria().getNombre()+producto);
			}
		}
	}
	
	public static void funcionPedidos(Scanner sc) {
		int opcion;

		do {
			opcion = Funciones.dimeEntero("Elige una opcion:\n0-Salir\n1-Crear pedido\n2-Ver pedidos", sc);

			switch (opcion) {
			case 1:
			crearPedido(sc);
				break;
			case 2:
			verPedidos(sc);
				break;
			case 0:
				System.out.println("Saliendo de Pedidos");
				break;
			default:
				System.out.println("Opcion no valida. Seleccionar otra vez");
				break;
			}
		} while (opcion != 0);
	}
	
	public static void crearPedido(Scanner sc) {
		Cliente clienteEncontrado = null;
		int codigo;

		do {
			codigo = Funciones.dimeEntero("Introduce el codigo de un cliente", sc);
			clienteEncontrado = ClienteDAO.buscar(codigo);
			if (clienteEncontrado != null) {
				System.out.println(clienteEncontrado.getNombre());
			}
		} while (clienteEncontrado == null);
		
		Pedido pedido = new Pedido(clienteEncontrado, 0,clienteEncontrado.getDireccion(),Funciones.convierte_LocalDate_a_Date(LocalDate.now()));
		PedidosDAO.insertar(pedido);
		Producto productoEncontrado = null;
		String nomProd, nuevaDir;

		int opcion = 0, cantProd=0, stockNuevo=0,cont=0;
		boolean pedidoCreado=false;
		do {
			opcion = Funciones.dimeEntero("¿Quieres seguir agregando productos, 1- Si , 2-No?", sc);
			if (opcion == 1) {
				pedidoCreado=true;
				do {
					nomProd = Funciones.dimeString("Introduce el nombre del producto que quieres", sc);
					productoEncontrado = dao.ProductoDAO.BuscarProductonombre(nomProd);
					if(productoEncontrado!=null) {
						//dao de crear pedido pasadole el idproducto y la cantidad de stock
						cantProd = Funciones.dimeEntero("Cuantas unidades quieres del producto?", sc);
						if(productoEncontrado.getStock()<cantProd) {
							cantProd= productoEncontrado.getStock();
						}
							stockNuevo=productoEncontrado.getStock()-cantProd;
							PedidoProducto pp = new PedidoProducto(pedido, productoEncontrado, cantProd, productoEncontrado.getPrecio());
							PedidoProductoDAO.insertar(pp);
							ProductoDAO.updateStock(productoEncontrado, stockNuevo);
					}
				} while (productoEncontrado == null);
			}
		} while (opcion != 2);
		if(pedidoCreado) {
			int opcNuevaDir = Funciones.dimeEntero("Usar: '"+clienteEncontrado.getDireccion()+"' como  direccion de envio? 1-si 2-no", sc);
			if (opcNuevaDir == 2) {
				nuevaDir = Funciones.dimeString("Introduce direccion de envio: ", sc); 
			} else {
				nuevaDir = clienteEncontrado.getDireccion();
			}
			double precioFinal = PedidoProductoDAO.precioTotal(pedido.getIdPedido());
			PedidosDAO.actualizaDirPrecio(pedido, nuevaDir, precioFinal);
			System.out.println("Pedido guardado. El precio final es: "+precioFinal);
		} else {
			System.out.println("No se generó ningún pedido");
			PedidosDAO.eliminarPedidoVacio(pedido.getIdPedido());
		}
	}
	
	public static void verPedidos(Scanner sc) {
		List<Pedido> pedidosPorMes = PedidosDAO.verPedidos();
		for (Pedido pedido : pedidosPorMes) {
			System.out.println(pedido);
			List<PedidoProducto> lista = PedidoProductoDAO.listaPorPedido(pedido);
			for (PedidoProducto p : lista) {
				System.out.println(p);
			}
			System.out.println();
		}
	}
	
	public static void funcionInformes(Scanner sc) {
		int opcion;

		do {
			opcion = Funciones.dimeEntero(
					"Elige una opcion:\n0-Salir\n1-Bajo Stock\n2-Pedidos por Cliente\n3-Productos mas vendidos", sc);

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
					pedidosPorCliente(cliente);
				}
				break;
			case 3:
				productoMasVendido();
				break;
			case 0:
				System.out.println("Saliendo de informes");
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
	
	public static void pedidosPorCliente(Cliente cliente) {
		List<Pedido> pedidos = PedidosDAO.PedidosPorCliente(cliente);
		if(pedidos.isEmpty()) {
			System.out.println("Cliente "+cliente.getNombre()+" no tiene pedidos.");
		} else {
			System.out.println("Pedidos de "+cliente.getNombre());
			for (Pedido pedido : pedidos) {
				System.out.println("Pedido realizado en la fecha "+Funciones.convierte_Date_a_String(pedido.getFecha())+", el precio total es: "+pedido.getPrecioTotal()+" y la direccion de envio es: "+pedido.getDireccionEnvio());
				List<PedidoProducto> lista = PedidoProductoDAO.listaPorPedido(pedido);
				for (PedidoProducto p : lista) {
					System.out.println(p);
				}
				System.out.println();
			}
		}
	}

	public static void productoMasVendido() {
		List<Producto> productos = ProductoDAO.ProductosMasVendido();
		for (Producto producto : productos) {
			System.out.println("Categoria: "+producto.getCategoria().getNombre()+", nombre: "+producto.getNombre()+" , stock: "+producto.getStock());
		}
	}
	
}
