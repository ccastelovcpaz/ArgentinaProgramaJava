package Clase3;

import java.util.Arrays;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("*** Clase 3 - Array y String - Ejercicio 1 ****");
		contarLetra("Argentina Programa",'n');
		ordenarTresNumeros(5,3,8,false);
		sumarNrosMayoresA(4);
	
	} //main
	
	public static void contarLetra(String cadena, char letra) {
		int contador = 0;

		for (int i=0;i<cadena.length();i++){
			if (cadena.charAt(i)==letra) { 
				contador++;
			}
		}
		System.out.println("a) La letra "+letra+" aparece "+contador+" veces en la cadena \""+cadena+"\".");
	} //contarLetra
	
	public static void ordenarTresNumeros(int nro1, int nro2, int nro3, boolean ascendente) {
		int vector[] = new int[] {nro1,nro2,nro3};
		boolean cambios = true;
		int i=0;
		int temp;
		String orden="descendente";
		
		while (cambios) {
			cambios=false;
			for (i=0;i<vector.length-1;i++) {
				if (ascendente) {
					if (vector[i]>vector[i+1]) {
						temp=vector[i];
						vector[i]=vector[i+1];
						vector[i+1]=temp;
						cambios=true;
					}
				} else {   //descendente
					if (vector[i]<vector[i+1]) {
						temp=vector[i];
						vector[i]=vector[i+1];
						vector[i+1]=temp;
						cambios=true;
					}
				} //if
			} //for
		} //while
		if(ascendente) { orden="ascendente"; }
		System.out.print("b) Los nros ordenados de forma "+orden+" quedan así: ");
		for (i=0;i<vector.length;i++) {
			System.out.print(vector[i]);
			if (i<vector.length-1) {System.out.print(",");}
		}
		System.out.println(".");
	} //ordenarTresNumeros
	
	public static void sumarNrosMayoresA(int numeroX){
		int vector[]=new int[] {5,8,2,3,9,4,7,4,3,5};
		int suma=0;
		
		System.out.print("c) La suma de los nros mayores a "+numeroX+" en el vector "+Arrays.toString(vector));
		for (int i=0;i<vector.length;i++) {
			if(vector[i]>numeroX) {
				suma=suma+vector[i];
			}
		}
		System.out.println(" es: "+suma+".");
	} //sumarNrosMayoresA
	
} //Ejercicio1