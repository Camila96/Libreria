package persistencia;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import vista.VentanaPrincipal;
import modelo.dao.*;
import modelo.entidades.*;


public class ArchivoBinarioCliente {

	public static final String RUTA_ARCHIVO = "src/data/F.cam";
	//sitio turitoco//guardar un sitio turistico
	private VentanaPrincipal ventanaPrincipal;

	public static void guardarArchivo(Cliente cliente){//guardar clase juego
		try {
			FileOutputStream salida = new FileOutputStream(RUTA_ARCHIVO);//crear escritura para trzbajr el earchivo
			ObjectOutputStream archivoSalida = new ObjectOutputStream(salida);
			archivoSalida.writeObject(cliente);//escribir el juego
			archivoSalida.close();//cerrar el archivo
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "error", "error al guardare le archivo", 0);
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, "error", "error al guardare le archivo", 0);
			e.printStackTrace();
		}
	}

	public static Cliente abrirArchivo(){
		
		File nuevoArchivo = null;
		JFileChooser jf = new JFileChooser(RUTA_ARCHIVO);
		int option = jf.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			nuevoArchivo = jf.getSelectedFile();
		}
		try {
			FileInputStream entrada = new FileInputStream(RUTA_ARCHIVO);//crear escritura para trzbajr el earchivo
			ObjectInputStream archivoEntrada = new ObjectInputStream(entrada);
			Cliente cliente = (Cliente)archivoEntrada.readObject();
			archivoEntrada.close();
			return cliente;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "error", "error al guardare le archivo", 0);
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, "error", "error al guardare le archivo", 0);

		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "error", "error al guardare le archivo", 0);
		}
		return null;
	}
}
