package Clase7;

import java.time.LocalDateTime;

public class Carrito {
	
	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	private LocalDateTime fechaCompra;
	
	public Carrito(Producto producto1, Producto producto2, Producto producto3, LocalDateTime fechaCompra) {
		this.producto1=producto1;
		this.producto2=producto2;
		this.producto3=producto3;
		this.fechaCompra=fechaCompra;
	}

	public Producto getProducto1() {
		return this.producto1;
	}

	public void setProducto1(Producto producto1) {
		this.producto1 = producto1;
	}

	public Producto getProducto2() {
		return this.producto2;
	}

	public void setProducto2(Producto producto2) {
		this.producto2 = producto2;
	}

	public Producto getProducto3() {
		return this.producto3;
	}

	public void setProducto3(Producto producto3) {
		this.producto3 = producto3;
	}

	public LocalDateTime getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public float costoFinal(Descuento dto) {
		return dto.valorFinal(producto1.costoFinal()+producto2.costoFinal()+producto3.costoFinal());
	}
	
}