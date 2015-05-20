package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

import vista.DialogoCliente;
import vista.VentanaPrincipal;
import modelo.entidades.Cliente;
import controlador.Controlador;

public class ArchivoPlanoCliente {
	private static FileReader lectorArchivo;
	private static BufferedWriter escribir;
	private static BufferedReader leer;
	public static final String RUTA = "src/archivos/";


	public static void guardarArchivo(Cliente cliente){
		File archivoCliente = new File(RUTA + cliente.getNombre() + ".txt");
		try {
			escribir = new BufferedWriter(new FileWriter(archivoCliente, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			escribir.write(cliente.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			escribir.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Cliente abrirArchivo(){
		File nuevoArchivo = null;
		FileReader fileReader = null;
		JFileChooser jf = new JFileChooser(RUTA);
		Cliente cliente = null;
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
//			System.out.println(items[1]);
			cliente = new Cliente(items[0], Double.parseDouble(items[2]));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			leer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cliente;
	}
}
