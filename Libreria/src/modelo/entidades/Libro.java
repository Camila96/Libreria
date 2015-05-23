package modelo.entidades;

import java.awt.Image;
import java.io.Serializable;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class Libro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private String genero;
	private int copiasVendidas;
	private double valor;
	private String image;
	private String autor;
	private int id;
	private static int consecutivo;


	public Libro(String nombre, String descripcion, double valor, String genero,String autor,
			int copiasVendidas, String image) {
		this.id = consecutivo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.genero = genero;
		this.copiasVendidas = copiasVendidas;
		this.valor = valor;
		this.image = image;
		this.autor = autor;
		consecutivo++;
	}	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCopiasVendidas() {
		return copiasVendidas;
	}

	public void setCopiasVendidas(int copiasVendidas) {
		this.copiasVendidas = copiasVendidas;
	}



	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return nombre + ","+ descripcion + "," +valor+ ","+ genero+","+ autor+","+copiasVendidas +","+image;
	}
}
