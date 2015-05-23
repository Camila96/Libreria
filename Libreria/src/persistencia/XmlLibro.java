//package persistencia;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerException;
//import modelo.entidades.Libro;
//import org.jespxml.JespXML;
//import org.jespxml.excepciones.AtributoNotFoundException;
//import org.jespxml.excepciones.TagHijoNotFoundException;
//import org.jespxml.modelo.Atributo;
//import org.jespxml.modelo.Comentario;
//import org.jespxml.modelo.Encoding;
//import org.jespxml.modelo.Tag;
//import org.xml.sax.SAXException;
//
//
//public class XmlLibro{
//	
//	private Tag raiz;
//	private Tag libro;
//	private Tag id;
//	private Tag nombre;
//	private Tag descripcion;
//	private Tag valor;
//	private Tag genero;
//	private Tag autor;
//	private Tag copias;
//	private Tag pathImagen;
//
//	public void EscribirXML(ArrayList<Libro>  listaLibro, String ruta){
//		raiz = new Tag("Libro");
//		raiz.addAtributo(new Atributo("Cantidad-Libro", Integer.toString(listaLibro.size())));
//		raiz.addComentario(new Comentario("coemntario :v"));
//		for (Libro libro : listaLibro) {
//			libro = new Tag("libro");
//			id = new Tag("id");
//			nombre = new Tag("nombre");
//			descripcion = new Tag("descripcion");
//			valor = new Tag("valor");
//			genero = new Tag("genero");
//			autor = new Tag("autor");
//			copias = new Tag("copias");
//			pathImagen = new Tag("rutaImagen");
//			id.addContenido(Integer.toString(libro.getId()));
//			nombre.addContenido(libro.getNombre());
//			descripcion.addContenido(libro.getDescripcion());
//			valor.addContenido(Double.toString(libro.getValor()));
//			genero.addContenido(libro.getGenero());
//			autor.addContenido(libro.getAutor());
//			copias.addContenido(Double.toString(libro.getCopiasVendidas()));
//			pathImagen.addContenido(libro.getImage());
//			libro.addTagHijo(libro);
//			libro.addTagHijo(id);
//			libro.addTagHijo(nombre);
//			libro.addTagHijo(descripcion);
//			libro.addTagHijo(valor);
//			libro.addTagHijo(genero);
//			libro.addTagHijo(autor);
//			libro.addTagHijo(copias);
//			libro.addTagHijo(pathImagen);
//
//			JespXML xml = new JespXML(ruta, Encoding.UTF_8);
//			try {
//				xml.escribirXML(raiz);
//			} catch (ParserConfigurationException ex) {
//				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
//			} catch (TransformerConfigurationException ex) {
//				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
//			} catch (FileNotFoundException ex) {
//				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
//			} catch (TransformerException ex) {
//				Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
//			}
//		}
//	}
//	@SuppressWarnings("deprecation")
//	public ArrayList<Libro> leerXML(String ruta){
//		JespXML xml = new JespXML(ruta);
//		ArrayList<Libro> lista = new ArrayList<>();
//		try {
//			Tag raiz = xml.leerXML();
//			System.out.println(raiz.getNombre());
//
//			for(Tag libro : raiz.getTagsHijos()){
//				System.out.println(libro);
//				Tag id = libro.getTagHijoByName("id");
//				Tag nombre = libro.getTagHijoByName("nombre");
//				Tag descripcion = libro.getTagHijoByName("descripcion");
//				Tag valor = libro.getTagHijoByName("valor");
//				Tag genero = libro.getTagHijoByName("genero");
//				Tag autor = libro.getTagHijoByName("autor");
//				Tag copias = libro.getTagHijoByName("copias");
//				Tag pathImagenTag = libro.getTagHijoByName("rutaImagen");
//				for(Atributo atr : libro.getAtributos()){
//					
//					System.out.println(atr);
//				}
//
//				System.out.println("id: "+id.getContenido());
//				System.out.println("nombre: "+nombre.getContenido());
//				System.out.println("descripcion: "+ descripcion.getContenido());
//				System.out.println("valor: "+valor.getContenido());
//				System.out.println("genero: "+valor.getContenido());
//				System.out.println("autor: "+valor.getContenido());
//				System.out.println("copias: "+valor.getContenido());
//				System.out.println("Imagen peep: "+ pathImagenTag.getContenido());
//				System.out.println("------------------------------------ ");
//				lista.add(new  Libro(nombre.getContenido(),descripcion.getContenido(),
//						Double.parseDouble(valor.getContenido()),genero.getContenido(),
//						autor.getContenido(),Double.parseDouble(copias.getContenido())
//						,pathImagenTag.getContenido()));
//			}
//		} catch (ParserConfigurationException ex) {
//			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (SAXException ex) {
//			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (IOException ex) {
//			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (TagHijoNotFoundException ex) {
//			Logger.getLogger(XmlLibro.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return lista;
//	}
//}
//
