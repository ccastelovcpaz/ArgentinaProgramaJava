package Clase8;

public class CarritoException extends Exception {
	
	private String error;
	
	public CarritoException (String error) {
		this.error = error;
	}
	
	public String getError() {
		return this.error;
	}
}
