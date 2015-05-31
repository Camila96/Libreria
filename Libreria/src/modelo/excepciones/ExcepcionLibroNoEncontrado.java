package modelo.excepciones;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class ExcepcionLibroNoEncontrado extends Exception {

	private static final long serialVersionUID = 1L;
	public static final String ERROR_LIBRO_NO_ENCONTRADO ="El libro buscado no ha sido encontrado";

	public ExcepcionLibroNoEncontrado(int id) {
		super(ERROR_LIBRO_NO_ENCONTRADO + "("+ id+")");
	}

	public ExcepcionLibroNoEncontrado(String nombre) {
		super(ERROR_LIBRO_NO_ENCONTRADO + "("+ nombre+")");
	}
}
