package modelo.entidades;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class Autor {

	private String nombre;
	private int id;
	private String image;
	private static int consecutivo;

	public Autor(String nombre, String image) {
		this.id = consecutivo;
		this.nombre = nombre;
		this.image = image;
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

	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return nombre+","+image;
	}
}
