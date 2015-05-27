//package persistencia;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//import javax.swing.JFileChooser;
//
//import modelo.entidades.Autor;
//import modelo.entidades.Libro;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//public class ArchivoJsonAutor {
//
//	public static final String C_NOMBRE = "Nombre";
//	public static final String C_ID = "id";
//	public static final String C_IMAGEN = "Imagen";
//	public static final String RUTA_ARCHIVO = "src/data/Autor.json";
//
//	public static void guardarArchivoJson(Autor autor){
//
//		JSONObject objeto = new JSONObject();
//		JSONArray arrayVisitas = new JSONArray();
//		JSONArray array = new JSONArray();
//		objeto.put(C_ID, autor.getId());
//		objeto.put(C_NOMBRE, autor.getNombre());
//		objeto.put(C_IMAGEN, autor.getImage());
//
//		try {
//			FileWriter archivo = new FileWriter(RUTA_ARCHIVO);
//			archivo.write(objeto.toJSONString());
//			archivo.flush();
//			archivo.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(objeto);
//	}
//
//	public static Autor abrirArchivo(){
//		File nuevoArchivo = null;
//		JFileChooser jf = new JFileChooser(RUTA_ARCHIVO);
//		int option = jf.showOpenDialog(null);
//		if (option == JFileChooser.APPROVE_OPTION) {
//			nuevoArchivo = jf.getSelectedFile();
//		}
//		Autor autor = null;
//		JSONParser parser = new JSONParser();
//
//		try {
//			Object objeto = parser.parse(new FileReader(RUTA_ARCHIVO));;
//			JSONObject jsonObjeto = (JSONObject) objeto;
//			autor = new Autor((String)jsonObjeto.get(C_NOMBRE),(String)jsonObjeto.get(C_IMAGEN)); 
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return autor;
//	}
//}
