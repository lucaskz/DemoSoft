package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;






import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import model.Cancion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.AnchorPane;

public class Audio2Controller implements Initializable {

	HashMap<String, ObservableList<Cancion>> playlist;

	@FXML
	private AnchorPane content;

	@FXML
	private AnchorPane listado;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.getPlaylists();
		double x = 69.0;

		// <Button fx:id="play" layoutX="69.0" layoutY="62.0"
		// mnemonicParsing="false" onAction="#loadPlaylist" text="Button" />
		Iterator it = playlist.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			Button boton = new Button((String) e.getKey());
			boton.setLayoutX(x);
			boton.setOnAction(this::loadPlaylist);
			x = x + 60.0;
			listado.getChildren().add(boton);
		}

		// for ( HashMap<String,ArrayList<String>> actual : lista ){
		// Button boton = new Button(actual.);
		// boton.setLayoutX(x);
		// x=x+60.0;
		// listado.getChildren().add(boton);
		// }
	}

	public void setContent(AnchorPane content) {
		this.content = content;
	}

	/**
	 * Controlador encargado de mostrar las playlist disponibles
	 */

	@FXML
	public void loadPlaylist(ActionEvent event) {
		content.getChildren().clear();

		try {
			URL url = getClass()
					.getResource("/view/Audio_PlaylistContent.fxml");
			FXMLLoader fxmlloader = new FXMLLoader();
			fxmlloader.setLocation(url);
			fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
			content.getChildren().clear();
			content.getChildren().add(fxmlloader.load(url.openStream()));
			// here we go
			((Audio1Controller) fxmlloader.getController()).setContent(content);
			((Audio1Controller) fxmlloader.getController())
					.setPlaylist(playlist.get(((Button) event.getSource())
							.getText()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getPlaylists() {
		/*
		 * Metodo que me devuelve una lista de hash ,donde cada clave del hash
		 * es la lista y el valor es un arraylsit de paths
		 */
		File root = new File("./resources/musica"); // path por defecto, se
													// puede cambiar, recorre
													// maximo 1 nivel.

		playlist = new HashMap<String, ObservableList<Cancion>>();
		
		ObservableList<Cancion> actual = FXCollections.observableArrayList();

		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.equals(root))
				continue;
			if (f.isDirectory()) {
				File[] sub = f.listFiles();
				for (File s : sub) {
					
					try {
						AudioFileFormat baseFileFormat = AudioSystem.getAudioFileFormat(s);
						Map properties = baseFileFormat.properties();
						Cancion temp=new Cancion((String)properties.get("title"),(String)properties.get("album"),(float) (( ((Long) properties.get("duration")) / 1000000.0 )/  60.0),s.getPath());
	                	actual.add(temp);
					} catch (UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				}	
					
				playlist.put(f.getName(), (ObservableList<Cancion>) actual);
				actual = FXCollections.observableArrayList();
			}
		}
	}

}