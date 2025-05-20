package clases;

import java.util.ArrayList;
import java.util.List;

public class PedidoProducto {
	/*
CREATE TABLE pedidoproducto (
    idpedidoproducto INT PRIMARY KEY,
    idpedido INT NOT NULL,
    idproducto INT NOT NULL,
    unidades INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idpedido) REFERENCES pedidos(idpedido),
    FOREIGN KEY (idproducto) REFERENCES productos(idproducto)
);*/
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



	public PedidoProducto(){
		
	}
	
	public PedidoProducto(int idPedidoProducto, Pedido pedido, Producto producto, int unidades, double precio
		) {
		super();
		this.idPedidoProducto = idPedidoProducto;
		this.pedido = pedido;
		this.producto = producto;
		this.unidades = unidades;
		this.precio = precio;
	}
	
	public PedidoProducto(Pedido pedido, Producto producto, int unidades, double precio) {
		this.pedido = pedido;
		this.producto = producto;
		this.unidades = unidades;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "PedidoProducto [idPedidoProducto=" + idPedidoProducto + ", pedido=" + pedido + ", producto=" + producto
				+ ", unidades=" + unidades + ", precio=" + precio;
	}

}
