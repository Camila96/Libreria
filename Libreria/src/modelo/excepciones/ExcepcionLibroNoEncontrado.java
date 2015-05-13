package modelo.excepciones;

public class ExcepcionLibroNoEncontrado extends Exception {

	public static final String ERROR_LIBRO_NO_ENCONTRADO ="El libro buscado no ha sido encontrado";
	
	public ExcepcionLibroNoEncontrado(int id) {
		super(ERROR_LIBRO_NO_ENCONTRADO + "("+ id+")");
	}

	public ExcepcionLibroNoEncontrado(String nombre) {
		super(ERROR_LIBRO_NO_ENCONTRADO + "("+ nombre+")");
	}
}
