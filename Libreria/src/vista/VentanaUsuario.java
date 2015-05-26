package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

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
	private PanelLibrosUsuario panelLibrosUsuario;
	private PanelOpcionesUsuario panelOpcionesUsuario;
	private Controlador controlador;
	
	public VentanaUsuario(Controlador controlador) {
		this.controlador = controlador;
		setIconImage(Util.createImageIcon(ConstantesGUI.I_ICONO_VENTANA).getImage());
		setLayout(new BorderLayout());
		setSize(ConstantesGUI.VENTANA_ANCHO,ConstantesGUI.VENTANA_ALTO);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panelOpcionesUsuario = new PanelOpcionesUsuario(controlador);
		add(panelOpcionesUsuario , BorderLayout.WEST);
		
		panelLibrosUsuario = new PanelLibrosUsuario(this);
		add(panelLibrosUsuario , BorderLayout.CENTER);
		
		barraHerramientasUsuario = new BarraHerramientasUsuario(controlador);
		add(barraHerramientasUsuario, BorderLayout.PAGE_START);

	}
	
	public void init(){
		setTitle(ConstantesGUI.T_TITULO_VENTANA);		
	}

	public ArrayList<Libro> getListaLibros() {
		return controlador.getListaLibros();
	}
}
