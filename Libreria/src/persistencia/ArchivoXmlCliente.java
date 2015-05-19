package persistencia;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modelo.entidades.Cliente;


public class ArchivoXmlCliente {

	public static final String RUTA_GUARDAR_XML = "src/archivos/";
	public static final String C_NOMBRE = "Nombre";
	public static final String C_ID = "id";
	public static final String C_CREDITO = "Valor";
	public static final String C_IMAGEN = "Imagen";

	public static void guardarXml(Cliente cliente){

		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document archivo = documentBuilder.newDocument();

			Element cuerpo = archivo.createElement("Clientes");
			archivo.appendChild(cuerpo);

			Element elementos = archivo.createElement("Elementos");
			cuerpo.appendChild(elementos);

			Attr atributos = archivo.createAttribute(C_ID);
			atributos.setValue(Integer.toString(cliente.getId()));
			cuerpo.setAttributeNode(atributos);

			Element nombre = archivo.createElement(C_NOMBRE);
			nombre.appendChild(archivo.createTextNode(cliente.getNombre()));				
			cuerpo.appendChild(nombre);

			Element valor = archivo.createElement(C_CREDITO);
			valor.appendChild(archivo.createTextNode(Double.toString(cliente.getCredito())));
			cuerpo.appendChild(valor);

//			Element imagen = archivo.createElement(C_IMAGEN);
//			imagen.appendChild(archivo.createTextNode(cliente.getImagen()));
//			cuerpo.appendChild(imagen);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(archivo);
			StreamResult resultado = new StreamResult(new File(RUTA_GUARDAR_XML + cliente.getId() + "-" + cliente.getNombre() + ".xml"));

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

	public static Cliente cargarArchivoXml(File archivo){
		Cliente cliente = null;
		try {
		
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document documento;
			try {
				documento = docBuilder.parse(archivo);
				documento.getDocumentElement().normalize();

				Element doc = documento.getDocumentElement();
				NodeList lista = doc.getChildNodes();
				
				System.out.println(lista.item(0).getTextContent());
				cliente = new Cliente(lista.item(0).getTextContent(), Double.parseDouble(lista.item(1).getTextContent()));
				cliente.setId(Integer.parseInt(doc.getAttribute(C_ID)));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return cliente;
	}
}
	


