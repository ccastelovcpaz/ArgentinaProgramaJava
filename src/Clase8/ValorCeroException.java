package Clase8;

public class ValorCeroException extends Exception {

	private final float valorCarrito;

	public ValorCeroException(float valorCarrito) {
		this.valorCarrito = valorCarrito;
	}

	public float getValorCarrito() {
		return valorCarrito;
	}
	
	@Override
	public String getMessage() {
		return "Error: no se puede aplicar descuento a un carrito de precio 0.";
	}
}
