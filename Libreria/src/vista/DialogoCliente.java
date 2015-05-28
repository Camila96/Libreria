package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import persistencia.XmlLibro;
import modelo.dao.GestorCliente;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.EnumGeneroLibro;
import modelo.entidades.Libro;
import controlador.Controlador;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class DialogoCliente  extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbNombre;
	private JLabel lbId;
	private JLabel lbcredito;
	private JLabel lbImagen;
	ImageIcon image;
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtcredito;
	private JTextField txtImage;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JButton btnCargarImagen;
	private VentanaPrincipal ventanaPrincipal;
	private Controlador controlador;
	private JCheckBox check;
	
	public DialogoCliente(VentanaPrincipal ventanaPrincipal, Controlador controlador){
		super(ventanaPrincipal);
		setTitle("Agregar Cliente");	
		this.controlador = controlador;
		UIManager.put("Button.background", Color.lightGray);
		setLayout(null);
		setSize(ConstantesGUI.DIALOGO_ANCHO, ConstantesGUI.DIALOGO_ALTO);
		setLocationRelativeTo(null);
		setBackground(Color.CYAN);
	
		lbNombre = new JLabel(ConstantesGUI.T_AGREGAR_NOMBRE);
		lbNombre.setBounds(30,0,100,100);

		txtNombre = new JTextField();
		txtNombre.setBounds(150, 30, 150, 30);
		txtNombre.setBackground(ConstantesGUI.COlOR_DATOS);

		lbcredito = new JLabel(ConstantesGUI.T_AGREGAR_CREDITO);
		lbcredito.setBounds(30, 45, 100, 100);

		txtcredito = new JTextField();
		txtcredito.setBounds(150, 75, 150, 30);
		txtcredito.setBackground(ConstantesGUI.COlOR_DATOS);

		lbImagen = new JLabel(ConstantesGUI.T_AGREGAR_IMAGEN);
		lbImagen.setBounds(30, 110, 100, 100);

		txtImage = new JTextField();
		txtImage.setBounds(150, 140, 150, 30);
		txtImage.setBackground(ConstantesGUI.COlOR_DATOS);

		btnAgregar = new JButton(createImageIcon("/img/clientea.png"));
		btnAgregar.setText(ConstantesGUI.T_ITEM_AGREGAR_BUTTON_CLIENTE);
		btnAgregar.addActionListener(controlador);
		btnAgregar.setActionCommand(Controlador.A_AGREGAR_CLIENTE);
		btnAgregar.setBounds(100, 385, 150, 30);

		btnCancelar = new JButton(ConstantesGUI.T_ITEM_CANCELAR);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_MOSTRAR_CANCELAR_CLIENTE);
		btnCancelar.setBounds(270, 385, 150, 30);

		btnCargarImagen = new JButton(ConstantesGUI.T_AGREGAR_IMAGEN);
		btnCargarImagen.addActionListener(controlador);
		btnCargarImagen.setActionCommand(Controlador.A_CREAR_IMAGEN);
		btnCargarImagen.setBounds(350,140, 150, 30);

		add(lbNombre);
		add(txtNombre);
		add(lbcredito);
		add(txtcredito);
		add(lbImagen);
		add(txtImage);
		add(btnAgregar);
		add(btnCancelar);
		add(btnCargarImagen);
	}
	public Cliente crearCliente(){
		Cliente cliente = GestorCliente.crearCliente(txtNombre.getText(),
				txtcredito.getText());
		dispose();
		eliminarDatosTableCliente();
		return cliente;
	}

	public void eliminarDatosTableCliente(){
		txtNombre.setText("");
		txtcredito.setText("");
	}

	public ImageIcon importarImagen(){
		JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		if (file != null){
			txtImage.setText(file.getPath());
			image = new ImageIcon(file.getPath());
		}
		return image;
	}
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
//	public static void main(String[] args) {
//		DialogoCliente d = new DialogoCliente(null, null);
//		d.setVisible(true);
//	}
}
