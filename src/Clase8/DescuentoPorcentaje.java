package Clase8;

public class DescuentoPorcentaje extends Descuento{

	public DescuentoPorcentaje(float valor) {
		super(valor);
	}

	@Override
	public float valorFinal(float valorInicial) throws ValorCeroException, TotalNegativoException {
		return valorInicial - ( valorInicial * super.getValorDesc());
	}

}
