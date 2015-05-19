package vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.UIManager;

import controlador.Controlador;

public class JDialogoPrincipal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAdministrador;
	private JButton btnUsuario;
	private JLabel lbImagen;
	
	
	public JDialogoPrincipal(Controlador controlador) {
		UIManager.put("Button.background", Color.GRAY);
		setLayout(null);
		setSize(ConstantesGUI.DIALOGO_ANCHO, ConstantesGUI.DIALOGO_ALTO);
		setLocationRelativeTo(null);
		setBackground(Color.CYAN);
		
		lbImagen = new JLabel(createImageIcon("/img/f.jpg"));
		lbImagen.setBounds(0,0,500,480);
		
		btnAdministrador = new JButton(ConstantesGUI.T_ITEM_AGREGAR_ADMINISTRADOR,createImageIcon("/img/admi.png"));
		btnAdministrador.addActionListener(controlador);
		btnAdministrador.setActionCommand(Controlador.A_AGREGAR_ADMINISTRADOR);
		btnAdministrador.setBounds(250,380, 210, 50);
		
		btnUsuario = new JButton(ConstantesGUI.T_ITEM_AGREGAR_USUARIO,createImageIcon("/img/user.png"));
		btnUsuario.addActionListener(controlador);
		btnUsuario.setActionCommand(Controlador.A_MOSTRAR_USUARIO);
		btnUsuario.setBounds(50,380, 170, 50);
		
		add(btnAdministrador);
		add(btnUsuario);
		add(lbImagen);
		
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
}
