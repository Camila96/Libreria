package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.dao.GestorAutor;
import modelo.dao.GestorCliente;
import modelo.dao.GestorLibro;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;

public class VentanaPrincipal  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarraMenu barraMenu;
	private BarraHerramientas barraHerramientas;
	private GestorAutor gestorAutor;
	private GestorCliente gestorCliente;
	private GestorLibro gestorLibro;
	private Libro libro;
	private Autor autor;
	private Cliente cliente;
	private JTable tableLibro;
	private DefaultTableModel modeloLibro;
	private JTable tableCliente;
	private DefaultTableModel modeloCliente;
	private JTable tableAutor;
	private DefaultTableModel modeloAutor;
	
	public VentanaPrincipal(final Controlador controlador) {

		setLayout(new BorderLayout());
		setSize(ConstantesGUI.VENTANA_ANCHO,ConstantesGUI.VENTANA_ALTO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		barraMenu = new BarraMenu(controlador);
		setJMenuBar(barraMenu);
		
		barraHerramientas = new BarraHerramientas(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);
		
		modeloLibro = new DefaultTableModel(new String[]{"NOMBRE", "DESCRIPCION","GENERO","COPIAS VENDIDAS","AUTOR", "VALOR"}, 0);
		tableLibro = new JTable(modeloLibro);
		tableLibro.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableLibro),BorderLayout.PAGE_START);
		
		modeloCliente = new DefaultTableModel(new String[]{"NOMBRE", "CREDITO", "LIBRO"}, 0);
		tableCliente = new JTable(modeloCliente);
		tableCliente.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableCliente),BorderLayout.WEST);
		
		modeloAutor = new DefaultTableModel(new String[]{"NOMBRE"}, 0);
		tableAutor = new JTable(modeloAutor);
		tableAutor.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableAutor),BorderLayout.EAST);
	}

	public BarraMenu getBarraMenu() {
		return barraMenu;
	}

	public void setBarraMenu(BarraMenu barraMenu) {
		this.barraMenu = barraMenu;
	}

	public GestorAutor getGestorAutor() {
		return gestorAutor;
	}

	public void setGestorAutor(GestorAutor gestorAutor) {
		this.gestorAutor = gestorAutor;
	}

	public GestorCliente getGestorCliente() {
		return gestorCliente;
	}

	public void setGestorCliente(GestorCliente gestorCliente) {
		this.gestorCliente = gestorCliente;
	}

	public GestorLibro getGestorLibro() {
		return gestorLibro;
	}

	public void setGestorLibro(GestorLibro gestorLibro) {
		this.gestorLibro = gestorLibro;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
