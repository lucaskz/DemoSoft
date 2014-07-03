package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import model.Cancion;
import model.MediaControl;
import model.Video;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;
import application.Main;
import application.Terminal.TerminalScreen;

public class MultimediaController implements Initializable {

	private Main mainApp;
	
	private ChangeListener<Duration> progressChangeListener;
	
	private InvalidationListener progressChangeListener2;

	private MediaPlayer mp_actual;
	
	private MediaPlayer mp_anterior;

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
	
	@FXML
	private Button previousTerminal;
	
	@FXML
	private Button nextTerminal;
	
	@FXML
	private Label currentTerminal;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	@FXML
	public void PlayMedia(ActionEvent event) {
		TableView<Cancion> Tabla = (TableView<Cancion>) content
				.lookup("#table_playlist");
		List<Cancion> tabla = Tabla.getSelectionModel().getSelectedItems();
		Cancion cancion_selected = tabla.get(0);
		String terminal;
		if(((ToggleButton) this.content.lookup("#terminal1")).isSelected()){
			mp_actual=TerminalScreen.playMedia(cancion_selected.getPath(),"TERMINAL 1");
			this.currentTerminal.setText("TERMINAL 1");
	   }
		if(((ToggleButton) this.content.lookup("#terminal2")).isSelected()){
			mp_actual=TerminalScreen.playMedia(cancion_selected.getPath(),"TERMINAl 2");
			this.currentTerminal.setText("TERMINAL 2");
		}	
		if(((ToggleButton) this.content.lookup("#terminal3")).isSelected()){
			mp_actual=TerminalScreen.playMedia(cancion_selected.getPath(),"TERMINAL 3");
			this.currentTerminal.setText("TERMINAL 3");
		}	
		if(((ToggleButton) this.content.lookup("#terminal4")).isSelected()){
			mp_actual=TerminalScreen.playMedia(cancion_selected.getPath(),"TERMINAL 4");
			this.currentTerminal.setText("TERMINAL 4");
		}
		if(mp_actual == null){
			mp_actual=TerminalScreen.playMedia(cancion_selected.getPath(),this.currentTerminal.getText());
		}
		
		mediaBar.setProgress(0);
		progressChangeListener = new ChangeListener<Duration>() {
			@Override
			public void changed(
					ObservableValue<? extends Duration> observableValue,
					Duration oldValue, Duration newValue) {
				mediaBar.setProgress(1.0 * mp_actual.getCurrentTime().toMillis()
						/ mp_actual.getTotalDuration().toMillis());
			}
		};
		mp_actual.currentTimeProperty().addListener(progressChangeListener);
		progressChangeListener2 = new InvalidationListener() {
			public void invalidated(Observable ov) {
				mediaBarTime.setVisible(true);
				mediaBarTime.setText(MediaControl.formatTime(mp_actual.getCurrentTime(), mp_actual.getTotalDuration()));

			}
		};
		mp_actual.currentTimeProperty().addListener(progressChangeListener2);
		
	
		
		

	}
	
	public void PlayVideo(Video video,String terminal){
		mp_actual=TerminalScreen.playMedia(video.getPath(),terminal);
		this.currentTerminal.setText(terminal);
		mediaBar.setProgress(0);
		progressChangeListener = new ChangeListener<Duration>() {
			@Override
			public void changed(
					ObservableValue<? extends Duration> observableValue,
					Duration oldValue, Duration newValue) {
				mediaBar.setProgress(1.0 * mp_actual.getCurrentTime().toMillis()
						/ mp_actual.getTotalDuration().toMillis());
			}
		};
		mp_actual.currentTimeProperty().addListener(progressChangeListener);
		progressChangeListener2 = new InvalidationListener() {
			public void invalidated(Observable ov) {
				mediaBarTime.setVisible(true);
				mediaBarTime.setText(MediaControl.formatTime(mp_actual.getCurrentTime(), mp_actual.getTotalDuration()));

			}
		};
		mp_actual.currentTimeProperty().addListener(progressChangeListener2);
		
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
			((Video1Controller) fxmlloader.getController()).setMultimedia(this);

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
			((Audio2Controller) fxmlloader.getController()).setMultimedia(this);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void previousTerminal(ActionEvent event) {
		if(mp_actual != null & progressChangeListener2!= null & progressChangeListener!=null){
			mp_actual.currentTimeProperty().removeListener(progressChangeListener2);
			mp_actual.currentTimeProperty().removeListener(progressChangeListener);
		}
		String currentTerminal=this.currentTerminal.getText();		
		currentTerminal=currentTerminal.replaceAll("\\D+","");
		if (!currentTerminal.equals("1"))
			this.currentTerminal.setText("TERMINAL " + (Integer.parseInt(currentTerminal)-1));

		switch ("TERMINAL " + (Integer.parseInt(currentTerminal)-1)) {
		case "TERMINAL 1":
			SubTerminalController terminal1= TerminalScreen.getTerminal1();
			mp_actual = TerminalScreen.terminal1.getMediaPlayer();
			break;

		case "TERMINAL 2":
			SubTerminalController terminal2= TerminalScreen.getTerminal2();
			mp_actual = TerminalScreen.terminal2.getMediaPlayer();
			break;
		case "TERMINAL 3":
			SubTerminalController terminal3= TerminalScreen.getTerminal2();
			mp_actual = TerminalScreen.terminal3.getMediaPlayer();
			break;

		case "TERMINAL 4":
			SubTerminalController terminal4= TerminalScreen.getTerminal2();
			mp_actual = TerminalScreen.terminal4.getMediaPlayer();
			break;

		default:
			break;
		}
		
		if(mp_actual!=null){
		
	//	if(TerminalScreen.terminal2.getMediaPlayer()!=null)
	//	this.mediaProgressBar(this.currentTerminal.getText());
		progressChangeListener = new ChangeListener<Duration>() {
			@Override
			public void changed(
					ObservableValue<? extends Duration> observableValue,
					Duration oldValue, Duration newValue) {
				mediaBar.setProgress(1.0 * mp_actual.getCurrentTime().toMillis()
						/ mp_actual.getTotalDuration().toMillis());
			}
		};
		mp_actual.currentTimeProperty().addListener(progressChangeListener);
		mp_actual.currentTimeProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				mediaBarTime.setVisible(true);
				mediaBarTime.setText(MediaControl.formatTime(
						mp_actual.getCurrentTime(), mp_actual.getTotalDuration()));

			}
		});
	
		}else{
			mediaBar.setProgress(0);
			mediaBarTime.setText("00:00");
		}
		
	}
	
	
	
	@FXML
	public void nextTerminal(ActionEvent event) {
		if(mp_actual != null & progressChangeListener2!= null & progressChangeListener!=null){
			mp_actual.currentTimeProperty().removeListener(progressChangeListener2);
			mp_actual.currentTimeProperty().removeListener(progressChangeListener);
		}
		String currentTerminal=this.currentTerminal.getText();
		
		currentTerminal=currentTerminal.replaceAll("\\D+","");
		if (!currentTerminal.equals("4"))
			this.currentTerminal.setText("TERMINAL " + (Integer.parseInt(currentTerminal)+1));

		switch ("TERMINAL " + (Integer.parseInt(currentTerminal)+1)) {
		case "TERMINAL 1":
			SubTerminalController terminal1= TerminalScreen.getTerminal1();
			mp_actual = TerminalScreen.terminal1.getMediaPlayer();
			break;

		case "TERMINAL 2":
			SubTerminalController terminal2= TerminalScreen.getTerminal2();
			mp_actual = TerminalScreen.terminal2.getMediaPlayer();
			break;
		case "TERMINAL 3":
			SubTerminalController terminal3= TerminalScreen.getTerminal2();
			mp_actual = TerminalScreen.terminal3.getMediaPlayer();
			break;

		case "TERMINAL 4":
			SubTerminalController terminal4= TerminalScreen.getTerminal2();
			mp_actual = TerminalScreen.terminal4.getMediaPlayer();
			break;

		default:
			break;
		}
		

		if(mp_actual!=null){
	//	if(TerminalScreen.terminal2.getMediaPlayer()!=null)
	//	this.mediaProgressBar(this.currentTerminal.getText());
		progressChangeListener = new ChangeListener<Duration>() {
			@Override
			public void changed(
					ObservableValue<? extends Duration> observableValue,
					Duration oldValue, Duration newValue) {
				mediaBar.setProgress(1.0 * mp_actual.getCurrentTime().toMillis()
						/ mp_actual.getTotalDuration().toMillis());
			}
		};
		mp_actual.currentTimeProperty().addListener(progressChangeListener);
		mp_actual.currentTimeProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				mediaBarTime.setVisible(true);
				mediaBarTime.setText(MediaControl.formatTime(
						mp_actual.getCurrentTime(), mp_actual.getTotalDuration()));

			}
		});
		}
		else{
			mediaBar.setProgress(0);
			mediaBarTime.setText("00:00");
		}
		
	
	}
	
	

	public void mediaProgressBar(String terminal) {
		


		switch (terminal) {
		case "TERMINAL 1":
			SubTerminalController terminal1= TerminalScreen.getTerminal1();
			mp_actual = TerminalScreen.terminal1.getMediaPlayer();
			break;

		case "TERMINAL 2":
			SubTerminalController terminal2= TerminalScreen.getTerminal2();
			mp_actual = TerminalScreen.terminal2.getMediaPlayer();
			break;
		case "TERMINAL 3":
			mp_actual = TerminalScreen.terminal3.getMediaPlayer();
			break;

		case "TERMINAL 4":
			mp_actual = TerminalScreen.terminal4.getMediaPlayer();
			break;

		default:
			break;
		}		

		mediaBar.setProgress(0);
		progressChangeListener = new ChangeListener<Duration>() {
			@Override
			public void changed(
					ObservableValue<? extends Duration> observableValue,
					Duration oldValue, Duration newValue) {
				mediaBar.setProgress(1.0 * mp_actual.getCurrentTime().toMillis()
						/ mp_actual.getTotalDuration().toMillis());
			}
		};
		mp_actual.currentTimeProperty().addListener(progressChangeListener);
		progressChangeListener2 = new InvalidationListener() {
			public void invalidated(Observable ov) {
				mediaBarTime.setVisible(true);
				mediaBarTime.setText(MediaControl.formatTime(mp_actual.getCurrentTime(), mp_actual.getTotalDuration()));

			}
		};
		mp_actual.currentTimeProperty().addListener(progressChangeListener2);
	
	}

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

}
