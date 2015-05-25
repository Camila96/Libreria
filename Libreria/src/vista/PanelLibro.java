package vista;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.entidades.Libro;
/**
 * 
 * @author johnn
 *
 */
public class PanelLibro extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public PanelLibro(Libro libro) {
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(150, 150));
		GridBagConstraints gb = new GridBagConstraints();
		
		PanelImagen panelImg = new PanelImagen(libro.getImage());
		panelImg.setPreferredSize(new Dimension(100, 100));
		gb.gridx = 0;
		gb.gridy = 0;
		add(panelImg , gb);
		
		gb.anchor = GridBagConstraints.CENTER;
		
		JLabel lblNombre = new JLabel("Nombre: " + libro.getNombre());
		JLabel lblGenero = new JLabel("Genero: " + libro.getGenero());
		JLabel lblclasificacion = new JLabel("Autor: " + libro.getAutor());
		gb.gridy = 1;
		add(lblNombre , gb);
		gb.gridy = 2;
		add(lblGenero , gb);
		gb.gridy = 3;
		add(lblclasificacion , gb);
	}
	
	
}
