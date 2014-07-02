package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Terminal;
import application.Terminal.TerminalScreen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.Pane;

public class TerminalController implements Initializable {
	

	@FXML
	private Pane contenido1;
	
	@FXML
	private Pane contenido2;
	
	@FXML
	private Pane contenido3;
	
	@FXML
	private Pane contenido4;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	  
			try {
				
				 URL url = getClass().getResource("/view/SubTerminalView.fxml");
				 FXMLLoader fxmlloader = new FXMLLoader();
				 fxmlloader.setLocation(url);
				 fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
				 contenido1.getChildren().clear();
				 contenido1.getChildren().add( fxmlloader.load(url.openStream()));
				            // here we go
				 ((SubTerminalController)fxmlloader.getController()).setContenido(contenido1);
				    TerminalScreen.setTerminal1((SubTerminalController)fxmlloader.getController());
				    

					 FXMLLoader fxmlloader2 = new FXMLLoader();
					 fxmlloader.setLocation(url);
					 fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
					 contenido2.getChildren().clear();
					 contenido2.getChildren().add( fxmlloader2.load(url.openStream()));
					            // here we go				
					 ((SubTerminalController)fxmlloader.getController()).setContenido(contenido2);
					    TerminalScreen.setTerminal2((SubTerminalController)fxmlloader.getController());   
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	

}
