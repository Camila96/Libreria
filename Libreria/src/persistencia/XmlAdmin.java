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
import org.jespxml.modelo.Comentario;
import org.jespxml.modelo.Encoding;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;


public class XmlAdmin{

	private static Tag raiz;
	private static Tag libro;
	private static Tag id;
	private static Tag nombre;
	private static Tag saldo;
	private static Tag contrasena;
	
	public static void EscribirXML(String admin,String pass, String ruta){
		raiz = new Tag("Admin");
		raiz.addAtributo(new Atributo("Cantidad-Admins"));
		raiz.addComentario(new Comentario("login access :v"));
		libro = new Tag("Admin");
		nombre = new Tag("nombre");
		contrasena = new Tag("contrasena");
		nombre.addContenido(admin);
		contrasena.addContenido(pass);
		raiz.addTagHijo(libro);
		libro.addTagHijo(nombre);
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

	@SuppressWarnings("deprecation")
	public static ArrayList<String> leerXML(String ruta){
		JespXML xml = new JespXML(ruta);
		ArrayList<String> listaArrayList = new ArrayList<String>();
		try {
			Tag raiz = xml.leerXML();	
			for(Tag cliente : raiz.getTagsHijos()){
				Tag nombre = cliente.getTagHijoByName("nombre");
				Tag valor = cliente.getTagHijoByName("contrasena");
				listaArrayList.add(0, nombre.getContenido());
				listaArrayList.add(1, valor.getContenido());
				
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
		return listaArrayList;
	}
	public static void main(String[] args) {
		String adminString = "admin1";
		String passString = "admin1";
		EscribirXML(adminString, passString,"src/data/admin.xml");
		leerXML("src/data/admin.xml").get(0);
	}
}