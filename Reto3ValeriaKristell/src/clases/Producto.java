package clases;

public class Producto {
	private int idProducto;
	private Categoria categoria;
	private String nombre;
	private double precio;
	private String descripcion;
	private String color;
	private String talla;
	private int stock;

	/**
	 * Constructor con parámetro  idProducto,  categoria,  nombre,  precio,  descripcion,  color,
			 talla,  stock
	 *  Crea un nuevo Producto  con idProducto,  categoria,  nombre,  precio,  descripcion,  color,
			 talla,  stockpasado por parámetro
			 
	 * @param idProducto int
	 * @param categoria Categoria
	 *  @param nombre String
	 *   @param precio double
	 *     @param descripcion String
	 *    @param color String
	 *     @param talla String 
	 *     @param stock int
	 * 
	 */
	public Producto(int idProducto, Categoria categoria, String nombre, double precio, String descripcion,
			String color,
			String talla, int stock) {
		super();
		this.idProducto = idProducto;
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}
	
	/**
	 * Constructor con parámetro   categoria,  nombre,  precio,  descripcion,  color,
			 talla,  stock
	 *  Crea un nuevo Producto  con idProducto,  categoria,  nombre,  precio,  descripcion,  color,
			 talla,  stockpasado por parámetro
			 
	 * @param categoria Categoria
	 *  @param nombre String
	 *   @param precio double
	 *     @param descripcion String
	 *    @param color String
	 *     @param talla String 
	 *     @param stock int
	 * 
	 */
	public Producto(Categoria categoria, String nombre, double precio, String descripcion, String color,
			String talla, int stock) {
		super();
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}

	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return nombre + ", precio: "
				+ precio + ", descripcion: " + descripcion + ", color: " + color + ", talla: " + talla + ", stock: " + stock;
	}
	
}
