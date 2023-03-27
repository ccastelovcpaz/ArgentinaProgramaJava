package Clase8;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Carrito {
	
//	private Producto producto1;
//	private Producto producto2;
//	private Producto producto3;
	private ArrayList<Producto> productos;
	private LocalDateTime fechaCompra;
	
	public Carrito(LocalDateTime fechaCompra) {
//		this.producto1=producto1;
//		this.producto2=producto2;
//		this.producto3=producto3;
		this.productos = new ArrayList<Producto>();
		this.fechaCompra=fechaCompra;
	}

	public ArrayList<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public LocalDateTime getFechaCompra() {
		return this.fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public float costoFinal(Descuento dto) throws CarritoException {
		float resultado=0;
		for (int i=0;i<productos.size();i++) {
			resultado += productos.get(i).costoFinal();
		}
//		return dto.valorFinal(producto1.costoFinal()+producto2.costoFinal()+producto3.costoFinal());
		if (resultado==0) {
			throw new CarritoException("Error: no se puede aplicar descuento a un carrito de precio 0.");
		}
		resultado = dto.valorFinal(resultado);
		if (resultado<0) {
			throw new CarritoException("Error: al aplicar el descuento queda un importe negativo.");
		}
		return resultado;
	}
	
}