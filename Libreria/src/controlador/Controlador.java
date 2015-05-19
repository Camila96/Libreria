package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistencia.ArchivoBinarioLibro;
import persistencia.ArchivoJsonLibro;
import persistencia.ArchivoPlanoLibro;
import persistencia.ArchivoXmlLibro;
import modelo.dao.GestorAutor;
import modelo.dao.GestorCliente;
import modelo.dao.GestorLibro;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
import modelo.excepciones.ExcepcionLibroNoEncontrado;
import vista.BarraMenu;
import vista.ConstantesGUI;
import vista.DialogoCliente;
import vista.DialogoEditar;
import vista.DialogoLibro;
import vista.JDialogoPrincipal;
import vista.VentanaPrincipal;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class Controlador implements ActionListener {

	public static final String A_AGREGAR_LIBRO = "agregar libro";
	public static final String A_AGREGAR_CLIENTE = "agregar cliente";
	public static final String A_AGREGAR_AUTOR = "agregar autor";
	public static final String A_ELIMINAR_LIBRO = "eliminar libro";
	public static final String A_ELIMINAR_CLIENTE = "eliminar cliente";
	public static final String A_ELIMINAR_AUTOR = "eliminar autor";
	public static final String A_EDITAR_LIBRO  = "editar libro";
	public static final String A_EDITAR_CLIENTE  = "editar cliente";
	public static final String A_EDITAR_AUTOR  = "editar autor";
	public static final String A_BUSCAR_LIBRO = "buscar libro";
	public static final String A_BUSCAR_CLIENTE = "buscar cliente";
	public static final String A_BUSCAR_AUTOR = "buscar autor";
	public static final String A_MOSTRAR_AGREGAR_LIBRO="mostrar libro";
	public static final String A_MOSTRAR_CANCELAR_LIBRO = "mostrar cancelar sitio";
	public static final String A_CREAR_IMAGEN = "crear imagen";
	public static final String A_MOSTRAR_DIALOGO_EDITAR_SITIO="Editar Dialogo";
	public static final String A_MOSTRAR_CANCELAR_CLIENTE = "Mostrar agregar Cliente";
	public static final String A_MOSTRAR_AGREGAR_CLIENTE = "Mostrar Agregar Cliente";
	public static final String A_IMPORTAR_ARCHIVO_BINARIO_LIBRO = "importar binario";
	public static final String A_IMPORTAR_ARCHIVO_PLANO_LIBRO = "Importar Plano";
	public static final String A_IMPORTAR_ARCHIVO_XML_LIBRO = "Importar Xml";
	public static final String A_IMPORTAR_ARCHIVO_JSON_LIBRO = "Importar Json";
	public static final String A_EXPORTAR_ARCHIVO_BINARIO_LIBRO = "Exportar Binario";
	public static final String A_EXPORTAR_ARCHIVO_PLANO_LIBRO = "Exportar Plano";
	public static final String A_EXPORTAR_ARCHIVO_XML_LIBRO = "exportar xml";
	public static final String A_EXPORTAR_ARCHIVO_JSON_LIBRO = "exportar json";
	public static final String A_AGREGAR_ADMINISTRADOR = "administrador";
	public static final String A_MOSTRAR_USUARIO = "usuario";

	private BarraMenu barraMenu;
	private ConstantesGUI constantesGUI;
	private VentanaPrincipal ventanaPrincipal;
	private GestorAutor gestorAutor;
	private GestorCliente gestorCliente;
	private GestorLibro gestorLibro;
	private Libro libro;
	private Autor autor;
	private Cliente cliente;
	private DialogoLibro dialogoLibro;
	private DialogoEditar dialogoEditar;
	private DialogoCliente dialogoCliente;
	private JDialogoPrincipal dialogoPrincipal;

	public Controlador() {
		gestorAutor = new GestorAutor();
		gestorCliente = new GestorCliente();
		gestorLibro = new GestorLibro();
		ventanaPrincipal = new VentanaPrincipal(this);
		dialogoLibro = new DialogoLibro(ventanaPrincipal, this);
		dialogoCliente = new DialogoCliente(ventanaPrincipal, this);
		dialogoEditar = new DialogoEditar(ventanaPrincipal, this);
		dialogoPrincipal = new JDialogoPrincipal(this);
		dialogoPrincipal.setVisible(true);
//		ventanaPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		
		case A_MOSTRAR_AGREGAR_LIBRO:
			dialogoLibro.setVisible(true);
			break;

		case A_MOSTRAR_AGREGAR_CLIENTE:
			dialogoCliente.setVisible(true);
			break;
		case A_AGREGAR_CLIENTE:
			agregarCliente();
			dialogoCliente.eliminarDatosTableCliente();
			
			
			break;

		case A_AGREGAR_LIBRO:
			agregarLibro();
			dialogoLibro.eliminarDatosTabla();
			break;
		case A_MOSTRAR_CANCELAR_LIBRO:
			dialogoLibro.setVisible(false);
			break; 

		case A_ELIMINAR_LIBRO:
			try {
				borrarSitio();
			} catch (ExcepcionLibroNoEncontrado e1) {

				e1.printStackTrace();
			}
			dialogoLibro.eliminarDatosTabla();
			break;
		case A_CREAR_IMAGEN:
			dialogoLibro.importarImagen();
			break;
		case A_MOSTRAR_DIALOGO_EDITAR_SITIO:
			dialogoEditar.cambiarValores(buscarId(ventanaPrincipal.retornarIdSeleccion()));
			dialogoEditar.setVisible(true);
			break;
		case A_EDITAR_LIBRO:
			editarSitio();
			break;
		case A_BUSCAR_LIBRO:
			try {
				buscar();
			} catch (ExcepcionLibroNoEncontrado e1) {
				e1.printStackTrace();
			}
			break;
		case ConstantesGUI.C_JM_IDIOMA_INGLES:
			ventanaPrincipal.getBarraMenu().cargarPropiedades(constantesGUI.RUTA_ARCHIVO_ENG);
			ventanaPrincipal.getBarraMenu().actualizarProperties();
			break;
		case ConstantesGUI.C_JM_IDIOMA_ESPANIOL:
			ventanaPrincipal.getBarraMenu().cargarPropiedades(constantesGUI.RUTA_ARCHIVO_ESP);
			ventanaPrincipal.getBarraMenu().actualizarProperties();	
			break;
		case A_IMPORTAR_ARCHIVO_BINARIO_LIBRO:
			agregarLibro(ArchivoBinarioLibro.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_BINARIO_LIBRO:
			ArchivoBinarioLibro.guardarArchivo(buscarId(ventanaPrincipal.retornarIdSeleccion()));
			break;
		case A_IMPORTAR_ARCHIVO_PLANO_LIBRO:
			agregarLibro(ArchivoPlanoLibro.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_PLANO_LIBRO:
			ArchivoPlanoLibro.guardarArchivo(buscarId(ventanaPrincipal.retornarIdSeleccion()));
			break;
		case A_IMPORTAR_ARCHIVO_XML_LIBRO:
			agregarLibro(ArchivoXmlLibro.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_XML_LIBRO:
			ArchivoXmlLibro.guardarArchivo(buscarId(ventanaPrincipal.retornarIdSeleccion()));
			break;
		case A_IMPORTAR_ARCHIVO_JSON_LIBRO:
			agregarLibro(ArchivoJsonLibro.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_JSON_LIBRO:
			ArchivoJsonLibro.guardarArchivoJson(buscarId(ventanaPrincipal.retornarIdSeleccion()));
			break;
		case A_AGREGAR_ADMINISTRADOR:
			ventanaPrincipal.setVisible(true);
			break;
		case A_MOSTRAR_USUARIO:
			ventanaPrincipal.setVisible(true);
			break;
		default:
			break;
		}
	}

	public void agregarLibro(Libro libro){
		if (libro != null) {
			gestorLibro.agregarLibro(libro);
			ventanaPrincipal.agregarLibro(libro);
		}
	}

	public void agregarLibro(){
		Libro libro =dialogoLibro.crearLibro();
		if (libro != null) {
			gestorLibro.agregarLibro(libro);
			ventanaPrincipal.agregarLibro(libro);
		}
	}

	public void agregarCliente(){
		Cliente cliente = dialogoCliente.crearCliente();
		if (cliente != null){
			gestorCliente.agregarCliente(cliente);
			ventanaPrincipal.agregarCliente(cliente);
		}
	}

	public void borrarSitio() throws ExcepcionLibroNoEncontrado{
		int id = ventanaPrincipal.eliminarSitio();
		gestorLibro.eliminarLibro(gestorLibro.buscarLibro(id));
	}

	public void editarSitio(){
		try {
			dialogoEditar.editar(buscarId(ventanaPrincipal.retornarIdSeleccion()));
			ventanaPrincipal.actualizarVentana(buscarId(ventanaPrincipal.retornarIdSeleccion()), ventanaPrincipal.retornarIdSeleccion());
		} catch (Exception e) {
		}
	}

	public Libro buscarId(int id){
		try {
			return gestorLibro.buscarLibro(id);
		} catch (ExcepcionLibroNoEncontrado e) {
			e.printStackTrace();
		}
		return null;
	}

	public void buscar() throws ExcepcionLibroNoEncontrado{
		if (ventanaPrincipal.getBarraHerramientas().getJrBtnId().isSelected()) {
			buscarSitioId();
		}else if (ventanaPrincipal.getBarraHerramientas().getJrBtnNombre().isSelected()) {
			buscarSitioNombre();
		}
	}

	public void buscarSitioId() throws ExcepcionLibroNoEncontrado{
		gestorLibro.buscarLibro(Integer.parseInt(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText()));
		ventanaPrincipal.buscarLibroId(Integer.parseInt(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText()));
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
	}

	public void buscarSitioNombre() throws ExcepcionLibroNoEncontrado{
		gestorLibro.buscarLibro(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.buscarLibroNombre(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
	}

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
	}
}
