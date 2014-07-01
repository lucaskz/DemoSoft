package application;

import java.util.List;

import application.Terminal.TerminalScreen;
import controller.MainController;
import controller.MultimediaController;
import controller.AudioPlayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private Stage primaryStage;
	private Stage primaryStage2;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			TerminalScreen t1= new TerminalScreen();
			TerminalScreen t2= new TerminalScreen();
			TerminalScreen t3= new TerminalScreen();
			TerminalScreen t4= new TerminalScreen();
	
		//	t1.start(primaryStage2);
			
			
			FXMLLoader loader = new FXMLLoader(
					Main.class.getResource("/view/MainView.fxml"));

			this.setPrimaryStage(primaryStage);
			AnchorPane anchorPane = (AnchorPane) loader.load();

			MainController controller = (MainController) loader.getController();
			Scene scene = new Scene(anchorPane);
			controller.setMainApp(this);
			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeScene(String controller,String view, String container) {
		try {

			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/"
					+ view + "View.fxml"));

			Class<?> myContainerClass= Class.forName("javafx.scene.layout."+container);
			Object myContainer = myContainerClass.cast(loader.load());
			

			switch (controller+"Controller") {
			case "MainController":
				MainController controllerMain = (MainController) loader.getController();
				controllerMain.setMainApp(this);
				break;
			
			case "AudioController":
				MultimediaController controllerAudio = (MultimediaController) loader.getController();	
				controllerAudio.setMainApp(this);
				controllerAudio.loadAudio(null);
				break;
			case "VideoController":
				MultimediaController controllerVideo = (MultimediaController) loader.getController();	
				controllerVideo.setMainApp(this);
				controllerVideo.loadVideo(null);
				break;
			case "PictureController":
				MultimediaController controllerPicture = (MultimediaController) loader.getController();	
				controllerPicture.setMainApp(this);
				controllerPicture.loadPicture(null);
				break;	
			case "PlayListController":
				final List<String> params = getParameters().getRaw();
				AudioPlayController controllerPlay = (AudioPlayController) loader
						.getController();
				controllerPlay.cargarTemas(params,container);
				controllerPlay.setMainApp(this);
				container="AnchorPane";
			default:
				break;
			}
			

					
			
			Scene scene = new Scene((Parent) myContainer);

			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			this.getPrimaryStage().setScene(scene);
			this.getPrimaryStage().show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	


	public static void main(String[] args) {
		launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}
