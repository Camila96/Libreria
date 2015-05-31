package vista;

import java.awt.Color;
import java.io.File;
import java.util.HashMap;

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
import modelo.entidades.EnumGeneroLibro;
import modelo.entidades.Libro;
import modelos.util.Util;
import controlador.Controlador;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class DialogoEditar extends JDialog {
	private static final long serialVersionUID = 1L;
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
	private JComboBox<String> boxAutor;
	private JComboBox<EnumGeneroLibro> boxGenero;
	private EnumGeneroLibro[] listaGenerosLibros;
	private JTextField txtCopiasVendidas;
	private JButton btnNewAutor;
	private JTextField txtId;
	private JTextField txtValor;
	private JTextField txtImage;

	private JButton btnEditar;
	private JButton btnCancelar;
	private JButton btnCargarImage;
	private JLabel lbImageFondo;
	private Libro libro;

	public DialogoEditar(VentanaPrincipal ventanaPrincipal, Controlador controlador) {
		super(ventanaPrincipal);
		setTitle("Editar Libro");
		setIconImage(createImageIcon("/img/editb.png").getImage());
		UIManager.put("Button.background", Color.lightGray);
		setLayout(null);
		setSize(ConstantesGUI.DIALOGO_ANCHO, ConstantesGUI.DIALOGO_ALTO);
		setLocationRelativeTo(null);
		setBackground(Color.CYAN);

		lbImageFondo = new JLabel(createImageIcon("/img/editBook.JPG"));
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

		btnEditar = new JButton(ConstantesGUI.T_ITEM_EDITAR,createImageIcon("/img/editC.png"));
		btnEditar.addActionListener(controlador);
		btnEditar.setActionCommand(Controlador.A_EDITAR_LIBRO);
		btnEditar.setBounds(310,380, 120, 30);

		btnCancelar = new JButton(ConstantesGUI.T_ITEM_CANCELAR,createImageIcon("/img/cancelar.png"));
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
		add(btnNewAutor);
		add(lbAutor);
		add(boxAutor);
		add(boxGenero);
		add(lbCopisVendidas);
		add(txtCopiasVendidas);
		add(lbImagen);
		add(txtImage);
		add(btnEditar);
		add(btnCancelar);
		add(btnCargarImage);
		add(lbImageFondo);
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

	public Libro editar(){
	HashMap<String, String> listaCampos = new HashMap<String, String>();
		
		if (!txtNombre.getText().equals(libro.getNombre())) {
			listaCampos.put("NOMBRE", txtNombre.getText());
		}
		if (!txtDescripcion.getText().equals(libro.getDescripcion())) {
			listaCampos.put("DETALLES", txtDescripcion.getText());
		}
		if (!txtValor.getText().equals(libro.getValor())) {
			listaCampos.put("VALOR", txtValor.getText());
		}
		if (!txtImage.getText().equals(libro.getImage())) {
			String nombreImagen = txtNombre.getText()+ libro.getId();
			libro.setImage("/images/imgLibros/"+nombreImagen+".jpg");
			Util.guardarImagen(nombreImagen, libro.getImage());
			listaCampos.put("DIRECCION", libro.getImage());
		}
		GestorLibro.editarStioTuristico(libro, listaCampos);
		return libro;
	}

	public void cambiarValores(Libro libroViejo){
		this.libro =  libroViejo;
		txtNombre.setText( libroViejo.getNombre());
		txtDescripcion.setText( libroViejo.getDescripcion());
		txtValor.setText(Double.toString( libroViejo.getValor()));
		boxGenero.setSelectedItem(libroViejo.getGenero());
		txtCopiasVendidas.setText(Double.toString( libroViejo.getCopiasVendidas()));
		txtImage.setText( libroViejo.getImage());
	}

	public Libro crearLibro(){
		Libro libro = GestorLibro.crearLibro(txtNombre.getText(), txtDescripcion.getText(), txtValor.getText()
				,  boxGenero.getSelectedItem().toString(), boxAutor.getSelectedItem().toString(),txtCopiasVendidas.getText(),txtImage.getText());
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

	
	public JTextField getTxtCopiasVendidas() {
		return txtCopiasVendidas;
	}

	public void setTxtCopiasVendidas(JTextField txtCopiasVendidas) {
		this.txtCopiasVendidas = txtCopiasVendidas;
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
	public JComboBox<String> getBoxAutor() {
		return boxAutor;
	}

}
