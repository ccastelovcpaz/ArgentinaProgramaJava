package Clase4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		String rutaArchivoEntrada = "C:\\Users\\noteb\\Documents\\GitHub\\ArgentinaProgramaJava\\src\\Clase4\\Entrada.txt";
		String rutaArchivoSalida = "C:\\Users\\noteb\\Documents\\GitHub\\ArgentinaProgramaJava\\src\\Clase4\\Salida.txt";
		String cadenaCodificada;
		
		char queHacer = Ejercicio2.unCaracter("Ingrese C para codificar o D para decodificar: ", "CD");
		int desplazamiento = unNumero("Indique las posiciones para el desplazamiento: ");
				
		try {
			if (Files.exists(Paths.get(rutaArchivoSalida))) {
				Files.delete(Paths.get(rutaArchivoSalida));
			}
			Files.createFile(Paths.get(rutaArchivoSalida));
			for (String linea : Files.readAllLines(Paths.get(rutaArchivoEntrada))) {
				cadenaCodificada = codificar(linea,queHacer,desplazamiento);
				Files.writeString(Paths.get(rutaArchivoSalida),cadenaCodificada+"\n",StandardOpenOption.APPEND);
				System.out.println("La codificación del archivo "+rutaArchivoEntrada+"\nha resultado exitosa. Revise el archivo "
						           +rutaArchivoSalida+"\npara ver el resultado.");
			}
		} catch (IOException e) {
			System.out.println("Ocurrió un error: " + e.getMessage());
		}
		
		
	
	} // main

	public static String codificar(String cadenaOrigen, char queHacer, int desplazamiento) {
		String cadenaCodificada = "";
		for (int i=0;i<cadenaOrigen.length();i++) {
			cadenaCodificada=cadenaCodificada+nuevoCaracterCodificado(cadenaOrigen.charAt(i),queHacer,desplazamiento);
		}
		return cadenaCodificada;
	} // codificar

	public static char nuevoCaracterCodificado(char caracterBuscado, char queHacer, int desplazamiento) {
		String cadenaParaCodificar = "abcdefghijklmnñopqrstuvwxyz ";  // 28 caracteres
		char caracterCodificado = '\n';
		int correccion;
		boolean caracterNoEncontrado=true;
		for (int i = 0; i < cadenaParaCodificar.length(); i++) {
			if (cadenaParaCodificar.charAt(i)==caracterBuscado) {
				if (queHacer=='C') {
					correccion=0;
					if (i+desplazamiento>cadenaParaCodificar.length()-1) {
						correccion=-cadenaParaCodificar.length();
					}
					caracterCodificado=cadenaParaCodificar.charAt(i+desplazamiento+correccion);
				} else {
					correccion=0;
					if (i-desplazamiento<0) {
						correccion=cadenaParaCodificar.length();
					}
					desplazamiento=-desplazamiento;
				}
				caracterCodificado=cadenaParaCodificar.charAt(i+desplazamiento+correccion);
				caracterNoEncontrado=false;
				i = cadenaParaCodificar.length();
			}
		}
		if (caracterNoEncontrado) {
			caracterCodificado=caracterBuscado;
		}
		return caracterCodificado;
	} // nuevoCaracterCodificado

	public static int unNumero(String mensaje) {
		Scanner scn = new Scanner(System.in);
		String nro ="";
		System.out.print(mensaje);
		do {
			nro=scn.next();
		} while (!esNumero(nro));
		return Integer.parseInt(nro);
	} // unNumero
	
	private static boolean esNumero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	} // esNumero

} // Ejercicio3
