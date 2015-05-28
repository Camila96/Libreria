package modelo.entidades;

public enum TipoBusqueda {
	
	SELECIONE("Selecione una Opci�n"),AUTOR("Nombre Autor"), LIBRO("Nombre Libro"), 
	IDAUTOR("ID Autor"), IDLIBRO("ID Libro"), CLIENTE("Nombre Cliente"), IDCLIENTE("ID Cliente");

	private String name;
	
	TipoBusqueda(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	 @Override
	  public String toString() {
	    return ""+getName()+"";
	  }
}
