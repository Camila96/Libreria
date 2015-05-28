package vista;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import modelo.entidades.TipoBusqueda;
import controlador.Controlador;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class BarraHerramientas extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAgregarLibro;
	private JButton btnAgregarCliente;
	private JButton btnAgregarAutor;
	private JButton btnEditarLibro;
	private JButton btnEditarCliente;
	private JButton btnEditarAutor;
	private JButton btnEliminarLibro;
	private JButton btnEliminarCliente;
	private JButton btnEliminarAutor;
	private JButton btnBuscarLibro;
	private JButton btnBuscarCliente;
	private JButton btnBuscarAutor;
	private JTextField txtBuscar;
	private JRadioButton jrBtnId;
	private JRadioButton jrBtnNombre;
	private ButtonGroup btnGroup;
	private JRadioButton jrBtnIdAutor;
	private JRadioButton jrBtnNombreAutor;
	private ButtonGroup btnGroupAutor;

	private JButton btnBuscar;
	private JComboBox cBox;

	public BarraHerramientas(Controlador controlador) {
		setEnabled(false);
		btnAgregarLibro = new JButton(createImageIcon("/img/book.png"));
		btnAgregarLibro.addActionListener(controlador);
		btnAgregarLibro.setActionCommand(Controlador.A_MOSTRAR_AGREGAR_LIBRO);
		btnAgregarLibro.setToolTipText("Agregar Libro");
		add(btnAgregarLibro);

		btnEditarLibro = new JButton(createImageIcon("/img/editb.png"));
		btnEditarLibro.addActionListener(controlador);
		btnEditarLibro.setActionCommand(Controlador.A_MOSTRAR_DIALOGO_EDITAR_LIBRO);
		btnEditarLibro.setToolTipText("Editar Libro");
		add(btnEditarLibro);

		btnEliminarLibro = new JButton(createImageIcon("/img/borrarb.png"));
		btnEliminarLibro.addActionListener(controlador);
		btnEliminarLibro.setActionCommand(Controlador.A_ELIMINAR_LIBRO);
		btnEliminarLibro.setToolTipText("Eliminar Libro");
		add(btnEliminarLibro);

		btnAgregarCliente = new JButton(createImageIcon("/img/clientea.png"));
		btnAgregarCliente.addActionListener(controlador);
		btnAgregarCliente.setActionCommand(Controlador.A_MOSTRAR_AGREGAR_CLIENTE);
		btnAgregarCliente.setToolTipText("Agregar Cliente");
		add(btnAgregarCliente);

		btnEditarCliente = new JButton(createImageIcon("/img/editarc.png"));
		btnEditarCliente.addActionListener(controlador);
		btnEditarCliente.setActionCommand(Controlador.A_EDITAR_CLIENTE);
		btnEditarCliente.setToolTipText("Editar Cliente");
		add(btnEditarCliente);

		btnEliminarCliente = new JButton(createImageIcon("/img/eliminarc.png"));
		btnEliminarCliente.addActionListener(controlador);
		btnEliminarCliente.setActionCommand(Controlador.A_ELIMINAR_CLIENTE);
		btnEliminarCliente.setToolTipText("Eliminar Cliente");
		add(btnEliminarCliente);

		btnAgregarAutor = new JButton(createImageIcon("/img/autora.png"));
		btnAgregarAutor.addActionListener(controlador);
		btnAgregarAutor.setActionCommand(Controlador.A_MOSTRAR_AGREGAR_AUTOR);
		btnAgregarAutor.setToolTipText("Agregar Autor");
		add(btnAgregarAutor);

		btnEditarAutor = new JButton(createImageIcon("/img/editara.png"));
		btnEditarAutor.addActionListener(controlador);
		btnEditarAutor.setActionCommand(Controlador.A_MOSTRAR_DIALOGO_EDITAR_AUTOR);
		btnEditarAutor.setToolTipText("Editar Autor");
		add(btnEditarAutor);

		btnEliminarAutor = new JButton(createImageIcon("/img/eliminara.png"));
		btnEliminarAutor.addActionListener(controlador);
		btnEliminarAutor.setActionCommand(Controlador.A_ELIMINAR_AUTOR);
		btnEliminarAutor.setToolTipText("Eliminar Autor");
		add(btnEliminarAutor);

		txtBuscar = new JTextField(5);	
		add(txtBuscar);

		cBox = new JComboBox<TipoBusqueda>(TipoBusqueda.values());
		cBox.setPreferredSize(new Dimension(150, 10));
		add(cBox);
		cBox.addActionListener(controlador);
		
		btnBuscar = new JButton(createImageIcon("/img/Search.png"));
		btnBuscar.addActionListener(controlador);
		btnBuscar.setActionCommand(Controlador.A_BUSCAR_AUTOR);
		btnBuscar.setToolTipText("Bucar Autor");
		add(btnBuscar);
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}


	public JRadioButton getJrBtnId() {
		return jrBtnId;
	}

	public void setJrBtnId(JRadioButton jrBtnId) {
		this.jrBtnId = jrBtnId;
	}

	public JRadioButton getJrBtnNombre() {
		return jrBtnNombre;
	}

	public void setJrBtnNombre(JRadioButton jrBtnNombre) {
		this.jrBtnNombre = jrBtnNombre;
	}

	public ButtonGroup getBtnGroup() {
		return btnGroup;
	}

	public void setBtnGroup(ButtonGroup btnGroup) {
		this.btnGroup = btnGroup;
	}

	public JButton getBtnAgregarLibro() {
		return btnAgregarLibro;
	}

	public void setBtnAgregarLibro(JButton btnAgregarLibro) {
		this.btnAgregarLibro = btnAgregarLibro;
	}

	public JButton getBtnAgregarCliente() {
		return btnAgregarCliente;
	}

	public void setBtnAgregarCliente(JButton btnAgregarCliente) {
		this.btnAgregarCliente = btnAgregarCliente;
	}

	public JButton getBtnAgregarAutor() {
		return btnAgregarAutor;
	}

	public void setBtnAgregarAutor(JButton btnAgregarAutor) {
		this.btnAgregarAutor = btnAgregarAutor;
	}

	public JButton getBtnEditarLibro() {
		return btnEditarLibro;
	}

	public void setBtnEditarLibro(JButton btnEditarLibro) {
		this.btnEditarLibro = btnEditarLibro;
	}

	public JButton getBtnEditarCliente() {
		return btnEditarCliente;
	}

	public void setBtnEditarCliente(JButton btnEditarCliente) {
		this.btnEditarCliente = btnEditarCliente;
	}

	public JButton getBtnEditarAutor() {
		return btnEditarAutor;
	}

	public void setBtnEditarAutor(JButton btnEditarAutor) {
		this.btnEditarAutor = btnEditarAutor;
	}

	public JButton getBtnEliminarLibro() {
		return btnEliminarLibro;
	}

	public void setBtnEliminarLibro(JButton btnEliminarLibro) {
		this.btnEliminarLibro = btnEliminarLibro;
	}

	public JButton getBtnEliminarCliente() {
		return btnEliminarCliente;
	}

	public void setBtnEliminarCliente(JButton btnEliminarCliente) {
		this.btnEliminarCliente = btnEliminarCliente;
	}

	public JButton getBtnEliminarAutor() {
		return btnEliminarAutor;
	}

	public void setBtnEliminarAutor(JButton btnEliminarAutor) {
		this.btnEliminarAutor = btnEliminarAutor;
	}

	public JButton getBtnBuscarLibro() {
		return btnBuscarLibro;
	}

	public void setBtnBuscarLibro(JButton btnBuscarLibro) {
		this.btnBuscarLibro = btnBuscarLibro;
	}

	public JButton getBtnBuscarCliente() {
		return btnBuscarCliente;
	}

	public void setBtnBuscarCliente(JButton btnBuscarCliente) {
		this.btnBuscarCliente = btnBuscarCliente;
	}

	public JButton getBtnBuscarAutor() {
		return btnBuscarAutor;
	}

	public void setBtnBuscarAutor(JButton btnBuscarAutor) {
		this.btnBuscarAutor = btnBuscarAutor;
	}

	public JTextField getTxtBuscar() {
		return txtBuscar;
	}

	public void setTxtBuscar(JTextField txtBuscar) {
		this.txtBuscar = txtBuscar;
	}

	public JRadioButton getJrBtnIdAutor() {
		return jrBtnIdAutor;
	}

	public void setJrBtnIdAutor(JRadioButton jrBtnIdAutor) {
		this.jrBtnIdAutor = jrBtnIdAutor;
	}

	public JRadioButton getJrBtnNombreAutor() {
		return jrBtnNombreAutor;
	}

	public void setJrBtnNombreAutor(JRadioButton jrBtnNombreAutor) {
		this.jrBtnNombreAutor = jrBtnNombreAutor;
	}

	public ButtonGroup getBtnGroupAutor() {
		return btnGroupAutor;
	}

	public void setBtnGroupAutor(ButtonGroup btnGroupAutor) {
		this.btnGroupAutor = btnGroupAutor;
	}
	
}
