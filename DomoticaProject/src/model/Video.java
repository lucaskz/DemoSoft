package model;

import javafx.beans.property.SimpleStringProperty;

public class Video {
	private String path;
	private String nombre;
	private float lenght;
	
	public Video(String nombre, String path) {
		super();
		this.nombre = nombre;
        this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
