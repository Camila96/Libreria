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
import modelo.entidades.Libro;
import vista.VentanaPrincipal;

public class ArchivoBinarioLibro {

	public static final String RUTA_ARCHIVO="src/data/Libro.cpr";

	public static void guardarArchivo(Libro libro){
		try {
			FileOutputStream  salida = new FileOutputStream(RUTA_ARCHIVO);
			ObjectOutputStream archivoSalida = new ObjectOutputStream(salida);
			archivoSalida.writeObject(libro);
			archivoSalida.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "error", "error al guardare le archivo", 0);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "error", "error al guardare le archivo", 0);
			e.printStackTrace();
		}
	}

	public static Libro abrirArchivo(){
		
		File nuevoArchivo = null;
		JFileChooser jf = new JFileChooser(RUTA_ARCHIVO);
		int option = jf.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			nuevoArchivo = jf.getSelectedFile();
		}
		try {
			FileInputStream entrada = new FileInputStream(RUTA_ARCHIVO);
			ObjectInputStream archivoEntrada = new ObjectInputStream(entrada);
			Libro libro = (Libro)archivoEntrada.readObject();
			archivoEntrada.close();
			return libro;
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
