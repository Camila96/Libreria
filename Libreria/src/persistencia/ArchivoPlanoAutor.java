//package persistencia;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
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
//public class ArchivoPlanoAutor {
//	
//	private static FileReader leerArchivo;
//	private static BufferedWriter escribir;
//	private static BufferedReader leer;
//	public static final String RUTA = "src/data/";
//
//	public static void guardarArchivo(Autor autor){
//		File archivoLibro = new File(RUTA+ autor.getNombre() + ".txt");
//		try {
//			escribir = new BufferedWriter(new FileWriter(archivoLibro, true));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			escribir.write(autor.toString());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			escribir.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static Autor abrirArchivo(){
//		File nuevoArchivo = null;
//		FileReader fileReader = null;
//		JFileChooser jf = new JFileChooser(RUTA);
//		Autor autor = null;
//		int option = jf.showOpenDialog(null);
//		if (option == JFileChooser.APPROVE_OPTION) {
//			nuevoArchivo = jf.getSelectedFile();
//		}
//		try {
//			fileReader = new FileReader(nuevoArchivo);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		leer = new BufferedReader(fileReader);
//		try {
//			String[] items =  leer.readLine().split(",");
//			autor = new Autor(items[0], items[1]);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//
//		try {
//			leer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return autor;
//	}
//}
