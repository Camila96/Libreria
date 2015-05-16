package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.dao.GestorAutor;
import modelo.dao.GestorCliente;
import modelo.dao.GestorLibro;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
import vista.BarraMenu;
import vista.ConstantesGUI;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener {

	public static final String A_AGREGAR_LIBRO = "agregar libro";
	public static final String A_AGREGAR_CLIENTE = "agregar cliente";
	public static final String A_AGREGAR_AUTOR = "agregar autor";
	public static final String A_ELIMINAR_LIBRO = "eliminar libro";
	public static final String A_ELIMINAR_CLIENTE = "eliminar cliente";
	public static final String A_ELIMINAR_AUTOR = "eliminar autor";
	public static final String A_EDITAR_LIBRO  = "editar libro";
	public static final String A_EDITAR_CLIENTE  = "editar cliente";
	public static final String A_EDITAR_AUTOR  = "editar autor";
	public static final String A_BUSCAR_LIBRO = "buscar libro";
	public static final String A_BUSCAR_CLIENTE = "buscar cliente";
	public static final String A_BUSCAR_AUTOR = "buscar autor";
	
	private BarraMenu barraMenu;
	private ConstantesGUI constantesGUI;
	private VentanaPrincipal ventanaPrincipal;
	private GestorAutor gestorAutor;
	private GestorCliente gestorCliente;
	private GestorLibro gestorLibro;
	private Libro libro;
	private Autor autor;
	private Cliente cliente;

	public Controlador() {
		gestorAutor = new GestorAutor();
		gestorCliente = new GestorCliente();
		gestorLibro = new GestorLibro();
		ventanaPrincipal = new VentanaPrincipal(this);
		ventanaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ConstantesGUI.C_JM_IDIOMA_INGLES:
			ventanaPrincipal.getBarraMenu().cargarPropiedades(constantesGUI.RUTA_ARCHIVO_ENG);
			ventanaPrincipal.getBarraMenu().actualizarProperties();
			break;
		case ConstantesGUI.C_JM_IDIOMA_ESPANIOL:
			ventanaPrincipal.getBarraMenu().cargarPropiedades(constantesGUI.RUTA_ARCHIVO_ESP);
			ventanaPrincipal.getBarraMenu().actualizarProperties();	
			break;
		}
	}

	public static void main(String[] args) {
		Controlador controlador = new Controlador();

	}
}
