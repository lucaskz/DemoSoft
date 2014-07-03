package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.commons.io.FilenameUtils;

import model.MediaControl;
import model.Video;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;





public class Video2Controller implements Initializable {
	
	
	private Video video;
	
	private MediaPlayer mediaPlayer;
	
	public MultimediaController multi;

	@FXML
	private AnchorPane content;
	
	@FXML
	private AnchorPane listado;
	
	@FXML
	private AnchorPane reproductor;
	
	
	
	
	public void setContent(AnchorPane content){
		this.content=content;
	}
	 
	public void loadVideo(ActionEvent event){
		
	}

	/**
	 *  Controlador encargasdo de mostrar imagenes  */ 
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

	}
	
	public void setMultimedia(MultimediaController multimediaController) {
		// TODO Auto-generated method stub
		this.multi=multimediaController;
	}

    public void startMediaView() {
		// TODO Auto-generated method stub
		File arch = new File(this.getVideo().getPath());
    	Media media = new Media( arch.toURI().toString());
		mediaPlayer = new MediaPlayer(media);	 
		mediaPlayer.setAutoPlay(true);
		MediaControl mediaControl = new MediaControl(mediaPlayer);
		reproductor.getChildren().add(mediaControl);
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	@FXML
	public void backMenu(ActionEvent event) {		
		content.getChildren().clear();
		try {
			
			 URL url = getClass().getResource("/view/Video_VideoList.fxml");
			 FXMLLoader fxmlloader = new FXMLLoader();
			 fxmlloader.setLocation(url);
			 fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
			 content.getChildren().clear();
			 content.getChildren().add( fxmlloader.load(url.openStream()));
			            // here we go
			    ((Video1Controller)fxmlloader.getController()).setContent(content);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}


	

	

}