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

public class Audio1Controller implements Initializable {

	@FXML
	private AnchorPane content;
		
	@FXML
	private Button button_back;
	
	@FXML
	private AnchorPane playlist_content;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void setContent(AnchorPane content){
		this.content=content;
	}
	 

	/**
	 *  Controlador encargado de mostrar los temas de las listas de una playlist seleccionada  */ 
	
	

	
	@FXML
	public void backMenu(ActionEvent event) {		
		content.getChildren().clear();
		try {
			
			 URL url = getClass().getResource("/view/PlayListed.fxml");
			 FXMLLoader fxmlloader = new FXMLLoader();
			 fxmlloader.setLocation(url);
			 fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
			 content.getChildren().clear();
			 content.getChildren().add( fxmlloader.load(url.openStream()));
			            // here we go
			    ((Audio2Controller)fxmlloader.getController()).setContent(content);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	

}
