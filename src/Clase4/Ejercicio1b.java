package Clase4;

import java.util.Scanner;

public class Ejercicio1b {

	public static void main(String[] args) {
		
		System.out.println("*** Clase 4 - Programas y Archivos - Ejercicio 1.b ****");
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingrese tres números enteros:");
		System.out.print("1° nro: ");
		String nro1 = scn.nextLine();
		System.out.print("2° nro: ");
		String nro2 = scn.nextLine();
		System.out.print("3° nro: ");
		String nro3 = scn.nextLine();
		System.out.print("Ingrese el orden (A para ascendente, D para descendente): ");
		String orden = scn.nextLine();
		
		scn.close();
		Ejercicio1a.ordenarTresNumeros(Integer.parseInt(nro1),Integer.parseInt(nro2),Integer.parseInt(nro3),orden.charAt(0));
		
	} //main
	
}
