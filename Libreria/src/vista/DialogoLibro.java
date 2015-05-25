package vista;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import modelo.dao.GestorLibro;
import modelo.entidades.Autor;
import modelo.entidades.EnumGeneroLibro;
import modelo.entidades.Libro;
import modelos.util.Util;
import controlador.Controlador;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class DialogoLibro extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1274171077440489665L;
	private JLabel lbNombre;
	private JLabel lbDescripcion;
	private JLabel lbGenero;
	private JLabel lbCopisVendidas;
	private JLabel lbValor;
	private JLabel lbImagen;
	private JLabel lbAutor;
	
	private JComboBox<String> boxAutor;
	private JComboBox<EnumGeneroLibro> boxGenero;
	private EnumGeneroLibro[] listaGenerosLibros;
	private JTextField txtNombre;
	private JTextArea txtDescripcion;
	private JTextField txtCopiasVendidas;
	private JTextField txtValor;
	private JTextField txtImage;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JButton btnCargarImage;
	private JButton btnNewAutor;
	private JLabel lbImageFondo;

	public DialogoLibro(VentanaPrincipal ventanaPrincipal, Controlador controlador) {
		super(ventanaPrincipal);
		UIManager.put("Button.background", Color.lightGray);
		setLayout(null);
		setSize(ConstantesGUI.DIALOGO_ANCHO, ConstantesGUI.DIALOGO_ALTO);
		setLocationRelativeTo(null);
		setBackground(Color.CYAN);

		lbImageFondo = new JLabel(createImageIcon("/img/bookDialogo.jpg"));
		lbImageFondo.setBounds(0,0,500,480);
		
		lbNombre = new JLabel(ConstantesGUI.T_AGREGAR_NOMBRE);
		lbNombre.setBounds(30,0,100,100);

		txtNombre = new JTextField();
		txtNombre.setBounds(150, 30, 150, 30);
		txtNombre.setBackground(ConstantesGUI.COlOR_DATOS);

		lbDescripcion = new JLabel(ConstantesGUI.T_AGREGAR_DESCRIPCION);
		lbDescripcion.setBounds(30,45,100,100);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBounds(150, 75, 150, 50);
		txtDescripcion.setBackground(ConstantesGUI.COlOR_DATOS);

		lbValor = new JLabel(ConstantesGUI.T_AGREGAR_VALOR);
		lbValor.setBounds(30,110,100,100);

		txtValor = new JTextField();
		txtValor.setBounds(150, 140, 150, 30);
		txtValor.setBackground(ConstantesGUI.COlOR_DATOS);

		lbGenero = new JLabel(ConstantesGUI.T_AGREGAR_GENERO);
		lbGenero.setBounds(30,155,100,100);


		lbAutor = new JLabel(ConstantesGUI.T_AGREGAR_AUTOR);
		lbAutor.setBounds(30,200,100,100);

		lbCopisVendidas = new JLabel(ConstantesGUI.T_AGREGAR_COPIAS_VENDIDAS);
		lbCopisVendidas.setBounds(30,245,100,100);

		txtCopiasVendidas = new JTextField();
		txtCopiasVendidas.setBounds(150,280, 150, 30);
		txtCopiasVendidas.setBackground(ConstantesGUI.COlOR_DATOS);

		lbImagen = new JLabel(ConstantesGUI.T_AGREGAR_IMAGEN);
		lbImagen.setBounds(30,290,100,100);

		txtImage = new JTextField();
		txtImage.setBounds(150, 320, 150, 30);
		txtImage.setBackground(ConstantesGUI.COlOR_DATOS);

		btnAgregar = new JButton(ConstantesGUI.T_ITEM_AGREGAR_BUTTON,createImageIcon("/img/add.png"));
		btnAgregar.addActionListener(controlador);
		btnAgregar.setActionCommand(Controlador.A_AGREGAR_LIBRO);
		btnAgregar.setBounds(310,380, 150, 30);

		btnCancelar = new JButton(ConstantesGUI.T_ITEM_CANCELAR,createImageIcon("/img/cancel.png"));
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_MOSTRAR_CANCELAR_LIBRO);
		btnCancelar.setBounds(100,380, 150, 30);

		btnCargarImage = new JButton(ConstantesGUI.T_ITEM_CARGAR_IMAGEN,createImageIcon("/img/load.png"));
		btnCargarImage.addActionListener(controlador);
		btnCargarImage.setActionCommand(Controlador.A_CREAR_IMAGEN);
		btnCargarImage.setBounds(310,320, 150, 30);
		
		boxAutor = new JComboBox<String>();
		boxAutor.setBounds(150, 230, 200, 30);
	
	
		
		boxGenero = new JComboBox<EnumGeneroLibro>();
		boxGenero.setBounds(150, 180, 200, 30);
		listaGenerosLibros = EnumGeneroLibro.values();
		for (int i = 0; i < listaGenerosLibros.length; i++) {
			boxGenero.addItem(listaGenerosLibros[i]);
		}
		btnNewAutor = new JButton(ConstantesGUI.T_ITEM_NEW_AUTOR_BUTTON,createImageIcon("/img/add.png"));
		btnNewAutor.addActionListener(controlador);
		btnNewAutor.setActionCommand(Controlador.A_MOSTRAR_AGREGAR_AUTOR);
		btnNewAutor.setBounds(350,230, 150, 30);
		
		add(lbNombre);
		add(txtNombre);
		add(lbDescripcion);
		add(txtDescripcion);
		add(lbValor);
		add(txtValor);
		add(lbGenero);
		add(boxAutor);
		add(boxGenero);
		add(lbAutor);
		add(lbCopisVendidas);
		add(txtCopiasVendidas);
		add(lbImagen);
		add(txtImage);
		add(btnAgregar);
		add(btnCancelar);
		add(lbImageFondo);
		add(btnCargarImage);
		add(btnNewAutor);
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
	
	public Libro crearLibro(){
		Libro libro = GestorLibro.crearLibro(txtNombre.getText(), txtDescripcion.getText(), txtValor.getText()
				, boxGenero.getSelectedItem().toString(), boxAutor.getSelectedItem().toString(),txtCopiasVendidas.getText(),txtImage.getText());
		String nombreImagen = libro.getNombre() + libro.getId();
		Util.guardarImagen(nombreImagen, libro.getImage());
		libro.setImage("/img/imgLibros/"+nombreImagen+".jpg");
		dispose();
		eliminarDatosTabla();
		return libro;		 
	}

	public void importarImagen(){
		JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		if(file != null){
			txtImage.setText(file.getPath());
		}
	}
	
	public void eliminarDatosTabla(){
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtValor.setText("");
		txtImage.setText("");
		txtCopiasVendidas.setText("");
		
	}

	public JComboBox<String> getBoxAutor() {
		return boxAutor;
	}
	
}
