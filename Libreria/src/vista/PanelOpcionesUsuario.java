package vista;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelOpcionesUsuario extends JPanel{

	private static final long serialVersionUID = 1L;

	public PanelOpcionesUsuario(Controlador controlador) {
		
		setPreferredSize(new Dimension(200 , 0));
		setLayout(new GridBagLayout());
		
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.gridx = 0;
		gb.gridy = 0;
		JButton btnOpcionColeccion = new JButton("Mi coleccion");
		btnOpcionColeccion.setActionCommand(Controlador.A_MOSTRAR_COLECCION);
		btnOpcionColeccion.addActionListener(controlador);
		
		add(btnOpcionColeccion , gb);
		
		gb.gridy = 1;
		JButton librosAComprar = new JButton("Libros seleccionados");
		librosAComprar.setActionCommand(Controlador.A_MOSTRAR_LIBROS_A_COMPRAR);
		librosAComprar.addActionListener(controlador);
		add(librosAComprar , gb);
		
	}
	
	
}
