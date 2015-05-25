package vista;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.dao.GestorLibro;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class JPanelImage extends JPanel{

	private static final long serialVersionUID = 1L;
	private GestorLibro gestorLibro;
	private String rutaImagen;
	private DialogoLibro dialogoLibro;
	private DialogoAutor dialogoAutor;


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(new ImageIcon(rutaImagen).getImage() ,0, 0, this);		
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			return null;
		}
	}

	public GestorLibro getGestorLibro() {
		return gestorLibro;
	}

	public void setGestorLibro(GestorLibro gestorLibro) {
		this.gestorLibro = gestorLibro;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public DialogoLibro getDialogoLibro() {
		return dialogoLibro;
	}

	public void setDialogoLibro(DialogoLibro dialogoLibro) {
		this.dialogoLibro = dialogoLibro;
	}
}