package de.pk.view.visuell.customControls.untereDungeonLeiste;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.interaktion.aktionen.Aktion;
import de.pk.utils.lokalisierung.Lokalisierbar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;

public class UntereDungeonAnzeige extends HBox implements Initializable, Lokalisierbar
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
	private Label wirkendeEffekteButton1;
	@FXML
	private Label wirkendeEffekteButton2;
	@FXML
	private Label wirkendeEffekteButton3;
	@FXML
	private Label wirkendeEffekteButton4;
	@FXML
	private Label wirkendeEffekteButton5;

	private int aktiveAktionsIndex = -1;

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
	public void setAktuellerHeld(Held held)
	{
		this.held = held;
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//
	}

	private void resetAktiveAktion()
	{
		this.aktiveAktionsIndex = -1;
	}

	@FXML
	public void aktionButton1Pressed(ActionEvent event)
	{
		this.aktiveAktionsIndex = 0;
	}

	@FXML
	public void aktionButton2Pressed(ActionEvent event)
	{
		this.aktiveAktionsIndex = 1;
	}

	@FXML
	public void aktionButton3Pressed(ActionEvent event)
	{
		this.aktiveAktionsIndex = 2;
	}

	@FXML
	public void aktionButton4Pressed(ActionEvent event)
	{
		this.aktiveAktionsIndex = 3;
	}

	@FXML
	public void heldenInventarButton1Pressed(ActionEvent event)
	{
		this.resetAktiveAktion();
	}

	@FXML
	public void heldenInventarButton2Pressed(ActionEvent event)
	{
		this.resetAktiveAktion();
	}

	@FXML
	public void heldenInventarButton3Pressed(ActionEvent event)
	{
		this.resetAktiveAktion();
	}

	@FXML
	public void heldenInventarButton4Pressed(ActionEvent event)
	{
		this.resetAktiveAktion();
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		// TODO Lokalisierung
	}

	public int getAktiveAktion()
	{
		return this.aktiveAktionsIndex;
	}

}
