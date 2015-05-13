package modelos.util;

public class Util {

	public static boolean validarValor(String numero){
		try {
			 Double.parseDouble(numero);	
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
