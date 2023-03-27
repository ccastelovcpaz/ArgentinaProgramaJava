package Clase8;

import java.time.Duration;
import java.time.LocalDateTime;

public class Persona {

	private String nombre;
	private String apellido;
	private LocalDateTime fechaDeNacimiento;
	private Carrito carrito;
	
	public Persona(String nombre, String apellido, LocalDateTime fechaDeNacimiento, Carrito carrito) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.carrito=carrito;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDateTime fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public int edad() {
		LocalDateTime fechaActual = LocalDateTime.now();
		long dias = Duration.between(this.fechaDeNacimiento, fechaActual).toDays();
		int edad = (int)(dias/365.2425);
		return edad;
	}
	
	public Carrito getCarrito() {
		return this.carrito;
	}
	
	public void setCarrito(Carrito carrito) {
		this.carrito=carrito;
	}
}
