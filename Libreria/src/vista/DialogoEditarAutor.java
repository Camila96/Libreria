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
	private VentanaPrincipal ventanaPrincipal;

	public DialogoEditarAutor(VentanaPrincipal ventanaPrincipal, Controlador controlador){
		super(ventanaPrincipal);
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
		
		lbImagen = new JLabel(ConstantesGUI.T_AGREGAR_IMAGEN);
		lbImagen.setBounds(30,290,100,100);

		txtImage = new JTextField();
		txtImage.setBounds(150, 320, 150, 30);
		txtImage.setBackground(ConstantesGUI.COlOR_DATOS);

		btnEditar = new JButton(ConstantesGUI.T_ITEM_EDITAR_AUTOR);
		btnEditar.addActionListener(controlador);
		btnEditar.setActionCommand(Controlador.A_EDITAR_AUTOR);
		btnEditar.setBounds(100, 185, 150, 30);

		btnCancelar = new JButton(ConstantesGUI.T_ITEM_CANCELAR_AUTOR);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_MOSTRAR_CANCELAR_AUTOR);
		btnCancelar.setBounds(320, 185, 150, 30);

		btnCargarImagen = new JButton(ConstantesGUI.T_AGREGAR_IMAGEN_AUTOR);
		btnCargarImagen.addActionListener(controlador);
		btnCargarImagen.setActionCommand(Controlador.A_CREAR_IMAGEN);
		btnCargarImagen.setBounds(310,140, 150, 30);
		
		add(lbNombre);
		add(txtNombre);
		add(lbImagen);
		add(txtImage);
		add(btnEditar);
		add(btnCancelar);
		add(btnCargarImagen);
		
	}

	public Autor crearAutor(){
		Autor autor  = GestorAutor.crearAutor(txtNombre.getText());
		dispose();
		eliminarDatosTablaAutor();
		return autor;
	}
	
	public Autor editarAutor(Autor autor){
		autor.setNombre(txtNombre.getText());
//		autor.setImage(txtImage.getText());
		eliminarDatosTablaAutor();
		dispose();
		return autor;
	}
	
	public void cambiarValores(Autor autor){
		txtNombre.setText(autor.getNombre());
//		txtImage.setText(autor.getImage());
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
