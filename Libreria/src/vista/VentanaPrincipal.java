package vista;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import modelos.util.Util;

public class VentanaPrincipal  extends JFrame{

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
	private DialogoLibro dialogoLibro;

	public VentanaPrincipal(final Controlador controlador) {
		setIconImage(createImageIcon(ConstantesGUI.I_ICONO_VENTANA).getImage());
		setLayout(new BorderLayout());
		setSize(ConstantesGUI.VENTANA_ANCHO,ConstantesGUI.VENTANA_ALTO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setTitle("LIBRERIA");

		barraMenu = new BarraMenu(controlador);
		setJMenuBar(barraMenu);

		barraHerramientas = new BarraHerramientas(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);


		modeloLibro = new DefaultTableModel(new String[]{"N°ORDEN" ,"NOMBRE", "DESCRIPCION","VALOR","GENERO","AUTOR", "COPIAS VENDIDAS"}, 0);
		tableLibro = new JTable(modeloLibro);
		tableLibro.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableLibro),BorderLayout.WEST);

		modeloCliente = new DefaultTableModel(new String[]{"ID", "NOMBRE", "CREDITO"}, 0);
		tableCliente = new JTable(modeloCliente);
		tableCliente.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableCliente),BorderLayout.CENTER);

		modeloAutor = new DefaultTableModel(new String[]{"NOMBRE"}, 0);
		tableAutor = new JTable(modeloAutor);
		tableAutor.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableAutor),BorderLayout.EAST);
		init();
	}

	public void init(){
		setTitle(ConstantesGUI.T_TITULO_VENTANA);		
	}

	
	public void agregarLibro(Libro libro){
		modeloLibro.addRow(Util.sitioAVector(libro));
	}
	
	public void agregarCliente(Cliente cliente){
		modeloCliente.addRow(Util.clienteAVector(cliente));
	}

	public int retornarIdSeleccion(){
		return Integer.parseInt((String) modeloLibro.getValueAt(tableLibro.getSelectedRow(), 0));
	}
	public int eliminarSitio(){

		int auxiliar = Integer.parseInt((String) modeloLibro.getValueAt(tableLibro.getSelectedRow(), 0));
		int ob = JOptionPane.showConfirmDialog(this, "SEGURO QUE QUIERE ELIMINAR?.");
		if(ob == JOptionPane.YES_OPTION){
			modeloLibro.removeRow(tableLibro.getSelectedRow());
		}
		return auxiliar;
	}


	public void actualizarVentana(Libro libro, int fila){
		modeloLibro.setValueAt(libro.getId(),fila,0);
		modeloLibro.setValueAt(libro.getNombre(),fila, 1);
		modeloLibro.setValueAt(libro.getDescripcion(),fila, 2);
		modeloLibro.setValueAt(libro.getValor(),fila, 3);
		modeloLibro.fireTableDataChanged();
	}
	
	public void actualizarVentana(Cliente cliente, int fila){
		modeloCliente.setValueAt(cliente.getId(),fila,0);
		modeloCliente.setValueAt(cliente.getNombre(),fila, 1);
		modeloCliente.setValueAt(cliente.getCredito(),fila, 2);
		modeloCliente.fireTableDataChanged();
	}
	
	public void buscarLibroNombre(String nombre){
		boolean auxiliar = true;
		if (barraHerramientas.getTxtBuscar().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese una ciudad");
		}
		for (int i = 0; i < modeloLibro.getRowCount(); i++) {
			String aux = (String) modeloLibro.getValueAt(i, 1);
			if (aux.equalsIgnoreCase(nombre)) {
				auxiliar= true;
				tableLibro.setRowSelectionInterval(i, i);
				break;
			}
		}if (auxiliar == true) {
			JOptionPane.showMessageDialog(null, "Si se encontro la ciudad");	
		}else
			JOptionPane.showMessageDialog(null, "No se encontro la ciudad");
	}

	public void buscarLibroId(int id){
		boolean auxiliar = true;
		if (barraHerramientas.getTxtBuscar().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese una ciudad");
			return;
		}
		for (int i = 0; i < tableLibro.getRowCount(); i++) {
			int aux = Integer.parseInt((String) modeloLibro.getValueAt(i, 0));
			if(id == aux){
				tableLibro.setRowSelectionInterval(i, i);
				break;
			}
		}
		if(auxiliar == true){
			JOptionPane.showMessageDialog(null, "Si se encontro la ciudad");
		}else
			JOptionPane.showMessageDialog(null, "No se encontro la ciudad");
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}
	public BarraHerramientas getBarraHerramientas() {
		return barraHerramientas;
	}

	public void setBarraHerramientas(BarraHerramientas barraHerramientas) {
		this.barraHerramientas = barraHerramientas;
	}

	public JTable getTableLibro() {
		return tableLibro;
	}

	public void setTableLibro(JTable tableLibro) {
		this.tableLibro = tableLibro;
	}

	public DefaultTableModel getModeloLibro() {
		return modeloLibro;
	}

	public void setModeloLibro(DefaultTableModel modeloLibro) {
		this.modeloLibro = modeloLibro;
	}

	public JTable getTableCliente() {
		return tableCliente;
	}

	public void setTableCliente(JTable tableCliente) {
		this.tableCliente = tableCliente;
	}

	public DefaultTableModel getModeloCliente() {
		return modeloCliente;
	}

	public void setModeloCliente(DefaultTableModel modeloCliente) {
		this.modeloCliente = modeloCliente;
	}

	public JTable getTableAutor() {
		return tableAutor;
	}

	public void setTableAutor(JTable tableAutor) {
		this.tableAutor = tableAutor;
	}

	public DefaultTableModel getModeloAutor() {
		return modeloAutor;
	}

	public void setModeloAutor(DefaultTableModel modeloAutor) {
		this.modeloAutor = modeloAutor;
	}

	public DialogoLibro getDialogoLibro() {
		return dialogoLibro;
	}

	public void setDialogoLibro(DialogoLibro dialogoLibro) {
		this.dialogoLibro = dialogoLibro;
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
