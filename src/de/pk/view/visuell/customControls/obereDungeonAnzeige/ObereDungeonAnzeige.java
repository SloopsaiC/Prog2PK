package de.pk.view.visuell.customControls.obereDungeonAnzeige;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.lokalisierung.Lokalisierbar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;

public class ObereDungeonAnzeige extends StackPane implements Initializable, Lokalisierbar
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "ObereDungeonAnzeige.fxml";

	public static final String BEZEICHNER_MENUE_BUTTON_1 = "dungeonMenueButton1";
	public static final String BEZEICHNER_MENUE_BUTTON_2 = "dungeonMenueButton2";
	public static final String BEZEICHNER_MENUE_BUTTON_3 = "dungeonMenueButton3";

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
	private Label dungeonTitelLabel;
	@FXML
	private ProgressBar dungeonFortschrittProgressBar;

	/**
	 * Erstellt eine neue ObereDungeonAnzeige, indem die fxml-Datei geladen wird und
	 * diese Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public ObereDungeonAnzeige()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(ObereDungeonAnzeige.FXML_PFAD));
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

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		// TODO Lokalisierung
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//
	}

	public void setAnzuzeigendeAnzahlFragmente(int anzahlFragmente)
	{
		this.fragmenteAnzeigeLabel.setText(String.valueOf(anzahlFragmente));
	}

	public void setAnzuzeigendeMengeGold(int mengeGold)
	{
		this.goldAnzeigeLabel.setText(String.valueOf(mengeGold));
	}

	public void setAnzuzeigendenDungeonFortschritt(int fortschrittInProzent)
	{
		this.dungeonFortschrittProgressBar.setProgress(fortschrittInProzent / 100.0d);
	}

	public void setAnzuzeigendenDungeonTitel(String dungeonTitel)
	{
		this.dungeonTitelLabel.setText(dungeonTitel);
	}

}
