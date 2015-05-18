package persistencia;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import modelo.entidades.Libro;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class ArchivoXmlLibro {

	public static final String RUTA_GUARDAR_XML = "src/data/j.xml";
	public static final String C_ID = "id";
	public static final String C_NOMBRE = "Nombre";
	public static final String C_DESCRIPCION = "Descripcion"; 
	public static final String C_VALOR = "Valor";
	public static final String C_GENERO = "Genero";
	public static final String C_AUTOR = "Autor";
	public static final String C_COPIAS = "Copias Vendidas";
	public static final String C_IMAGEN = "Imagen";


	public static void guardarArchivo(Libro libro){
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document archivo = documentBuilder.newDocument();

			Element cuerpo = archivo.createElement("Libro");
			archivo.appendChild(cuerpo);		

			Attr atributos = archivo.createAttribute(C_ID);
			atributos.setValue(Integer.toString(libro.getId()));
			cuerpo.setAttributeNode(atributos);

			Element nombre = archivo.createElement(C_NOMBRE);
			nombre.appendChild(archivo.createTextNode(libro.getNombre()));				
			cuerpo.appendChild(nombre);

			Element descripcion = archivo.createElement(C_DESCRIPCION);
			descripcion.appendChild(archivo.createTextNode(libro.getDescripcion()));
			cuerpo.appendChild(descripcion);

			Element valor = archivo.createElement(C_VALOR);
			valor.appendChild(archivo.createTextNode(Double.toString(libro.getValor())));
			cuerpo.appendChild(valor);

			Element genero = archivo.createElement(C_GENERO);
			genero.appendChild(archivo.createTextNode(libro.getGenero()));
			cuerpo.appendChild(genero);

			Element autor = archivo.createElement(C_AUTOR);
			autor.appendChild(archivo.createTextNode(libro.getAutor()));
			cuerpo.appendChild(autor);

			Element copias = archivo.createElement(C_COPIAS);
			copias.appendChild(archivo.createTextNode(Double.toString(libro.getCopiasVendidas())));
			cuerpo.appendChild(copias);

			Element imagen = archivo.createElement(C_IMAGEN);
			imagen.appendChild(archivo.createTextNode(libro.getImage()));
			cuerpo.appendChild(imagen);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(archivo);
			StreamResult resultado = new StreamResult(new File(RUTA_GUARDAR_XML));

			try {
				transformer.transform(domSource, resultado);
			} catch (TransformerException e) {
				e.printStackTrace();       
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static Libro abrirArchivo(){
		File nuevoArchivo = null;
		JFileChooser jf = new JFileChooser(RUTA_GUARDAR_XML);
		int option = jf.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			nuevoArchivo = jf.getSelectedFile();
		}
		Libro libro = null;
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document documento;
			try {
				documento = docBuilder.parse(nuevoArchivo);
				documento.getDocumentElement().normalize();

				Element doc = documento.getDocumentElement();
				NodeList lista = doc.getChildNodes();

				libro = new Libro(lista.item(0).getTextContent(), lista.item(1).getTextContent(),
						Double.parseDouble(lista.item(2).getTextContent()),lista.item(3).getTextContent()
						,lista.item(4).getTextContent(),Double.parseDouble(lista.item(5).getTextContent()),
						lista.item(6).getTextContent());
				libro.setId(Integer.parseInt(doc.getAttribute(C_ID)));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return libro;
	}
}
