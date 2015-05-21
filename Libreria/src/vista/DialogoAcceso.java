package vista;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DialogoAcceso extends JFrame{

	public static void login(){

		JFrame f = new JFrame();
		GridBagConstraints cons = new GridBagConstraints();
		JPanel info = new JPanel(new GridLayout(4,7,5,5));
		JLabel lbNombre= new JLabel("Usuario");
		info.add(lbNombre);
		JTextField userName = new JTextField(10);
		info.add(userName);
		JLabel lbContraseña= new JLabel("Contraseña");
		info.add(lbContraseña);
		JPasswordField password = new JPasswordField(10);
		info.add(password);
		JButton lnButton = new JButton("ENTRAR");
		info.add(lnButton);
		f.setLayout(new FlowLayout());
		f.setResizable(false);
		f.add(info);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);

	}
	public static class Main {
		public static void main(String[]args){
		   DialogoAcceso.login();
		}
		}
}

