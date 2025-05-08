package clases;

public class Categoria {
private int idcategoria;
private String nombre;

public Categoria(int idcategoria, String nombre) {
	super();
	this.idcategoria = idcategoria;
	this.nombre = nombre;
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
	return "Categoria: idcategoria=" + idcategoria + ", nombre=" + nombre ;
}


}
