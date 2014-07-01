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
import application.Main;

public class MultimediaController implements Initializable {

	
	private Main mainApp;


	
	@FXML
	private AnchorPane content;
	
	@FXML
	private AnchorPane menuBar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		System.out.println("Initialize");
		// TODO Auto-generated method stub
		Button audio = (Button) menuBar.lookup("#audio");
		audio.setStyle("-fx-background-color: #474747 #5b39b6 radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);");
		Button home = (Button) menuBar.lookup("#home");
		home.setStyle("-fx-background-color: #191919 !important;");
		Button pictures = (Button) menuBar.lookup("#pictures");
		pictures.setStyle("-fx-background-color: #191919 !important;");
		Button videos = (Button) menuBar.lookup("#videos");
		videos.setStyle("-fx-background-color: #191919 !important;"); 
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
	
	@FXML
	public void loadPlaylist(ActionEvent event) {	
		content.getChildren().clear();
		try {
			
			 URL url = getClass().getResource("/view/PlaylistContent.fxml");
			 FXMLLoader fxmlloader = new FXMLLoader();
			 fxmlloader.setLocation(url);
			 fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
			 content.getChildren().clear();
			 content.getChildren().add( fxmlloader.load(url.openStream()));
			            // here we go
			    ((Audio1Controller)fxmlloader.getController()).setContent(content);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	


	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

}

