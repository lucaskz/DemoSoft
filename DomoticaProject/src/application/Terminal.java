package application;

import controller.SubTerminalController;
import model.MediaControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Terminal {

	public static class TerminalScreen extends Application {
		
		public static SubTerminalController terminal1;
		public static SubTerminalController terminal2;
		public static SubTerminalController terminal3;
		public static SubTerminalController terminal4;
		
		

		private static Stage secondaryStage= new Stage();
		private static final String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";
		private static String filename;
		private static String arg1;
		private Stage primaryStage;
		public static String getFilename() {
			return filename;
		}

		public static void setFilename(String filename) {
			TerminalScreen.filename = filename;
		}
		
		public static void setTerminal1(SubTerminalController t){
			terminal1=t;
		}
		
		public static void setTerminal2(SubTerminalController t){
			terminal2=t;
		}
		public static void setTerminal3(SubTerminalController t){
			terminal3=t;
		}
		public static void setTerminal4(SubTerminalController t){
			terminal4=t;
		}
		
		public static SubTerminalController getTerminal1(){
			return terminal1;
		}
		
		public static SubTerminalController getTerminal2(){
			return terminal2;
		}
		
		public static SubTerminalController getTerminal3(){
			return terminal3;
		}
		
		public static SubTerminalController getTerminal4(){
			return terminal4;
		}
		
		
		

		/*
		 * @Override public void start(Stage primaryStage) throws Exception {
		 * primaryStage.setTitle("Embedded Media Player"); // Group root= new
		 * Group (); Pane root = FXMLLoader.load(getClass().getResource(
		 * "/view/MultimediaView.fxml")); Scene scene = new Scene(root, 320,
		 * 240);
		 * 
		 * // create media player Media media = new Media((arg1 != null) ? arg1
		 * : MEDIA_URL); MediaPlayer mediaPlayer = new MediaPlayer(media);
		 * mediaPlayer.setAutoPlay(true);
		 * 
		 * MediaControl mediaControl = new MediaControl(mediaPlayer);
		 * scene.setRoot(mediaControl);
		 * 
		 * 
		 * primaryStage.setScene(scene); primaryStage.show();
		 * 
		 * }
		 
   
		public void reproducirVideo() {
			Group root = new Group();
			Pane root = FXMLLoader.load(getClass().getResource(
					"/view/MultimediaView.fxml"));

		}
		*/

		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
			// TODO Auto-generated method stub
			
		}

		public static MediaPlayer playMedia(String URL,String terminal) {
			// TODO Auto-generated method stub
			
			switch (terminal) {
			case "TERMINAL 1":
				return terminal1.reproducirMedia(URL);
			case "TERMINAL 2":
				return terminal2.reproducirMedia(URL);
			case "TERMINAL 3":
				return terminal3.reproducirMedia(URL);
			case "TERMINAL 4":
				return terminal4.reproducirMedia(URL);
			default:
				break;
			}
			return null;
		}
		


		public static void setTerminal(SubTerminalController controller,
				int terminal) {
			switch (terminal) {
			case 1: 
				terminal1=controller;				
				break;
			case 2:
				terminal2=controller;
				break;
			case 3:
				terminal3=controller;
				break;
			case 4:
				terminal4=controller;
				break;

			default:
				break;
			}
			
		}
		


	}

}
