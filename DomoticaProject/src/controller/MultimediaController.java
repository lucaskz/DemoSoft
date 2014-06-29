package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import application.Main;

public class MultimediaController implements Initializable {

	
	private Main mainApp;

	@FXML
	private Button videoButton;
	@FXML
	private Button audioButton;
	@FXML
	private Button imagenesButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void loadScene(ActionEvent event) {
	
		
		this.getMainApp().changeScene("Video", "AnchorPane");
	}

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

}

