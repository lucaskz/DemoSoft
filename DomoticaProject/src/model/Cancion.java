package model;

 
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cancion {
	private SimpleStringProperty  Nombre;
	private SimpleStringProperty  Autor;
	private Integer posicion;
	
	 
	public Cancion(String nombre, String autor) {
		super();
		this.Nombre = new SimpleStringProperty(nombre);
        this.Autor = new SimpleStringProperty(autor);
	}

	public String getNombre() {
		return Nombre.get();
	}

	public String getAutor() {
		return Autor.get();
	}

	public void setAutor(SimpleStringProperty autorColumna) {
		Autor = autorColumna;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	 

}
