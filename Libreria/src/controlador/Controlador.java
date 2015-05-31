package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import persistencia.XmlAutor;
import persistencia.XmlCliente;
import persistencia.XmlLibro;
import modelo.dao.GestorAutor;
import modelo.dao.GestorCliente;
import modelo.dao.GestorLibro;
import modelo.entidades.Autor;
import modelo.entidades.Cliente;
import modelo.entidades.Libro;
import modelo.excepciones.ExcepcionAutorNoEncontrado;
import modelo.excepciones.ExcepcionClienteNoEncontrado;
import modelo.excepciones.ExcepcionLibroNoEncontrado;
import vista.ConstantesGUI;
import vista.DialogoAutor;
import vista.DialogoCliente;
import vista.DialogoEditar;
import vista.DialogoEditarAutor;
import vista.DialogoEditarCliente;
import vista.DialogoIniciarSesion;
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
	public static final String A_MOSTRAR_AGREGAR_LIBRO="mostrar libro";
	public static final String A_MOSTRAR_CANCELAR_LIBRO = "mostrar cancelar sitio";
	public static final String A_CREAR_IMAGEN = "crear imagen";
	public static final String A_MOSTRAR_DIALOGO_EDITAR_LIBRO="Editar Dialogo";
	public static final String A_MOSTRAR_CANCELAR_CLIENTE = "Mostrar agregar Cliente";
	public static final String A_MOSTRAR_AGREGAR_CLIENTE = "Mostrar Agregar Cliente";
	public static final String A_IMPORTAR_ARCHIVO_XML_LIBRO = "Importar Xml";
	public static final String A_EXPORTAR_ARCHIVO_XML_LIBRO = "exportar xml";
	public static final String A_AGREGAR_ADMINISTRADOR = "Administrador";
	public static final String A_MOSTRAR_USUARIO = "Usuario";
	public static final String A_MOSTRAR_AGREGAR_AUTOR = "mostrar autor";
	public static final String A_MOSTRAR_CANCELAR_AUTOR = "cancelar autor";
	public  static final String A_MOSTRAR_DIALOGO_EDITAR_AUTOR = "mostar editar autor";
	public static final String A_CREAR_IMAGEN_AUTOR ="Crear Autor";
	public static final String A_IMPORTAR_ARCHIVO_XML_AUTOR = "xml autor";
	public static final String A_EXPORTAR_ARCHIVO_XML_AUTOR = "ex xml autor";
	public static final String A_IMPORTAR_ARCHIVO_XML_CLIENTE = "Xml Cliente";
	public static final String A_EXPORTAR_ARCHIVO_XML_CLIENTE = "Ex Xml Cliente";
	public  static final String GUARDAR_ARRAY_LIBROS = "guardar xml";
	public static final String A_MOSTRAR_COLECCION = "mostrar coleccion Usuario";
	public static final String A_MOSTRAR_LIBROS_A_COMPRAR = "mostrar libros seleccionados para la compra";
	public static final String GUARDAR_ARRAY_AUTOR = "xmlautor";
	public static final String A_CANCELAR_INCIO_SESION = "cancelar incio de sesion";
	public static final String A_INICIAR_SESION = "Iniciar sesion";
	public static final String A_BUSCAR = "buscar";
	public static final String RUTA_CLIENTE = "src/data/arrayClientes.xml";
	public static final String RUTA_AUTOR = "src/data/arrayAutor.xml";
	public static final String RUTA_LIBRO = "src/data/arraylibros.xml";
	public static final String A_CREAR_IMAGEN_CLIENTE = "CLIENTE";
	public static final String A_MOSTRAR_EDITAR_CLIENTE = "EDITAR CLIENTE";
	public static final String A_CREAR_IMAGEN_EDITAR_CLIENTE = "IMAGEN CLIENTE";
	private VentanaPrincipal ventanaPrincipal;
	private VentanaUsuario ventanaUsuario;
	private GestorAutor gestorAutor;
	private GestorCliente gestorCliente;
	private GestorLibro gestorLibro;
	private Libro libro;
	private Cliente cliente;
	private DialogoLibro dialogoLibro;
	private DialogoEditar dialogoEditar;
	private DialogoCliente dialogoCliente;
	private DialogoAutor dialogoAutor;
	private DialogoEditarAutor dialogoEditarAutor;
	private JDialogoPrincipal dialogoPrincipal;
	private DialogoIniciarSesion dialogoIniciarSesion;
	private DialogoEditarCliente dialogoEditarCliente;

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
		dialogoIniciarSesion = new DialogoIniciarSesion(dialogoPrincipal, this);
		dialogoEditarCliente = new DialogoEditarCliente(ventanaPrincipal, this);
		gestorCliente.setListaCliente(XmlCliente.leerXML(RUTA_CLIENTE));
		gestorAutor.setListaAutor(XmlAutor.leerXML(RUTA_AUTOR));
		gestorLibro.setListaLibro(XmlLibro.leerXML(RUTA_LIBRO));
		inicializaDatos();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {


		case A_MOSTRAR_AGREGAR_LIBRO:
			dialogoLibro.setVisible(true);
			break;
		case A_ELIMINAR_CLIENTE:
			try {
				borrarCliente();
			} catch (ExcepcionAutorNoEncontrado e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			break;
		case GUARDAR_ARRAY_LIBROS:
			XmlLibro.EscribirXML(gestorLibro.getListaLibro(), RUTA_LIBRO);
			break;

		case GUARDAR_ARRAY_AUTOR:
			XmlAutor.EscribirXML(gestorAutor.getListaAutor(),RUTA_AUTOR);
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
			dialogoAutor.setVisible(false);
			dialogoCliente.setVisible(false);
			dialogoEditar.setVisible(false);
			break; 

		case A_MOSTRAR_CANCELAR_AUTOR:
			dialogoAutor.setVisible(false);
			dialogoEditarAutor.setVisible(false);
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
		case A_CREAR_IMAGEN_CLIENTE:
			dialogoCliente.importarImagen();
			break;
		case A_CREAR_IMAGEN_AUTOR:
			dialogoAutor.importarImagenAutor();
			break;
		case A_CREAR_IMAGEN_EDITAR_CLIENTE:
			dialogoEditarCliente.importarImagen();
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
			dialogoEditar.dispose();
			break;
		case A_EDITAR_AUTOR:
			editarAutor();
			break;
		case A_EDITAR_CLIENTE:
			editarCliente();
			dialogoEditarCliente.dispose();
			break;
		case A_MOSTRAR_EDITAR_CLIENTE:
			dialogoEditarCliente.cambiarValores(buscarIdCliente(ventanaPrincipal.retornarIdSeleccionCliente()));
			dialogoEditarCliente.setVisible(true);
			break;
		case A_BUSCAR:
			try {
				buscar();
			} catch (ExcepcionLibroNoEncontrado e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;

		case ConstantesGUI.C_JM_IDIOMA_INGLES:
			ventanaPrincipal.getBarraMenu().cargarPropiedades(ConstantesGUI.RUTA_ARCHIVO_ENG);
			ventanaPrincipal.getBarraMenu().actualizarProperties();
			break;
		case ConstantesGUI.C_JM_IDIOMA_ESPANIOL:
			ventanaPrincipal.getBarraMenu().cargarPropiedades(ConstantesGUI.RUTA_ARCHIVO_ESP);
			ventanaPrincipal.getBarraMenu().actualizarProperties();	
			break;
		case A_AGREGAR_ADMINISTRADOR:
			ventanaPrincipal.setVisible(true);

			break;
		case A_MOSTRAR_USUARIO:
			dialogoIniciarSesion.setVisible(true);
			break;
		case A_EXPORTAR_ARCHIVO_XML_CLIENTE:
			XmlCliente.EscribirXML(gestorCliente.getListaCliente(), RUTA_CLIENTE);
			break;
		case A_IMPORTAR_ARCHIVO_XML_CLIENTE:
			XmlCliente.leerXML(RUTA_CLIENTE);
			break;
		case A_MOSTRAR_COLECCION:
			mostrarColeccionCliente();
			break;
		case A_CANCELAR_INCIO_SESION:
			dialogoIniciarSesion.dispose();
			break;
		case A_MOSTRAR_CANCELAR_CLIENTE:
			dialogoCliente.dispose();
			dialogoEditarCliente.setVisible(false);
			break;
		case A_INICIAR_SESION:
			if (login()) {

			}else {
				JOptionPane.showMessageDialog(dialogoIniciarSesion, "Error de Acceso,intentelo de nuevo");
			}
			break;
		default:
			break;
		}
	}

	private void mostrarColeccionCliente() {

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
			XmlLibro.EscribirXML(gestorLibro.getListaLibro(),RUTA_LIBRO);
		}

	}

	public void agregarCliente(){
		Cliente cliente = dialogoCliente.crearCliente();
		if (cliente != null){
			gestorCliente.agregarCliente(cliente);
			ventanaPrincipal.agregarCliente(cliente);
			XmlCliente.EscribirXML(gestorCliente.getListaCliente(), RUTA_CLIENTE);
		}
	}
	public void inicializaDatos(){
		for (int i = 0; i < gestorCliente.getListaCliente().size(); i++) {
			ventanaPrincipal.agregarCliente(gestorCliente.getListaCliente().get(i));
		}
		for (int i = 0; i < gestorAutor.getListaAutor().size(); i++) {
			ventanaPrincipal.agregarAutor(gestorAutor.getListaAutor().get(i));
		}
		for (int i = 0; i < gestorLibro.getListaLibro().size(); i++) {
			ventanaPrincipal.agregarLibro( gestorLibro.getListaLibro().get(i));
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
			XmlAutor.EscribirXML(gestorAutor.getListaAutor(), RUTA_AUTOR);

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
		XmlLibro.EscribirXML(gestorLibro.getListaLibro(), RUTA_LIBRO);
	}

	public void borrarAutor() throws ExcepcionAutorNoEncontrado{
		int id = ventanaPrincipal.eliminarAutor();
		gestorAutor.eliminarAutor(gestorAutor.buscarAutor(id));
		XmlAutor.EscribirXML(gestorAutor.getListaAutor(), RUTA_AUTOR);
	}
	public void borrarCliente() throws ExcepcionAutorNoEncontrado{
		int id = ventanaPrincipal.eliminarCliente();
		try {
			gestorCliente.eliminarCliente(gestorCliente.buscarCliente(id));
			XmlCliente.EscribirXML(gestorCliente.getListaCliente(), RUTA_CLIENTE);
		} catch (ExcepcionClienteNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editarLibro(){
		try {
			Libro libro = dialogoEditar.editar();
			ventanaPrincipal.actualizarVentana(libro, ventanaPrincipal.filaSeleccionadalibro());
			XmlLibro.EscribirXML(gestorLibro.getListaLibro(), RUTA_LIBRO);
		} catch (Exception e) {
		}
	}

	public void editarCliente(){
		try {
			Cliente cliente = dialogoEditarCliente.editar();
			ventanaPrincipal.actualizarVentana(cliente, ventanaPrincipal.filaSeleccionadaCliente());
			XmlCliente.EscribirXML(gestorCliente.getListaCliente(), RUTA_CLIENTE);
		} catch (Exception e) {
		}
	}

	public void editarAutor(){
		try {
			dialogoEditarAutor.editarAutor(buscarIdAutor(ventanaPrincipal.retornarIdSeleccionAutor()));
			ventanaPrincipal.actualizarVentanaAutor(buscarIdAutor(ventanaPrincipal.retornarIdSeleccionAutor()), ventanaPrincipal.retornarIdSeleccionAutor());
			XmlAutor.EscribirXML(gestorAutor.getListaAutor(), RUTA_AUTOR);
			//			agrgegarAutoraChecKBox();
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
		String obtenercBoX = ventanaPrincipal.getBarraHerramientas().getcBox().getSelectedItem().toString();
		if (obtenercBoX.equals("ID Autor")) {
			try {
				buscarAutorId();
			} catch (ExcepcionAutorNoEncontrado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			if (obtenercBoX.equals("Nombre Autor")) {
				try {
					buscarAutorNombre();
				} catch (ExcepcionAutorNoEncontrado e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				if (obtenercBoX.equals("Nombre Libro")) {
					buscarLibroNombre();
				}else {
					if (obtenercBoX.equals("ID Libro")) {
						buscarLibroId();
					}else{
						if (obtenercBoX.equals("Nombre Cliente")) {
							buscarClienteId();
						}else {
							if (obtenercBoX.equals("ID Cliente")) {
								buscarClienteNombre();
							}
						}
					}
				}
			}
		}
	}


	public void buscarClienteId() throws ExcepcionLibroNoEncontrado{
		try {
			gestorCliente.buscarCliente(Integer.parseInt(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionClienteNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ventanaPrincipal.buscarClienteId(Integer.parseInt(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText()));
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
	}

	public void buscarLibroNombre() throws ExcepcionLibroNoEncontrado{
		gestorLibro.buscarLibro(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.buscarLibroNombre(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
	}
	public void buscarLibroId() throws ExcepcionLibroNoEncontrado{
		gestorLibro.buscarLibro(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.buscarLibroId(Integer.parseInt(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText()));
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
	}

	public void buscarClienteNombre() throws ExcepcionLibroNoEncontrado{
		try {
			gestorCliente.buscarCliente(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		} catch (ExcepcionClienteNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ventanaPrincipal.buscarClienteNombre(ventanaPrincipal.getBarraHerramientas().getTxtBuscar().getText());
		ventanaPrincipal.getBarraHerramientas().getTxtBuscar().setText("");
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
		new Controlador();
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

	public ArrayList<Libro> getListaLibros() {
		return gestorLibro.getListaLibro();
	}
	public boolean login(){

		char[] arrayC = dialogoIniciarSesion.getTxtContrasena().getPassword(); 
		String pass = new String(arrayC); 
		String name = dialogoIniciarSesion.getTxtNombre().getText();
		for (int i = 0; i < gestorCliente.getListaCliente().size(); i++) {
			if (name.equals(gestorCliente.getListaCliente().get(i).getNombre()) && pass.equals(gestorCliente.getListaCliente().get(i).getPassWord())) {
				ventanaUsuario.setVisible(true);
				return true;
			}
		}
		return false;
	}

}