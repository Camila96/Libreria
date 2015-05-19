package modelo.entidades;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class Autor {

	private String nombre;
	private int id;
	private static int consecutivo;

	public Autor(String nombre) {
		this.id = consecutivo;
		this.nombre = nombre;
		consecutivo++;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
