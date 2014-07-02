package model;

 
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cancion {
	private SimpleStringProperty  Nombre;
	private SimpleStringProperty  Autor;
 
	private String  Path;
	 
	public Cancion(String nombre, String autor ,String path) {
		super();
		this.setNombre(new SimpleStringProperty(nombre));
        this.Autor = new SimpleStringProperty(autor);
        this.setPath(path);
	}

	 
	public String getAutor() {
		return Autor.get();
	}

	public void setAutor(SimpleStringProperty autorColumna) {
		Autor = autorColumna;
	}


	public SimpleStringProperty getNombre() {
		return Nombre;
	}


	public void setNombre(SimpleStringProperty nombre) {
		Nombre = nombre;
	}


	public String getPath() {
		return Path;
	}


	public void setPath(String path) {
		Path = path;
	}

 

	 

}
