package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import modelo.entidades.Autor;

import org.jespxml.JespXML;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Atributo;
import org.jespxml.modelo.Comentario;
import org.jespxml.modelo.Encoding;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;

public class XmlAutor {

	private static Tag raiz;
	private static Tag autorE;
	private static Tag id;
	private static Tag nombre;
	private static Tag imagen;

	public static void EscribirXML(ArrayList<Autor>  listaAutor, String ruta){
		raiz = new Tag("Autor");
		raiz.addAtributo(new Atributo("Cantidad-Autor", Integer.toString(listaAutor.size())));
		raiz.addComentario(new Comentario("comentario :v"));
		for (Autor autor : listaAutor) {
			autorE = new Tag("autor");
			id = new Tag("id");
			nombre = new Tag("nombre");
			imagen = new Tag("imagen");
			id.addContenido(Integer.toString(autor.getId()));
			nombre.addContenido(autor.getNombre());
			imagen.addContenido(autor.getImage());
			raiz.addTagHijo(autorE);
			autorE.addTagHijo(id);
			autorE.addTagHijo(nombre);
			autorE.addTagHijo(imagen);

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
	public static ArrayList<Autor> leerXML(String ruta){
		JespXML xml = new JespXML(ruta);
		ArrayList<Autor> lista = new ArrayList<>();
		try {
			Tag raiz = xml.leerXML();

			for(Tag libro : raiz.getTagsHijos()){

				Tag id = libro.getTagHijoByName("id");
				Tag nombre = libro.getTagHijoByName("nombre");
				Tag imagen = libro.getTagHijoByName("imagen");

				Autor aut = new Autor(nombre.getContenido(),imagen.getContenido());
				aut.setId(Integer.parseInt(id.getContenido()));

				lista.add(aut);
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
