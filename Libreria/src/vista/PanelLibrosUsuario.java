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
	
	public PanelLibrosUsuario(ArrayList<Libro> lista) {
		setLayout(new GridLayout(3,6 ));
		init(lista);
	}
	
	public void init(ArrayList<Libro> lista){
		this.removeAll();
		for (Libro libro : lista) {
			add(new PanelLibro(libro));
		}
	}
	
}
