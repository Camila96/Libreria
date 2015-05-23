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
import modelo.entidades.EnumGeneroLibro;
import modelo.entidades.Libro;

import org.jespxml.JespXML;
import org.jespxml.excepciones.AtributoNotFoundException;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Atributo;
import org.jespxml.modelo.Comentario;
import org.jespxml.modelo.Encoding;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;


public class XmlLibro{

	private Tag raiz;
	private Tag libro;
	private Tag id;
	private Tag nombre;
	private Tag descripcion;
	private Tag valor;
	private Tag genero;
	private Tag autor;
	private Tag copias;
	private Tag pathImagen;

	public void EscribirXML(ArrayList<Libro>  listaLibro, String ruta){
		raiz = new Tag("Libros");
		raiz.addAtributo(new Atributo("Cantidad-Libro", Integer.toString(listaLibro.size())));
		raiz.addComentario(new Comentario("coemntario :v"));
		for (Libro libros : listaLibro) {
			libro = new Tag("libro");
			id = new Tag("id");
			nombre = new Tag("nombre");
			descripcion = new Tag("descripcion");
			valor = new Tag("valor");
			genero = new Tag("genero");
			autor = new Tag("autor");
			copias = new Tag("copias");
			pathImagen = new Tag("rutaImagen");
			id.addContenido(Integer.toString(libros.getId()));
			nombre.addContenido(libros.getNombre());
			descripcion.addContenido(libros.getDescripcion());
			valor.addContenido(Double.toString(libros.getValor()));
			genero.addContenido(libros.getGenero());
			autor.addContenido(libros.getAutor());
			copias.addContenido(Double.toString(libros.getCopiasVendidas()));
			pathImagen.addContenido(libros.getImage());
			raiz.addTagHijo(libro);
			libro.addTagHijo(id);
			libro.addTagHijo(nombre);
			libro.addTagHijo(descripcion);
			libro.addTagHijo(valor);
			libro.addTagHijo(genero);
			libro.addTagHijo(autor);
			libro.addTagHijo(copias);
			libro.addTagHijo(pathImagen);

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
	public ArrayList<Libro> leerXML(String ruta){
		JespXML xml = new JespXML(ruta);
		ArrayList<Libro> lista = new ArrayList<>();
		try {
			Tag raiz = xml.leerXML();
		
			for(Tag libro : raiz.getTagsHijos()){
				
				Tag id = libro.getTagHijoByName("id");
				Tag nombre = libro.getTagHijoByName("nombre");
				Tag descripcion = libro.getTagHijoByName("descripcion");
				Tag valor = libro.getTagHijoByName("valor");
				Tag genero = libro.getTagHijoByName("genero");
				Tag autor = libro.getTagHijoByName("autor");
				Tag copias = libro.getTagHijoByName("copias");
				Tag pathImagenTag = libro.getTagHijoByName("rutaImagen");
				
				System.out.println("id: "+id.getContenido());
				System.out.println("nombre: "+nombre.getContenido());
				System.out.println("descripcion: "+ descripcion.getContenido());
				System.out.println("valor: "+valor.getContenido());
				System.out.println("genero: "+valor.getContenido());
				System.out.println("autor: "+valor.getContenido());
				System.out.println("copias: "+valor.getContenido());
				System.out.println("Imagen peep: "+ pathImagenTag.getContenido());
				System.out.println("------------------------------------ ");
				lista.add(new  Libro(nombre.getContenido(),descripcion.getContenido(),
						Double.parseDouble(valor.getContenido()),genero.getContenido(),
						autor.getContenido(),Double.parseDouble(copias.getContenido())
						,pathImagenTag.getContenido()));
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
	public static void main(String[] args) {
		ArrayList<Libro>lista = new ArrayList<Libro>();
		XmlLibro xml = new XmlLibro();
		Autor autor = new Autor("jose", "SRC/SDASD/SDAS.SA");
		Libro libro = new Libro("hola", "sfds", 21312, EnumGeneroLibro.ACCION.toString(),autor.getNombre(), 6, "/sdads");
		Libro libro2 = new Libro("pendejo", "sfddsadas", 2132212, EnumGeneroLibro.ROMANCE.toString(),autor.getNombre(), 26, "/sdads");
		lista.add(libro);
		lista.add(libro2);
		xml.leerXML("src/data/lol.xml");
		
		}
}

