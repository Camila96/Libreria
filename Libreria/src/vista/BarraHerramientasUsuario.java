package vista;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controlador.Controlador;

public class BarraHerramientasUsuario extends JToolBar{

	private JButton btnBuscarLibro;
	private JButton btnBuscarCliente;
	private JButton btnBuscarAutor;
	private JTextField txtBuscar;
	private JRadioButton jrBtnId;
	private JRadioButton jrBtnNombre;
	private ButtonGroup btnGroup;
	
	public BarraHerramientasUsuario(Controlador controlador) {
		setEnabled(false);
		
		btnBuscarLibro = new JButton(createImageIcon("/img/buscarb.png"));
		btnBuscarLibro.addActionListener(controlador);
		btnBuscarLibro.setActionCommand(Controlador.A_BUSCAR_LIBRO);
		btnBuscarLibro.setToolTipText("Buscar Libro");
		add(btnBuscarLibro);
		
		btnBuscarCliente = new JButton(createImageIcon("/img/buscarc.png"));
		btnBuscarCliente.addActionListener(controlador);
		btnBuscarCliente.setActionCommand(Controlador.A_BUSCAR_CLIENTE);
		btnBuscarCliente.setToolTipText("Buscar Cliente");
		add(btnBuscarCliente);
		
		btnBuscarAutor = new JButton(createImageIcon("/img/buscara.png"));
		btnBuscarAutor.addActionListener(controlador);
		btnBuscarAutor.setActionCommand(Controlador.A_BUSCAR_AUTOR);
		btnBuscarAutor.setToolTipText("Bucar Autor");
		add(btnBuscarAutor);

		txtBuscar = new JTextField(5);	
		add(txtBuscar);

		btnGroup = new ButtonGroup();
		jrBtnId = new JRadioButton("Buscar por Id");
		jrBtnId.addActionListener(controlador);
		jrBtnId.setActionCommand(Controlador.A_BUSCAR_LIBRO);
		btnGroup.add(jrBtnId);
		add(jrBtnId);

		jrBtnNombre = new JRadioButton("Buscar por Nombre");
		jrBtnNombre.addActionListener(controlador);
		jrBtnNombre.setActionCommand(Controlador.A_BUSCAR_LIBRO);
		btnGroup.add(jrBtnNombre);
		add(jrBtnNombre);
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
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

}
