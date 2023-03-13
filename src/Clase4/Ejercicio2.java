package Clase4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		String rutaArchivo = "C:\\Users\\noteb\\Documents\\GitHub\\ArgentinaProgramaJava\\src\\Clase4\\ArchivoConNumeros.txt";
		
		Scanner scn = new Scanner(System.in);
		switch (unCaracter("Presione \"+\" para suma o \"*\" para multiplicación: ","+*")) {
		case '+': 
			sumaNumeros(rutaArchivo); 
			break;
		case '*': 
			multiplicacionNumeros(rutaArchivo); 
			break;
		}
	}

	public static char unCaracter(String mensaje, String opciones) {
		Scanner scn = new Scanner(System.in);
		String opcionesMayuscula = opciones.toUpperCase();
		String caracter="";
		
		System.out.print(mensaje);
		do {
			do {
				caracter=(scn.next().toUpperCase());
			} while (caracter.length()==0);
			caracter=caracter.substring(0,1);
			if (!opcionesMayuscula.contains(caracter)) {
				System.out.print(mensaje);
			}	
		} while (!opcionesMayuscula.contains(caracter));
		return caracter.charAt(0);
	}
	
	private static int multiplicacionNumeros(String rutaArchivo) {
		int multiplicacion=1;
		String stringDeMultiplicacion="";
		try {
			for (String linea : Files.readAllLines(Paths.get(rutaArchivo))) {
				multiplicacion=multiplicacion*Integer.parseInt(linea);
				stringDeMultiplicacion+=linea+"*";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		stringDeMultiplicacion=stringDeMultiplicacion.substring(0,(stringDeMultiplicacion.length()-1));
		System.out.println(stringDeMultiplicacion+"="+multiplicacion);
		return multiplicacion;		
	}

	private static int sumaNumeros(String rutaArchivo) {
		int suma=0;
		String stringDeSuma="";
		try {
			for (String linea : Files.readAllLines(Paths.get(rutaArchivo))) {
				suma+=Integer.parseInt(linea);
				stringDeSuma+=linea+"+";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		stringDeSuma=stringDeSuma.substring(0,(stringDeSuma.length()-1));
		System.out.println(stringDeSuma+"="+suma);
		return suma;
	}

}
