package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import modelo.entidades.Libro;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class ArchivoJsonLibro {

	public static final String C_NOMBRE = "Nombre";
	public static final String C_ID = "id";
	public static final String C_DESCRIPCION = "Descripcion"; 
	public static final String C_VALOR = "Valor";
	public static final String C_GENERO = "Genero";
	public static final String C_AUTOR = "Autor";
	public static final String C_COPIAS_VENDIDAS = "Copias Vendidas";
	public static final String C_IMAGEN = "Imagen";
	public static final String RUTA_ARCHIVO = "src/data/jsonfile.json";

	public static void guardarArchivoJson(Libro libro){

		JSONObject objeto = new JSONObject();
		JSONArray arrayVisitas = new JSONArray();
		JSONArray array = new JSONArray();
		objeto.put(C_ID, libro.getId());
		objeto.put(C_NOMBRE, libro.getNombre());
		objeto.put(C_DESCRIPCION, libro.getDescripcion());
		objeto.put(C_VALOR, libro.getValor());
		objeto.put(C_GENERO, libro.getGenero());
		objeto.put(C_AUTOR, libro.getAutor());
		objeto.put(C_COPIAS_VENDIDAS, libro.getCopiasVendidas());
		objeto.put(C_IMAGEN, libro.getImage());

		try {
			FileWriter archivo = new FileWriter(RUTA_ARCHIVO);
			archivo.write(objeto.toJSONString());
			archivo.flush();
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(objeto);
	}

	public static Libro abrirArchivo(){
		File nuevoArchivo = null;
		JFileChooser jf = new JFileChooser(RUTA_ARCHIVO);
		int option = jf.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			nuevoArchivo = jf.getSelectedFile();
		}
		Libro libro = null;
		JSONParser parser = new JSONParser();

		try {
			Object objeto = parser.parse(new FileReader(RUTA_ARCHIVO));;
			JSONObject jsonObjeto = (JSONObject) objeto;
			libro = new Libro((String)jsonObjeto.get(C_NOMBRE), (String)jsonObjeto.get(C_DESCRIPCION),
					(double)jsonObjeto.get(C_VALOR),(String)jsonObjeto.get(C_GENERO),
					(String)jsonObjeto.get(C_AUTOR),(int)jsonObjeto.get(C_COPIAS_VENDIDAS),
					(String)jsonObjeto.get(C_IMAGEN)); 

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return libro;
	}
}
