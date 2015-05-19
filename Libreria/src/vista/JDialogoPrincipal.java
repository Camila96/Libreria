package vista;

import java.awt.Color;

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
	
	
	public JDialogoPrincipal(Controlador controlador) {
		UIManager.put("Button.background", Color.lightGray);
		setLayout(null);
		setSize(ConstantesGUI.DIALOGO_ANCHO, ConstantesGUI.DIALOGO_ALTO);
		setLocationRelativeTo(null);
		setBackground(Color.CYAN);
		
		btnAdministrador = new JButton(ConstantesGUI.T_ITEM_AGREGAR_ADMINISTRADOR);
		btnAdministrador.addActionListener(controlador);
		btnAdministrador.setActionCommand(Controlador.A_AGREGAR_ADMINISTRADOR);
		btnAdministrador.setBounds(310,380, 150, 30);
		
		btnUsuario = new JButton(ConstantesGUI.T_ITEM_AGREGAR_USUARIO);
		btnUsuario.addActionListener(controlador);
		btnUsuario.setActionCommand(Controlador.A_MOSTRAR_USUARIO);
		btnUsuario.setBounds(100,380, 150, 30);
		
		add(btnAdministrador);
		add(btnUsuario);
		
	}
	
}
