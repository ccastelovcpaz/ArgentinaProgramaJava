package Clase7;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CarritoTest {

	@Test
	void testCostoFinalConDtoFijo() {
		Producto producto1 = new Producto("Atún","58",100F);
		Producto producto2 = new Producto("Arvejas","67",50F);
		Producto producto3 = new Producto("Arroz","35",20F);
		Carrito miCarrito = new Carrito(producto1, producto2, producto3, LocalDateTime.parse("2023-03-17T10:00:00"));
		Descuento dtoFijo = new DescuentoFijo(20);
		float resultado = miCarrito.costoFinal(dtoFijo);
		assertEquals(150,resultado);
	}

	@Test
	void testCostoFinalConDtoPorcentaje() {
		Producto producto1 = new Producto("Atún","58",100F);
		Producto producto2 = new Producto("Arvejas","67",50F);
		Producto producto3 = new Producto("Arroz","35",20F);
		Carrito miCarrito = new Carrito(producto1, producto2, producto3, LocalDateTime.parse("2023-03-17T10:00:00"));
		Descuento dtoPorcentaje = new DescuentoPorcentaje(.2F);
		float resultado = miCarrito.costoFinal(dtoPorcentaje);
		assertEquals(136,resultado);
	}
	
	@Test
	void testCostoFinalConDtoPorcentajeConTope1() {
		Producto producto1 = new Producto("Atún","58",100F);
		Producto producto2 = new Producto("Arvejas","67",50F);
		Producto producto3 = new Producto("Arroz","35",20F);
		Carrito miCarrito = new Carrito(producto1, producto2, producto3, LocalDateTime.parse("2023-03-17T10:00:00"));
		Descuento dtoPorcConTope = new DescuentoPorcentajeConTope(.2F);
		dtoPorcConTope.setValorDesc(.1F);
		float resultado = miCarrito.costoFinal(dtoPorcConTope);
		assertEquals(163,resultado);
	}
	
	@Test
	void testCostoFinalConDtoPorcentajeConTope2() {
		Producto producto1 = new Producto("Atún","58",100F);
		Producto producto2 = new Producto("Arvejas","67",50F);
		Producto producto3 = new Producto("Arroz","35",20F);
		Carrito miCarrito = new Carrito(producto1, producto2, producto3, LocalDateTime.parse("2023-03-17T10:00:00"));
		Descuento dtoPorcConTope = new DescuentoPorcentajeConTope(.2F);
		dtoPorcConTope.setValorDesc(.3F);
		float resultado = miCarrito.costoFinal(dtoPorcConTope);
		assertEquals(170,resultado);
	}
}
