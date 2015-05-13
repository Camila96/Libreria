package modelo.entidades;

import java.awt.Image;

public class Libro {

	private String nombre;
	private String descripcion;
	private Genero genero;
	private int copiasVendidas;
	private double valor;
	private String image;
	private Autor autor;
	private int id;
	
	
	public Libro(String nombre, String descripcion, Genero genero,
			int copiasVendidas, double valor, String image, Autor autor,int id) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.genero = genero;
		this.copiasVendidas = copiasVendidas;
		this.valor = valor;
		this.image = image;
		this.autor = autor;
		this.id = id;
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


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public int getCopiasVendidas() {
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

	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
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
	
}
