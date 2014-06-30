package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import model.Cancion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AudioController_jorge implements Initializable {

	private Main mainApp;

	@FXML
	private TableView<Cancion> Tabla1;
	@FXML
	private TableColumn<Cancion, String> Columna1;
	@FXML
	private TableColumn<Cancion, String> Columna2;

	@FXML
	private Button multimediaButton1;
	@FXML
	private Button multimediaButton2;
	@FXML
	private Button multimediaButton3;
	@FXML
	private Button multimediaButton4;
	@FXML
	private Button multimediaButton5;
	@FXML
	private Button multimediaButton6;

	ObservableList<Cancion> canciones = FXCollections.observableArrayList();

	public void inicializarTablaMusica() {

		Tabla1.setItems(canciones);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void loadPlay1(ActionEvent event) {

		this.getMainApp().changeScene(
				"Multimedia",
				"/Users//MatiasBarrera/Musica/"
						+ multimediaButton1.getText().toString());
	}

	public void loadPlay2(ActionEvent event) {

		this.getMainApp().changeScene(
				"Multimedia",
				"/Users/MatiasBarrera/Musica/"
						+ multimediaButton2.getText().toString());
	}

	public void loadPlay3(ActionEvent event) {

		this.getMainApp().changeScene(
				"Multimedia",
				"/Users//MatiasBarrera/Musica/"
						+ multimediaButton3.getText().toString());
	}

	public void loadPlay4(ActionEvent event) {

		this.getMainApp().changeScene(
				"Multimedia",
				"/Users//MatiasBarrera/Musica/"
						+ multimediaButton4.getText().toString());
	}

	public void loadPlay5(ActionEvent event) {

		this.getMainApp().changeScene(
				"Multimedia",
				"/Users//MatiasBarrera/Musica/"
						+ multimediaButton5.getText().toString());
	}

	public void loadPlay6(ActionEvent event) {

		this.getMainApp().changeScene(
				"Multimedia",
				"/Users//MatiasBarrera/Musica/"
						+ multimediaButton6.getText().toString());
	}

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

}
