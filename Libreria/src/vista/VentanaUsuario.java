package vista;

import java.awt.BorderLayout;

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

public class VentanaUsuario  extends JFrame{
	
	private BarraHerramientasUsuario barraHerramientasUsuario;
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
	
	public VentanaUsuario(final Controlador controlador) {

		setIconImage(createImageIcon(ConstantesGUI.I_ICONO_VENTANA).getImage());
		setLayout(new BorderLayout());
		setSize(ConstantesGUI.VENTANA_ANCHO,ConstantesGUI.VENTANA_ALTO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		barraHerramientasUsuario = new BarraHerramientasUsuario(controlador);
		add(barraHerramientasUsuario, BorderLayout.PAGE_START);
		
		modeloLibro = new DefaultTableModel(new String[]{"N°ORDEN" ,"NOMBRE", "DESCRIPCION","VALOR","GENERO","AUTOR", "COPIAS VENDIDAS"}, 0);
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
		add(new JScrollPane(tableLibro),BorderLayout.WEST);
		add(jPanelImage,BorderLayout.EAST);

		modeloCliente = new DefaultTableModel(new String[]{"ID", "NOMBRE", "CREDITO"}, 0);
		tableCliente = new JTable(modeloCliente);
		tableCliente.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableCliente),BorderLayout.CENTER);

		modeloAutor = new DefaultTableModel(new String[]{"NOMBRE"}, 0);
		tableAutor = new JTable(modeloAutor);
		tableAutor.getTableHeader().setReorderingAllowed(false);
		add(new JScrollPane(tableAutor),BorderLayout.SOUTH);
		init();
	}
	
	public void init(){
		setTitle(ConstantesGUI.T_TITULO_VENTANA);		
	}
	
	public int retornarIdSeleccion(){
		return Integer.parseInt((String) modeloLibro.getValueAt(tableLibro.getSelectedRow(), 0));
	}
	
	public void actualizarVentana(Libro libro, int fila){
		modeloLibro.setValueAt(libro.getId(),fila,0);
		modeloLibro.setValueAt(libro.getNombre(),fila, 1);
		modeloLibro.setValueAt(libro.getDescripcion(),fila, 2);
		modeloLibro.setValueAt(libro.getValor(),fila, 3);
		modeloLibro.setValueAt(libro.getGenero(),fila,4);
		modeloLibro.setValueAt(libro.getAutor(),fila,5);
		modeloLibro.setValueAt(libro.getCopiasVendidas(),fila,6);		
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
		if (barraHerramientasUsuario.getTxtBuscar().getText().isEmpty()) {
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
		if (barraHerramientasUsuario.getTxtBuscar().getText().isEmpty()) {
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

}
