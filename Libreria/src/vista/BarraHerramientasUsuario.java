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

public class BarraHerramientasUsuario extends JToolBar{

	private static final long serialVersionUID = 1L;
	private JComboBox cBox;
	private JButton btnBuscarLibro;
	private JButton btnBuscarCliente;
	private JButton btnBuscarAutor;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private ButtonGroup btnGroup;
	
	public BarraHerramientasUsuario(Controlador controlador) {
		setEnabled(false);
		
		btnBuscarLibro = new JButton(createImageIcon("/img/buscarb.png"));
		btnBuscarLibro.addActionListener(controlador);
		btnBuscarLibro.setActionCommand(Controlador.A_BUSCAR_LIBRO);
		btnBuscarLibro.setToolTipText("Buscar Libro");
		add(btnBuscarLibro);
		
				
		btnBuscarAutor = new JButton(createImageIcon("/img/buscara.png"));
		btnBuscarAutor.addActionListener(controlador);
		btnBuscarAutor.setActionCommand(Controlador.A_BUSCAR_AUTOR);
		btnBuscarAutor.setToolTipText("Bucar Autor");
		add(btnBuscarAutor);

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

	public ButtonGroup getBtnGroup() {
		return btnGroup;
	}

	public void setBtnGroup(ButtonGroup btnGroup) {
		this.btnGroup = btnGroup;
	}

}
