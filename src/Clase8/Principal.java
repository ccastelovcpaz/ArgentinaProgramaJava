package Clase8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		String archivo = "Compras.txt";
		Carrito carrito = new Carrito(LocalDateTime.parse("2023-03-17T10:00:00"));
		
		try {
			List<String> lista = Files.readAllLines(Paths.get(archivo));
			for (int i=1; i<lista.size();i++) {
				String[] datosProducto = lista.get(i).split(" ");
				carrito.agregarProducto(new Producto(datosProducto[1],datosProducto[2],Float.parseFloat(datosProducto[0])));
			}
			Persona persona = new Persona("Juan","Perez",LocalDateTime.parse("1990-01-01T12:00:00"),carrito);
			Descuento dtoFijo = new DescuentoFijo(20);
//			dtoFijo.setValorDesc(25);
			Descuento dtoPorcentaje = new DescuentoPorcentaje(.2F);
			Descuento dtoPorcConTope = new DescuentoPorcentajeConTope(0.25F);
			dtoPorcConTope.setValorDesc(0.10F);
			try {
				System.out.println("El costo del carrito sin descuento es: "+persona.getCarrito().costoFinal(new DescuentoFijo(0)));
				float resultado = persona.getCarrito().costoFinal(dtoPorcentaje);
				System.out.println("El costo final del carrito con descuento es: "+resultado);
//				System.out.println(dtoPorcConTope.getClass().toString());
//				for(int i=0;i<persona.getCarrito().getProductos().size();i++) {
//					System.out.println(persona.getCarrito().getProductos().get(i).toString());
//				}
			} catch (ValorCeroException | TotalNegativoException e) {
				System.out.println(e);
			}
			
		} catch (IOException e){
			System.out.println(e);
		}
	}

}
