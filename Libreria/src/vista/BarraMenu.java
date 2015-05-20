package vista;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controlador.Controlador;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
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
	private JMenu menuImportarArchivo;
	private JMenu menuExportarArchivo;
	private JMenuItem itemImBinarioLibro;
	private JMenuItem itemImPlanoLibro;
	private JMenuItem itemImXmlLibro;
	private JMenuItem itemImJsonLibro;
	private JMenuItem itemExBinarioLibro;
	private JMenuItem itemExPlanoLibro;
	private JMenuItem itemExXmlLibro;
	private JMenuItem itemExJsonLibro;
	private JMenuItem itemImBinarioAutor;
	private JMenuItem itemImPlanoAutor;
	private JMenuItem itemImXmlAutor;
	private JMenuItem itemImJsonAutor;
	private JMenuItem itemExBinarioAutor;
	private JMenuItem itemExPlanoAutor;
	private JMenuItem itemExXmlAutor;
	private JMenuItem itemExJsonAutor;
	
	private JMenuItem itemImBinarioCliente;
	private JMenuItem itemImPlanoCliente;
	private JMenuItem itemImXmlCliente;
	private JMenuItem itemImJsonCliente;
	private JMenuItem itemExBinarioCliente;
	private JMenuItem itemExPlanoCliente;
	private JMenuItem itemExXmlCliente;
	private JMenuItem itemExJsonCliente;

	public BarraMenu(Controlador controlador) {
		properties = new Properties();
		cargarPropiedades(ConstantesGUI.RUTA_ARCHIVO_ENG);

		menuArchivo = new JMenu();
		menuArchivo.setMnemonic('A');
		menuArchivo.setMnemonic('F');

		itemAgregarLibro = new JMenuItem(createImageIcon("/img/addBook.png"));
		itemAgregarLibro.addActionListener(controlador);
		itemAgregarLibro.setActionCommand(Controlador.A_MOSTRAR_AGREGAR_LIBRO);
		menuArchivo.add(itemAgregarLibro);

		itemAgregarCliente = new JMenuItem(createImageIcon("/img/addClient.png"));
		itemAgregarCliente.addActionListener(controlador);
		itemAgregarCliente.setActionCommand(Controlador.A_AGREGAR_CLIENTE);
		menuArchivo.add(itemAgregarCliente);

		itemAgregarAutor = new JMenuItem(createImageIcon("/img/addAuthor.png"));
		itemAgregarAutor.addActionListener(controlador);
		itemAgregarAutor.setActionCommand(Controlador.A_MOSTRAR_AGREGAR_AUTOR);
		menuArchivo.add(itemAgregarAutor);

		itemEliminarLibro = new JMenuItem(createImageIcon("/img/deleteBook.png"));
		itemEliminarLibro.addActionListener(controlador);
		itemEliminarLibro.setActionCommand(Controlador.A_ELIMINAR_LIBRO);
		menuArchivo.add(itemEliminarLibro);

		itemEliminarCliente = new JMenuItem(createImageIcon("/img/deleteCliente.png"));
		itemEliminarCliente.addActionListener(controlador);
		itemEliminarCliente.setActionCommand(Controlador.A_ELIMINAR_CLIENTE);
		menuArchivo.add(itemEliminarCliente);

		itemEliminarAutor = new JMenuItem(createImageIcon("/img/deleteAutor.png"));
		itemEliminarAutor.addActionListener(controlador);
		itemEliminarAutor.setActionCommand(Controlador.A_ELIMINAR_AUTOR);
		menuArchivo.add(itemEliminarAutor);

		menuImportarArchivo = new JMenu();

		itemImBinarioLibro = new JMenuItem();
		itemImBinarioLibro.addActionListener(controlador);
		itemImBinarioLibro.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_BINARIO_LIBRO);
		menuImportarArchivo.add(itemImBinarioLibro);

		itemImPlanoLibro = new JMenuItem();
		itemImPlanoLibro.addActionListener(controlador);
		itemImPlanoLibro.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_PLANO_LIBRO);
		menuImportarArchivo.add(itemImPlanoLibro);

		itemImXmlLibro = new JMenuItem();
		itemImXmlLibro.addActionListener(controlador);
		itemImXmlLibro.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_XML_LIBRO);
		menuImportarArchivo.add(itemImXmlLibro);

		itemImJsonLibro = new JMenuItem();
		itemImJsonLibro.addActionListener(controlador);
		itemImJsonLibro.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_JSON_LIBRO);
		menuImportarArchivo.add(itemImJsonLibro);
		menuArchivo.add(menuImportarArchivo);

		itemImBinarioAutor = new JMenuItem();
		itemImBinarioAutor.addActionListener(controlador);
		itemImBinarioAutor.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_BINARIO_AUTOR);
		menuImportarArchivo.add(itemImBinarioAutor);

		itemImPlanoAutor = new JMenuItem();
		itemImPlanoAutor.addActionListener(controlador);
		itemImPlanoAutor.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_PLANO_AUTOR);
		menuImportarArchivo.add(itemImPlanoAutor);

		itemImXmlAutor = new JMenuItem();
		itemImXmlAutor.addActionListener(controlador);
		itemImXmlAutor.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_XML_AUTOR);
		menuImportarArchivo.add(itemImXmlAutor);

		itemImJsonAutor = new JMenuItem();
		itemImJsonAutor.addActionListener(controlador);
		itemImJsonAutor.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_JSON_AUTOR);
		menuImportarArchivo.add(itemImJsonAutor);
		
		itemImBinarioCliente = new JMenuItem();
		itemImBinarioCliente.addActionListener(controlador);
		itemImBinarioCliente.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_BINARIO_CLIENTE);
		menuImportarArchivo.add(itemImBinarioCliente);

		itemImPlanoCliente = new JMenuItem();
		itemImPlanoCliente.addActionListener(controlador);
		itemImPlanoCliente.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_PLANO_CLIENTE);
		menuImportarArchivo.add(itemImPlanoCliente);

		itemImXmlCliente = new JMenuItem();
		itemImXmlCliente.addActionListener(controlador);
		itemImXmlCliente.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_XML_CLIENTE);
		menuImportarArchivo.add(itemImXmlCliente);

		itemImJsonCliente = new JMenuItem();
		itemImJsonCliente.addActionListener(controlador);
		itemImJsonCliente.setActionCommand(Controlador.A_IMPORTAR_ARCHIVO_JSON_CLIENTE);
		menuImportarArchivo.add(itemImJsonCliente);
		
		menuArchivo.add(menuImportarArchivo);
		
		menuExportarArchivo = new JMenu();

		itemExBinarioLibro = new JMenuItem();
		itemExBinarioLibro.addActionListener(controlador);
		itemExBinarioLibro.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_BINARIO_LIBRO);
		menuExportarArchivo.add(itemExBinarioLibro);

		itemExPlanoLibro = new JMenuItem();
		itemExPlanoLibro.addActionListener(controlador);
		itemExPlanoLibro.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_PLANO_LIBRO);
		menuExportarArchivo.add(itemExPlanoLibro);

		itemExXmlLibro = new JMenuItem();
		itemExXmlLibro.addActionListener(controlador);
		itemExXmlLibro.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_XML_LIBRO);
		menuExportarArchivo.add(itemExXmlLibro);

		itemExJsonLibro = new JMenuItem();
		itemExJsonLibro.addActionListener(controlador);
		itemExJsonLibro.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_JSON_LIBRO);
		menuExportarArchivo.add(itemExJsonLibro);
		menuArchivo.add(menuExportarArchivo);
		
		itemExBinarioAutor = new JMenuItem();
		itemExBinarioAutor.addActionListener(controlador);
		itemExBinarioAutor.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_BINARIO_AUTOR);
		menuExportarArchivo.add(itemExBinarioAutor);

		itemExPlanoAutor = new JMenuItem();
		itemExPlanoAutor.addActionListener(controlador);
		itemExPlanoAutor.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_PLANO_AUTOR);
		menuExportarArchivo.add(itemExPlanoAutor);

		itemExXmlAutor = new JMenuItem();
		itemExXmlAutor.addActionListener(controlador);
		itemExXmlAutor.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_XML_AUTOR);
		menuExportarArchivo.add(itemExXmlAutor);

		itemExJsonAutor = new JMenuItem();
		itemExJsonAutor.addActionListener(controlador);
		itemExJsonAutor.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_JSON_AUTOR);
		menuExportarArchivo.add(itemExJsonAutor);
//
		itemExBinarioCliente = new JMenuItem();
		itemExBinarioCliente.addActionListener(controlador);
		itemExBinarioCliente.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_BINARIO_CLIENTE);
		menuExportarArchivo.add(itemExBinarioCliente);

		itemExPlanoCliente = new JMenuItem();
		itemExPlanoCliente.addActionListener(controlador);
		itemExPlanoCliente.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_PLANO_CLIENTE);
		menuExportarArchivo.add(itemExPlanoCliente);

		itemExXmlCliente = new JMenuItem();
		itemExXmlCliente.addActionListener(controlador);
		itemExXmlCliente.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_XML_CLIENTE);
		menuExportarArchivo.add(itemExXmlCliente);

		itemExJsonCliente = new JMenuItem();
		itemExJsonCliente.addActionListener(controlador);
		itemExJsonCliente.setActionCommand(Controlador.A_EXPORTAR_ARCHIVO_JSON_CLIENTE);
		menuExportarArchivo.add(itemExJsonCliente);
		
		menuArchivo.add(menuExportarArchivo);
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
		menuImportarArchivo.setText(properties.getProperty(ConstantesGUI.T_MENU_IMPORTAR_ARCHIVO));	
		itemImBinarioLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_BINARIO));	
		itemImPlanoLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_PLANO));
		itemImXmlLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_XML));
		itemImJsonLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_JSON));
		itemExBinarioLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_BINARIO));
		itemExPlanoLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_PLANI));
		itemExXmlLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_XML));
		itemExJsonLibro.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_JSON));
		menuExportarArchivo.setText(properties.getProperty(ConstantesGUI.T_MENU_EXPORTAR_ARCHIVO));	
		itemImBinarioAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_AUTOR));
		itemImPlanoAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_AUTOR_PL));
		itemImXmlAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_AUTOR_XM));
		itemImJsonAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_AUTOR_JS));
		itemExBinarioAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_AUTOR));
		itemExPlanoAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_AUTOR_PL));
		itemExXmlAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_AUTOR_XM));
		itemExJsonAutor.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_AUTOR_JS));
		itemImBinarioCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_CLIENTE));
		itemImPlanoCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_CLIENTE_PL));
		itemImXmlCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_CLIENTE_XM));
		itemImJsonCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_IMPORTAR_CLIENTE_JS));
		itemExBinarioCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_CLIENTE));
		itemExPlanoCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_CLIENTE_PL));
		itemExXmlCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_CLIENTE_XM));
		itemExJsonCliente.setText(properties.getProperty(ConstantesGUI.T_MENU_ITEM_EXPORTAR_CLIENTE_JS));
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
