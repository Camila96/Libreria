package modelos.util;

import modelo.entidades.Libro;

public class Util {

	public static boolean validarValor(String numero){
		try {
			 Double.parseDouble(numero);	
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean validarCopias(String numero){
		try {
			 Double.parseDouble(numero);	
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static String[] sitioAVector(Libro libro){
		return new String[]{Integer.toString(libro.getId()),libro.getNombre(),
				libro.getDescripcion(),Double.toString(libro.getValor()),libro.getGenero(),
				libro.getAutor(),Double.toString(libro.getCopiasVendidas()),libro.getImage()};
	}
}
