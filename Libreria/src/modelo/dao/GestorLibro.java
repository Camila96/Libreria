package modelo.dao;

import java.util.ArrayList;

import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Genero;
import modelo.entidades.Libro;
import modelo.excepciones.ExcepcionClienteNoEncontrado;
import modelo.excepciones.ExcepcionLibroNoEncontrado;
import modelos.util.Util;


public class GestorLibro {

	private ArrayList<Libro> listaLibro;

	public GestorLibro() {
		listaLibro = new ArrayList<Libro>();
	}

	public void agregarLibro(Libro libro){
		listaLibro.add(libro);
	}

	public void eliminarLibro(Libro libro){
		listaLibro.remove(libro);	
	}

	public Libro buscarSitioTuristico(int id) throws ExcepcionLibroNoEncontrado{
		for (Libro libro:listaLibro ) {
			if (libro.getId() == id) {
				return libro;
			}
		}
		throw new ExcepcionLibroNoEncontrado(id);
	}

	public Libro buscarAutor(String nombre) throws ExcepcionLibroNoEncontrado{
		for (Libro libro:listaLibro) {
			if (libro.getNombre().equalsIgnoreCase(nombre)) {
				return libro;
			}
		}
		throw new ExcepcionLibroNoEncontrado(nombre);
	}
	
	public static Libro crearLibro(String nombre,String descripcion,Genero genero,int copiasVendidas,String valor, String image,Autor autor,int id){
		if (Util.validarValor(valor)) {
			return new Libro(nombre, descripcion,genero,copiasVendidas,
					Double.parseDouble(valor), image,autor,id);	
		}
		return null;
	}

	public ArrayList<Libro> getListaLibro() {
		return listaLibro;
	}

	public void setListaLibro(ArrayList<Libro> listaLibro) {
		this.listaLibro = listaLibro;
	}
}
