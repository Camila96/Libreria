package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelOpcionesUsuario extends JPanel{

	private static final long serialVersionUID = 1L;
	public JButton comprar;
	public PanelOpcionesUsuario(Controlador controlador) {
		
		setPreferredSize(new Dimension(200 , 0));
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.anchor = GridBagConstraints.WEST;
		gb.gridx = 0;
		gb.gridy = 0;
		
		JButton btn =new JButton("Inicio");
		btn.addActionListener(controlador);
		btn.setActionCommand(Controlador.A_ATRAS);
		panel.add(btn , gb);
		gb.gridy = 1;
		JButton btnOpcionColeccion = new JButton("Mi coleccion");
		btnOpcionColeccion.setActionCommand(Controlador.A_MOSTRAR_COLECCION);
		btnOpcionColeccion.addActionListener(controlador);
		panel.add(btnOpcionColeccion , gb);
		
		gb.gridy = 2;
		JButton librosAComprar = new JButton("Libros seleccionados");
		librosAComprar.setActionCommand(Controlador.A_MOSTRAR_LIBROS_A_COMPRAR);
		librosAComprar.addActionListener(controlador);
		panel.add(librosAComprar , gb);
		
		gb.gridy = 3;
		comprar = new JButton("Comprar");
		comprar.setActionCommand(Controlador.A_COMPRAR);
		comprar.addActionListener(controlador);
		comprar.setEnabled(false);
		panel.add(comprar , gb);
			
		add(panel , BorderLayout.PAGE_START);
	}
	
	
}
