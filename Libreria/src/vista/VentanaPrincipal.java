package vista;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.dao.GestorAutor;
import modelo.dao.GestorCliente;
import modelo.dao.GestorLibro;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
import modelos.util.Util;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
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
	private JPanelImage jPanelImage;
	private String ruta;
	private int selectionAutor;
	private int selectionCliente;
	private int selectionLibro;


	public VentanaPrincipal(final Controlador controlador) {
		setIconImage(createImageIcon(ConstantesGUI.I_ICONO_VENTANA).getImage());
		setLayout(new BorderLayout());
		setSize(ConstantesGUI.VENTANA_ANCHO,ConstantesGUI.VENTANA_ALTO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent e){ controlador.mostrarVentanaInicial(); } });

		barraMenu = new BarraMenu(controlador);
		setJMenuBar(barraMenu);

		barraHerramientas = new BarraHerramientas(controlador);
		add(barraHerramientas, BorderLayout.PAGE_START);


		modeloLibro = new DefaultTableModel(new String[]{"Id" ,"Nombre", "Descripcion","Valor","Genero","Autor", "Copias Vendidas"}, 0);
		tableLibro = new JTable(modeloLibro);
		jPanelImage = new JPanelImage();
		tableLibro.getTableHeader().setReorderingAllowed(false);
		tableLibro.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			

			public void valueChanged(ListSelectionEvent e) {		
				if(modeloLibro.getRowCount() > 0){
					jPanelImage.setRutaImagen(controlador.buscarId(retornarIdSeleccion()).getImage());
					jPanelImage.repaint();
				}

			}
		});
		add(new JScrollPane(tableLibro),BorderLayout.SOUTH);
		add(jPanelImage,BorderLayout.EAST);

		modeloCliente = new DefaultTableModel(new String[]{"Id", "Nombre", "Credito","Contrase�a"}, 0);
		tableCliente = new JTable(modeloCliente);
		tableCliente.getTableHeader().setReorderingAllowed(false);
		tableCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			

			public void valueChanged(ListSelectionEvent e) {		
				if(modeloCliente.getRowCount() > 0){
//					jPanelImage.setRutaImagen(controlador.buscarIdCliente(retornarIdSeleccionCliente()).getImage());
					jPanelImage.repaint();
				}

			}
		});
		
		tableCliente.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableCliente),BorderLayout.CENTER);
		
		modeloAutor = new DefaultTableModel(new String[]{"Id","Nombre"}, 0);
		tableAutor = new JTable(modeloAutor);
		jPanelImage = new JPanelImage();
		tableAutor.getTableHeader().setReorderingAllowed(false);
		tableAutor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			

			public void valueChanged(ListSelectionEvent e) {		
				if(modeloAutor.getRowCount() > 0){
				//	jPanelImage.setRutaImagen(controlador.buscarIdAutor(retornarIdSeleccionAutor()).getImage());
					jPanelImage.repaint();
				}

			}
		});
		tableAutor.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableAutor),BorderLayout.WEST);
		add(jPanelImage,BorderLayout.EAST);
		tableAutor.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectionAutor = Integer.parseInt((String)modeloAutor.getValueAt(tableAutor.getSelectedRow(), 0));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		tableCliente.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectionCliente = Integer.parseInt((String)modeloCliente.getValueAt(tableCliente.getSelectedRow(), 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		tableLibro.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectionLibro = Integer.parseInt((String)modeloLibro.getValueAt(tableLibro.getSelectedRow(), 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		init();
		
	}

	public void init(){
		setTitle(ConstantesGUI.T_TITULO_VENTANA_ADMINISTRADOR);		
	}

	public void agregarLibro(Libro libro){
		modeloLibro.addRow(Util.libroAVector(libro));
	}
	
	public void agregarAutor(Autor autor){
		modeloAutor.addRow(Util.autorAVector(autor));
	}

	public void agregarCliente(Cliente cliente){
		modeloCliente.addRow(Util.clienteAVector(cliente));
	}

	public int retornarIdSeleccion(){
		return selectionLibro;
	}
	
	public int filaSeleccionadalibro(){
		return tableLibro.getSelectedRow();
	}
	public int filaSeleccionadaCliente(){
		return tableCliente.getSelectedRow();
	}
	public int filaSeleccionadaAutor(){
		return tableAutor.getSelectedRow();
	}
	public int retornarIdSeleccionAutor(){
		return  selectionAutor;
	}

	public int retornarIdSeleccionCliente(){
		return selectionCliente;
	}

	public int eliminarLibro(){

		int auxiliar = Integer.parseInt((String) modeloLibro.getValueAt(tableLibro.getSelectedRow(), 0));
		int ob = JOptionPane.showConfirmDialog(this, "SEGURO QUE QUIERE ELIMINAR?.");
		if(ob == JOptionPane.YES_OPTION){
			modeloLibro.removeRow(tableLibro.getSelectedRow());
		}
		return auxiliar;
	}
	
	public int eliminarCliente(){
		int ob = JOptionPane.showConfirmDialog(this, "SEGURO QUE QUIERE ELIMINAR?.");
		if(ob == JOptionPane.YES_OPTION){
			modeloCliente.removeRow(tableCliente.getSelectedRow());
		}
		return selectionCliente;
	}

	public int eliminarAutor(){
		int ob = JOptionPane.showConfirmDialog(this, "SEGURO QUE QUIERE ELIMINAR?.");
		if(ob == JOptionPane.YES_OPTION){
			modeloAutor.removeRow(tableAutor.getSelectedRow());
		}
		return selectionAutor;
	}

	public void actualizarVentana(Libro libro, int fila){
		modeloLibro.insertRow(fila, Util.libroAVector(libro));
		modeloLibro.removeRow(fila+1);
	}

	public void actualizarVentana(Cliente cliente, int fila){
		modeloCliente.setValueAt(cliente.getId(),fila,0);
		modeloCliente.setValueAt(cliente.getNombre(),fila, 1);
		modeloCliente.setValueAt(cliente.getCredito(),fila, 2);
		modeloCliente.setValueAt(cliente.getPassWord(), fila, 3);
		modeloCliente.fireTableDataChanged();
	}
	
	public void actualizarVentanaAutor(Autor autor, int fila){
		modeloAutor.setValueAt(autor.getId(),fila,0);
		modeloAutor.setValueAt(autor.getNombre(),fila, 1);
		modeloAutor.fireTableDataChanged();
	}
	
	public void buscarLibroNombre(String nombre){
		boolean auxiliar = true;
		if (barraHerramientas.getTxtBuscar().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese un libro");
		}
		for (int i = 0; i < modeloLibro.getRowCount(); i++) {
			String aux = (String) modeloLibro.getValueAt(i, 1);
			if (aux.equalsIgnoreCase(nombre)) {
				auxiliar= true;
				tableLibro.setRowSelectionInterval(i, i);
				break;
			}
		}if (auxiliar == true) {
			JOptionPane.showMessageDialog(null, "Si se encontro la libro");	
		}else
			JOptionPane.showMessageDialog(null, "No se encontro la libro");
	}

	public void buscarLibroId(int id){
		boolean auxiliar = true;
		if (barraHerramientas.getTxtBuscar().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese una libro");
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
			JOptionPane.showMessageDialog(null, "Si se encontro la libro");
		}else
			JOptionPane.showMessageDialog(null, "No se encontro la libro");
	}

	public void buscarAutorNombre(String nombre){
		boolean auxiliar = true;
		if (barraHerramientas.getTxtBuscar().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese un autor");
		}
		for (int i = 0; i < modeloAutor.getRowCount(); i++) {
			String aux = (String) modeloAutor.getValueAt(i, 1);
			if (aux.equalsIgnoreCase(nombre)) {
				auxiliar= true;
				tableAutor.setRowSelectionInterval(i, i);
				break;
			}
		}if (auxiliar == true) {
			JOptionPane.showMessageDialog(null, "Si se encontro la autor");	
		}else
			JOptionPane.showMessageDialog(null, "No se encontro la autor");
	}
	
	public void buscarClienteNombre(String nombre){
		boolean auxiliar = true;
		if (barraHerramientas.getTxtBuscar().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese un Cliente");
		}
		for (int i = 0; i < modeloCliente.getRowCount(); i++) {
			String aux = (String) modeloCliente.getValueAt(i, 1);
			if (aux.equalsIgnoreCase(nombre)) {
				auxiliar= true;
				tableCliente.setRowSelectionInterval(i, i);
				break;
			}
		}if (auxiliar == true) {
			JOptionPane.showMessageDialog(null, "Si se encontro el Cliente");	
		}else
			JOptionPane.showMessageDialog(null, "No se encontro el Clienet");
	}
	
	public void buscarClienteId(int id){
		boolean auxiliar = true;
		if (barraHerramientas.getTxtBuscar().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese un Cliente");
			return;
		}
		for (int i = 0; i < tableCliente.getRowCount(); i++) {
			int aux = Integer.parseInt((String) modeloCliente.getValueAt(i, 0));
			if(id == aux){
				tableCliente.setRowSelectionInterval(i, i);
				break;
			}
		}
		if(auxiliar == true){
			JOptionPane.showMessageDialog(null, "Si se encontro el Cliente");
		}else
			JOptionPane.showMessageDialog(null, "No se encontro el cliente");
	}

	public void buscarAutorId(int id){
		boolean auxiliar = true;
		if (barraHerramientas.getTxtBuscar().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese un autor");
			return;
		}
		for (int i = 0; i < tableAutor.getRowCount(); i++) {
			int aux = Integer.parseInt((String) modeloAutor.getValueAt(i, 0));
			if(id == aux){
				tableAutor.setRowSelectionInterval(i, i);
				break;
			}
		}
		if(auxiliar == true){
			JOptionPane.showMessageDialog(null, "Si se encontro la autor");
		}else
			JOptionPane.showMessageDialog(null, "No se encontro la autor");
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
