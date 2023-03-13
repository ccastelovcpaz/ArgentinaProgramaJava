package Clase4;

public class Ejercicio1a {

	public static void main(String[] args) {
		
		System.out.println("*** Clase 4 - Programas y Archivos - Ejercicio 1.a ****");
		
		ordenarTresNumeros(2,1,3,'A');
		
	} //main

	public static void ordenarTresNumeros(int nro1, int nro2, int nro3, char letraOrden) {
		int vector[] = new int[] {nro1,nro2,nro3};
		boolean cambios = true;
		int i=0;
		int temp;
		String orden="no especificada";
		
		while (cambios) {
			cambios=false;
			for (i=0;i<vector.length-1;i++) {
				if (letraOrden=='A') {          //ascendente
					if (vector[i]>vector[i+1]) {
						temp=vector[i];
						vector[i]=vector[i+1];
						vector[i+1]=temp;
						cambios=true;
					}
				} else if (letraOrden=='D') {   //descendente
					if (vector[i]<vector[i+1]) {
						temp=vector[i];
						vector[i]=vector[i+1];
						vector[i+1]=temp;
						cambios=true;
					}
				} //if
			} //for
		} //while
		if(letraOrden=='A') { orden="ascendente"; } else if (letraOrden=='D') { orden="descendente"; }
		System.out.print("Los nros ordenados de forma "+orden+" quedan así: ");
		for (i=0;i<vector.length;i++) {
			System.out.print(vector[i]);
			if (i<vector.length-1) {System.out.print(",");}
		}
		System.out.println(".");
	} //ordenarTresNumeros
	
} //clase4
