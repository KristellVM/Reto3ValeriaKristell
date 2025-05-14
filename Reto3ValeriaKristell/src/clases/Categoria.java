package clases;

public class Categoria {
private int idcategoria;
private String nombre;

public Categoria(String nombre) {
	super();
	this.nombre = nombre;
	
}
public Categoria(int idCategoria,String nombre) {
	super();
	this.idcategoria = idCategoria;
	this.nombre = nombre;
}

public Categoria(int idCategoria) {
	super();
	this.idcategoria = idCategoria;
}

public int getIdcategoria() {
	return idcategoria;
}
public void setIdcategoria(int idcategoria) {
	this.idcategoria = idcategoria;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}


@Override
public String toString() {
	return "idcategoria: " + idcategoria + ", nombre: " + nombre ;
}


}
