package model;

 
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cancion {
	private SimpleStringProperty  Nombre;
	private SimpleStringProperty  Autor;
	private float Lenght;
	private String Path;
	
	 
	public Cancion(String nombre, String autor,float lenght,String path) {
		super();
		this.Nombre = new SimpleStringProperty(nombre);
        this.Autor = new SimpleStringProperty(autor);
        this.Lenght=lenght;
        this.Path=path;
	}
	
	public float getLenght(){
		return Lenght;
	}
	
	public void setLenght(float lenght){
		this.Lenght=lenght;
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

	public String getPath() {
		return this.Path;
	}

	public void setPath(String posicion) {
		this.Path = posicion;
	}

	 

}
