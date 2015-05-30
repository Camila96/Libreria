package vista;

import java.awt.Color;

import javax.swing.Icon;
/**
 * @author Maria Camila Preciado Rojas y 
 * Angel Isidro Gutierrez Guerrero
 */
public class ConstantesGUI {

	/**
	 * ventana principal
	 */
	public static final String RUTA_ARCHIVO_ESP = "properties/esp.properties";
	public static final String RUTA_ARCHIVO_ENG = "properties/ing.properties";
	public static final int VENTANA_ANCHO = 1350;
	public static final int VENTANA_ALTO = 750;
	public static final int DIALOGO_ANCHO = 500;
	public static final int DIALOGO_ALTO = 480;
	public static final String I_ICONO_VENTANA = "/img/icon.png";
	public static final String T_TITULO_VENTANA = "Libreria";
	public static final String T_TITULO_VENTANA_ADMINISTRADOR = "Libreria Administrador";
	public static final String T_TITULO_VENTANA_CLIENTE = "Libreria Cliente";

	/**
	 * Constantes dialogo
	 */
	public static final String T_TITULO = "Sitios Turisticos";
	public static final String T_AGREGAR_NOMBRE = "Nombre";
	public static final String T_AGREGAR_VALOR = "Valor";
	public static final String T_AGREGAR_DESCRIPCION = "Descripcion";
	public static final String T_AGREGAR_LIBROS_A_COMPRAR = "Libros Disponibles";
	public static final String T_AGREGAR_IMAGEN = "Imagen";
	public static final Color COlOR_DATOS = Color.decode("#E0ECF8");
	public static final String T_AGREGAR_GENERO = "Genero";
	public static final String T_AGREGAR_AUTOR = "Autor";
	public static final String T_AGREGAR_COPIAS_VENDIDAS = "Copias Vendidas";
	public static final String T_ITEM_AGREGAR_BUTTON= "Agregar Libro";
	public static final String T_ITEM_AGREGAR_BUTTON_CLIENTE = "Agregar Cliente";
	public static final String T_ITEM_NEW_AUTOR_BUTTON= "Add Autor";
	public static final String T_ITEM_CANCELAR= "Cancelar Libro";
	public static final String T_ITEM_CARGAR_IMAGEN= "Cargar imagen";
	public static final String T_ITEM_EDITAR="Editar";
	public static final String T_AGREGAR_CREDITO = "Credito";
	public static final String T_AGREGAR_ID = "Id";
	
	public static final String T_ITEM_AGREGAR_ADMINISTRADOR = "Administrador";
	public static final String T_ITEM_AGREGAR_USUARIO = "Usuario";
	public static final String T_ITEM_AGREGAR_BUTTON_AUTOR = "Agregar Autor";
	public static final String  T_ITEM_CANCELAR_AUTOR= "Cancelar Autor";
	public static final String T_AGREGAR_IMAGEN_AUTOR ="Imagen Autor";
	public static final String T_ITEM_EDITAR_AUTOR = "Editar Autor";
	/**
	 * barra menu
	 */
	public static final String C_JM_IDIOMA_ESPANIOL="CAMBIAR ESPANIOL";
	public static final String C_JM_IDIOMA_INGLES="CAMBIAR INGLES";
	public static final String T_MENU_ARCHIVO = "t.menu.archivo";
	public static final String T_MENU_ITEM_AGREGAR_LIBRO  = "t.menu.item.agregar.libro";
	public static final String T_MENU_ITEM_AGREGAR_CLIENTE  = "t.menu.item.agregar.cliente";
	public static final String T_MENU_ITEM_AGREGAR_AUTOR = "t.menu.item.agregar.autor";
	public static final String T_MENU_ITEM_ELIMINAR_LIBRO = "t.menu.item.eliminar.libro";
	public static final String T_MENU_ITEM_ELIMINAR_CLIENTE= "t.menu.item.eliminar.cliente";
	public static final String T_MENU_ITEM_ELIMINAR_AUTOR = "t.menu.item.eliminar.autor";
	public static final String T_MENU_PREFERENCIAS = "t.menu.preferencias";
	public static final String T_MENU_CAMBIAR_IDIOMA= "t.menu.cambiar.idioma";
	public static final String T_MENU_ITEM_INGLES = "t.menu.item.ingles";
	public static final String T_MENU_ITEM_ESPANIOL = "t.menu.item.espaniol";
	public static final String T_MENU_ACERCA_DE = "t.menu.acerca.de";
	public static final String T_MENU_IMPORTAR_ARCHIVO = "t.menu.importar.archivo";
	public static final String T_MENU_EXPORTAR_ARCHIVO = "t.menu.exportar.archivo";
	public static final String T_MENU_ITEM_IMPORTAR_BINARIO ="t.menu.item.im.binario";
	public static final String T_MENU_ITEM_IMPORTAR_PLANO = "t.menu.item.im.plano";
	public static final String T_MENU_ITEM_IMPORTAR_JSON = "t.menu.item.im.json";
	public static final String T_MENU_ITEM_IMPORTAR_XML = "t.menu.item.xml";
	public static final String T_MENU_ITEM_EXPORTAR_BINARIO = "t.menu.item.ex.binario";
	public static final String T_MENU_ITEM_EXPORTAR_PLANI = "t.menu.item.ex.plano";
	public static final String T_MENU_ITEM_EXPORTAR_XML = "t.menu.item.ex.xml";
	public static final String T_MENU_ITEM_EXPORTAR_JSON = "t.menu.item.ex.json";
	public static final String T_MENU_ITEM_IMPORTAR_AUTOR = "t.menu.item.im.binario.a";
	public static final String T_MENU_ITEM_IMPORTAR_AUTOR_PL = "t.menu.item.im.plano.a";
	public static final String T_MENU_ITEM_IMPORTAR_AUTOR_XM = "t.menu.item.im.xml.a";
	public static final String T_MENU_ITEM_IMPORTAR_AUTOR_JS = "t.menu.item.im.json.a";
	public static final String T_MENU_ITEM_EXPORTAR_AUTOR = "t.menu.item.ex.binario.a";
	public static final String T_MENU_ITEM_EXPORTAR_AUTOR_PL = "t.menu.item.ex.plano.a";
	public static final String T_MENU_ITEM_EXPORTAR_AUTOR_XM = "t.menu.item.ex.xml.a";
	public static final String T_MENU_ITEM_EXPORTAR_AUTOR_JS = "t.menu.item.ex.json.a";
	public static final String T_MENU_ITEM_IMPORTAR_CLIENTE = "t.menu.item.im.binario.c";
	public static final String T_MENU_ITEM_IMPORTAR_CLIENTE_PL = "t.menu.item.im.plano.c";
	public static final String T_MENU_ITEM_IMPORTAR_CLIENTE_XM = "t.menu.item.im.xml.c";
	public static final String T_MENU_ITEM_IMPORTAR_CLIENTE_JS = "t.menu.item.im.json.c";
	public static final String T_MENU_ITEM_EXPORTAR_CLIENTE = "t.menu.item.ex.binario.c";
	public static final String T_MENU_ITEM_EXPORTAR_CLIENTE_PL = "t.menu.item.ex.plano.c";
	public static final String T_MENU_ITEM_EXPORTAR_CLIENTE_XM = "t.menu.item.ex.xml.c";
	public static final String T_MENU_ITEM_EXPORTAR_CLIENTE_JS = "t.menu.item.ex.json.c";
	

}
