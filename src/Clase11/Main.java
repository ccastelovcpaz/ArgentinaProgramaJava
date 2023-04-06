package Clase11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String opcion = null;
		String rutaArchivo = "Mensajes.txt";
		String mensaje = null;
		LocalDateTime fecha;
		Scanner scn = new Scanner(System.in);
		System.out.print("Ingrese su nombre: ");
		String nombre = scn.nextLine();
		do {
			limpiarConsola(); 
			System.out.println("Hola "+nombre+", bienvenido!\n");
			System.out.println("Ingrese una opción:\n\n      1) Escribir mensaje.\n      2) Leer mensajes.\n      9) Salir.");
			opcion = scn.nextLine();
			if (opcion.equals("1")) {
				System.out.println("Ingrese su mensaje:\n");
				mensaje = scn.nextLine();
				try {
					if (!Files.exists(Paths.get(rutaArchivo))) {
						Files.createFile(Paths.get(rutaArchivo));
					}

					String dateTime = DateTimeFormatter.ofPattern("dd/mm/yyyy|HH:mm:ss")
		                    .format(LocalDateTime.now());		 
					System.out.println(dateTime);       
					
					Files.writeString(Paths.get(rutaArchivo),"["+nombre+"|"+dateTime+"]: "+mensaje+"\n",StandardOpenOption.APPEND);
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if (opcion.equals("2")) {
				try {
					if (Files.exists(Paths.get(rutaArchivo))) {
						limpiarConsola();
						System.out.println("[Consola de "+nombre+"] Leyendo mensajes...\n");
						for (String linea : Files.readAllLines(Paths.get(rutaArchivo))) {
							System.out.println(linea);
						}
						System.out.println("\nPresione enter para volver al menú...");
						scn.nextLine();
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		} while (!opcion.equals("9"));
		System.out.println("Adios "+nombre+", gracias por utilizar el servicio de mensajería.\n");
	}
	
	private static void limpiarConsola() {
		System.out.print("\033[H\033[2J");  
		System.out.flush();
	}
}
