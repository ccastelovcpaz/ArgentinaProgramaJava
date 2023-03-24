package Clase7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		String archivo = "Compras.txt";
		try {
			List<String> lista = Files.readAllLines(Paths.get(archivo));
			String[] datosProducto1 = lista.get(1).split(" ");
			String[] datosProducto2 = lista.get(2).split(" ");
			String[] datosProducto3 = lista.get(3).split(" ");
			Producto producto1 = new Producto(datosProducto1[1],datosProducto1[2],Float.parseFloat(datosProducto1[0]));
			Producto producto2 = new Producto(datosProducto2[1],datosProducto2[2],Float.parseFloat(datosProducto2[0]));
			Producto producto3 = new Producto(datosProducto3[1],datosProducto3[2],Float.parseFloat(datosProducto3[0]));
			Carrito carrito = new Carrito(producto1, producto2, producto3, LocalDateTime.parse("2023-03-17T10:00:00"));
			Persona persona = new Persona("Juan","Perez",LocalDateTime.parse("1990-01-01T12:00:00"),carrito);
			Descuento dtoFijo = new DescuentoFijo(20);
//			dtoFijo.setValorDesc(25);
			Descuento dtoPorcentaje = new DescuentoPorcentaje(.2F);
			Descuento dtoPorcConTope = new DescuentoPorcentajeConTope(0.25F);
			dtoPorcConTope.setValorDesc(0.10F);
			
			float resultado = persona.getCarrito().costoFinal(dtoPorcConTope);
			System.out.println("El costo final del carrito es: "+resultado);
		} catch (IOException e){
			System.out.println(e);
		}
	}

}
