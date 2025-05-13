package clases;

import java.util.Date;

public class Pedido {
	private int idPedido;
	private Cliente cliente;
	private double precioTotal;
	private String direccionEnvio;
	private Date fecha;
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public String getDireccionEnvio() {
		return direccionEnvio;
	}
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", cliente=" + cliente + ", precioTotal=" + precioTotal
				+ ", direccionEnvio=" + direccionEnvio + ", fecha=" + fecha + "]";
	}
	
	
	
}
