package modelo.entidades;

import java.util.ArrayList;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class Cliente {

	private String nombre;
	private int id;
	private double credito;
	private static int consecutivo;
	private ArrayList<Libro> listaLibro;
	private boolean activo;
	private String passWord;

	public Cliente(String nombre, double credito, String passWord) {
		this.nombre = nombre;
		this.id = consecutivo;
		this.credito = credito;
		this.passWord = passWord;
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
