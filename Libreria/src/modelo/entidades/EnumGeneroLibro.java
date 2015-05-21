package modelo.entidades;

public enum EnumGeneroLibro {			
	ROMANCE("ROMANCE"), ACCION("ACCION"),COMEDIA("COMEDIA"),CIENCIA("CIENCIA"),
	TERROR("TERROR"),CULTURA("CULTURA");
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
