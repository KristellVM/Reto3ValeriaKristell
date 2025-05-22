package clases;

import java.util.Date;

import util.Funciones;

/** Clase Pedido
 * 
 *Esta clase representa el Pedido que hace un cliente 
 *
* Contiene información básica sobre el Pedido: id,cliente, precioTotal,direccionEnvio y fecha
* 
 * @author Valeria y Kristell
* @version 1.0 22/05/2025
 */
public class Pedido {
	/**
	 * id del Pedido
	 */
	private int idPedido;
	/**
	 * Cliente que hace el Pedido
	 */
	private Cliente cliente;
	/**
	 * precio total del Pedido
	 */
	private double precioTotal;
	/**
	 * direccionn de encio del Pedido
	 */
	private String direccionEnvio;
	/**
	 * fecha de realización del Pedido
	 */
	private Date fecha;
	
	/**
	 * Obtiene el idPedido del Pedido
	 * @return el idPedido del Pedido
	 */
	public int getIdPedido() {
		return idPedido;
	}
	/**
	 * Establece el idPedido  del Pedido
	 * @param idPedido el nuevo idPedido del Pedido
	 */
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	/**
	 * Obtiene el cliente que hace  el Pedido
	 * @return el cliente que hace  el Pedido
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * Establece el cliente que realiza  el Pedido
	 * @param cliente el nuevo cliente que realiza  el Pedido
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * Obtiene el precioTotal del Pedido
	 * @return el precioTotal del Pedido
	 */
	public double getPrecioTotal() {
		return precioTotal;
	}
	/**
	 * Establece el precioTotal  del Pedido
	 * @param precioTotal el nuevo precioTotal del Pedido
	 */
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	/**
	 * Obtiene la direccionEnvio del Pedido
	 * @return la direccionEnvio del Pedido
	 */
	public String getDireccionEnvio() {
		return direccionEnvio;
	}
	/**
	 * Establece la direccionEnvio  del Pedido
	 * @param direccionEnvio la nueva  direccionEnvio del Pedido
	 */
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}
	
	/**
	 * Constructor con parámetro id ,cliente,precioTotal,direccionEnvio y fecha
	 *  Crea un nuevo cliente  con un id ,cliente,precioTotal,direccionEnvio y fecha específico pasado por parámetro
	 * @param idPedido int
	 * @param cliente Cliente
	 *  @param precioTotal double
	 *   @param direccionEnvio String
	 *    @param fecha Date
	 *    
	 * 
	 */
	public Pedido(int idPedido, Cliente cliente, double precioTotal, String direccionEnvio, Date fecha) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.precioTotal = precioTotal;
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}

	/**
	 * Constructor con cliente, precioTotal,  direccionEnvio y fecha
	 * Crea un nuevo Pedido  con cliente,  precioTotal,  direccionEnvio y fecha específico pasado por parámetro
	 * @param cliente Cliente
	 * @param precioTotal double
	 *  @param direccionEnvio String
	 *    @param fecha Date
	 *    
	 * 
	 */
	public Pedido(Cliente cliente, double precioTotal, String direccionEnvio, Date fecha) {
		super();
		this.cliente = cliente;
		this.precioTotal = precioTotal;
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}
	
	/**
	 * Constructor con cliente y fecha
	 * Crea un nuevo Pedido  con cliente,  y fecha específico pasado por parámetro
	 * @param cliente Cliente
	 *    @param fecha Date
	 *    
	 * 
	 */
	public Pedido(Cliente cliente, Date fecha) {
		super();
		this.cliente = cliente;
		this.fecha = fecha;
	}
	
	/**
	 * Obtiene la fecha del pedido
	 * @return  la fecha del pedido
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * Establece la fecha del pedido
	 * @param fecha la nueva fecha del pedido
	 */
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Pedido realizado por cliente: " + cliente.getNombre() + ", el precio total es: " + precioTotal
				+ ", la direccion de envio es " + direccionEnvio + " en la fecha: " + Funciones.convierte_Date_a_String(fecha);
	}
	
	
	
}
