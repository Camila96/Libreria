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
import modelo.entidades.Autor;
import modelo.entidades.Libro;
import controlador.Controlador;

public class DialogoEditarAutor extends JDialog{

	private JLabel lbNombre;
	private ImageIcon image;

	private JTextField txtNombre;
	private JTextField txtImage;

	private JButton btnEditar;
	private JButton btnCancelar;
	private JButton btnCargarImagen;
	private JLabel lbImagen;
	private JLabel lbImageFondo;
	private VentanaPrincipal ventanaPrincipal;

	public DialogoEditarAutor(VentanaPrincipal ventanaPrincipal, Controlador controlador){
		super(ventanaPrincipal);
		UIManager.put("Button.background", Color.lightGray);
		setLayout(null);
		setSize(500, 300);
		setLocationRelativeTo(null);
		setBackground(Color.CYAN);

		lbImageFondo = new JLabel(createImageIcon("/img/editAU.jpg"));
		lbImageFondo.setBounds(0,0,500,480);
		
		lbNombre = new JLabel(ConstantesGUI.T_AGREGAR_NOMBRE);
		lbNombre.setBounds(30,20,100,100);

		txtNombre = new JTextField();
		txtNombre.setBounds(150, 60, 150, 30);
		txtNombre.setBackground(ConstantesGUI.COlOR_DATOS);
		
		lbImagen = new JLabel(ConstantesGUI.T_AGREGAR_IMAGEN);
		lbImagen.setBounds(30,90,100,100);

		txtImage = new JTextField();
		txtImage.setBounds(150, 120, 150, 30);
		txtImage.setBackground(ConstantesGUI.COlOR_DATOS);

		btnEditar = new JButton(ConstantesGUI.T_ITEM_EDITAR_AUTOR,createImageIcon("/img/add.png"));
		btnEditar.addActionListener(controlador);
		btnEditar.setActionCommand(Controlador.A_EDITAR_AUTOR);
		btnEditar.setBounds(100, 185, 150, 30);

		btnCancelar = new JButton(ConstantesGUI.T_ITEM_CANCELAR_AUTOR,createImageIcon("/img/cancel.png"));
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_MOSTRAR_CANCELAR_AUTOR);
		btnCancelar.setBounds(320, 185, 150, 30);

		btnCargarImagen = new JButton(ConstantesGUI.T_AGREGAR_IMAGEN_AUTOR,createImageIcon("/img/load.png"));
		btnCargarImagen.addActionListener(controlador);
		btnCargarImagen.setActionCommand(Controlador.A_CREAR_IMAGEN);
		btnCargarImagen.setBounds(320,120, 150, 30);
		
		add(lbNombre);
		add(txtNombre);
		add(lbImagen);
		add(txtImage);
		add(btnEditar);
		add(btnCancelar);
		add(btnCargarImagen);
		add(lbImageFondo);
		
	}

	public Autor crearAutor(){
		Autor autor  = GestorAutor.crearAutor(txtNombre.getText(),txtImage.getText());
		dispose();
		eliminarDatosTablaAutor();
		return autor;
	}
	
	public Autor editarAutor(Autor autor){
		autor.setNombre(txtNombre.getText());
		autor.setImage(txtImage.getText());
		eliminarDatosTablaAutor();
		dispose();
		return autor;
	}
	
	public void cambiarValores(Autor autor){
		txtNombre.setText(autor.getNombre());
		txtImage.setText(autor.getImage());
	}

	public void eliminarDatosTablaAutor(){
		txtNombre.setText("");
		txtImage.setText("");
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
	

	public JLabel getLbNombre() {
		return lbNombre;
	}

	public void setLbNombre(JLabel lbNombre) {
		this.lbNombre = lbNombre;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtImage() {
		return txtImage;
	}

	public void setTxtImage(JTextField txtImage) {
		this.txtImage = txtImage;
	}

	public JButton getBtnAgregar() {
		return btnEditar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnEditar = btnAgregar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnCargarImagen() {
		return btnCargarImagen;
	}

	public void setBtnCargarImagen(JButton btnCargarImagen) {
		this.btnCargarImagen = btnCargarImagen;
	}

	public JLabel getLbImagen() {
		return lbImagen;
	}

	public void setLbImagen(JLabel lbImagen) {
		this.lbImagen = lbImagen;
	}

}
