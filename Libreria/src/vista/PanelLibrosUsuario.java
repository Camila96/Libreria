package vista;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import modelo.entidades.Libro;
/**
 * 
 * @author johnn
 *
 */
public class PanelLibrosUsuario extends JPanel{

	private static final long serialVersionUID = 1L;
	private VentanaUsuario ventanaUsuario;
	
	public PanelLibrosUsuario(VentanaUsuario ventanaUsuario) {
		this.ventanaUsuario = ventanaUsuario;
		setLayout(new GridLayout(3,6 ));
		init();
	}
	
	public void init(){
		cargarDatosLibros();
	}
	
	public void cargarDatosLibros(){
		ArrayList<Libro> lista = ventanaUsuario.getListaLibros();
		this.removeAll();
		for (Libro libro : lista) {
			add(new PanelLibro(libro));
		}
	}
	
}
