package Clase8;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarritoTest {

	Carrito miCarrito;
	
	@BeforeEach
	void inicializar () {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto("Atún","58",100F));
		productos.add(new Producto("Arvejas","67",50F));
		productos.add(new Producto("Arroz","35",20F));
		miCarrito = new Carrito(LocalDateTime.parse("2023-03-17T10:00:00"));
		miCarrito.setProductos(productos);
	}
	
	@Test
	void testCostoFinalConDtoFijo() {
		Descuento dtoFijo = new DescuentoFijo(20);
		try {
			float resultado = miCarrito.costoFinal(dtoFijo);
			assertEquals(150,resultado);
		} catch (CarritoException c) {
			System.out.println(c.getError());
		}
	}

	@Test
	void testCostoFinalConDtoPorcentaje() {
		Descuento dtoPorcentaje = new DescuentoPorcentaje(.2F);
		try {
			float resultado = miCarrito.costoFinal(dtoPorcentaje);
			assertEquals(136,resultado);
		} catch (CarritoException c) {
			System.out.println(c.getError());
		}
	}
	
	@Test
	void testCostoFinalConDtoPorcentajeConTope1() {
		Descuento dtoPorcConTope = new DescuentoPorcentajeConTope(.2F);
		dtoPorcConTope.setValorDesc(.1F);
		try {
			float resultado = miCarrito.costoFinal(dtoPorcConTope);
			assertEquals(153,resultado);
		} catch (CarritoException c) {
			System.out.println(c.getError());
		}	
	}
	
	@Test
	void testCostoFinalConDtoPorcentajeConTope2() {
		Descuento dtoPorcConTope = new DescuentoPorcentajeConTope(.2F);
		dtoPorcConTope.setValorDesc(.3F);
		try {
			float resultado = miCarrito.costoFinal(dtoPorcConTope);
			assertEquals(170,resultado);
		} catch (CarritoException c) {
			System.out.println(c.getError());
		}	
	}
	
	@Test
	void testCarritoConPrecioCero() {
		ArrayList<Producto> productosEnCero = new ArrayList<Producto>();
		productosEnCero.add(new Producto("","",0));
		miCarrito.setProductos(productosEnCero);
		try {
			float resultado = miCarrito.costoFinal(new DescuentoFijo(0));
			assertEquals(230,resultado);
		} catch (CarritoException c) {
			System.out.println(c.getError());
		}
	}
	
	@Test
	void testResultadoDelDescuentoDaMontoNegativo() {
		Descuento dtoPorcentaje = new DescuentoPorcentaje(1.5F);
		try {
			float resultado = miCarrito.costoFinal(dtoPorcentaje);
			assertEquals(230,resultado);
		} catch (CarritoException c) {
			System.out.println(c.getError());
		}
	}
}
