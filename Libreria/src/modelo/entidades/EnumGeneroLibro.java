package modelo.entidades;

public enum EnumGeneroLibro {			
	ROMANCE("Romance"), ACCION("Accion"),COMEDIA("Comedia"),CIENCIA("Ciencia"),
	TERROR("Terror"),CULTURA("Cultura");
	private String generoSelected;
	

	private EnumGeneroLibro (String generoSelected){
		this.generoSelected = generoSelected;
	}
	public String getGenreSelected() {
		return generoSelected;
	}
	public void setGenreSlected(String generoSelected) {
		this.generoSelected = generoSelected;
	}
}
