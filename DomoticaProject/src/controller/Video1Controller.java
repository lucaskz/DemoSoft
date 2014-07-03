package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.commons.io.FilenameUtils;

import model.Video;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;





public class Video1Controller implements Initializable {
	
	
	 ArrayList<Video> videoList;

	@FXML
	private AnchorPane content;
	
	@FXML
	private AnchorPane listado;
	
	
	
	public void setContent(AnchorPane content){
		this.content=content;
	}
	 
	public void loadVideo(ActionEvent event){
		
	}

	/**
	 *  Controlador encargasdo de mostrar imagenes  */ 
	
	public void getVideoList(){
		/*
		 * Metodo que me devuelve una lista de hash ,donde cada clave del hash
		 * es la lista y el valor es un arraylsit de paths
		 */
		File root = new File("./resources/videos"); // path por defecto, se
													// puede cambiar, recorre
													// maximo 1 nivel.
		 videoList = new ArrayList<Video>();
			File[] list = root.listFiles();
			for (File s : list) {					
				try {
					String ext=FilenameUtils.getExtension(s.getCanonicalPath());
					if( ext.equals("mp4") || ext.equals("flv") ) {
						Video temp=new Video(s.getName().replaceFirst("[.][^.]+$", ""),s.getPath());
						videoList.add(temp);
					}
					
				}  catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();				
				}
			}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.getVideoList();
		double x = 63.0;
		double y=154.0;
		double x_label=63.0;
		for (Iterator<Video> iterator = this.videoList.iterator(); iterator.hasNext();) {			
			Video act =  iterator.next();
			Button boton= new Button("");
			boton.setLayoutX(x);
			boton.setLayoutY(y);
			boton.setUserData(act);
			boton.getStyleClass().add("playlist");
			boton.setOnAction(this::loadVideo);
			Label label = new Label(act.getNombre());
			label.getStyleClass().add("item-title");
			label.setLayoutX(x_label);
			label.setLayoutY(292.0);
			x = x + 130.0;
			x_label=x_label+130;
			listado.getChildren().addAll(boton,label);			
		}
	}

	

	

}