package Clase1;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("*** Clase 1 - Introducción a Algoritmos y Java - Ejercicio 1 ****");
		// ejercicio 1.a
		String salida = "Ejercicio 1.a: ";
		int a = 10;
		int b = 20;
		int contador = a;
		while (contador<=b) {
			salida=salida+contador;
			if (contador<b) salida=salida+",";
			contador++;
		}
		System.out.println(salida);
		// fin ejercicio 1.a
		
		// ejercicio 1.b
		salida = "Ejercicio 1.b: ";
		
		contador = a;
		while (contador<=b) {
			if(contador%2 == 0) {
				salida=salida+contador;
				if (contador<b) salida=salida+",";
			}
			contador++;
		}
		System.out.println(salida);
		// fin ejercicio 1.b

		// ejercicio 1.c
		salida = "Ejercicio 1.c: ";
		
		boolean mostrarPares = false;
		contador = a;
		while (contador<=b) {
			if((contador%2 == 0)==mostrarPares) {
				salida=salida+contador;
				if (contador<b-1) salida=salida+",";
			}
			contador++;	
		}
		System.out.println(salida);
		// fin ejercicio 1.c
		
		// ejercicio 1.d
		salida = "Ejercicio 1.d: ";
		
		for (int i=b;i>=a;i--) {
			if(i%2 == 0) {
				salida=salida+i;
				if (i>a) salida=salida+",";
			}			
		}
		System.out.println(salida);
		// fin ejercicio 1.d
		
	} //main
} // Ejercicio1
