package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.app.Anwendung;
import de.pk.control.spiel.Dungeon;
import de.pk.model.interaktion.WuerfelWurf;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import de.pk.view.visuell.AnwendungFX;
import de.pk.view.visuell.customControls.einstellungenControlPane.EinstellungenControlPane;
import de.pk.view.visuell.customControls.heldenStatusAnzeige.HeldenStatusAnzeige;
import de.pk.view.visuell.customControls.karteGridPane.KarteGridPane;
import de.pk.view.visuell.customControls.obereDungeonLeiste.ObereDungeonAnzeige;
import de.pk.view.visuell.customControls.questLog.QuestLog;
import de.pk.view.visuell.customControls.unschaerfeFensterDialog.UnschaerfeFensterDialog;
import de.pk.view.visuell.customControls.untereDungeonLeiste.UntereDungeonAnzeige;
import de.pk.view.visuell.events.KachelPositionEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class TODO: An einen Dungeon anbinden und dessen Karte, Name,
 * Quests etc. "einlesen" und anzeigen.
 *
 * @author Dylan
 */
public class DungeonSzeneController implements Initializable, Lokalisierbar
{

	private Dungeon aktiverDungeon = null;

	@FXML
	private BorderPane dungeonBorderPane;
	@FXML
	private KarteGridPane karteGridPane;
	@FXML
	private HeldenStatusAnzeige heldenStatusAnzeige;
	@FXML
	private UntereDungeonAnzeige untereDungeonAnzeige;
	@FXML
	private ObereDungeonAnzeige obereDungeonAnzeige;
	@FXML
	private QuestLog questLog;

	@FXML
	private UnschaerfeFensterDialog pauseMenueDialogPane;
	@FXML
	private Label pauseLabel;
	@FXML
	private Button pauseMenueZurueckButton;
	@FXML
	private Button pauseMenueBeendenButton;
	@FXML
	private UnschaerfeFensterDialog einstellungenDialogPane;
	@FXML
	private Label einstellungenLabel;
	@FXML
	private Button einstellungenZurueckButton;
	@FXML
	private EinstellungenControlPane einstellungenControlPane;

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		this.heldenStatusAnzeige.aktualisiereTextKomponenten(sprachRessource);
		this.untereDungeonAnzeige.aktualisiereTextKomponenten(sprachRessource);
		this.obereDungeonAnzeige.aktualisiereTextKomponenten(sprachRessource);
		this.questLog.aktualisiereTextKomponenten(sprachRessource);
		this.karteGridPane.aktualisiereTextKomponenten(sprachRessource);
		this.pauseMenueDialogPane.aktualisiereTextKomponenten(sprachRessource);
		this.einstellungenDialogPane.aktualisiereTextKomponenten(sprachRessource);
		this.einstellungenControlPane.aktualisiereTextKomponenten(sprachRessource);
		this.pauseMenueBeendenButton.setText(sprachRessource.getString(LokalisierungsKeys.BEENDEN_KEY));
		this.pauseMenueZurueckButton.setText(sprachRessource.getString(LokalisierungsKeys.ZURUECK_KEY));
		this.einstellungenZurueckButton.setText(sprachRessource.getString(LokalisierungsKeys.ZURUECK_KEY));
		this.pauseLabel.setText(sprachRessource.getString(LokalisierungsKeys.PAUSE_KEY));
		this.einstellungenLabel.setText(sprachRessource.getString(LokalisierungsKeys.EINSTELLUNGEN_KEY));
	}

	/**
	 * Wird zu Beginn aufgerufen, um gewisse Komponenten zu initialisieren.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.initObereAnzeigeButtonEvents();
		this.initKartenGridPane();
	}

	/**
	 * Es wird ein EventHandler fuer das Anklicken einer Kachel der Karte
	 * hinzugefuegt. Ueber das KachelPositionEvent kann die KachelPosition der
	 * angeklickten Kachel ausgelesen werden.
	 */
	private void initKartenGridPane()
	{
		this.karteGridPane.addEventHandler(KachelPositionEvent.KACHEL_ANGELICKT,
				(a) -> this.kachelPositionAngeklickt(a));
	}

	/**
	 * Es wird ein EventHandler fuer die ActionEvents der Menue-Buttons der oberen
	 * Dungeon-Anzeige hinzugefuegt.
	 */
	private void initObereAnzeigeButtonEvents()
	{
		this.obereDungeonAnzeige.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event)
			{
				// fx:id des jeweiligen Buttons, der das ActionEvent ausgeloest hat.
				switch (((Control) event.getTarget()).getId())
				{
				case ObereDungeonAnzeige.BEZEICHNER_MENUE_BUTTON_1: // erster MenueButton
				{
					break;
				}
				case ObereDungeonAnzeige.BEZEICHNER_MENUE_BUTTON_2: // zweiter MenueButton
				{
					DungeonSzeneController.this.einstellungenDialogPane.setSichtbar(
							DungeonSzeneController.this.dungeonBorderPane, DungeonSzeneController.this.karteGridPane);
					break;
				}
				case ObereDungeonAnzeige.BEZEICHNER_MENUE_BUTTON_3: // dritter MenueButton
				{
					DungeonSzeneController.this.pauseMenueDialogPane.setSichtbar(
							DungeonSzeneController.this.dungeonBorderPane, DungeonSzeneController.this.karteGridPane);
					break;
				}
				}
			}
		});
	}

	/**
	 * Wird aufergurfen, wenn der pauseMenueZurueckButton gedrueckt wurde.
	 */
	@FXML
	public void zurueckButtonPressed()
	{
		this.pauseMenueDialogPane.setUnsichtbar();
		this.einstellungenDialogPane.setUnsichtbar();
	}

	/**
	 * Wird aufergurfen, wenn der pauseMenueBeendenButton gedrueckt wurde.
	 */
	@FXML
	public void pauseMenueBeendenButtonPressed()
	{
		this.pauseMenueDialogPane.setUnsichtbar();
		AnwendungFX.zeigeSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

	private void kachelPositionAngeklickt(KachelPositionEvent event)
	{
		if (this.untereDungeonAnzeige.getAktiveAktion() > -1)
		{
			this.aktiverDungeon.getAktivePhase().verarbeiteKlickAufKachelPosition(event.getEventKachelPosition(),
					this.untereDungeonAnzeige.getAktiveAktion());
		}
	}

	public void setDungeon(Dungeon dungeon)
	{
		Anwendung.getInstanz().getAktivesSpiel().waehleDungeon(dungeon);
		dungeon.getWuerfel().addListener(new ChangeListener<WuerfelWurf>()
		{
			@Override
			public void changed(ObservableValue<? extends WuerfelWurf> observable, WuerfelWurf oldValue,
					WuerfelWurf newValue)
			{
				System.out.println(newValue.warErfolgreich());

			}
		});
		this.aktiverDungeon = dungeon;
		this.karteGridPane.setSpielbrett(this.aktiverDungeon.getSpielbrett());
		this.heldenStatusAnzeige.setHelden(this.aktiverDungeon.getHelden());
		this.obereDungeonAnzeige.setAnzuzeigendenDungeonTitel(dungeon.getName());
		this.obereDungeonAnzeige.setAnzuzeigendenDungeonFortschritt(50);
		this.obereDungeonAnzeige.setAnzuzeigendeAnzahlFragmente(10);
	}

}
