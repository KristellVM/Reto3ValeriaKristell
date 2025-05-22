package clases;

/** Clase Categoria
 * 
 *Esta clase representa la categoría de un producto.
 *
* Contiene información básica sobre la categoría: id y nombre
* 
 * @author Valeria y Kristell
* @version 1.0 22/05/2025
 */

public class Categoria {

	/**
	 *  id de la categoria
	 */
private int idcategoria;
/** 
 * Nombre de la categoria
 */
private String nombre;

/**
 * Constructor con parámetro nombre
 * 
 * Crea una nueva categoria con un nombre específico pasado por parámetro
 * 
 * @param nombre String el nombre de la categoría
 */
public Categoria(String nombre) {
	super();
	this.nombre = nombre;
	
}
/**
 * Constructor con parámetro id y nombre
 *  Crea una nueva categoria con un nombre e id específico pasado por parámetro
 * @param idCategoria int
 * @param nombre String
 */
public Categoria(int idCategoria,String nombre) {
	super();
	this.idcategoria = idCategoria;
	this.nombre = nombre;
}

/**
 *  Constructor con parámetro id
 *  Crea una nueva categoria con un id específico pasado por parámetro
 * @param idCategoria int
 */
public Categoria(int idCategoria) {
	super();
	this.idcategoria = idCategoria;
}

/**
 * Obtiene el id de la categoria
 * @return el id de la categoria
 */
public int getIdcategoria() {
	return idcategoria;
}
/**
 * Establece el id de la categoria
 * @param idcategoria el nuevo id de la categoria
 */
public void setIdcategoria(int idcategoria) {
	this.idcategoria = idcategoria;
}

/**
 * Obtiene el nombre de la categoria
 * @return el nombre de la categoria
 */
public String getNombre() {
	return nombre;
}
/**
 * Establece el nombre de la categoria
 * @param nombre el nuevo nombre de la categoria
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}


@Override
public String toString() {
	return "idcategoria: " + idcategoria + ", nombre: " + nombre ;
}


}
