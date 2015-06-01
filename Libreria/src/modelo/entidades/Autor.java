package modelo.entidades;

import java.io.Serializable;

import modelos.util.Util;

/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class Autor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int id;
	private String image;

	public Autor(String nombre,String imagen) {
		this.id = Util.asignarId("src/data/Archivo Id Autor.txt");
		this.nombre = nombre;
		this.image = imagen;
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
