package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.commons.io.FilenameUtils;

import model.Cancion;
import model.Video;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;





public class Video1Controller implements Initializable {
	
	
	public MultimediaController multi;
	
	 ArrayList<Video> videoList;

	@FXML
	private AnchorPane content;
	
	@FXML
	private AnchorPane listado;
	
	@FXML
	private ToggleButton terminal1;
	
	@FXML
	private ToggleButton terminal2;
	
	@FXML
	private ToggleButton terminal3;
	
	@FXML
	private ToggleButton terminal4;
	
	
	
	
	
	
	
	public void setContent(AnchorPane content){
		this.content=content;
	}
	 
//	public void loadVideo(ActionEvent event){
//		content.getChildren().clear();
//		try {
//			URL url = getClass()
//					.getResource("/view/Video_Content.fxml");
//			FXMLLoader fxmlloader = new FXMLLoader();
//			fxmlloader.setLocation(url);
//			fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
//			content.getChildren().clear();
//			content.getChildren().add(fxmlloader.load(url.openStream()));
//			// here we go
//			((Video2Controller) fxmlloader.getController()).setContent(content);
//			((Video2Controller) fxmlloader.getController()).setVideo(  (Video) ((Button) event.getSource()).getUserData()  );
//			((Video2Controller) fxmlloader.getController()).startMediaView();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void loadVideo(ActionEvent event){
		if(this.terminal1.isSelected())
			this.multi.PlayVideo( (Video) ((Button) event.getSource()).getUserData(),"TERMINAL 1");
		if(this.terminal2.isSelected())
			this.multi.PlayVideo( (Video) ((Button) event.getSource()).getUserData(),"TERMINAL 2");
		if(this.terminal3.isSelected())
			this.multi.PlayVideo( (Video) ((Button) event.getSource()).getUserData(),"TERMINAL 3");	
		if(this.terminal4.isSelected())
			this.multi.PlayVideo( (Video) ((Button) event.getSource()).getUserData(),"TERMINAL 4");	
		
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
			boton.getStyleClass().add("videoList");
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

	public void setMultimedia(MultimediaController multimediaController) {
		// TODO Auto-generated method stub
		this.multi=multimediaController;
	}

	
	

	

}