package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controlador.Controlador;
import modelo.entidades.Libro;
/**
 * 
 * @author johnn
 *
 */
public class PanelLibrosUsuario extends JPanel{

	private static final long serialVersionUID = 1L;
	private ArrayList<PanelLibro> listaPanelLibro;
	private ArrayList<Libro> listaLibrosSeleccionados;

	public PanelLibrosUsuario(ArrayList<Libro> lista) {
		listaPanelLibro = new ArrayList<PanelLibro>();
		setLayout(new GridLayout(4,6 ));
		init(lista);
	}

	public void rellenar(ArrayList<PanelLibro> lis){
		for (PanelLibro panelLibro : lis) {
			add(panelLibro);
		}
	}

	public void init(ArrayList<Libro> lista){
		this.removeAll();
		for (Libro libro : lista) {
			listaPanelLibro.add(new PanelLibro(libro));
		}
		rellenar(listaPanelLibro);
	}

	public PanelLibrosUsuario(ArrayList<PanelLibro> lista, Controlador controlador) {
		this.listaPanelLibro = lista;
		setLayout(new GridLayout(4,6 ));
		rellenar(lista);
		this.updateUI();
		this.repaint();
	}

	public PanelLibrosUsuario() {
		setLayout(new FlowLayout());
	}

	public ArrayList<PanelLibro> listaSeleccionados(){
		ArrayList<PanelLibro> lis = new ArrayList<PanelLibro>();
		ArrayList<Libro> listalibr= new ArrayList<Libro>();
		for (PanelLibro panelLibro : listaPanelLibro) {
			if (panelLibro.isSelect()) {
				lis.add(panelLibro);
				listalibr.add(panelLibro.getLibr());
			}
		}
		setListaLibrosSeleccionados(listalibr);
		if (lis.size() == 0) {
			return null;
		}else
			return lis; 
	}

	public ArrayList<Libro> getListaLibrosSeleccionados() {
		listaSeleccionados();
		return listaLibrosSeleccionados;
	}

	public void setListaLibrosSeleccionados(ArrayList<Libro> listaLibrosSeleccionados) {
		this.listaLibrosSeleccionados = listaLibrosSeleccionados;
	}
}
