package vista;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.UIManager;

import modelos.util.Util;
import controlador.Controlador;

public class JDialogoPrincipal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAdministrador;
	private JButton btnUsuario;
	
	public JDialogoPrincipal(Controlador controlador) {
		setTitle(ConstantesGUI.T_TITULO_VENTANA);	
		setIconImage(createImageIcon(ConstantesGUI.I_ICONO_VENTANA).getImage());
		UIManager.put("Button.background", Color.GRAY);
		setSize(ConstantesGUI.DIALOGO_ANCHO, ConstantesGUI.DIALOGO_ALTO);
		setLocationRelativeTo(null);
		setBackground(Color.CYAN);
		addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent e){ System.exit(0); } });
		PanelImagen panelImg = new PanelImagen("/img/f.jpg");
		
		btnAdministrador = new JButton(ConstantesGUI.T_ITEM_AGREGAR_ADMINISTRADOR,Util.createImageIcon("/img/admi.png"));
		btnAdministrador.addActionListener(controlador);
		btnAdministrador.setActionCommand(Controlador.A_AGREGAR_ADMINISTRADOR);
		btnAdministrador.setBounds(250,380, 210, 50);
		
		btnUsuario = new JButton(ConstantesGUI.T_ITEM_AGREGAR_USUARIO,Util.createImageIcon("/img/user.png"));
		btnUsuario.addActionListener(controlador);
		btnUsuario.setActionCommand(Controlador.A_MOSTRAR_USUARIO);
		btnUsuario.setBounds(50,380, 170, 50);
		
		add(btnAdministrador);
		add(btnUsuario);
		add(panelImg);
		
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
