package de.pk.view.visuell.customControls.heldenStatusAnzeige.heldStatusHBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.lokalisierung.Lokalisierbar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

public class HeldStatusHBox extends HBox implements Initializable, Lokalisierbar
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "HeldStatusHBox.fxml";

	private Held held = null;

	@FXML
	private Label heldenAvatarLabel;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar;
	@FXML
	private Label aktuellerHeldenModusLabel;
	@FXML
	private Label verbleibendePhasenLabel1;
	@FXML
	private Label verbleibendePhasenLabel2;
	@FXML
	private Label verbleibendePhasenLabel3;

	/**
	 * Erstellt eine neue HeldStatusHBox, indem die fxml-Datei geladen wird und
	 * diese Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public HeldStatusHBox()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HeldStatusHBox.FXML_PFAD));
		try
		{
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	/**
	 * Legt den Helden fest, er von dieser Anzeige "ueberwacht" werden soll. Es
	 * werden somit automatisch immer die aktuellen Werte seiner Attribute auf die
	 * entsprechenden Anzeigen dieser StatusAnzeige gelegt.
	 *
	 * @param held Der Held, dessen Attribute von dieser StatusAnzeige ueberwacht
	 *             und angezeigt werden sollen.
	 */
	public void setHeld(Held held)
	{
		this.held = held;
		aktualisiereHeldenAnzeige(this.held);
	}

	/**
	 * Initialisiert die HeldStatusHBox, indem seinen Attributen ChangeListener
	 * hinzugefuegt werden, die automatisch dafuer sorgen, dass die aktuellen Werte
	 * seiner Attribute stets auf die entsprechenden Anzeigen dieser StatusHBox
	 * gelegt werden.
	 *
	 * @param held Der zu ueberwachende Held
	 */
	private void aktualisiereHeldenAnzeige(Held held)
	{
		// TODO ChangeListener (oder ähnliches) für LP, RP, etc. hinzufügen und Werte
		// auf
		// entsprechende Anzeigen (die ganzen Bilder-Labels und ProgressBars) legen.
	}

	/**
	 * Umrandet diese Box mit einem roten Rahmen.
	 */
	public void umrandeFarbig()
	{
		this.setStyle("-fx-border-style: solid inside;" + "-fx-border-color: rgb(100.0,30.0,30.0);"
				+ "-fx-border-width: 3;" + "-fx-border-radius: 10;");
	}

	/**
	 * Entfernt die Umrandung.
	 */
	public void entferneUmrandung()
	{
		this.setStyle("-fx-border-style: none;");
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		// TODO Lokalisierung
	}

}
