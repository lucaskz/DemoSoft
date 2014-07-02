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
		this.startTerminal(contenido1,1);
		this.startTerminal(contenido2,2);
		this.startTerminal(contenido3,3);
		this.startTerminal(contenido4,4);
	}

	private void startTerminal(Pane content,int terminal) {
		URL url = getClass().getResource("/view/SubTerminalView.fxml");
		FXMLLoader fxmlloader = new FXMLLoader();
		fxmlloader.setLocation(url);
		fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
		content.getChildren().clear();
		try {
			content.getChildren().add(fxmlloader.load(url.openStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// here we go
		((SubTerminalController) fxmlloader.getController())
				.setContenido(content);
		TerminalScreen.setTerminal((SubTerminalController) fxmlloader
				.getController(),terminal);
		
	}

}
