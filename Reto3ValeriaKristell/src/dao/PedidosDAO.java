package dao;

import java.util.List;
import java.util.Scanner;

import clases.Cliente;
import clases.Pedido;
import clases.PedidoProducto;
import clases.Producto;
import util.Funciones;

public class PedidosDAO {
	
	public static Pedido crearPedido() {
		Scanner sc=new Scanner(System.in);
		
	
		PedidoProducto pedido=new PedidoProducto();
		
		Cliente clienteEncontrado=null;
		int codigo;
	
		do {
			 codigo=Funciones.dimeEntero("Introduce el codigo de un cliente", sc);
			 clienteEncontrado=dao.ClienteDAO.buscar(codigo);
		}while(!(clienteEncontrado!= null));//mientras no exista el cliente con ese codigo-> lo vuelvo a pedir
		
		//una vez tengo el cliente con ese codigo-> muestrop su nombre
		System.out.println(clienteEncontrado.getNombre());
		
		//bucle pedir productos x nombre .-> mientras que NO exista 
		
		
		// da nombre,talla,collor y devuelve un obj producto-> 
		//public static Producto BuscarProducto(String nombre, String talla, String color ) {
		Producto productoEncontrado=null;
		String nomProd;
		Boolean existeProducto=false;
		do {
		 nomProd=Funciones.dimeString("Introduce el nombre del producto que quieres", sc);
		 productoEncontrado=dao.ProductoDAO.BuscarProductonombre(nomProd);
		 existeProducto=true;
		}while(!(productoEncontrado!= null));
	
		int cantProd;
		if(existeProducto=true) {// si existe-> pido cant
		 cantProd=Funciones.dimeEntero("Cuantas unidades quieres del producto?", sc);
		 //si mi el stock del producto>=esa cant
		 if(productoEncontrado.getStock()>=cantProd) {
			
		 }
		 
		 //si no hay suficiente stock
		 else {
			 
		 }
		}
	}
	
	
	
	
/*3.1. Crear pedido: 
 * -pediremos el código de un cliente hasta que exista,
 * -muestra nombre del cliente con ese código.
 * -bucle pidiendo nombres de productos.
 * -Buscamos en la base de datos si hay algún producto con ese nombre
 * - y si existe, pediremos cuántas unidades queremos de ese producto. 
 * 
 * -Si hay suficiente stock lo añadiremos al pedido.
 *  -Si no hay stock  se comprarán todos los que haya en stock.
 *  
Así hasta que terminemos de añadir productos (establecer cómo queréis que termine, si al pedir el
código introduce un -1, o nada, o lo que digáis).
Una vez que ya hemos seleccionado los productos a comprar, se mostrará la dirección del cliente que
habíamos seleccionado antes y preguntaremos si usamos esa dirección como dirección de envío o no.
Si nos dicen que no pediremos la nueva y pondremos esa como dirección de envío.
Guardaremos el pedido en la base de datos mostrando “Pedido guardado “, e indicaremos el precio
total.*/
	
	
	
}
