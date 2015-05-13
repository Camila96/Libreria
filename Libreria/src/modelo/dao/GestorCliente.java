package modelo.dao;

import java.util.ArrayList;

import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.excepciones.ExcepcionAutorNoEncontrado;
import modelo.excepciones.ExcepcionClienteNoEncontrado;
import modelos.util.Util;

public class GestorCliente {

	private ArrayList<Cliente> listaCliente;

	public GestorCliente() {
		listaCliente = new ArrayList<Cliente>();
	}

	public void agregarCliente(Cliente cliente){
		listaCliente.add(cliente);
	}

	public void eliminarCliente(Cliente cliente){
		listaCliente.remove(cliente);	
	}

	public Cliente buscarSitioTuristico(int id) throws ExcepcionClienteNoEncontrado{
		for (Cliente cliente: listaCliente) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		throw new ExcepcionClienteNoEncontrado(id);
	}

	public Cliente buscarAutor(String nombre) throws ExcepcionClienteNoEncontrado{
		for (Cliente cliente : listaCliente) {
			if (cliente.getNombre().equalsIgnoreCase(nombre)) {
				return cliente;
			}
		}
		throw new ExcepcionClienteNoEncontrado(nombre);
	}
	
	public static Cliente crearCliente(String nombre, int id, String valor){
		if (Util.validarValor(valor)) {
			return new Cliente(nombre,id, Double.parseDouble(valor));	
		}
		return null;
	}
	
	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
}
