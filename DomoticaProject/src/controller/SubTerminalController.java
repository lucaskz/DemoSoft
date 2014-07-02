package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.MediaControl;
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

public class SubTerminalController implements Initializable {

	private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
	private static String filename;
	private static String arg1;
	
	@FXML
	private Pane contenido;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void setContenido(Pane contenido1) {
		this.contenido = contenido1;
	}

	public void AgregarBoton() {
		Media media = new Media((arg1 != null) ? arg1 : MEDIA_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);

		MediaControl mediaControl = new MediaControl(mediaPlayer);
		contenido.getChildren().add(mediaControl);

	}

	/**
	 * Controlador encargado de mostrar los temas de las listas de una playlist
	 * seleccionada
	 */

}