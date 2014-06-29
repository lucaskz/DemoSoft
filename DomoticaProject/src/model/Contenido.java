package model;

/**Clase abstracta, modela los contenidos de un catálogo.*/

public abstract class Contenido {
	
	
	private Long oId;
	protected String titulo;
	

	
	public Contenido () {
		
	}
	
	public	Contenido(String titulo){
		this.titulo=titulo;
	
	}



	public  boolean esListaDeFotos(){
		return false;
	}

	public  boolean esListaDeMusica(){
		return false;
	}
	
	public  boolean esListaDeVideos(){
		return false;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	


	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

}
