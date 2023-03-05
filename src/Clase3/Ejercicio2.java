package Clase3;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("*** Clase 3 - Array y String - Ejercicio 2 ****");
		String cadenaCodificar = "Hola mi nombre es Claudio";
		String cadenaDecodificar = "~%jxyt~%js%Fwljsynsf%Uwtlwfrf%935";
		int desplazamiento = 5;
		System.out.println("La cadena  \""+cadenaCodificar+"\" codificada con un desplazamiento de "+desplazamiento+" lugares\nqueda así: \""+codificar(cadenaCodificar,desplazamiento)+"\"");
		System.out.println("La cadena  \""+cadenaDecodificar+"\" decodificada con un desplazamiento de "+desplazamiento+" lugares\nqueda así: \""+decodificar(cadenaDecodificar,desplazamiento)+"\"");
	
	} //main
	
	public static String codificar(String cadena, int desplazamiento) {
		String cadenaNueva="";
		
		for (int i=0;i<cadena.length();i++) {
			cadenaNueva+=(char)((int)cadena.charAt(i)+desplazamiento);
		}
		cadena=cadenaNueva;
		return cadena;
	} //codificar
	
	public static String decodificar(String cadena, int desplazamiento) {
		String cadenaNueva="";
		
		for (int i=0;i<cadena.length();i++) {
			cadenaNueva+=(char)((int)cadena.charAt(i)-desplazamiento);
		}
		cadena=cadenaNueva;
		return cadena;
	} //decodificar
	
} //Ejercicio2
