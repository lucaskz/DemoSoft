package controller;

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	public void insertButton(ActionEvent event){
		TerminalScreen.insertarBoton();
	}
	
	public void insertButton2(ActionEvent event){
		TerminalScreen.insetarBoton2();
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
