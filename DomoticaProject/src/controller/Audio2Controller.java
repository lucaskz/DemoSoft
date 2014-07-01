package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Audio2Controller implements Initializable {

	@FXML
	private AnchorPane content;
		
	@FXML
	private AnchorPane listado;
	
	@FXML
	private Button play;
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void setContent(AnchorPane content){
		this.content=content;
	}
	
	/**
	 *  Controlador encargado de mostrar las playlist disponibles  */ 
	
	@FXML
	public void loadPlaylist(ActionEvent event) {	
		content.getChildren().clear();
		try {
			
			 URL url = getClass().getResource("/view/Audio_PlaylistContent.fxml");
			 FXMLLoader fxmlloader = new FXMLLoader();
			 fxmlloader.setLocation(url);
			 fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
			 content.getChildren().clear();
			 content.getChildren().add( fxmlloader.load(url.openStream()));
			            // here we go
			    ((Audio1Controller)fxmlloader.getController()).setContent(content);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		
	        File home = new File("c:/FairyMusic");

	        if (home.listFiles(new FileExtensionFilter()).length > 0) {
	            for (File file : home.listFiles(new FileExtensionFilter())) {
	                HashMap<String, String> song = new HashMap<String, String>();
	                song.put(
	                        "songTitle",
	                        file.getName().substring(0,(file.getName().length() - 4)));
	                song.put("songPath", file.getPath());

	                // Adding each song to SongList
	                songsList.add(song);
	            }
	        }
	        // return songs list array
	        
		
		ArrayList<ArrayList<String>> Playlists = new ArrayList<ArrayList<String>>();
		 ArrayList<String> List=new ArrayList<String>();
	        try {
				Files.walk(Paths.get("E:/FairyMusic")).forEach(filePath -> {
				    if (Files.isRegularFile(filePath)&& Files.isDirectory(filePath)) {
				    	if(!List.isEmpty()){
				    		Playlists.add(List);
				    	}
				       List = new ArrayList<String>();
				    }
				    if ((Files.isRegularFile(filePath)&& !Files.isDirectory(filePath))){
				      List.add(filePath.toString());
				    }
				});
				
				Playlists.add(List);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     */
	}
	

}