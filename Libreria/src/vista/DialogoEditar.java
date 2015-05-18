package vista;

import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import modelo.dao.GestorLibro;
import modelo.entidades.Libro;
import controlador.Controlador;

public class DialogoEditar extends JDialog {


	private JLabel lbNombre;
	private JLabel lbDescripcion;
	private JLabel lbGenero;
	private JLabel lbCopisVendidas;
	private JLabel lbValor;
	private JLabel lbImagen;
	private JLabel lbAutor;
	private JLabel lbId;
	private ImageIcon image;

	private JTextField txtNombre;
	private JTextArea txtDescripcion;
	private JTextField txtGenero;
	private JTextField txtCopiasVendidas;
	private JTextField txtAutor;
	private JTextField txtId;
	private JTextField txtValor;
	private JTextField txtImage;

	private JButton btnEditar;
	private JButton btnCancelar;
	private JButton btnCargarImage;
	private VentanaPrincipal ventanaPrincipal;

	public DialogoEditar(VentanaPrincipal ventanaPrincipal, Controlador controlador) {
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

		txtGenero = new JTextField();
		txtGenero.setBounds(150, 185, 150, 30);
		txtGenero.setBackground(ConstantesGUI.COlOR_DATOS);
		
		lbAutor = new JLabel(ConstantesGUI.T_AGREGAR_AUTOR);
		lbAutor.setBounds(30,200,100,100);

		txtAutor = new JTextField();
		txtAutor.setBounds(150, 230, 150, 30);
		txtAutor.setBackground(ConstantesGUI.COlOR_DATOS);

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
		
		btnEditar = new JButton(ConstantesGUI.T_ITEM_EDITAR);
		btnEditar.addActionListener(controlador);
		btnEditar.setActionCommand(Controlador.A_EDITAR_LIBRO);
		btnEditar.setBounds(310,380, 150, 30);

		btnCancelar = new JButton(ConstantesGUI.T_ITEM_CANCELAR);
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(Controlador.A_MOSTRAR_CANCELAR_LIBRO);
		btnCancelar.setBounds(100,380, 150, 30);

		btnCargarImage = new JButton(ConstantesGUI.T_ITEM_CARGAR_IMAGEN);
		btnCargarImage.addActionListener(controlador);
		btnCargarImage.setActionCommand(Controlador.A_CREAR_IMAGEN);
		btnCargarImage.setBounds(310,320, 150, 30);
		
		add(lbNombre);
		add(txtNombre);
		add(lbDescripcion);
		add(txtDescripcion);
		add(lbValor);
		add(txtValor);
		add(lbGenero);
		add(txtGenero);
		add(lbAutor);
		add(txtAutor);
		add(lbCopisVendidas);
		add(txtCopiasVendidas);
		add(lbImagen);
		add(txtImage);
		add(btnEditar);
		add(btnCancelar);
		add(btnCargarImage);
	}

	public ImageIcon importarImagen(){
		JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		if(file != null){
			txtImage.setText(file.getPath());
			image= new ImageIcon(file.getPath());
		}
		return image;		
	}

	public void eliminarDatosTabla(){
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtValor.setText("");
		txtImage.setText("");
	}

	public Libro editar(Libro libro){
		libro.setNombre(txtNombre.getText());
		libro.setDescripcion(txtDescripcion.getText());
		libro.setValor(Double.parseDouble(txtValor.getText()));
		libro.setGenero(txtGenero.getText());
		libro.setAutor(txtAutor.getText());
		libro.setCopiasVendidas(Double.parseDouble(txtCopiasVendidas.getText()));
		libro.setImage(txtImage.getText());
		eliminarDatosTabla();
		dispose();
		return libro;
	}
	
	public void cambiarValores(Libro libro){
		txtNombre.setText(libro.getNombre());
		txtDescripcion.setText(libro.getDescripcion());
		txtValor.setText(Double.toString(libro.getValor()));
		txtGenero.setText(libro.getGenero());
		txtAutor.setText(libro.getAutor());
		txtCopiasVendidas.setText(Double.toString(libro.getCopiasVendidas()));
		txtImage.setText(libro.getImage());
	}
	
	public Libro crearLibro(){
		Libro libro = GestorLibro.crearLibro(txtNombre.getText(), txtDescripcion.getText(), txtValor.getText()
				, txtGenero.getText(), txtAutor.getText(),txtCopiasVendidas.getText(),txtImage.getText());
		dispose();
		eliminarDatosTabla();
		return libro;		 
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

	public JLabel getLbDescripcion() {
		return lbDescripcion;
	}

	public void setLbDescripcion(JLabel lbDescripcion) {
		this.lbDescripcion = lbDescripcion;
	}

	public JLabel getLbGenero() {
		return lbGenero;
	}

	public void setLbGenero(JLabel lbGenero) {
		this.lbGenero = lbGenero;
	}

	public JLabel getLbCopisVendidas() {
		return lbCopisVendidas;
	}

	public void setLbCopisVendidas(JLabel lbCopisVendidas) {
		this.lbCopisVendidas = lbCopisVendidas;
	}

	public JLabel getLbValor() {
		return lbValor;
	}

	public void setLbValor(JLabel lbValor) {
		this.lbValor = lbValor;
	}

	public JLabel getLbImagen() {
		return lbImagen;
	}

	public void setLbImagen(JLabel lbImagen) {
		this.lbImagen = lbImagen;
	}

	public JLabel getLbAutor() {
		return lbAutor;
	}

	public void setLbAutor(JLabel lbAutor) {
		this.lbAutor = lbAutor;
	}

	public JLabel getLbId() {
		return lbId;
	}

	public void setLbId(JLabel lbId) {
		this.lbId = lbId;
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

	public JTextArea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(JTextArea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public JTextField getTxtGenero() {
		return txtGenero;
	}

	public void setTxtGenero(JTextField txtGenero) {
		this.txtGenero = txtGenero;
	}

	public JTextField getTxtCopiasVendidas() {
		return txtCopiasVendidas;
	}

	public void setTxtCopiasVendidas(JTextField txtCopiasVendidas) {
		this.txtCopiasVendidas = txtCopiasVendidas;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(JTextField txtValor) {
		this.txtValor = txtValor;
	}

	public JTextField getTxtImage() {
		return txtImage;
	}

	public void setTxtImage(JTextField txtImage) {
		this.txtImage = txtImage;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnCargarImage() {
		return btnCargarImage;
	}

	public void setBtnCargarImage(JButton btnCargarImage) {
		this.btnCargarImage = btnCargarImage;
	}
}
