package modelo.dao;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.excepciones.ExcepcionAutorNoEncontrado;
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

	public Autor buscarAutor(int id) throws ExcepcionAutorNoEncontrado{
		for (Autor autor:listaAutor ) {
			if (autor.getId() == id) {
				return autor;
			}
		}
		throw new ExcepcionAutorNoEncontrado(id);
	}
	
	public static Autor crearAutor(String nombre,String imagen){
			return new Autor(nombre,imagen);	
	}
	
	public ArrayList<Autor> getListaAutor() {
		return listaAutor;
	}

	public void setListaAutor(ArrayList<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}
	public static void editar(Autor autorViejo , HashMap<String, String> listaCampos ){
		if (listaCampos.containsKey("NOMBRE")) {
			autorViejo.setNombre(listaCampos.get("NOMBRE"));;
		}
		if (listaCampos.containsKey("IMAGEN")) {
			autorViejo.setImage(listaCampos.get("IMAGEN"));;
		}
	}

}
