package Clase7;

public class DescuentoPorcentajeConTope extends DescuentoPorcentaje {

	private float tope;
	
	public DescuentoPorcentajeConTope(float tope) {
		super(0);
		this.tope=tope;
	}

	public float getTope() {
		return this.tope;
	}
	
	public void setTope(float tope) {
		this.tope=tope;
	}
	
	@Override
	public void setValorDesc(float valor) {
		if (valor>this.tope) {
			super.setValorDesc(0);
			System.out.println("No se realiza descuento porque el valor supera el tope.");
		} else {
			super.setValorDesc(valor);
		}
	}

}
