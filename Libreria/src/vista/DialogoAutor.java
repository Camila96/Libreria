package vista;

import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import modelo.dao.GestorAutor;
import modelo.dao.GestorCliente;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import controlador.Controlador;

public class DialogoAutor extends JDialog{


	private static final long serialVersionUID = 1L;
	private JLabel lbNombre;
	private ImageIcon image;
	private JTextField txtNombre;
	private JTextField txtImage;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JButton btnCargarImagen;
	private JLabel lbImagen;
	private JLabel lbImageFondo;
	private VentanaPrincipal ventanaPrincipal;

	public DialogoAutor(VentanaPrincipal ventanaPrincipal, Controlador controlador){
		
		super(ventanaPrincipal);
		UIManager.put("Button.background", Color.lightGray);
		setLayout(null);
		setSize(ConstantesGUI.DIALOGO_ANCHO, ConstantesGUI.DIALOGO_ALTO);
		setLocationRelativeTo(null);
		setBackground(Color.CYAN);
		
		lbImageFondo = new JLabel(createImageIcon("/img/autorDialogo.jpg"));
		lbImageFondo.setBounds(0,0,500,480);

		lbNombre = new JLabel(ConstantesGUI.T_AGREGAR_NOMBRE);
		lbNombre.setBounds(30,0,100,100);

		txtNombre = new JTextField();
		txtNombre.setBounds(150, 30, 150, 30);
		txtNombre.setBackground(ConstantesGUI.COlOR_DATOS);

		lbImagen = new JLabel(ConstantesGUI.T_AGREGAR_IMAGEN);
		lbImagen.setBounds(30,35,100,100);

		txtImage = new JTextField();
		txtImage.setBounds(150, 70, 150, 30);
		txtImage.setBackground(ConstantesGUI.COlOR_DATOS);

		btnAgregar = new JButton(ConstantesGUI.T_ITEM_AGREGAR_BUTTON_AUTOR,createImageIcon("/img/add.png"));
		btnAgregar.addActionListener(controlador);
		btnAgregar.setActionCommand(Controlador.A_AGREGAR_AUTOR);
		btnAgregar.setBounds(320, 380, 150, 30);

		btnCancelar = new JButton(ConstantesGUI.T_ITEM_CANCELAR_AUTOR,createImageIcon("/img/cancel.png"));
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_MOSTRAR_CANCELAR_AUTOR);
		btnCancelar.setBounds(50, 380, 150, 30);

		btnCargarImagen = new JButton(ConstantesGUI.T_AGREGAR_IMAGEN_AUTOR,createImageIcon("/img/load.png"));
		btnCargarImagen.addActionListener(controlador);
		btnCargarImagen.setActionCommand(Controlador.A_CREAR_IMAGEN);
		btnCargarImagen.setBounds(310,70, 150, 30);

		add(lbNombre);
		add(txtNombre);
		add(lbImagen);
		add(txtImage);
		add(btnAgregar);
		add(btnCancelar);
		add(btnCargarImagen);
		add(lbImageFondo);

	}

	public Autor crearAutor(){
		Autor autor  = GestorAutor.crearAutor(txtNombre.getText());
		dispose();
		eliminarDatosTablaAutor();
		return autor;
	}

	public void eliminarDatosTablaAutor(){
		txtNombre.setText("");
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

}
