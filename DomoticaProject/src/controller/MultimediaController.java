package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import model.Cancion;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import application.Main;
import application.Terminal.TerminalScreen;

public class MultimediaController implements Initializable {

	private Main mainApp;

	@FXML
	private Button video;

	@FXML
	private Button picture;

	@FXML
	private Button home;

	@FXML
	private Button audio;

	@FXML
	private AnchorPane content;

	@FXML
	private AnchorPane menuBar;

	@FXML
	private Button play;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Initialize");
		// TODO Auto-generated method stub

	}

	public void PlayMedia(ActionEvent event) {
		TableView<Cancion> Tabla = (TableView<Cancion>) content
				.lookup("#table_playlist");
		List<Cancion> tabla = Tabla.getSelectionModel().getSelectedItems();
		Cancion cancion_selected = tabla.get(0);
		TerminalScreen.playSound(cancion_selected.getPath());
	}

	@FXML
	public void loadPicture(ActionEvent event) {
		Button audio = (Button) menuBar.lookup("#audio");
		audio.setStyle("-fx-background-color: #191919 !important;");
		Button home = (Button) menuBar.lookup("#home");
		home.setStyle("-fx-background-color: #191919 !important;");
		Button picture = (Button) menuBar.lookup("#picture");
		picture.setStyle("-fx-background-color: #474747 #5b39b6 radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%)");
		Button video = (Button) menuBar.lookup("#video");
		video.setStyle("-fx-background-color: #191919 !important;");
		try {

			URL url = getClass().getResource("/view/Picture_PictureList.fxml");
			FXMLLoader fxmlloader = new FXMLLoader();
			fxmlloader.setLocation(url);
			fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
			content.getChildren().clear();
			content.getChildren().add(fxmlloader.load(url.openStream()));
			// here we go
			((Picture1Controller) fxmlloader.getController())
					.setContent(content);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void loadVideo(ActionEvent event) {
		Button audio = (Button) menuBar.lookup("#audio");
		audio.setStyle("-fx-background-color:  #191919 !important;");
		Button home = (Button) menuBar.lookup("#home");
		home.setStyle("-fx-background-color: #191919 !important;");
		Button picture = (Button) menuBar.lookup("#picture");
		picture.setStyle("-fx-background-color: #191919 !important;");
		Button video = (Button) menuBar.lookup("#video");
		video.setStyle("-fx-background-color:  #474747 #5b39b6 radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);");
		try {

			URL url = getClass().getResource("/view/Video_VideoList.fxml");
			FXMLLoader fxmlloader = new FXMLLoader();
			fxmlloader.setLocation(url);
			fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
			content.getChildren().clear();
			content.getChildren().add(fxmlloader.load(url.openStream()));
			// here we go
			((Video1Controller) fxmlloader.getController()).setContent(content);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void loadHome(ActionEvent event) {
		this.getMainApp().changeScene("Main", "Main", "AnchorPane");
	}

	@FXML
	public void loadAudio(ActionEvent event) {
		Button audio = (Button) menuBar.lookup("#audio");
		audio.setStyle("-fx-background-color: #474747 #5b39b6 radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);");
		Button home = (Button) menuBar.lookup("#home");
		home.setStyle("-fx-background-color: #191919 !important;");
		Button picture = (Button) menuBar.lookup("#picture");
		picture.setStyle("-fx-background-color: #191919 !important;");
		Button video = (Button) menuBar.lookup("#video");
		video.setStyle("-fx-background-color: #191919 !important;");
		try {

			URL url = getClass().getResource("/view/Audio_PlayListed.fxml");
			FXMLLoader fxmlloader = new FXMLLoader();
			fxmlloader.setLocation(url);
			fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
			content.getChildren().clear();
			content.getChildren().add(fxmlloader.load(url.openStream()));
			// here we go
			((Audio2Controller) fxmlloader.getController()).setContent(content);

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

