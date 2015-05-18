package vista;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controlador.Controlador;

public class BarraMenu extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menuArchivo;
	private JMenu menuPreferencias;
	private JMenu menuAcercaDe;
	private JMenu cambiarIdioma;
	private JMenuItem menuItemIngles;
	private JMenuItem menuItemEspaniol;
	private JMenuItem itemAgregarLibro;
	private JMenuItem itemAgregarAutor;
	private JMenuItem itemAgregarCliente;
	private JMenuItem itemEliminarLibro;
	private JMenuItem itemEliminarAutor;
	private JMenuItem itemEliminarCliente;
	private Properties properties;

	public BarraMenu(Controlador controlador) {
		properties = new Properties();
		cargarPropiedades(ConstantesGUI.RUTA_ARCHIVO_ENG);
		
		menuArchivo = new JMenu();
		menuArchivo.setMnemonic('A');
		menuArchivo.setMnemonic('F');

		itemAgregarLibro = new JMenuItem();
		itemAgregarLibro.addActionListener(controlador);
		itemAgregarLibro.setActionCommand(Controlador.A_MOSTRAR_AGREGAR_LIBRO);
		menuArchivo.add(itemAgregarLibro);

		itemAgregarCliente = new JMenuItem();
		itemAgregarCliente.addActionListener(controlador);
		itemAgregarCliente.setActionCommand(Controlador.A_AGREGAR_CLIENTE);
		menuArchivo.add(itemAgregarCliente);

		itemAgregarAutor = new JMenuItem();
		itemAgregarAutor.addActionListener(controlador);
		itemAgregarAutor.setActionCommand(Controlador.A_AGREGAR_AUTOR);
		menuArchivo.add(itemAgregarAutor);

		itemEliminarLibro = new JMenuItem();
		itemEliminarLibro.addActionListener(controlador);
		itemEliminarLibro.setActionCommand(Controlador.A_ELIMINAR_LIBRO);
		menuArchivo.add(itemEliminarLibro);

		itemEliminarCliente = new JMenuItem();
		itemEliminarCliente.addActionListener(controlador);
		itemEliminarCliente.setActionCommand(Controlador.A_ELIMINAR_CLIENTE);
		menuArchivo.add(itemEliminarCliente);

		itemEliminarAutor = new JMenuItem();
		itemEliminarAutor.addActionListener(controlador);
		itemEliminarAutor.setActionCommand(Controlador.A_ELIMINAR_AUTOR);
		menuArchivo.add(itemEliminarAutor);
		
		add(menuArchivo);

		menuPreferencias= new JMenu();
		menuPreferencias.setMnemonic('P');

		cambiarIdioma  = new JMenu();
		menuItemIngles = new JMenuItem();
		menuItemIngles.addActionListener(controlador);
		menuItemIngles.setActionCommand(ConstantesGUI.C_JM_IDIOMA_INGLES);
		cambiarIdioma.add(menuItemIngles);

		menuItemEspaniol = new JMenuItem();
		menuItemEspaniol.addActionListener(controlador);
		menuItemEspaniol.setActionCommand(ConstantesGUI.C_JM_IDIOMA_ESPANIOL);
		cambiarIdioma.add(menuItemEspaniol);	

		menuPreferencias.add(cambiarIdioma);
		add(menuPreferencias);

		menuAcercaDe = new JMenu();
		menuAcercaDe.setMnemonic('A');
		add(menuAcercaDe);
		actualizarProperties();	
	}

	public void actualizarProperties(){
		menuArchivo.setText(properties.getProperty(ConstantesGUI.T_MENU_ARCHIVO));	
		itemAgregarLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_AGREGAR_LIBRO));	
		itemAgregarCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_AGREGAR_CLIENTE));	
		itemAgregarAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_AGREGAR_AUTOR));	
		itemEliminarLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_ELIMINAR_LIBRO));	
		itemEliminarCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_ELIMINAR_CLIENTE));	
		itemEliminarAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_ELIMINAR_AUTOR));	
		menuPreferencias.setText(properties.getProperty(ConstantesGUI.T_MENU_PREFERENCIAS));
		cambiarIdioma.setText(properties.getProperty(ConstantesGUI.T_MENU_CAMBIAR_IDIOMA));
		menuItemIngles.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_INGLES));	
		menuItemEspaniol.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_ESPANIOL));
		menuAcercaDe.setText(properties.getProperty(ConstantesGUI.T_MENU_ACERCA_DE));	
	}

	public void cargarPropiedades(String archivo){
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivo);		
		if(inputStream != null){
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
