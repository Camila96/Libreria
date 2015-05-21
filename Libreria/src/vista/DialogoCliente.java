package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

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

import modelo.dao.GestorCliente;
import modelo.entidades.Cliente;
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
	private JLabel lbLibrosAComprar;
	ImageIcon image;
	private JPanel p1;
	private JCheckBox[]  listaCheckboxsLibros;
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtcredito;
	private JTextField txtImage;

	private JButton btnAgregar;
	private JButton btnCancelar;
	private JButton btnCargarImagen;
	private VentanaPrincipal ventanaPrincipal;
	

	public DialogoCliente(VentanaPrincipal ventanaPrincipal, Controlador controlador){
		super(ventanaPrincipal);
		listaCheckboxsLibros = new JCheckBox[controlador.getGestorLibro().getListaLibro().size()]; 
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
		
		lbLibrosAComprar = new JLabel(ConstantesGUI.T_AGREGAR_LIBROS_A_COMPRAR);
		lbLibrosAComprar.setBounds(30, 180, 150, 100);

		txtImage = new JTextField();
		txtImage.setBounds(150, 140, 150, 30);
		txtImage.setBackground(ConstantesGUI.COlOR_DATOS);

		btnAgregar = new JButton(ConstantesGUI.T_ITEM_AGREGAR_BUTTON);
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
		add(lbLibrosAComprar);
		add(txtImage);
		add(btnAgregar);
		add(btnCancelar);
		add(btnCargarImagen);
		p1 = new JPanel(); 
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.blue);
		p1.setBounds(200, 180, 200, 200);
		add(p1); 
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

	public JCheckBox[] getListaCheckboxsLibros() {
		return listaCheckboxsLibros;
	}

	public void setListaCheckboxsLibros(JCheckBox[] listaCheckboxsLibros) {
		this.listaCheckboxsLibros = listaCheckboxsLibros;
	}

	public JPanel getP1() {
		return p1;
	}
	
	



}
