package modelo.dao;

import java.util.ArrayList;
import modelo.entidades.Autor;
import modelo.excepciones.ExcepcionAutorNoEncontrado;
import modelos.util.Util;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class GestorAutor {

	private ArrayList<Autor> listaAutor;

	public GestorAutor() {
		listaAutor = new ArrayList<Autor>();
	}

	public void agregarAutor(Autor autor){
		listaAutor.add(autor);
	}

	public void eliminarAutor(Autor autor){
		listaAutor.remove(autor);	
	}

	public Autor buscarAutor(String nombre) throws ExcepcionAutorNoEncontrado{
		for (Autor autor : listaAutor) {
			if (autor.getNombre().equalsIgnoreCase(nombre)) {
				return autor;
			}
		}
		throw new ExcepcionAutorNoEncontrado(nombre);
	}

	public static Autor crearAutor(String nombre,int id){
		return new Autor(nombre,id);	
	}

	public ArrayList<Autor> getListaAutor() {
		return listaAutor;
	}

	public void setListaAutor(ArrayList<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}


}
