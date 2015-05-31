package modelo.entidades;

import java.util.ArrayList;

import modelos.util.Util;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class Cliente {

	private String nombre;
	private int id;
	private double credito;
	private ArrayList<Libro> listaLibro;
	private boolean activo;
	private String passWord;

	public Cliente(String nombre, double credito, String passWord) {
		this.nombre = nombre;
		this.id = Util.asignarId("src/data/Archivo Id Clientes.txt");
		this.credito = credito;
		this.passWord = passWord;
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

	@Override
	public String toString() {
		return nombre + ","+ credito;
	}
	
	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
