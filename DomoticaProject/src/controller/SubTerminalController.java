package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SubTerminalController implements Initializable {

	@FXML
	private Pane contenido;
		

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void setContenido(Pane contenido1){
		this.contenido=contenido1;
	}

	public void AgregarBoton() {
		contenido.getChildren().add(new Button("hola"));
		
	}
	 

	/**
	 *  Controlador encargado de mostrar los temas de las listas de una playlist seleccionada  */ 
	
	

	

	

}