package de.pk.view.visuell.customControls.pauseDialog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.view.visuell.AnwendungFX;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;

public class PauseDialog extends DialogPane implements Initializable, Lokalisierbar
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "PauseDialog.fxml";

	public static final String BEZEICHNER_ZURUECK_BUTTON = "pauseMenueZurueckButton";

	public static final String BEZEICHNER_BEENDEN_BUTTON = "pauseMenueBeendenButton";

	@FXML
	private Button pauseMenueZurueckButton;
	@FXML
	private Button pauseMenueBeendenButton;

	/**
	 * Erstellt einen neuen PauseDialog, indem die fxml-Datei geladen wird und diese
	 * Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public PauseDialog()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PauseDialog.FXML_PFAD));
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

	/**
	 * Wird aufergurfen, wenn der pauseMenueZurueckButtonPressed aufgerufen wird.
	 */
	@FXML
	public void pauseMenueZurueckButtonPressed()
	{
		this.setVisible(false);
		this.getParent().setEffect(null);
		this.getParent().applyCss();
	}

	/**
	 * Wird aufergurfen, wenn der pauseMenueBeendenButtonPressed aufgerufen wird.
	 */
	@FXML
	public void pauseMenueBeendenButtonPressed()
	{
		this.setVisible(false);
		this.getParent().setEffect(null);
		this.getParent().applyCss();
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

}
