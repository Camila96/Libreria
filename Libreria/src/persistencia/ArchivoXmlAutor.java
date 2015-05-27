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

import modelo.entidades.Autor;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ArchivoXmlAutor {

	public static final String RUTA_GUARDAR_XML = "src/data/";
	public static final String C_NOMBRE = "Nombre";
	public static final String C_ID = "id";
	public static final String C_IMAGEN = "Imagen";

	public static void guardarArchivo(Autor autor){
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document archivo = documentBuilder.newDocument();
			
			Element cuerpo = archivo.createElement("Autor");//cuerpo
			archivo.appendChild(cuerpo);		

			Attr atributos = archivo.createAttribute(C_ID);
			atributos.setValue(Integer.toString(autor.getId()));
			cuerpo.setAttributeNode(atributos);

			Element nombre = archivo.createElement(C_NOMBRE);
			nombre.appendChild(archivo.createTextNode(autor.getNombre()));				
			cuerpo.appendChild(nombre);

			Element imagen = archivo.createElement(C_IMAGEN);
			imagen.appendChild(archivo.createTextNode(autor.getImage()));
			cuerpo.appendChild(imagen);
		

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(archivo);
			StreamResult resultado = new StreamResult(new File(RUTA_GUARDAR_XML + autor.getId() + "-" + autor.getNombre() + ".xml"));

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

	public static Autor abrirArchivo(){
		File nuevoArchivo = null;
		JFileChooser jf = new JFileChooser(RUTA_GUARDAR_XML);
		int option = jf.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			nuevoArchivo = jf.getSelectedFile();
		}
		Autor autor = null;
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document documento;
			try {
				documento = docBuilder.parse(nuevoArchivo);
				documento.getDocumentElement().normalize();

				Element doc = documento.getDocumentElement();
				NodeList lista = doc.getChildNodes();

				autor = new Autor(lista.item(0).getTextContent());
				autor.setId(Integer.parseInt(doc.getAttribute(C_ID)));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return autor;
	}
}
