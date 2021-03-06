package vista;
import java.awt.Color;
import java.io.File;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import modelo.dao.GestorCliente;
import modelo.entidades.Cliente;
import modelos.util.Util;
import controlador.Controlador;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class DialogoEditarCliente  extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbNombre;
	private JLabel lbcredito;
	private JLabel lbImagen;
	ImageIcon image;
	private JTextField txtNombre;
	private JTextField txtcredito;
	private JTextField txtImage;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JButton btnCargarImagen;
	private JPasswordField jPasswordField;
	private Cliente cliente;
	private JLabel lbPass;

	public DialogoEditarCliente(VentanaPrincipal ventanaPrincipal, Controlador controlador){
		super(ventanaPrincipal);

		setTitle("Editar Cliente");	
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
		
		lbPass = new JLabel(ConstantesGUI.T_AGREGAR_PASS);
		lbPass.setBounds(30, 200, 150, 30);

		txtImage = new JTextField();
		txtImage.setBounds(150, 140, 150, 30);
		txtImage.setBackground(ConstantesGUI.COlOR_DATOS);

		btnAgregar = new JButton(createImageIcon("/img/clientea.png"));
		btnAgregar.setText(ConstantesGUI.T_ITEM_EDITAR);
		btnAgregar.addActionListener(controlador);
		btnAgregar.setActionCommand(Controlador.A_EDITAR_CLIENTE);
		btnAgregar.setBounds(100, 385, 150, 30);

		btnCancelar = new JButton(ConstantesGUI.T_ITEM_CANCELAR);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_MOSTRAR_CANCELAR_CLIENTE);
		btnCancelar.setBounds(270, 385, 150, 30);

		btnCargarImagen = new JButton(ConstantesGUI.T_AGREGAR_IMAGEN);
		btnCargarImagen.addActionListener(controlador);
		btnCargarImagen.setActionCommand(Controlador.A_CREAR_IMAGEN_EDITAR_CLIENTE);
		btnCargarImagen.setBounds(350,140, 150, 30);

		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(150,200, 150, 30);

		add(lbNombre);
		add(txtNombre);
		add(lbcredito);
		add(txtcredito);
		add(lbImagen);
		add(txtImage);
		add(btnAgregar);
		add(btnCancelar);
		add(btnCargarImagen);
		add(jPasswordField);
		add(lbPass);
	}
	public Cliente crearCliente(){
		char[] arrayC = jPasswordField.getPassword(); 
		String pass = new String(arrayC); 
		Cliente cliente = GestorCliente.crearCliente(txtNombre.getText(),
				txtcredito.getText(),pass,txtImage.getText());
		dispose();
		eliminarDatosTableCliente();
		System.out.println(cliente.getPassWord());
		eliminarDatosTableCliente();
		return cliente;
	}


	public Cliente editar(){
		char[] arrayC = jPasswordField.getPassword(); 
		String pass = new String(arrayC); 
	HashMap<String, String> listaCampos = new HashMap<String, String>();
		
		if (!txtNombre.getText().equals(cliente.getNombre())) {
			listaCampos.put("NOMBRE", txtNombre.getText());
		}
		if (!txtcredito.getText().equals(cliente.getCredito())) {
			listaCampos.put("CREDITO", txtcredito.getText());
		}
		if (!pass.equals(cliente.getPassWord())) {
			listaCampos.put("PASS", pass);
		}
		if (!txtImage.getText().equals(cliente.getImage())) {
			String nombreImagen = txtNombre.getText()+ cliente.getId();
			cliente.setImage("/images/imgCliente/"+nombreImagen+".jpg");
			Util.guardarImagen(nombreImagen, cliente.getImage());
			listaCampos.put("IMAGEN", cliente.getImage());
		}
		GestorCliente.editar(cliente, listaCampos);
		return cliente;
	}

	public void eliminarDatosTableCliente(){
		txtNombre.setText("");
		txtcredito.setText("");
		txtImage.setText("");
		jPasswordField.setText("");
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
	public void cambiarValores(Cliente clienteViejo){
		this.cliente =  clienteViejo;
		txtNombre.setText( clienteViejo.getNombre());
		txtcredito.setText( Double.toString(clienteViejo.getCredito()));
		txtImage.setText( clienteViejo.getImage());
	}
}