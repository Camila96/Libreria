package modelo.entidades;

public enum TipoBusqueda {
	
	AUTOR("Nombre Autor"), LIBRO("Nombre Libro"), IDAUTOR("ID Autor"), IDLIBRO("ID Libro");

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
