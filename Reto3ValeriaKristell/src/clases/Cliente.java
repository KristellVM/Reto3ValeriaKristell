package clases;

public class Cliente {
private int idcliente;
private String nombre,direccion;

public int getIdcliente() {
	return idcliente;
}
public void setIdcliente(int idcliente) {
	this.idcliente = idcliente;
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

public Cliente(int idcliente, String nombre, String direccion) {
	super();
	this.idcliente = idcliente;
	this.nombre = nombre;
	this.direccion = direccion;
}
@Override
public String toString() {
	return "Cliente: idcliente=" + idcliente + ", nombre=" + nombre + ", direccion=" + direccion ;
}
}
