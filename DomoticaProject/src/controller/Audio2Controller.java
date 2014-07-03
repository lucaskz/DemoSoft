package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.commons.io.FilenameUtils;

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
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;


public class Audio2Controller implements Initializable {

	ArrayList<HashMap<String,Object>> playlists;

	@FXML
	private AnchorPane content;

	@FXML
	private AnchorPane listado;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.getPlaylists();
		double x = 63.0;
		double y=154.0;
		double x_label=63.0;
		for (Iterator<HashMap<String, Object>> iterator = this.playlists.iterator(); iterator.hasNext();) {			
			HashMap<String,Object> act =  iterator.next();
			//Image img1 = new Image(getClass().getResourceAsStream("Cover.jpg"));
			//Image img1 = new Image(getClass().getResourceAsStream("C:/Users/Lucas/git/DemoSoft/DomoticaProject/resources/musica/Benjamin/Cover.png"));
			Image img1 = new Image(getClass().getResourceAsStream((new File ("./resources/musica/Benjamin/Cover.png")).toURI().toString()));
			Button boton = new Button("",new ImageView(img1));
			boton.setLayoutX(x);
			boton.setLayoutY(y);
			boton.setUserData(act.get("canciones"));
			boton.getStyleClass().add("playlist");
			boton.setOnAction(this::loadPlaylist);
			
			
			Label label = new Label((String) act.get("nombre"));
			label.getStyleClass().add("item-title");
			label.setLayoutX(x_label);
			label.setLayoutY(292.0);
			x = x + 130.0;
			x_label=x_label+130;
			listado.getChildren().addAll(boton,label);			
		}
       		
		
		
//		Iterator it = playlists.entrySet().iterator();
//		while (it.hasNext()) {
//			Map.Entry e = (Map.Entry) it.next();
//			Button boton = new Button();
//			boton.setLayoutX(x);
//			boton.setLayoutY(y);
//			boton.setUserData(e.getValue());
//			boton.getStyleClass().add("playlist");
//			boton.setOnAction(this::loadPlaylist);			
//			Label label = new Label((String) e.getKey());
//			label.getStyleClass().add("item-title");
//			label.setLayoutX(x_label);
//			label.setLayoutY(292.0);
//			x = x + 130.0;
//			x_label=x_label+130;
//			listado.getChildren().addAll(boton,label);
//		}
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
			((Audio1Controller) fxmlloader.getController()).setPlaylist(  (ObservableList<Cancion>) ((Button) event.getSource()).getUserData()  );
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

		playlists = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> playlist_actual = new HashMap<String,Object>();
		
		ObservableList<Cancion> canciones = FXCollections.observableArrayList();
		
		File[] list = root.listFiles();
		for (File f : list) {
			if (f.equals(root))
				continue;
			if (f.isDirectory()) {
				File[] sub = f.listFiles();
				for (File s : sub) {					
					try {
						String ext=FilenameUtils.getExtension(s.getCanonicalPath());
						if( ext.equals("mp3") || ext.equals("wav") || ext.equals("wma")) {
						AudioFileFormat baseFileFormat = AudioSystem.getAudioFileFormat(s);
						Map properties = baseFileFormat.properties();
						Cancion temp=new Cancion(s.getName().replaceFirst("[.][^.]+$", ""),(String)properties.get("album"),(float) (( ((Long) properties.get("duration")) / 1000000.0 )/  60.0),s.getPath());
						canciones.add(temp);
						}
						if(ext.equals("jpg")){
							playlist_actual.put("imagen", s.getCanonicalPath());
						}
					} catch (UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();				
					}
				}
				playlist_actual.put("canciones", canciones);
				playlist_actual.put("nombre", f.getName());
				playlists.add(playlist_actual);
				playlist_actual=new HashMap<String,Object>();
				canciones = FXCollections.observableArrayList();
			}
		}
	}

}