package Clase8;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Carrito {
	
	private ArrayList<Producto> productos;
	private LocalDateTime fechaCompra;
	
	public Carrito(LocalDateTime fechaCompra) {
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
	
	public void agregarProducto(Producto producto) {
		if (!existeProducto(producto)) {
			this.productos.add(producto);
		}
	}
	
	public void eliminarProducto(String codigo) {
		for (int i=0;i<productos.size();i++) {
			if (this.productos.get(i).getCodigo().equals(codigo)) {
				this.productos.remove(i);
			}
		}
	}
	
	public boolean existeProducto(Producto producto) {
		for (Producto p : productos) {
			if (p.getCodigo().equals(producto.getCodigo())) {
				return true;
			}
		}
		return false;
	}
	public void vaciarCarrito() {
		this.productos.clear();
		this.fechaCompra=null;
	}
	
	public float costoFinal(Descuento dto)  throws ValorCeroException, TotalNegativoException {
		float resultado=0;
		for (int i=0;i<productos.size();i++) {
			resultado += productos.get(i).costoFinal();
		}
		if (resultado==0) {
			throw new ValorCeroException(resultado);
		}
		resultado = dto.valorFinal(resultado);
		if (resultado<0) {
			throw new TotalNegativoException(resultado);
		}
		return resultado;
	}
	
}