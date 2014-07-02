package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Terminal.TerminalScreen;
import model.Cancion;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class Audio1Controller implements Initializable {

	ObservableList<Cancion> playlist ;
	
	@FXML
	private AnchorPane content;
		
	@FXML
	private Button button_back;
	
	@FXML
	private AnchorPane playlist_content;
	
	@FXML
	private TableView<Cancion> table_playlist;
	
	@FXML
	private TableColumn columna_nombre;
	
	@FXML
	private TableColumn columna_duracion;
	
	@FXML
	private TableColumn columna_album;
	
	@FXML
	private ToggleButton terminal1;
	
	@FXML
	private ToggleButton terminal2;
	
	@FXML
	private ToggleButton terminal3;
	
	@FXML
	private ToggleButton terminal4;
	

	
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
			
			 URL url = getClass().getResource("/view/Audio_PlayListed.fxml");
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

	public void setPlaylist(ObservableList<Cancion> arrayList) {
		// TODO Auto-generated method stub
		this.playlist=arrayList;
		columna_nombre.setCellValueFactory(new PropertyValueFactory<Cancion,String>("Nombre"));
		columna_album.setCellValueFactory(new PropertyValueFactory<Cancion,String>("Path"));		
		table_playlist.setItems(playlist);	
		
		
	}
	

}
