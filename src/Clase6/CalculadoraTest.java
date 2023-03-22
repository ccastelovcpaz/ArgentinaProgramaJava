package Clase6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSolicitado1() {
		assertEquals(Calculadora.multiplicar(80, 3),240);
	}

	@Test
	void testSolicitado2() {
		assertEquals(Calculadora.dividir(Calculadora.sumar(150, 180),3),110);
	}
	
	@Test
	void testSolicitado3() {
		assertFalse(Calculadora.multiplicar(Calculadora.restar(90, 50),15)==605);
	}
	
	@Test
	void testSolicitado4() {
		assertFalse(Calculadora.multiplicar(Calculadora.sumar(70, 40),25)==2700);
	}
}
