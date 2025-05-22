package clases;

/** Clase Cliente
 * 
 *Esta clase representa el Cliente que compra productios en una tienda.
 *
* Contiene información básica sobre el Cliente: id,codigo, nombre,direccion
* 
 * @author Valeria y Kristell
* @version 1.0 22/05/2025
 */
public class Cliente {
	

	/**
	 *  id del cliente 
	 */
	/**
	 * codigo del cliente
	 */
private int idcliente,codigo;
/**
 * nombre del cliente
 */
/**
 * direccion del cliente
 */

private String nombre,direccion;


/**
 * Obtiene el idcliente del cliente
 * @return el idcliente del cliente
 */
public int getIdcliente() {
	return idcliente;
}

/**
 * Establece el idcliente del cliente
 * @param idcliente el nuevo idcliente del cliente
 */
public void setIdcliente(int idcliente) {
	this.idcliente = idcliente;
}

/**
 * Obtiene el codigo del cliente
 * @return el codigo del cliente
 */
public int getCodigo() {
	return codigo;
}

/**
 * Establece el codigo del cliente
 * @param codigo el nuevo codigo del cliente
 */
public void setCodigo(int codigo) {
	this.codigo = codigo;
}

/**
 * Obtiene el nombre del cliente
 * @return el nombre del cliente
 */
public String getNombre() {
	return nombre;
}

/**
 * Establece el nombre del cliente
 * @param nombre el nuevo nombre del cliente
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}

/**
 * Obtiene el direccion del cliente
 * @return el direccion del cliente
 */
public String getDireccion() {
	return direccion;
}

/**
 * Establece el direccion del cliente
 * @param direccion el nuevo direccion del cliente
 */
public void setDireccion(String direccion) {
	this.direccion = direccion;
}

/**
 * Constructor con parámetro idcliente,codigo,nombre,direccion
 * 
 * Crea un nuevo Cliente con un idcliente,codigo,nombre y direccion específico pasado por parámetro
 * 
 * @param idcliente int el idcliente del cliente
 *  @param codigo int el codigo del cliente
 *   @param nombre String el nombre del cliente
 *    @param direccion String el direccion del cliente
 *    
 */
public Cliente(int idcliente, int codigo, String nombre, String direccion) {
	super();
	this.idcliente = idcliente;
	this.codigo = codigo;
	this.nombre = nombre;
	this.direccion = direccion;
}


/**
 * Constructor con parámetrocodigo,nombre,direccion
 * 
 * Crea un nuevo Cliente con codigo,nombre y direccion específico pasado por parámetro
 *
 *  @param codigo int el codigo del cliente
 *   @param nombre String el nombre del cliente
 *    @param direccion String el direccion del cliente
 *    
 */
public Cliente(int codigo, String nombre, String direccion) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.direccion = direccion;
}
@Override
public String toString() {
	return "idcliente: " + idcliente + ", codigo: " + codigo + ", nombre: " + nombre + ", direccion: " + direccion
			;
}

}
