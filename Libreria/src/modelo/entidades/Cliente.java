package modelo.entidades;

import java.util.ArrayList;

public class Cliente {

	private String nombre;
	private int id;
	private double credito;
	private ArrayList<Libro> listaLibro;
	
	public Cliente(String nombre, int id, double credito) {
		this.nombre = nombre;
		this.id = id;
		this.credito = credito;
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

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public ArrayList<Libro> getListaLibro() {
		return listaLibro;
	}

	public void setListaLibro(ArrayList<Libro> listaLibro) {
		this.listaLibro = listaLibro;
	}
}
