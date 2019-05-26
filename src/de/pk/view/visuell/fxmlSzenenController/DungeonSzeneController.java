package de.pk.view.visuell.fxmlSzenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.view.visuell.fxmlSzenenLayouts.AnwendungFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class DungeonSzeneController implements Initializable
{

	@FXML
	private Label dungeonTitelLabel;
	@FXML
	private ProgressBar dungeonFortschrittProgressBar;
	@FXML
	private Button dungeonMenueButton1;
	@FXML
	private Button dungeonMenueButton2;
	@FXML
	private Button dungeonMenueButton3;
	@FXML
	private Label goldAnzeigeLabel;
	@FXML
	private Label fragmenteAnzeigeLabel;
	@FXML
	private ProgressIndicator grosseLebensPunkteAnzeigeProgressIndicator;
	@FXML
	private Button wirkendeEffekteButton1;
	@FXML
	private Button wirkendeEffekteButton2;
	@FXML
	private Button wirkendeEffekteButton3;
	@FXML
	private Button wirkendeEffekteButton4;
	@FXML
	private Button wirkendeEffekteButton5;
	@FXML
	private Button aktionButton1;
	@FXML
	private Button aktionButton2;
	@FXML
	private Button aktionButton3;
	@FXML
	private Button aktionButton4;
	@FXML
	private Button heldenInventarButton1;
	@FXML
	private Button heldenInventarButton2;
	@FXML
	private Button heldenInventarButton3;
	@FXML
	private Button heldenInventarButton4;
	@FXML
	private ProgressBar erfahrungsPunkteProgressBar;
	@FXML
	private Label erfahrungsPunkteGesamtLevelLabel;
	@FXML
	private ProgressIndicator grosseSpezialFaehigkeitsAnzeigeProgressIndicator;
	@FXML
	private HBox heldenStatusAnzeigeHBox1;
	@FXML
	private ImageView heldenAvatarImageView1;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar1;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar1;
	@FXML
	private ImageView aktuellerHeldenModusImageView1;
	@FXML
	private ImageView verbleibendePhasenImageView1;
	@FXML
	private ImageView verbleibendePhasenImageView2;
	@FXML
	private ImageView verbleibendePhasenImageView3;
	@FXML
	private HBox heldenStatusAnzeigeHBox2;
	@FXML
	private ImageView heldenAvatarImageView2;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar2;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar2;
	@FXML
	private ImageView aktuellerHeldenModusImageView2;
	@FXML
	private HBox heldenStatusAnzeigeHBox3;
	@FXML
	private ImageView heldenAvatarImageView3;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar3;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar3;
	@FXML
	private ImageView aktuellerHeldenModusImageView3;
	@FXML
	private HBox heldenStatusAnzeigeHBox4;
	@FXML
	private ImageView heldenAvatarImageView4;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar4;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar4;
	@FXML
	private ImageView aktuellerHeldenModusImageView4;
	@FXML
	private DialogPane pauseMenueDialogPane;
	@FXML
	private ToggleButton questLogButton;
	@FXML
	private DialogPane questLogDialogPane;
	@FXML
	private ListView<?> questLogListView;
	@FXML
	private GridPane kartenGridPane;

	/**
	 * Beinhaltet die x-Koordinate einer alten Position der Maus zum Vergleich mit
	 * einer Aktuelleren.
	 */
	private double oldX = 0;

	/**
	 * Beinhaltet die y-Koordinate einer alten Position der Maus zum Vergleich mit
	 * einer Aktuelleren.
	 */
	private double oldY = 0;

	/**
	 * Wird aufergurfen, wenn der aktionButton1Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void aktionButton1Pressed(ActionEvent event)
	{
		//
	}

	/**
	 * Wird aufergurfen, wenn der aktionButton2Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void aktionButton2Pressed(ActionEvent event)
	{
		//
	}

	/**
	 * Wird aufergurfen, wenn der aktionButton3Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void aktionButton3Pressed(ActionEvent event)
	{
		//
	}

	/**
	 * Wird aufergurfen, wenn der aktionButton4Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void aktionButton4Pressed(ActionEvent event)
	{
		//
	}

	/**
	 * Wird aufergurfen, wenn der dungeonMenueButton1Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void dungeonMenueButton1Pressed(ActionEvent event)
	{
		//
	}

	/**
	 * Wird aufergurfen, wenn der dungeonMenueButton2Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void dungeonMenueButton2Pressed(ActionEvent event)
	{
		//
	}

	/**
	 * Wird aufergurfen, wenn der dungeonMenueButton3Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void dungeonMenueButton3Pressed(ActionEvent event)
	{
		this.pauseMenueDialogPane.setVisible(true);
	}

	/**
	 * Wird aufergurfen, wenn der heldenInventarButton1Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void heldenInventarButton1Pressed(ActionEvent event)
	{
		//
	}

	/**
	 * Wird aufergurfen, wenn der heldenInventarButton2Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void heldenInventarButton2Pressed(ActionEvent event)
	{//
	}

	/**
	 * Wird aufergurfen, wenn der heldenInventarButton3Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void heldenInventarButton3Pressed(ActionEvent event)
	{
		//
	}

	/**
	 * Wird aufergurfen, wenn der heldenInventarButton4Pressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void heldenInventarButton4Pressed(ActionEvent event)
	{
		//
	}

	/**
	 * Wird zu Beginn aufgerufen, um gewisse Komponenten zu initialisieren.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//
	}

	/**
	 * Wird aufgerufen, wenn mit der Maus ins Fenster geklickt wurde.
	 *
	 * @param event MouseEvent des Mausklicks
	 */
	@FXML
	public void kartenGridPaneMouseClicked(MouseEvent event)
	{
		this.oldX = event.getX();
		this.oldY = event.getY();
	}

	/**
	 * Wird aufgerufen, wenn eine Maustaste heruntergedrueckt ist und die Maus dabei
	 * bewegt wird.
	 *
	 * @param event MouseEvent des Bewegens der gedrueckten Maus
	 */
	@FXML
	public void kartenGridPaneMouseDragged(MouseEvent event)
	{
		this.kartenGridPane.setTranslateX(this.kartenGridPane.getTranslateX() + ((event.getX() - this.oldX) / 2));
		this.oldX = event.getX();
		this.kartenGridPane.setTranslateY(this.kartenGridPane.getTranslateY() + ((event.getY() - this.oldY) / 2));
		this.oldY = event.getY();
	}

	/**
	 * Wird Aufgerufen, wenn mit dem Mausrad im Fenster "gescroolt" wird.
	 *
	 * @param event ScrollEvent des Mausraddrehens
	 */
	@FXML
	public void kartenGridPaneScroll(ScrollEvent event)
	{
		// Ein skalierungsFaktor wird je nach Mausrad-Drehrichtung ausgewahlt.
		double skalierungsFaktor = 1;
		if (event.getDeltaY() > 0)
		{
			skalierungsFaktor = 1.1;
		} else if (event.getDeltaY() < 0)
		{
			skalierungsFaktor = 1 / 1.1;
		}
		// Skaliert die Karte in x- und y-Dimension durch Multiplikation der aktuellen
		// Skalierung mit dem skalierungsFaktor.
		this.kartenGridPane.setScaleX(this.kartenGridPane.getScaleX() * skalierungsFaktor);
		this.kartenGridPane.setScaleY(this.kartenGridPane.getScaleY() * skalierungsFaktor);
	}

	/**
	 * Wird aufergurfen, wenn der pauseMenueBeendenButtonPressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void pauseMenueBeendenButtonPressed(ActionEvent event)
	{
		this.pauseMenueDialogPane.setVisible(false);
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

	/**
	 * Wird aufergurfen, wenn der pauseMenueZurueckButtonPressed aufgerufen wird.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void pauseMenueZurueckButtonPressed(ActionEvent event)
	{
		this.pauseMenueDialogPane.setVisible(false);
	}

	/**
	 * Wird aufgerufen, wenn der questLogButton gedrueckt wurde und entscheidet je
	 * nachdem, ob der Button ausgewaehlt ist oder nicht, ob das Quest Log angezeigt
	 * oder wieder versteckt werden soll.
	 *
	 * @param event ActionEvent fuer das Druecken des Buttons
	 */
	@FXML
	public void questLogButtonPressed(ActionEvent event)
	{
		if (this.questLogButton.isSelected())
		{
			this.questLogDialogPane.setVisible(true);
			this.questLogButton.setStyle("-fx-background-image: url('/de/pk/ressourcen/bildDateien/Forward_BTN.png')");
			this.questLogButton.setTooltip(new Tooltip("Schliesse das Quest Log"));
		} else
		{
			this.questLogDialogPane.setVisible(false);
			this.questLogButton.setStyle("-fx-background-image: url('/de/pk/ressourcen/bildDateien/Menu_BTN.png')");
			this.questLogButton.setTooltip(new Tooltip("Oeffne das Quest Log"));
		}
	}

}
