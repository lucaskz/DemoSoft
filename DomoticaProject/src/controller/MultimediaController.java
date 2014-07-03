package controller;

import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import model.Cancion;
import model.MediaControl;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import application.Main;
import application.Terminal.TerminalScreen;

public class MultimediaController implements Initializable {

	private Main mainApp;

	private MediaPlayer mp;

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
	private ProgressBar mediaBar;

	@FXML
	private Label mediaBarTime;

	@FXML
	private Button play;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void PlayMedia(ActionEvent event) {
		TableView<Cancion> Tabla = (TableView<Cancion>) content
				.lookup("#table_playlist");
		List<Cancion> tabla = Tabla.getSelectionModel().getSelectedItems();
		Cancion cancion_selected = tabla.get(0);
		TerminalScreen.playSound(cancion_selected.getPath());

		/*
		 * double time= TerminalScreen.getTerminal1().getDuration().toSeconds();
		 * task = new Timeline(
		 * 
		 * new KeyFrame(Duration.ZERO, new KeyValue(
		 * mediaBar.progressProperty(), 0)),
		 * 
		 * 
		 * new KeyFrame(Duration.seconds(time), new KeyValue(
		 * mediaBar.progressProperty(), 1))
		 * 
		 * );
		 * 
		 * task.play();
		 */

		this.mediaProgressBar("terminal1");

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

	public void mediaProgressBar(String terminal) {

		switch (terminal) {
		case "terminal1":
			mp = TerminalScreen.getTerminal1().getMediaPlayer();
			break;

		case "terminal2":
			mp = TerminalScreen.getTerminal2().getMediaPlayer();
			break;
		case "terminal3":
			mp = TerminalScreen.getTerminal3().getMediaPlayer();
			break;

		case "terminal4":
			mp = TerminalScreen.getTerminal4().getMediaPlayer();
			break;

		default:
			break;
		}

		mp.seek(Duration.ZERO);

		mediaBar.setProgress(0);
		ChangeListener<Duration> progressChangeListener = new ChangeListener<Duration>() {
			@Override
			public void changed(
					ObservableValue<? extends Duration> observableValue,
					Duration oldValue, Duration newValue) {
				mediaBar.setProgress(1.0 * mp.getCurrentTime().toMillis()
						/ mp.getTotalDuration().toMillis());
			}
		};
		mp.currentTimeProperty().addListener(progressChangeListener);
		mp.currentTimeProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				mediaBarTime.setVisible(true);
				mediaBarTime.setText(MediaControl.formatTime(
						mp.getCurrentTime(), mp.getTotalDuration()));

			}
		});

	}

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

}
