package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.MediaControl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SubTerminalController implements Initializable {

	private String MEDIA_URL="http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
	private static String filename;
	private static String arg1;
	private MediaPlayer mediaPlayer;
	
	

	
	@FXML
	private Pane contenido;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void setContenido(Pane contenido1) {
		this.contenido = contenido1;
	}
	
	public MediaPlayer getMediaPlayer(){
		return this.mediaPlayer;
	}
	
	String getFileName(){
		
		this.mediaPlayer.getMedia().getMetadata().get("algo");
		return "hola";
	}
	
	public MediaPlayer reproducirMedia(String path){
		File stream = new File(path);		
    	Media media = new Media((arg1 != null) ? arg1 : stream.toURI().toString());
		mediaPlayer = new MediaPlayer(media);	 
		mediaPlayer.setAutoPlay(true);
		MediaControl mediaControl = new MediaControl(mediaPlayer);
		contenido.getChildren().add(mediaControl);
		return this.mediaPlayer;
		
		
	}

	public String getMEDIA_URL() {
		return MEDIA_URL;
	}

	public void setMEDIA_URL(String mEDIA_URL) {
		MEDIA_URL = mEDIA_URL;
	}




	/**
	 * Controlador encargado de mostrar los temas de las listas de una playlist
	 * seleccionada
	 */

}