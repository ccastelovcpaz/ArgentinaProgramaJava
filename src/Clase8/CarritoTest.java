package Clase8;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarritoTest {

	Carrito miCarrito;
	
	@BeforeEach
	void inicializar () {
		miCarrito = new Carrito(LocalDateTime.parse("2023-03-17T10:00:00"));
		miCarrito.agregarProducto(new Producto("Atún","58",100F));
		miCarrito.agregarProducto(new Producto("Arvejas","67",50F));
		miCarrito.agregarProducto(new Producto("Arroz","35",20F));
	}
	
	@Test
	void testCostoFinalConDtoFijo() {
		Descuento dtoFijo = new DescuentoFijo(20);
		try {
			float resultado = miCarrito.costoFinal(dtoFijo);
			assertEquals(150,resultado);
		} catch (ValorCeroException | TotalNegativoException e) {
			System.out.println(e);
		}
	}

	@Test
	void testCostoFinalConDtoPorcentaje() {
		Descuento dtoPorcentaje = new DescuentoPorcentaje(.2F);
		try {
			float resultado = miCarrito.costoFinal(dtoPorcentaje);
			assertEquals(136,resultado);
		} catch (ValorCeroException | TotalNegativoException e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testCostoFinalConDtoPorcentajeConTope1() {
		Descuento dtoPorcConTope = new DescuentoPorcentajeConTope(.2F);
		dtoPorcConTope.setValorDesc(.1F);
		try {
			float resultado = miCarrito.costoFinal(dtoPorcConTope);
			assertEquals(153,resultado);
		} catch (ValorCeroException | TotalNegativoException e) {
			System.out.println(e);
		}	
	}
	
	@Test
	void testCostoFinalConDtoPorcentajeConTope2() {
		Descuento dtoPorcConTope = new DescuentoPorcentajeConTope(.2F);
		dtoPorcConTope.setValorDesc(.3F);
		try {
			float resultado = miCarrito.costoFinal(dtoPorcConTope);
			assertEquals(170,resultado);
		} catch (ValorCeroException | TotalNegativoException e) {
			System.out.println(e);
		}	
	}
	
	@Test
	void testCarritoConPrecioCero() {
		miCarrito.vaciarCarrito();
		miCarrito.agregarProducto(new Producto("","",0));
		Assertions.assertThrows(ValorCeroException.class, () -> {miCarrito.costoFinal(new DescuentoFijo(0));} );
	}
	
	@Test
	void testResultadoDelDescuentoDaMontoNegativo() {
		Descuento dtoPorcentaje = new DescuentoPorcentaje(1.5F);
		Assertions.assertThrows(TotalNegativoException.class, () -> {miCarrito.costoFinal(dtoPorcentaje);} );
	}
}
