package controller;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import model.Cancion;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class AudioPlayController implements Initializable {
	@FXML
	private TableView<Cancion> Tabla1;
	@FXML
	private TableColumn Columna1;
	@FXML
	private TableColumn Columna2;

	private MediaPlayer player;

	@FXML
	private Label pista;

	@FXML
	private Button Estado;
	private static MediaView mediaView;
	public static Integer cancionPos = 0;
	private List<MediaPlayer> players = new ArrayList<>();
	private Integer cancionActual;
	public static final int FILE_EXTENSION_LEN = 3;
	Hashtable<String, String> nombresCanciones = new Hashtable<String, String>();

	public List<String> nombres = new ArrayList();
	private Main mainApp;
	public static final List<String> SUPPORTED_FILE_EXTENSIONS = Arrays.asList(
			".mp3", ".m4a");

	private static Integer salio = 0;
	private ChangeListener<Duration> progressChangeListener;
	private MapChangeListener<String, Object> metadataChangeListener;
	public ArrayList<Cancion> CancionesPorIndice = new ArrayList<Cancion>();

	ObservableList<Cancion> canciones = FXCollections.observableArrayList();

	@FXML
	private ProgressBar progresoCancion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.inicializarTablaMusica();

		final ObservableList<Cancion> tablaCancionSel = Tabla1
				.getSelectionModel().getSelectedItems();
		tablaCancionSel.addListener(selectorTablaCanciones);

	}

	// CARGO LA LISTA DE TEMAS
	public void cargarTemas(List<String> params, String Lista) {
		
		// CUANDO ENTRO PREGUNTO SI ALGO SE ESTA REPRODUCIENDO
		if (salio == 1) {
			System.out.println("Entro");
			mediaView.getMediaPlayer().stop();
			salio = 0;
		}
		
		
		
		mediaView = new MediaView();
		final File dir = (params.size() > 0) ? new File(params.get(0))
				: new File(Lista);
		
		//PREGUNTABAS POR EL PATH
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("Cannot find audio source directory: " + dir
					+ " please supply a directory as a command line argument");
			Platform.exit();
			return;
		}
		// CREA LA LISTA DE LAS CANCIONES

		int posicion = 0;
		
		for (String file : dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				System.out.println(name.toString());// LISTADO DE TODOS LOS
													// TEMAS

				canciones.add(new Cancion(name, "Alan"));

					// EXTENSION QUE ESTA DEFINIDA ARRIBA
				for (String ext : SUPPORTED_FILE_EXTENSIONS) {
					if (name.endsWith(ext)) {

						return true;
					}
				}

				return false;
			}
		}))
			
			players.add(createPlayer("file://"
					+ (dir + "\\" + file).replace("\\", "/").replaceAll(" ",
							"%20")));

		if (players.isEmpty()) {
			System.out.println("No audio found in " + dir);
			Platform.exit();
			return;
		}

		// CREAR EL MEDIAVIEW QUE ES EL QUE REPRODUCE Y MANEJA TODO
		mediaView = new MediaView(players.get(0));
		
		
		for (int i = 0; i < players.size(); i++) {
			player = players.get(i);
			final MediaPlayer nextPlayer = players
					.get((i + 1) % players.size());
			
			
			player.setOnEndOfMedia(new Runnable() {
				@Override
				public void run() {
					player.currentTimeProperty().removeListener(
							progressChangeListener);
					player.getMedia().getMetadata()
							.removeListener(metadataChangeListener);
					player.stop();
					mediaView.setMediaPlayer(nextPlayer);
					nextPlayer.play();
				}
			});
		}
		
		mediaView.setMediaPlayer(players.get(2));// ACA VA LA PRUEBA DE QUE
													// REPRODUZCA EL TEMA EN LA
													// POSICION 0
		
		mediaView.getMediaPlayer().play();
		cancionActual = 0;
		Cancion c = canciones.get(0);
		pista.setText(c.getNombre().toString());
		setCurrentlyPlaying(mediaView.getMediaPlayer());


		
		
		
		// por si se acaba y tengo que reproducir de nuevo  AUN LE FALTA----------------------------------------

		
		for (Integer i = 0; i < players.size(); i++) {
			final MediaPlayer player = players.get(i);
			final MediaPlayer nextPlayer = players
					.get((i + 1) % players.size());
			cancionPos = i;
			System.out.println(i.toString());
			player.setOnEndOfMedia(new Runnable() {
				@Override
				public void run() {
					player.currentTimeProperty().removeListener(
							progressChangeListener);
					// player.getMedia().getMetadata().removeListener(metadataChangeListener);
					player.stop();
					
					
					
					mediaView.setMediaPlayer(nextPlayer);
					nextPlayer.play();
					Estado.setText("Pause");
	 
				
					setCurrentlyPlaying(mediaView.getMediaPlayer());
					
					if (cancionPos == canciones.size()) {
						 
						pista.setText(canciones.get(0).getNombre().toString());
						cancionPos=0;
					} else {
					 
						pista.setText(canciones.get(cancionPos).getNombre().toString());
					}
					cancionPos++;
					
				}
			});
		}

	}

	// CREA LA CANCION
	private MediaPlayer createPlayer(String mediaSource) {
		final Media media = new Media(mediaSource);

		final MediaPlayer player = new MediaPlayer(media);

		player.setOnError(new Runnable() {
			@Override
			public void run() {
				System.out.println("Media error occurred: " + player.getError());
			}
		});
		return player;
	}

	// INICIALIZADOR
	public void inicializarTablaMusica() {

		Columna1.setCellValueFactory(new PropertyValueFactory<Cancion, String>(
				"Nombre"));
		Tabla1.setItems(canciones);
	}

	/**
	 * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
	 */
	public Cancion getTablaCancionesSeleccionadas() {
		if (canciones != null) {
			List<Cancion> tabla = Tabla1.getSelectionModel().getSelectedItems();
			if (tabla.size() == 1) {
				final Cancion competicionSeleccionada = tabla.get(0);
				return competicionSeleccionada;
			}
		}
		return null;
	}

	// LISTENER
	private final ListChangeListener<Cancion> selectorTablaCanciones = new ListChangeListener<Cancion>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends Cancion> c) {
			ponerCancionSeleccionada();
		}
	};

	// METODO QUE HACE LA REPRODUCCION COMPLETA(TOMA EL SIG Y REPRODUCE)
	private int posicionCancionEnTabla;

	private void ponerCancionSeleccionada() {
		final Cancion cancionElegida = getTablaCancionesSeleccionadas();
		posicionCancionEnTabla = canciones.indexOf(cancionElegida);
		if (cancionElegida != null) {
			pista.setText(cancionElegida.getNombre().toString());
			final MediaPlayer curPlayer = mediaView.getMediaPlayer();
			curPlayer.stop();

			MediaPlayer nextPlayer = players.get(posicionCancionEnTabla);
			mediaView.setMediaPlayer(nextPlayer);
			nextPlayer.play();
			Estado.setText("Pause");
			setCurrentlyPlaying(mediaView.getMediaPlayer());
		}
	}

	// SIGUIENTE
	@FXML
	private void Siguiente() {

		final MediaPlayer curPlayer = mediaView.getMediaPlayer();

		curPlayer.stop();

		cancionActual = (players.indexOf(curPlayer) + 1);

		// Por si el siguiente es el ultimo de la lista
		if (cancionActual == canciones.size()) {
			Cancion c = canciones.get(0);
			pista.setText(c.getNombre().toString());
		} else {
			Cancion c = canciones.get(cancionActual);
			pista.setText(c.getNombre().toString());
		}

		MediaPlayer nextPlayer = players.get((players.indexOf(curPlayer) + 1)
				% players.size());

		mediaView.setMediaPlayer(nextPlayer);

		nextPlayer.play();

		Estado.setText("Pause");
		setCurrentlyPlaying(mediaView.getMediaPlayer());

		// por si se acaba y tengo que reproducir de nuevo  AUN LE FALTA----------------------------------------

		for (Integer i = 0; i < players.size(); i++) {
			final MediaPlayer player = players.get(i);
			final MediaPlayer nextPlayer2 = players.get((i + 1)
					% players.size());
			cancionPos = i;
			System.out.println("Siguiente"+i.toString());
			player.setOnEndOfMedia(new Runnable() {
				@Override
				public void run() {
					 
					player.currentTimeProperty().removeListener(
							progressChangeListener);

					player.stop();
 
					mediaView.setMediaPlayer(nextPlayer2);
					nextPlayer2.play();
					Estado.setText("Pause");
	 
				
					setCurrentlyPlaying(mediaView.getMediaPlayer());
					
					if (cancionPos == canciones.size()) {
						 
						pista.setText(canciones.get(0).getNombre().toString());
						cancionPos=0;
					} else {
					 
						pista.setText(canciones.get(cancionPos).getNombre().toString());
					}
					cancionPos++;
					
				}
			});
		}

	}

	// PLAY o STOP

	@FXML
	private void CambiarEstado() {

		if ("Pause".equals(Estado.getText())) {
			mediaView.getMediaPlayer().pause();
			Estado.setText("Play");
		} else {
			mediaView.getMediaPlayer().play();
			Estado.setText("Pause");
		}
	}

	// LA BARRA DE LA CANCION
	private void setCurrentlyPlaying(final MediaPlayer newPlayer) {
		newPlayer.seek(Duration.ZERO);

		progresoCancion.setProgress(0);// INICIALIZO LA BARRA
		progressChangeListener = new ChangeListener<Duration>() {
			@Override
			public void changed(
					ObservableValue<? extends Duration> observableValue,
					Duration oldValue, Duration newValue) {
				progresoCancion.setProgress(1.0
						* newPlayer.getCurrentTime().toMillis()
						/ newPlayer.getTotalDuration().toMillis());
			}
		};
		newPlayer.currentTimeProperty().addListener(progressChangeListener);

	}

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void Back() {
		salio++;
		this.getMainApp().changeScene("Music", "AnchorPane");

	}

}
