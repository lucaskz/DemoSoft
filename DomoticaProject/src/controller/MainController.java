package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Terminal.TerminalScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable {

	private Main mainApp;

	@FXML
	private Button audio;
	
	@FXML
	private Button video;
	
	@FXML
	private Button picture;
	
	@FXML
	private Button gps;
	
	@FXML
	private Button playbutton;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	public void PlayMedia(ActionEvent event){
		
		
	}
	
	public void reproducirMedia(ActionEvent event){
		TerminalScreen.playMedia(new File("./resources/videos/videodos.mp4").toURI().toString());
	
	}
	


	public void loadAudioScene(ActionEvent event) {
	
		
		this.getMainApp().changeScene("Audio","Multimedia", "AnchorPane");
	}
	
	public void loadVideoScene(ActionEvent event){
		this.getMainApp().changeScene("Video","Multimedia", "AnchorPane");
	}
	
	public void loadPictureScene(ActionEvent event){
		this.getMainApp().changeScene("Picture","Multimedia", "AnchorPane");
	}

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

}
