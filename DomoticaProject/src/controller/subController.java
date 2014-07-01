package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class subController implements Initializable {

	@FXML
	private AnchorPane content;
		
	@FXML
	private Button button_back;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void setContent(AnchorPane content){
		this.content=content;
	}
	

	
	@FXML
	public void backMenu(ActionEvent event) {		
		content.getChildren().clear();
		try {
			
			 URL url = getClass().getResource("/view/PlayListed.fxml");
			 FXMLLoader fxmlloader = new FXMLLoader();
			 fxmlloader.setLocation(url);
			 fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
			 content.getChildren().clear();
			 content.getChildren().add( fxmlloader.load(url.openStream()));
			            // here we go
			    ((subController2)fxmlloader.getController()).setContent(content);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	

}
