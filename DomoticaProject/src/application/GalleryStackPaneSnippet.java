package application;

import java.util.ArrayList;
import es.carlosmontero.javafx.gallery.Gallery;
import es.carlosmontero.javafx.gallery.PhotoGallery;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GalleryStackPaneSnippet extends Application {

	private Stage stage;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;

		final String[] urls = new String[] {
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/15",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/16",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/17",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/18",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/19",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/20",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/21",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/22",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/23",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/24",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/25",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/26",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/27",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/28",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/29",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/30",
				"http://carlosmontero.es/photoprovider/portfolio/2/false/image/31" };

		final HBox hBox = new HBox();
		hBox.setStyle("-fx-background-color: grey");
		hBox.setAlignment(Pos.CENTER);

		/*final Button button = new Button("Abrir galería");
		button.addEventHandler(ActionEvent.ACTION, new EventHandler() {

			@Override
			public void handle(Event arg0) {

				PhotoGallery p1 = new PhotoGallery(
						"http://carlosmontero.es/photoprovider/portfolio/2/false/image/15");
				PhotoGallery p2 = new PhotoGallery(
						"http://carlosmontero.es/photoprovider/portfolio/2/false/image/16");
				ArrayList<PhotoGallery> l = new ArrayList<PhotoGallery>();
				l.add(p1);
				l.add(p2);
				final Gallery gallery = new Gallery(stage, l, 0.5);
				gallery.show();

			}

		});*/

		//hBox.getChildren().addAll(button);
		final StackPane root = new StackPane();
		root.getChildren().add(hBox);
		final Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setHeight(600);
		stage.setWidth(600);
		stage.setTitle("Visor de imágenes en JavaFX");
		stage.setOnShown(new EventHandler() {

			@Override
			public void handle(Event event) {
				PhotoGallery p1 = new PhotoGallery(
						"http://carlosmontero.es/photoprovider/portfolio/2/false/image/15");
				PhotoGallery p2 = new PhotoGallery(
						"http://carlosmontero.es/photoprovider/portfolio/2/false/image/16");
				ArrayList<PhotoGallery> l = new ArrayList<PhotoGallery>();
				l.add(p1);
				l.add(p2);
				final Gallery gallery = new Gallery(stage, l, 0.5);
				gallery.show();
				
			}
			
		});
		stage.show();

	}

	public static void main(final String[] args) {
		launch(args);
	}

}