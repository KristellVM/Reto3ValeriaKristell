package clases;

import java.util.ArrayList;
import java.util.List;


/** Clase PedidoProducto
 * 
 *Esta clase representa los pedidos de un producto
 *
* Contiene información básica sobre el Pedido: id,pedido, producto,unidades y precio
* 
 * @author Valeria y Kristell
* @version 1.0 22/05/2025
 */
public class PedidoProducto {

	private int idPedidoProducto;
	
	private Pedido pedido;
	
	private Producto producto;
	
	private int unidades;
	
	private double precio;
	
	
	public int getIdPedidoProducto() {
		return idPedidoProducto;
	}
	
	public void setIdPedidoProducto(int idPedidoProducto) {
		this.idPedidoProducto = idPedidoProducto;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public int getUnidades() {
		return unidades;
	}
	
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}



	/**
	 * Constructor con parámetro  idPedidoProducto,  pedido,  producto,  unidades,  precio
	 *  Crea un nuevo PedidoProducto  con un idPedidoProducto,  pedido,  producto,  unidades,  precio pasado por parámetro
	 * @param idPedido int
	 * @param pedido Pedido
	 *  @param producto Producto
	 *   @param unidades int
	 *    @param precio double
	 *    
	 * 
	 */
	
	public PedidoProducto(int idPedidoProducto, Pedido pedido, Producto producto, int unidades, double precio
		) {
		super();
		this.idPedidoProducto = idPedidoProducto;
		this.pedido = pedido;
		this.producto = producto;
		this.unidades = unidades;
		this.precio = precio;
	}
	/**
	 * Constructor con parámetro   pedido,  producto,  unidades,  precio
	 *  Crea un nuevo PedidoProducto  con un  pedido,  producto,  unidades,  precio pasado por parámetro

	 * @param pedido Pedido
	 *  @param producto Producto
	 *   @param unidades int
	 *    @param precio double
	 *    
	 * 
	 */
	
	public PedidoProducto(Pedido pedido, Producto producto, int unidades, double precio) {
		this.pedido = pedido;
		this.producto = producto;
		this.unidades = unidades;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto: " + producto.getNombre()+", categoria: "+producto.getCategoria().getNombre()
				+ ", unidades compradas: " + unidades + " y precio: " + precio;
	}

}
