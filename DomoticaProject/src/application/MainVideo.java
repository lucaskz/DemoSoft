package application;

import java.io.IOException;

import model.MediaControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MainVideo extends Application {

	  private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
	  private static String arg1;

	  /**
	   * @param args
	   *          the command line arguments
	   */
	  public static void main(String[] args) {
	    launch(args);
	  }

	  @Override
	  public void start(Stage primaryStage) throws IOException {
	    primaryStage.setTitle("Embedded Media Player");
	    //Group root= new Group ();
	    Pane root = FXMLLoader.load(getClass().getResource("/view/MultimediaView.fxml"));
	    Scene scene = new Scene(root,800, 600);

	    // create media player
	    Media media = new Media((arg1 != null) ? arg1 : MEDIA_URL);
	    MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.setAutoPlay(true);

	    MediaControl mediaControl = new MediaControl(mediaPlayer);
	    scene.setRoot(mediaControl);

	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }
	  
	  public void changeScene(String view, String container) {
			try {

				FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/"
						+ view + "View.fxml"));

				// Parent root = FXMLLoader.load(getClass().getResource(
				// "view/MultimediaView.fxml"));
				
				Class<?> myClass= Class.forName("javafx.scene.layout."+container);

				
				Object myContainer = myClass.cast(loader.load());

				Scene scene = new Scene((Parent) myContainer);

				scene.getStylesheets().add(
						getClass().getResource("application.css").toExternalForm());
				this.getPrimaryStage().setScene(scene);
				this.getPrimaryStage().show();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	private Stage getPrimaryStage() {
		// TODO Auto-generated method stub
		return null;
	}
	}
