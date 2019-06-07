package de.pk.view.visuell.customControls.untereDungeonAnzeige;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.lokalisierung.Lokalisierbar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class UntereDungeonAnzeige extends HBox implements Initializable, Lokalisierbar
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "UntereDungeonAnzeige.fxml";

	private static final int AKTIVE_AKTION_INDEX_STANDARD_WERT = -1, AKTIVE_AKTION_INDEX_BUTTON_1 = 0,
			AKTIVE_AKTION_INDEX_BUTTON_2 = 1, AKTIVE_AKTION_INDEX_BUTTON_3 = 2, AKTIVE_AKTION_INDEX_BUTTON_4 = 3;

	/**
	 * Der Held, dessen Attribute von dieser UntereDungeonAnzeige ueberwacht und
	 * angezeigt werden sollen.
	 */
	private Held aktuellerHeld = null;

	private ToggleGroup aktionenToggleButtons = null;

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
	private ToggleButton aktionButton1;
	@FXML
	private ToggleButton aktionButton2;
	@FXML
	private ToggleButton aktionButton3;
	@FXML
	private ToggleButton aktionButton4;
	// Buttons fuer Inventar:
	@FXML
	private Button heldenInventarButton1;
	@FXML
	private Button heldenInventarButton2;
	@FXML
	private Button heldenInventarButton3;
	@FXML
	private Button heldenInventarButton4;
	// Labels fuer wirkende Effekte
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

	private int aktiveAktionsIndex = UntereDungeonAnzeige.AKTIVE_AKTION_INDEX_STANDARD_WERT;

	/**
	 * Erstellt eine neue UntereDungeonAnzeige, indem die fxml-Datei geladen wird
	 * und diese Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public UntereDungeonAnzeige()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(UntereDungeonAnzeige.FXML_PFAD));
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

	@FXML
	public void aktionButton1Pressed(ActionEvent event)
	{
		this.aktiveAktionsIndex = UntereDungeonAnzeige.AKTIVE_AKTION_INDEX_BUTTON_1;
	}

	@FXML
	public void aktionButton2Pressed(ActionEvent event)
	{
		this.aktiveAktionsIndex = UntereDungeonAnzeige.AKTIVE_AKTION_INDEX_BUTTON_2;
	}

	@FXML
	public void aktionButton3Pressed(ActionEvent event)
	{
		this.aktiveAktionsIndex = UntereDungeonAnzeige.AKTIVE_AKTION_INDEX_BUTTON_3;
	}

	@FXML
	public void aktionButton4Pressed(ActionEvent event)
	{
		this.aktiveAktionsIndex = UntereDungeonAnzeige.AKTIVE_AKTION_INDEX_BUTTON_4;
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		//
	}

	public int getAktiveAktion()
	{
		return this.aktiveAktionsIndex;
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

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.aktionenToggleButtons = new ToggleGroup();
		this.aktionButton1.setToggleGroup(aktionenToggleButtons);
		this.aktionButton2.setToggleGroup(aktionenToggleButtons);
		this.aktionButton3.setToggleGroup(aktionenToggleButtons);
		this.aktionButton4.setToggleGroup(aktionenToggleButtons);
	}

	private void resetAktiveAktion()
	{
		this.aktiveAktionsIndex = UntereDungeonAnzeige.AKTIVE_AKTION_INDEX_STANDARD_WERT;
		this.aktionenToggleButtons.getSelectedToggle().setSelected(false);
	}

	/**
	 * Legt den aktuellen Helden fest, der von dieser Anzeige "ueberwacht" werden
	 * sollen. Es werden somit automatisch immer die aktuellen Werte der Attribute
	 * auf die entsprechenden Anzeigen dieser StatusAnzeige gelegt.
	 *
	 * @param aktuellerHeld Der Held, dessen Attribute von dieser
	 *                      UntereDungeonAnzeige ueberwacht und angezeigt werden
	 *                      sollen.
	 */
	public void setAktuellerHeld(Held held)
	{
		this.aktuellerHeld = held;
	}

	public Held getAktuellerHeld()
	{
		return this.aktuellerHeld;
	}

}
