package modelo.excepciones;

public class ExcepcionAutorNoEncontrado  extends Exception{

	public static final String ERROR_AUTOR_NO_ENCONTRADO ="El autor buscado no ha sido encontrado";

	
	public ExcepcionAutorNoEncontrado(String nombre) {
		super(ERROR_AUTOR_NO_ENCONTRADO + "("+ nombre+")");
	}
}