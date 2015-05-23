package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JCheckBox;

import persistencia.ArchivoBinarioAutor;
import persistencia.ArchivoBinarioCliente;
import persistencia.ArchivoBinarioLibro;
import persistencia.ArchivoJsonAutor;
import persistencia.ArchivoJsonCliente;
import persistencia.ArchivoJsonLibro;
import persistencia.ArchivoPlanoAutor;
import persistencia.ArchivoPlanoCliente;
import persistencia.ArchivoPlanoLibro;
import persistencia.ArchivoXmlAutor;
import persistencia.ArchivoXmlCliente;
import persistencia.ArchivoXmlLibro;
import modelo.dao.GestorAutor;
import modelo.dao.GestorCliente;
import modelo.dao.GestorLibro;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
import modelo.excepciones.ExcepcionAutorNoEncontrado;
import modelo.excepciones.ExcepcionClienteNoEncontrado;
import modelo.excepciones.ExcepcionLibroNoEncontrado;
import vista.BarraMenu;
import vista.ConstantesGUI;
import vista.DialogoAutor;
import vista.DialogoCliente;
import vista.DialogoEditar;
import vista.DialogoEditarAutor;
import vista.DialogoLibro;
import vista.JDialogoPrincipal;
import vista.VentanaPrincipal;
import vista.VentanaUsuario;
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
	public static final String A_MOSTRAR_DIALOGO_EDITAR_LIBRO="Editar Dialogo";
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
	public static final String A_MOSTRAR_AGREGAR_AUTOR = "mostrar autor";
	public static final String A_MOSTRAR_CANCELAR_AUTOR = "cancelar autor";
	public  static final String A_MOSTRAR_DIALOGO_EDITAR_AUTOR = "mostar editar autor";
	public static final String A_CREAR_IMAGEN_AUTOR ="Crear Autor";
	public static final String A_IMPORTAR_ARCHIVO_BINARIO_AUTOR = "binario autor";
	public static final String A_IMPORTAR_ARCHIVO_PLANO_AUTOR = "plano autor";
	public static final String A_IMPORTAR_ARCHIVO_XML_AUTOR = "xml autor";
	public static final String A_IMPORTAR_ARCHIVO_JSON_AUTOR = "json autor";
	public static final String A_EXPORTAR_ARCHIVO_BINARIO_AUTOR = "ex binario autor";
	public static final String A_EXPORTAR_ARCHIVO_PLANO_AUTOR = "ex plano autor";
	public static final String A_EXPORTAR_ARCHIVO_XML_AUTOR = "ex xml autor";
	public static final String A_EXPORTAR_ARCHIVO_JSON_AUTOR = "ex json autor";

	public static final String A_IMPORTAR_ARCHIVO_BINARIO_CLIENTE = "Binario Cliente";
	public static final String A_IMPORTAR_ARCHIVO_PLANO_CLIENTE = "Plano Cliente";
	public static final String A_IMPORTAR_ARCHIVO_XML_CLIENTE = "Xml Cliente";
	public static final String A_IMPORTAR_ARCHIVO_JSON_CLIENTE = "Json Cliente";
	public static final String A_EXPORTAR_ARCHIVO_BINARIO_CLIENTE = "Ex Binario Cliente";
	public static final String A_EXPORTAR_ARCHIVO_PLANO_CLIENTE = "Ex Plano Cliente";
	public static final String A_EXPORTAR_ARCHIVO_XML_CLIENTE = "Ex Xml Cliente";
	public static final String A_EXPORTAR_ARCHIVO_JSON_CLIENTE = "Ex Json Cliente";
	private int j;
	private JCheckBox posicion ;
	private BarraMenu barraMenu;
	private ConstantesGUI constantesGUI;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaUsuario ventanaUsuario;
	private GestorAutor gestorAutor;
	private GestorCliente gestorCliente;
	private GestorLibro gestorLibro;
	private Libro libro;
	private Autor autor;
	private Cliente cliente;
	private DialogoLibro dialogoLibro;
	private DialogoEditar dialogoEditar;
	private DialogoCliente dialogoCliente;
	private DialogoAutor dialogoAutor;
	private DialogoEditarAutor dialogoEditarAutor;
	private JDialogoPrincipal dialogoPrincipal;

	public Controlador() {
		gestorAutor = new GestorAutor();
		gestorCliente = new GestorCliente();
		gestorLibro = new GestorLibro();
		ventanaPrincipal = new VentanaPrincipal(this);
		ventanaUsuario = new VentanaUsuario(this);
		dialogoLibro = new DialogoLibro(ventanaPrincipal, this);
		dialogoCliente = new DialogoCliente(ventanaPrincipal, this);
		dialogoEditar = new DialogoEditar(ventanaPrincipal, this);
		dialogoEditarAutor = new DialogoEditarAutor(ventanaPrincipal, this);
		dialogoAutor = new DialogoAutor(ventanaPrincipal, this);
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
		case A_MOSTRAR_AGREGAR_AUTOR:
			dialogoAutor.setVisible(true);
			break;
		case A_AGREGAR_CLIENTE:
			agregarCliente();
			dialogoCliente.eliminarDatosTableCliente();		
			break;
		case A_AGREGAR_LIBRO:
			agregarLibro();
			dialogoLibro.eliminarDatosTabla();
			break;
		case A_AGREGAR_AUTOR:
			agregarAutor();
			dialogoAutor.eliminarDatosTablaAutor();
			break;
		case A_MOSTRAR_CANCELAR_LIBRO:
			dialogoLibro.setVisible(false);
			break; 

		case A_MOSTRAR_CANCELAR_AUTOR:
			dialogoAutor.setVisible(false);
			break;
		case A_ELIMINAR_LIBRO:
			try {
				borrarLibro();
			} catch (ExcepcionLibroNoEncontrado e1) {

				e1.printStackTrace();
			}
			dialogoLibro.eliminarDatosTabla();
			break;
		case A_ELIMINAR_AUTOR:
			try {
				borrarAutor();
			} catch (ExcepcionAutorNoEncontrado e1) {

				e1.printStackTrace();
			}
			dialogoAutor.eliminarDatosTablaAutor();
			break;
		case A_CREAR_IMAGEN:
			dialogoLibro.importarImagen();
			break;
		case A_CREAR_IMAGEN_AUTOR:
			dialogoAutor.importarImagenAutor();
			break;
		case A_MOSTRAR_DIALOGO_EDITAR_LIBRO:
			dialogoEditar.cambiarValores(buscarId(ventanaPrincipal.retornarIdSeleccion()));
			dialogoEditar.setVisible(true);
			break;
		case A_MOSTRAR_DIALOGO_EDITAR_AUTOR:
			dialogoEditarAutor.cambiarValores(buscarIdAutor(ventanaPrincipal.retornarIdSeleccionAutor()));
			dialogoEditarAutor.setVisible(true);
			break;
		case A_EDITAR_LIBRO:
			editarLibro();
			break;
		case A_EDITAR_AUTOR:
			editarAutor();
			break;
		case A_BUSCAR_LIBRO:
			try {
				buscar();
			} catch (ExcepcionLibroNoEncontrado e1) {
				e1.printStackTrace();
			}
			break;
		case A_BUSCAR_AUTOR:
			try {
				buscarAutor();
			} catch (ExcepcionAutorNoEncontrado e1) {
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
			ventanaUsuario.setVisible(true);
			break;
		case A_IMPORTAR_ARCHIVO_BINARIO_AUTOR:
			agregarAutor(ArchivoBinarioAutor.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_BINARIO_AUTOR:
			ArchivoBinarioAutor.guardarArchivo(buscarIdAutor(ventanaPrincipal.retornarIdSeleccionAutor()));
			break;
		case A_IMPORTAR_ARCHIVO_PLANO_AUTOR:
			agregarAutor(ArchivoPlanoAutor.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_PLANO_AUTOR:
			ArchivoPlanoAutor.guardarArchivo(buscarIdAutor(ventanaPrincipal.retornarIdSeleccionAutor()));
			break;
		case A_IMPORTAR_ARCHIVO_XML_AUTOR:
			agregarAutor(ArchivoXmlAutor.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_XML_AUTOR:
			ArchivoXmlAutor.guardarArchivo(buscarIdAutor(ventanaPrincipal.retornarIdSeleccionAutor()));
			break;
		case A_IMPORTAR_ARCHIVO_JSON_AUTOR:
			agregarAutor(ArchivoJsonAutor.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_JSON_AUTOR:
			ArchivoJsonAutor.guardarArchivoJson(buscarIdAutor(ventanaPrincipal.retornarIdSeleccionAutor()));
			break;
		case A_EXPORTAR_ARCHIVO_BINARIO_CLIENTE:
			ArchivoBinarioCliente.guardarArchivo(buscarIdCliente(ventanaPrincipal.retornarIdSeleccionCliente()));
			break;
		case A_IMPORTAR_ARCHIVO_BINARIO_CLIENTE:
			agregarCliente(ArchivoBinarioCliente.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_PLANO_CLIENTE:
			ArchivoPlanoCliente.guardarArchivo(buscarIdCliente(ventanaPrincipal.retornarIdSeleccionCliente()));
			break;
		case A_IMPORTAR_ARCHIVO_PLANO_CLIENTE:
			agregarCliente(ArchivoPlanoCliente.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_XML_CLIENTE:
			ArchivoXmlCliente.guardarXml(buscarIdCliente(ventanaPrincipal.retornarIdSeleccionCliente()));
			break;
		case A_IMPORTAR_ARCHIVO_XML_CLIENTE:
			agregarCliente(ArchivoXmlCliente.abrirArchivo());
			break;
		case A_EXPORTAR_ARCHIVO_JSON_CLIENTE:
			ArchivoJsonCliente.guardarArchivoJson(buscarIdCliente(ventanaPrincipal.retornarIdSeleccionCliente()));
			break;
		case A_IMPORTAR_ARCHIVO_JSON_CLIENTE:
			agregarCliente(ArchivoJsonCliente.abrirArchivo());
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

	public void agregarCliente(Cliente Cliente){
		if (libro != null) {
			gestorCliente.agregarCliente(cliente);
			ventanaPrincipal.agregarCliente(cliente);
		}
	}
	public void agregarAutor(Autor autor){
		if (autor != null) {
			gestorAutor.agregarAutor(autor);
			ventanaPrincipal.agregarAutor(autor);
		}
	}
	// no idea
	public void agregarAutor(){
		Autor autor =dialogoAutor.crearAutor();
		if (autor != null) {
			gestorAutor.agregarAutor(autor);
			ventanaPrincipal.agregarAutor(autor);
			agrgegarAutoraChecKBox();

		}
	}
	public void agrgegarAutoraChecKBox() {
		dialogoLibro.getBoxAutor().removeAllItems();
		dialogoEditar.getBoxAutor().removeAllItems();
		for (int i = 0; i < gestorAutor.getListaAutor().size(); i++) {
			dialogoLibro.getBoxAutor().addItem(gestorAutor.getListaAutor().get(i).getNombre());
			dialogoEditar.getBoxAutor().addItem(gestorAutor.getListaAutor().get(i).getNombre());
		}
	}
	public void borrarLibro() throws ExcepcionLibroNoEncontrado{
		int id = ventanaPrincipal.eliminarLibro();
		gestorLibro.eliminarLibro(gestorLibro.buscarLibro(id));
	}

	public void borrarAutor() throws ExcepcionAutorNoEncontrado{
		int id = ventanaPrincipal.eliminarAutor();
		gestorAutor.eliminarAutor(gestorAutor.buscarAutor(id));
	}

	public void editarLibro(){
		try {
			dialogoEditar.editar(buscarId(ventanaPrincipal.retornarIdSeleccion()));
			ventanaPrincipal.actualizarVentana(buscarId(ventanaPrincipal.retornarIdSeleccion()), ventanaPrincipal.retornarIdSeleccion());
		} catch (Exception e) {
		}
	}

	public void editarAutor(){
		try {
			dialogoEditarAutor.editarAutor(buscarIdAutor(ventanaPrincipal.retornarIdSeleccionAutor()));
			ventanaPrincipal.actualizarVentanaAutor(buscarIdAutor(ventanaPrincipal.retornarIdSeleccionAutor()), ventanaPrincipal.retornarIdSeleccionAutor());
			agrgegarAutoraChecKBox();
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

	public Cliente buscarIdCliente(int id){
		try {
			return gestorCliente.buscarCliente(id);
		} catch (ExcepcionClienteNoEncontrado e) {
			e.printStackTrace();
		}
		return null;
	}

	public Autor buscarIdAutor(int id){
		try {
			return gestorAutor.buscarAutor(id);
		} catch (ExcepcionAutorNoEncontrado e) {
			e.printStackTrace();
		}
		return null;
	}

	public void buscar() throws ExcepcionLibroNoEncontrado{
		if (ventanaPrincipal.getBarraHerramientas().getJrBtnId().isSelected()) {
			buscarLibroId();
		}else if (ventanaPrincipal.getBarraHerramientas().getJrBtnNombre().isSelected()) {
			buscarLibroNombre();
		}
	}

	public void buscarLibroId() throws ExcepcionLibroNoEncontrado{
		gestorLibro.buscarLibro(Integer.parseInt(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText()));
		ventanaPrincipal.buscarLibroId(Integer.parseInt(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText()));
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
	}

	public void buscarLibroNombre() throws ExcepcionLibroNoEncontrado{
		gestorLibro.buscarLibro(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.buscarLibroNombre(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
	}

	public void buscarAutor() throws ExcepcionAutorNoEncontrado{
		if (ventanaPrincipal.getBarraHerramientas().getJrBtnIdAutor().isSelected()) {
			buscarAutorId();
		}else if (ventanaPrincipal.getBarraHerramientas().getJrBtnNombreAutor().isSelected()) {
			buscarAutorNombre();
		}
	}

	public void buscarAutorId() throws ExcepcionAutorNoEncontrado{
		gestorAutor.buscarAutor(Integer.parseInt(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText()));
		ventanaPrincipal.buscarAutorId(Integer.parseInt(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText()));
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
	}

	public void buscarAutorNombre() throws ExcepcionAutorNoEncontrado{
		gestorAutor.buscarAutor(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.buscarAutorNombre(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
	}


	public static void main(String[] args) {
		Controlador controlador = new Controlador();
	}

	public GestorAutor getGestorAutor() {
		return gestorAutor;
	}

	public GestorCliente getGestorCliente() {
		return gestorCliente;
	}

	public GestorLibro getGestorLibro() {
		return gestorLibro;
	}


}
