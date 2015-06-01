package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelos.util.Util;
import controlador.Controlador;

public class DialogoLoginAdmin extends JDialog{

	private static final long serialVersionUID = 1L;

	private JTextField txtNombre;
	private JPasswordField txtContrasena;

	public DialogoLoginAdmin(JDialogoPrincipal d , Controlador controlador) {

		setTitle("Iniciar sesion");
		setSize(300, 200);
		setIconImage(Util.createImageIcon(ConstantesGUI.I_ICONO_VENTANA).getImage());
		setLocationRelativeTo(d);
		setLayout(new GridBagLayout());

		GridBagConstraints gb = new GridBagConstraints();

		JLabel lblNombre = new JLabel("Nombre: ");
		gb.gridx = 0;
		gb.gridy = 0;
		add(lblNombre , gb);

		txtNombre = new JTextField(10);
		gb.gridx = 1;
		add(txtNombre);

		JLabel lblContrasena = new JLabel("Contrasena: ");
		gb.gridy = 1;
		gb.gridx = 0;
		add(lblContrasena , gb);

		txtContrasena = new JPasswordField(10);
		gb.gridx = 1;
		add(txtContrasena , gb);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand(Controlador.A_CANCELAR_INCIO_SESION);
		btnCancelar.addActionListener(controlador);
		gb.gridx = 0;
		gb.gridy = 2;
		add(btnCancelar , gb);

		gb.gridx = 1;
		JButton btnIniciar = new JButton("Iniciar Sesion");
		btnIniciar.setActionCommand(Controlador.A_INICIAR_SESION_ADMIN);
		btnIniciar.addActionListener(controlador);
		add(btnIniciar , gb);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JPasswordField getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContrasena(JPasswordField txtContrasena) {
		this.txtContrasena = txtContrasena;
	}



}
