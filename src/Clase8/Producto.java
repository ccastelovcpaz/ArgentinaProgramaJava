package Clase8;

public class Producto {
	
	private String nombre;
	private String codigo;
	private float precio;
	
	public Producto(String nombre, String codigo, float precio) {
		this.nombre=nombre;
		this.codigo=codigo;
		this.precio=precio;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public String getCodigo() {
		return this.codigo;
	}
	
	public float getPrecio() {
		return this.precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public float costoFinal() {
		return this.precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + "]";
	}
	
	
}
