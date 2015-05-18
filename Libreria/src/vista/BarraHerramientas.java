package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import controlador.Controlador;

public class BarraHerramientas extends JToolBar {

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
	
	public BarraHerramientas(Controlador controlador) {
		setEnabled(false);
		btnAgregarLibro = new JButton(createImageIcon("/img/edit.png"));
		btnAgregarLibro.addActionListener(controlador);
		btnAgregarLibro.setActionCommand(Controlador.A_MOSTRAR_AGREGAR_LIBRO);
		btnAgregarLibro.setToolTipText("Agregar Libro");
		add(btnAgregarLibro);
		
		btnAgregarCliente = new JButton(createImageIcon("/img/edit.png"));
		btnAgregarCliente.addActionListener(controlador);
		btnAgregarCliente.setActionCommand(Controlador.A_AGREGAR_CLIENTE);
		btnAgregarCliente.setToolTipText("Agregar Cliente");
		add(btnAgregarCliente);
		
		btnAgregarAutor = new JButton(createImageIcon("/img/edit.png"));
		btnAgregarAutor.addActionListener(controlador);
		btnAgregarAutor.setActionCommand(Controlador.A_AGREGAR_AUTOR);
		btnAgregarAutor.setToolTipText("Agregar Autor");
		add(btnAgregarAutor);
		
		btnEditarLibro = new JButton(createImageIcon("/img/edit.png"));
		btnEditarLibro.addActionListener(controlador);
		btnEditarLibro.setActionCommand(Controlador.A_MOSTRAR_DIALOGO_EDITAR_SITIO);
		btnEditarLibro.setToolTipText("Editar Libro");
		add(btnEditarLibro);

		btnEditarCliente = new JButton(createImageIcon("/img/edit.png"));
		btnEditarCliente.addActionListener(controlador);
		btnEditarCliente.setActionCommand(Controlador.A_EDITAR_CLIENTE);
		btnEditarCliente.setToolTipText("Editar Cliente");
		add(btnEditarCliente);
		
		btnEditarAutor = new JButton(createImageIcon("/img/edit.png"));
		btnEditarAutor.addActionListener(controlador);
		btnEditarAutor.setActionCommand(Controlador.A_EDITAR_AUTOR);
		btnEditarAutor.setToolTipText("Editar Autor");
		add(btnEditarAutor);
		
		btnEliminarLibro = new JButton(createImageIcon("/img/edit.png"));
		btnEliminarLibro.addActionListener(controlador);
		btnEliminarLibro.setActionCommand(Controlador.A_ELIMINAR_LIBRO);
		btnEliminarLibro.setToolTipText("Eliminar Libro");
		add(btnEliminarLibro);
		
		btnEliminarCliente = new JButton(createImageIcon("/img/edit.png"));
		btnEliminarCliente.addActionListener(controlador);
		btnEliminarCliente.setActionCommand(Controlador.A_ELIMINAR_CLIENTE);
		btnEliminarCliente.setToolTipText("Eliminar Cliente");
		add(btnEliminarCliente);
		
		btnEliminarAutor = new JButton(createImageIcon("/img/edit.png"));
		btnEliminarAutor.addActionListener(controlador);
		btnEliminarAutor.setActionCommand(Controlador.A_ELIMINAR_AUTOR);
		btnEliminarAutor.setToolTipText("Eliminar Autor");
		add(btnEliminarAutor);
		
		btnBuscarLibro = new JButton(createImageIcon("/img/edit.png"));
		btnBuscarLibro.addActionListener(controlador);
		btnBuscarLibro.setActionCommand(Controlador.A_BUSCAR_LIBRO);
		btnBuscarLibro.setToolTipText("Buscar Libro");
		add(btnBuscarLibro);
		
		btnBuscarCliente = new JButton(createImageIcon("/img/edit.png"));
		btnBuscarCliente.addActionListener(controlador);
		btnBuscarCliente.setActionCommand(Controlador.A_BUSCAR_CLIENTE);
		btnBuscarCliente.setToolTipText("Buscar Cliente");
		add(btnBuscarCliente);
		
		btnBuscarAutor = new JButton(createImageIcon("/img/edit.png"));
		btnBuscarAutor.addActionListener(controlador);
		btnBuscarAutor.setActionCommand(Controlador.A_BUSCAR_AUTOR);
		btnBuscarAutor.setToolTipText("Bucar Autor");
		add(btnBuscarAutor);
		
		txtBuscar = new JTextField(5);	
		add(txtBuscar);
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
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
}
