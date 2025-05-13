package clases;

public class Cliente {
private int idcliente,codigo;
private String nombre,direccion;

public int getIdcliente() {
	return idcliente;
}
public void setIdcliente(int idcliente) {
	this.idcliente = idcliente;
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}


public Cliente(int idcliente, int codigo, String nombre, String direccion) {
	super();
	this.idcliente = idcliente;
	this.codigo = codigo;
	this.nombre = nombre;
	this.direccion = direccion;
}
public Cliente(int codigo, String nombre, String direccion) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.direccion = direccion;
}
@Override
public String toString() {
	return "idcliente=" + idcliente + ", codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion
			;
}

}
