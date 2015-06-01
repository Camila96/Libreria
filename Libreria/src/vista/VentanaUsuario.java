package vista;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;
import modelo.entidades.Libro;
import modelos.util.Util;
/**
 * 
 * @author johnn
 *
 */
public class VentanaUsuario  extends JFrame{

	private static final long serialVersionUID = 1L;
	private BarraHerramientasUsuario barraHerramientasUsuario;
	private PanelLibrosUsuario panelLibrosUsuario = null;
	private PanelOpcionesUsuario panelOpcionesUsuario;
	private Controlador controlador;

	public VentanaUsuario(final Controlador controlador) {
		this.controlador = controlador;
		setTitle(ConstantesGUI.T_TITULO_VENTANA_CLIENTE);	
		setIconImage(Util.createImageIcon(ConstantesGUI.I_ICONO_VENTANA).getImage());
		setLayout(new BorderLayout());
		setSize(ConstantesGUI.VENTANA_ANCHO,ConstantesGUI.VENTANA_ALTO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent e){ controlador.mostrarVentanaInicial(); } });


		panelOpcionesUsuario = new PanelOpcionesUsuario(controlador);
		add(panelOpcionesUsuario , BorderLayout.WEST);

		agregarPanel();

		barraHerramientasUsuario = new BarraHerramientasUsuario(controlador);
		add(barraHerramientasUsuario, BorderLayout.PAGE_START);

	}

	public void init(){
		setTitle(ConstantesGUI.T_TITULO_VENTANA);
	}

	@SuppressWarnings("deprecation")
	public void agregarPanel(ArrayList<PanelLibro> lis){
		if (lis == null) {
			this.remove(panelLibrosUsuario);
			panelLibrosUsuario = new PanelLibrosUsuario();
			panelLibrosUsuario.add(new JLabel("No tienes libros seleccionados para la compra                                      "));
			add(panelLibrosUsuario , BorderLayout.CENTER);
			panelOpcionesUsuario.comprar.setEnabled(false);
		}else{
			this.remove(panelLibrosUsuario);
			panelLibrosUsuario = new PanelLibrosUsuario(lis , controlador);
			add(panelLibrosUsuario , BorderLayout.CENTER);
			panelOpcionesUsuario.comprar.setEnabled(true);
		}
		this.resize(ConstantesGUI.VENTANA_ANCHO-1,ConstantesGUI.VENTANA_ALTO-2);
	}

	@SuppressWarnings("deprecation")
	public void agregarPanel(){
		if (panelLibrosUsuario != null) {
			this.remove(panelLibrosUsuario);
		}
		panelLibrosUsuario = new PanelLibrosUsuario(getListaLibros());
		add(panelLibrosUsuario , BorderLayout.CENTER);
		this.resize(ConstantesGUI.VENTANA_ANCHO,ConstantesGUI.VENTANA_ALTO);
		panelOpcionesUsuario.comprar.setEnabled(false);
	}

	@SuppressWarnings("deprecation")
	public void agregarPanelColeccion(ArrayList<Libro> lista ){
		if (panelLibrosUsuario != null) {
			this.remove(panelLibrosUsuario);
		}
		if (lista == null) {
			panelLibrosUsuario = new PanelLibrosUsuario();
			panelLibrosUsuario.add(new JLabel("No tienes libros en tu coleccion                                    "));
			add(panelLibrosUsuario , BorderLayout.CENTER);
			panelOpcionesUsuario.comprar.setEnabled(false);
		}else{
			panelLibrosUsuario = new PanelLibrosUsuario(lista);
			add(panelLibrosUsuario , BorderLayout.CENTER);
		}
		this.resize(ConstantesGUI.VENTANA_ANCHO-2,ConstantesGUI.VENTANA_ALTO-1);
		panelOpcionesUsuario.comprar.setEnabled(false);
	}

	public ArrayList<PanelLibro> getListaLibros(String s) {
		return panelLibrosUsuario.listaSeleccionados();
	}

	public ArrayList<Libro> getListaLibros() {
		return controlador.getListaLibros();
	}

	public ArrayList<Libro> getListaLibrosSeleccionados(){
		return panelLibrosUsuario.getListaLibrosSeleccionados();
	}
}
