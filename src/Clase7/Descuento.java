package Clase7;

public abstract class Descuento {

		private float valor;
		
		public Descuento(float valor) {
			this.valor = valor;
		}
		
		public float getValorDesc() {
			return valor;
		}
		
		public void setValorDesc(float valor) {
			this.valor = valor;
		}
		
		public abstract float valorFinal(float valorInicial);

}

