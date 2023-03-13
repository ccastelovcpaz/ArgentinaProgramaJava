package Clase4;

import java.util.Scanner;

public class Ejercicio1c {
	
	public static void main(String[] args) {
		System.out.println("*** Clase 4 - Programas y Archivos - Ejercicio 1.c ****");
		Scanner scn = new Scanner(System.in);
		int nro1 = unNumero();
		int nro2 = unNumero();
		int nro3 = unNumero();
		System.out.print("Ingrese el orden (A para ascendente, D para descendente): ");
		char orden = unaLetra("AD"); 

		scn.close();
		Ejercicio1a.ordenarTresNumeros(nro1,nro2,nro3,orden);
		
	} //main

	public static char unaLetra(String opciones) {
		Scanner scn = new Scanner(System.in);
		String opcionesMayuscula = opciones.toUpperCase();
		String letra="x";
		
		while (!opcionesMayuscula.contains(letra)) {
			letra=(scn.nextLine().toUpperCase());
			if (!opcionesMayuscula.contains(letra) || letra.length()==0) {
				System.out.print("Debe ingresar una letra válida ("+opcionesMayuscula+")");
				letra="x";
			}	
		}
		scn.close();
		return letra.charAt(0);
	}

	public static int unNumero() {
		Scanner scn = new Scanner(System.in);
		String nro ="";
		System.out.print("Ingrese un número entero: ");
		while (nro.length()==0) {
			nro=scn.next();
		}
		return Integer.parseInt(nro);
	}
	
} //Ejercicio1c
