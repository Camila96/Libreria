package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelos.util.Util;
/**
 * 
 * @author johnn
 *
 */
public class PanelImagen extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private String ruta;
	
	public PanelImagen(String ruta) {
		this.ruta = ruta;
	}
	
	public boolean existeImagen(){
		String dir ="src"+ruta;
		File fichero = new File(dir);
		if (fichero.exists()) {
			return true;
		}else 
			return false;
	}
	
	@Override
	public void paint(Graphics g) {
		if (existeImagen()) {
			Dimension tam= getSize();
			ImageIcon imagen = Util.createImageIcon(ruta);
			g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
		}
	}
}
