package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelos.util.Util;

public class DialogoAcceso extends JFrame{
	

	public static void login(){

		JFrame f = new JFrame("Iniciar sesion");
		f.setIconImage(Util.createImageIcon(ConstantesGUI.I_ICONO_VENTANA).getImage());
		GridBagConstraints cons = new GridBagConstraints();
		JPanel info = new JPanel(new GridLayout(4,7,5,5));
		JLabel lbNombre= new JLabel("Usuario");
		info.add(lbNombre);
		JTextField userName = new JTextField(10);
		info.add(userName);
		JLabel lbContrasena= new JLabel("Contrase�a");
		info.add(lbContrasena);
		JPasswordField password = new JPasswordField(10);
		info.add(password);
		JButton lnButton = new JButton("ENTRAR");
		info.add(lnButton);
		JButton btnCancelar = new JButton("Cancelar");
		info.add(btnCancelar);
		f.setLayout(new FlowLayout());
		f.setResizable(false);
		f.add(info);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		

	}
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
	public static class Main {
		public static void main(String[]args){
			DialogoAcceso.login();
		}
	}
}

