package modelo.dao;

import java.util.ArrayList;
import java.util.HashMap;

import persistencia.XmlLibro;
import modelo.entidades.Libro;
import modelo.excepciones.ExcepcionLibroNoEncontrado;
import modelos.util.Util;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class GestorLibro {

	private ArrayList<Libro> listaLibro;

	public GestorLibro() {
		listaLibro = new ArrayList<Libro>();
		cargarDatos();
	}

	public void agregarLibro(Libro libro){
		listaLibro.add(libro);
	}

	public void eliminarLibro(Libro libro){
		listaLibro.remove(libro);	
	}

	public Libro buscarLibro(int id) throws ExcepcionLibroNoEncontrado{
		for (Libro libro:listaLibro ) {
			if (libro.getId() == id) {
				return libro;
			}
		}
		throw new ExcepcionLibroNoEncontrado(id);
	}

	public Libro buscarLibro(String nombre) throws ExcepcionLibroNoEncontrado{
		for (Libro libro:listaLibro) {
			if (libro.getNombre().equalsIgnoreCase(nombre)) {
				return libro;
			}
		}
		throw new ExcepcionLibroNoEncontrado(nombre);
	}

	public static Libro crearLibro(String nombre,String descripcion,String valor,String genero,String autor,String copiasVendidas, String image){
		if (Util.validarValor(valor)&& Util.validarCopias(copiasVendidas)) {
			return new Libro(nombre, descripcion,Double.parseDouble(valor),
					genero,autor,copiasVendidas,image);	
		}
		return null;
	}

	public static void editarStioTuristico(Libro libroViejo , HashMap<String, String> listaCampos ){
		if (listaCampos.containsKey("NOMBRE")) {
			libroViejo.setNombre(listaCampos.get("NOMBRE"));;
		}
		if (listaCampos.containsKey("DETALLES")) {
			libroViejo.setDescripcion(listaCampos.get("DETALLES"));;
		}
		if (listaCampos.containsKey("VALOR")) {
			libroViejo.setValor(Double.parseDouble(listaCampos.get("VALOR")));
		}
		if (listaCampos.containsKey("DIRECCION")) {
			libroViejo.setImage(listaCampos.get("DIRECCION"));;
		}
	}
	
	public ArrayList<Libro> getListaLibro() {
		return listaLibro;
	}

	public void setListaLibro(ArrayList<Libro> listaLibro) {
		this.listaLibro = listaLibro;
	}
	
	public void cargarDatos() {
		listaLibro = XmlLibro.leerXML("src/data/arraylibros.xml");
	}
}
