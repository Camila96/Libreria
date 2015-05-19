package persistencia;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import modelo.entidades.Cliente;

public class ArchivoJsonCliente {
	public static final String C_NOMBRE = "Nombre";
	public static final String C_ID = "Id";
	public static final String C_DESCRIPCION = "Descripcion";
	public static final String C_VALOR = "Valor";
	public static final String C_IMAGEN = "Imagen";
	public static final String RUTA_GUARDAR_JSON = "src/archivos/File.json";


	@SuppressWarnings("unchecked")
	public static void guardarArchivoJson(Cliente cliente){
		JSONObject objeto = new JSONObject();
		objeto.put(C_ID, cliente.getId());
		objeto.put(C_NOMBRE, cliente.getNombre());
		objeto.put(C_DESCRIPCION, cliente.getCredito());
		
		
		
		try {
			FileWriter archivo = new FileWriter(RUTA_GUARDAR_JSON);
			archivo.write(objeto.toJSONString());
			archivo.flush();
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static Cliente cargarArchivoJson(File file){
		Cliente cliente = null;
		JSONParser parser = new JSONParser();

		try {
			Object objeto = parser.parse(new FileReader(RUTA_GUARDAR_JSON));;
			JSONObject jsonObjeto = (JSONObject) objeto;
			cliente = new Cliente((String)jsonObjeto.get(C_NOMBRE), (double)jsonObjeto.get(C_VALOR)); 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}
}
