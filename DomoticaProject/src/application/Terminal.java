package application;

import model.MediaControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Terminal {

	public static class TerminalScreen extends Application {

		private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
		private static String filename;
		private static String arg1;
		

		public static String getFilename() {
			return filename;
		}

		public static void setFilename(String filename) {
			TerminalScreen.filename = filename;
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
			primaryStage.setTitle("Embedded Media Player");
			// Group root= new Group ();
			Pane root = FXMLLoader.load(getClass().getResource(
					"/view/MultimediaView.fxml"));
			Scene scene = new Scene(root, 800, 600);

			// create media player
			Media media = new Media((arg1 != null) ? arg1 : MEDIA_URL);
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setAutoPlay(true);

			MediaControl mediaControl = new MediaControl(mediaPlayer);
			scene.setRoot(mediaControl);

			primaryStage.setScene(scene);
			primaryStage.show();

		}

		public static void main(String[] args) {
			launch(args);
		}
	}

}
