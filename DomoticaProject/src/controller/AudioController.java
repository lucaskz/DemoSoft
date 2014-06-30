package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import application.Main;

public class AudioController implements Initializable {

	
	private Main mainApp;

	@FXML
	private Button multimediaButton6;
	
	@FXML
	private AnchorPane content;
	
	@FXML
	private AnchorPane menuBar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Button audio = (Button) menuBar.lookup("#audio");
		audio.setStyle("-fx-background-color: #474747 #5b39b6 radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%)");

	}
	
	@FXML
	public void loadPlaylist(ActionEvent event) {
	
		content.getChildren().clear();
	
	}


	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

}

