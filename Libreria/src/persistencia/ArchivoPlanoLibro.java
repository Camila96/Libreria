package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

import modelo.entidades.Libro;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class ArchivoPlanoLibro {

	private static FileReader leerArchivo;
	private static BufferedWriter escribir;
	private static BufferedReader leer;
	public static final String RUTA = "src/data/";

	public static void guardarArchivo(Libro libro){
		File archivoLibro = new File(RUTA  );
		try {
			escribir = new BufferedWriter(new FileWriter(archivoLibro, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			escribir.write(libro.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			escribir.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Libro abrirArchivo(){
		File nuevoArchivo = null;
		FileReader fileReader = null;
		JFileChooser jf = new JFileChooser(RUTA);
		Libro libro = null;
		int option = jf.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			nuevoArchivo = jf.getSelectedFile();
		}
		try {
			fileReader = new FileReader(nuevoArchivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		leer = new BufferedReader(fileReader);
		try {
			String[] items =  leer.readLine().split(",");
			libro = new Libro(items[0], items[1], Double.parseDouble(items[2]),
					items[3],items[4],Double.parseDouble(items[5]),items[6]);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			leer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return libro;
	}
}
