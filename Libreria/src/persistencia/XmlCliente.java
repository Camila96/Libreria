package persistencia;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import modelo.entidades.Cliente;

import org.jespxml.JespXML;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Atributo;
import org.jespxml.modelo.Encoding;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;


public class XmlCliente{

	private static Tag raiz;
	private static Tag libro;
	private static Tag id;
	private static Tag nombre;
	private static Tag saldo;
	private static Tag contrasena;
	
	public static void EscribirXML(ArrayList<Cliente>  listaClientes, String ruta){
		raiz = new Tag("Libreria");
		raiz.addAtributo(new Atributo("Cantidad-Clientes", Integer.toString(listaClientes.size())));
		for (Cliente cliente : listaClientes) {
			libro = new Tag("Cliente");
			id = new Tag("id");
			nombre = new Tag("nombre");
			saldo = new Tag("saldo");
			contrasena = new Tag("contrasena");
			id.addContenido(Integer.toString(cliente.getId()));
			nombre.addContenido(cliente.getNombre());
			saldo.addContenido(Double.toString(cliente.getCredito()));
			contrasena.addContenido(cliente.getPassWord());
			raiz.addTagHijo(libro);
			libro.addTagHijo(id);
			libro.addTagHijo(nombre);
			libro.addTagHijo(saldo);
			libro.addTagHijo(contrasena);
			JespXML xml = new JespXML(ruta, Encoding.UTF_8);
			try {
				xml.escribirXML(raiz);
			} catch (ParserConfigurationException ex) {
				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
			} catch (TransformerConfigurationException ex) {
				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
			} catch (TransformerException ex) {
				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	@SuppressWarnings("deprecation")
	public static ArrayList<Cliente> leerXML(String ruta){
		JespXML xml = new JespXML(ruta);
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			Tag raiz = xml.leerXML();
		
			for(Tag cliente : raiz.getTagsHijos()){
				
				Tag nombre = cliente.getTagHijoByName("nombre");
				Tag descripcion = cliente.getTagHijoByName("saldo");
				Tag valor = cliente.getTagHijoByName("contrasena");
				
				Cliente c = new Cliente(nombre.getContenido(),
						Double.parseDouble(descripcion.getContenido()),valor.getContenido()); 
				lista.add(c);
			}
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		} catch (TagHijoNotFoundException ex) {
			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lista;
	}
}

