package de.pk.view.visuell.customControls.questLog;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;

public class QuestLog extends StackPane implements Initializable, Lokalisierbar
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "QuestLog.fxml";

	@FXML
	private DialogPane questLogDialogPane;
	@FXML
	private ListView<?> questLogListView;
	@FXML
	private ToggleButton questLogButton;

	/**
	 * Erstellt einen neuen QuestLog, indem die fxml-Datei geladen wird und diese
	 * Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public QuestLog()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(QuestLog.FXML_PFAD));
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
		// TODO ListeView mit Quests fuellen
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		if (this.questLogButton.isSelected())
		{
			this.questLogButton.setTooltip(
					new Tooltip(sprachRessource.getString(LokalisierungsKeys.TOOLTIP_QUEST_LOG_SCHLIESSEN_KEY)));
		} else
		{
			this.questLogButton.setTooltip(
					new Tooltip(sprachRessource.getString(LokalisierungsKeys.TOOLTIP_QUEST_LOG_OEFFNEN_KEY)));
		}
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
			this.questLogButton
					.setStyle("-fx-background-image: url('/de/pk/ressourcen/bildDateien/buttonIcons/Forward_BTN.png')");
		} else
		{
			this.questLogDialogPane.setVisible(false);
			this.questLogButton
					.setStyle("-fx-background-image: url('/de/pk/ressourcen/bildDateien/buttonIcons/Menu_BTN.png')");
		}
		this.aktualisiereTextKomponenten(Einstellungen.getEinstellungen().getSprachRessource());
	}

}
