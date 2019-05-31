package de.pk.view.visuell.customControls.untereDungeonLeiste;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;

public class UntereDungeonAnzeige extends HBox implements Initializable
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "UntereDungeonAnzeige.fxml";

	/**
	 * Der Held, dessen Attribute von dieser UntereDungeonAnzeige ueberwacht und
	 * angezeigt werden sollen.
	 */
	private Held held = null;

	// Leben, Faehigkeit, Erfahrung:
	@FXML
	private ProgressIndicator grosseLebensPunkteAnzeigeProgressIndicator;
	@FXML
	private ProgressIndicator grosseSpezialFaehigkeitsAnzeigeProgressIndicator;
	@FXML
	private ProgressBar erfahrungsPunkteProgressBar;
	@FXML
	private Label erfahrungsPunkteGesamtLevelLabel;

	// Buttons fuer Aktionen:
	@FXML
	private Button aktionButton1;
	@FXML
	private Button aktionButton2;
	@FXML
	private Button aktionButton3;
	@FXML
	private Button aktionButton4;
	// Buttons fuer Inventar:
	@FXML
	private Button heldenInventarButton1;
	@FXML
	private Button heldenInventarButton2;
	@FXML
	private Button heldenInventarButton3;
	@FXML
	private Button heldenInventarButton4;
	// Buttons fuer wirkende Effekte
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

	/**
	 * Erstellt eine neue UntereDungeonAnzeige, indem die fxml-Datei geladen wird
	 * und diese Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public UntereDungeonAnzeige()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UntereDungeonAnzeige.FXML_PFAD));
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
	 * Legt den aktuellen Helden fest, der von dieser Anzeige "ueberwacht" werden
	 * sollen. Es werden somit automatisch immer die aktuellen Werte der Attribute
	 * auf die entsprechenden Anzeigen dieser StatusAnzeige gelegt.
	 *
	 * @param held Der Held, dessen Attribute von dieser UntereDungeonAnzeige
	 *             ueberwacht und angezeigt werden sollen.
	 */
	public void setAktuellenHelden(Held held)
	{
		this.held = held;
		aktualisiereHeldenAnzeige(this.held);
	}

	/**
	 * Initialisiert den Helden, indem seinen Attributen ChangeListener hinzugefuegt
	 * werden, die automatisch dafuer sorgen, dass die aktuellen Werte der Attribute
	 * stets auf die entsprechenden Anzeigen dieser UntereDungeonAnzeige gelegt
	 * werden.
	 *
	 * @param held Der zu ueberwachende Held
	 */
	private void aktualisiereHeldenAnzeige(Held held)
	{
		// TODO ChangeListener (oder ähnliches) für LP, EP und WIRKENDE EFFEKTE!
		// hinzufügen und Werte auf
		// entsprechende Anzeigen (die ganzen Bilder-Labels und ProgressBars) legen.

		// Achtung! Beachte das Weiterschieben der Helden! Reicht es, wenn diese Methode
		// jedes Mal bei "setAktuellenHelden()" auferufen wird?
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//
	}

	@FXML
	public void aktionButton1Pressed(ActionEvent event)
	{
		// TODO Aktion 1 ausfuehren, Bild anzeigen, etc.
	}

	@FXML
	public void aktionButton2Pressed(ActionEvent event)
	{
		// TODO Aktion 2 ausfuehren, Bild anzeigen, etc.
	}

	@FXML
	public void aktionButton3Pressed(ActionEvent event)
	{
		// TODO Aktion 3 ausfuehren, Bild anzeigen, etc.
	}

	@FXML
	public void aktionButton4Pressed(ActionEvent event)
	{
		// TODO Aktion 4 ausfuehren, Bild anzeigen, etc.
	}

	@FXML
	public void heldenInventarButton1Pressed(ActionEvent event)
	{
		// TODO Inventarplatz 1, Bild anzeigen, etc.
	}

	@FXML
	public void heldenInventarButton2Pressed(ActionEvent event)
	{
		// TODO Inventarplatz 2, Bild anzeigen, etc.
	}

	@FXML
	public void heldenInventarButton3Pressed(ActionEvent event)
	{
		// TODO Inventarplatz 3, Bild anzeigen, etc.
	}

	@FXML
	public void heldenInventarButton4Pressed(ActionEvent event)
	{
		// TODO Inventarplatz 4, Bild anzeigen, etc.
	}

}
