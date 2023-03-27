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
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String archivo = "Compras.txt";
		try {
			List<String> lista = Files.readAllLines(Paths.get(archivo));
			for (int i=1; i<lista.size();i++) {
				String[] datosProducto = lista.get(i).split(" ");
				productos.add(new Producto(datosProducto[1],datosProducto[2],Float.parseFloat(datosProducto[0])));
			}
//			String[] datosProducto1 = lista.get(1).split(" ");
//			String[] datosProducto2 = lista.get(2).split(" ");
//			String[] datosProducto3 = lista.get(3).split(" ");
//			Producto producto1 = new Producto(datosProducto1[1],datosProducto1[2],Float.parseFloat(datosProducto1[0]));
//			Producto producto2 = new Producto(datosProducto2[1],datosProducto2[2],Float.parseFloat(datosProducto2[0]));
//			Producto producto3 = new Producto(datosProducto3[1],datosProducto3[2],Float.parseFloat(datosProducto3[0]));
			Carrito carrito = new Carrito(LocalDateTime.parse("2023-03-17T10:00:00"));
			carrito.setProductos(productos);
			Persona persona = new Persona("Juan","Perez",LocalDateTime.parse("1990-01-01T12:00:00"),carrito);
			Descuento dtoFijo = new DescuentoFijo(20);
//			dtoFijo.setValorDesc(25);
			Descuento dtoPorcentaje = new DescuentoPorcentaje(.2F);
			Descuento dtoPorcConTope = new DescuentoPorcentajeConTope(0.25F);
			dtoPorcConTope.setValorDesc(0.10F);
			
			try {
//				ArrayList<Producto> productosEnCero = new ArrayList<Producto>();
//				productosEnCero.add(new Producto("","",0));
//				persona.getCarrito().setProductos(productosEnCero);
				System.out.println("El costo del carrito sin descuento es: "+persona.getCarrito().costoFinal(new DescuentoFijo(0)));
				float resultado = persona.getCarrito().costoFinal(dtoPorcConTope);
				System.out.println("El costo final del carrito con descuento es: "+resultado);
//			System.out.println(dtoPorcConTope.getClass().toString());
//			for(int i=0;i<persona.getCarrito().getProductos().size();i++) {
//				System.out.println(persona.getCarrito().getProductos().get(i).toString());
//			}
			} catch (CarritoException c) {
				System.out.println(c.getError());
			}
			
		} catch (IOException e){
			System.out.println(e);
		}
	}

}
