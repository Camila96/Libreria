package modelo.dao;

import java.util.ArrayList;
import java.util.HashMap;

import persistencia.XmlLibro;
import modelo.entidades.Cliente;
import modelo.excepciones.ExcepcionClienteNoEncontrado;
import modelos.util.Util;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
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

	public Cliente buscarCliente(int id) throws ExcepcionClienteNoEncontrado{
		for (Cliente cliente: listaCliente) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		throw new ExcepcionClienteNoEncontrado(id);
	}

	public Cliente buscarCliente(String nombre) throws ExcepcionClienteNoEncontrado{
		for (Cliente cliente : listaCliente) {
			if (cliente.getNombre().equalsIgnoreCase(nombre)) {
				return cliente;
			}
		}
		throw new ExcepcionClienteNoEncontrado(nombre);
	}

	public static Cliente crearCliente(String nombre, String valor, String passWord,String image){
		if (Util.validarValor(valor)) {
			return new Cliente(nombre, Double.parseDouble(valor),passWord,image);	
		}
		return null;
	}

	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public static void editar(Cliente clienteViejo , HashMap<String, String> listaCampos ){
		if (listaCampos.containsKey("NOMBRE")) {
			clienteViejo.setNombre(listaCampos.get("NOMBRE"));;
		}
		if (listaCampos.containsKey("CREDITO")) {
			clienteViejo.setCredito(Double.parseDouble(listaCampos.get("CREDITO")));;
		}
		if (listaCampos.containsKey("PASS")) {
			clienteViejo.setPassWord(listaCampos.get("PASS"));
		}
		if (listaCampos.containsKey("IMAGEN")) {
			clienteViejo.setImage(listaCampos.get("IMAGEN"));;
		}
	}
}
