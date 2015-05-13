package modelo.excepciones;

public class ExcepcionClienteNoEncontrado extends Exception{

	public static final String ERROR_CLIENTE_NO_ENCONTRADO ="El cliente buscado no ha sido encontrado";
	
	
	public ExcepcionClienteNoEncontrado(int id) {
		super(ERROR_CLIENTE_NO_ENCONTRADO + "("+ id+")");
	}

	public ExcepcionClienteNoEncontrado(String nombre) {
		super(ERROR_CLIENTE_NO_ENCONTRADO + "("+ nombre+")");
	}
}