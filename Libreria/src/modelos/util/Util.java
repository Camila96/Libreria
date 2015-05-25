package modelos.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class Util {

	public static boolean validarValor(String numero){
		try {
			Double.parseDouble(numero);	
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean validarCopias(String numero){
		try {
			Double.parseDouble(numero);	
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static String[] libroAVector(Libro libro){
		return new String[]{Integer.toString(libro.getId()),libro.getNombre(),
				libro.getDescripcion(),Double.toString(libro.getValor()),libro.getGenero(),
				libro.getAutor(),Double.toString(libro.getCopiasVendidas()),libro.getImage()};
	}

	public static String[] clienteAVector(Cliente cliente){
		return new String[]{Integer.toString(cliente.getId()),cliente.getNombre(),
				Double.toString(cliente.getCredito())};
	}
	
	public static String[] autorAVector(Autor autor){
		return new String[]{Integer.toString(autor.getId()),autor.getNombre()};
	}
	
	public static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Util.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
	
	public static void guardarImagen(String name , String direccionEntrada){
		Path RutaImagenEntrada = Paths.get(direccionEntrada);
		Path RutaImagenNueva = Paths.get("src/img/imgLibros/"+name+".jpg");
		try {
			Files.copy(RutaImagenEntrada, RutaImagenNueva);
		} catch (IOException e) {
			System.out.println("error al guardar la imagen");
		}
	}
}
