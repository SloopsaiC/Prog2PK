package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.app.Anwendung;
import de.pk.control.spiel.Dungeon;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.view.visuell.customControls.heldenStatusAnzeige.HeldenStatusAnzeige;
import de.pk.view.visuell.customControls.karteGridPane.KarteGridPane;
import de.pk.view.visuell.customControls.obereDungeonLeiste.ObereDungeonAnzeige;
import de.pk.view.visuell.customControls.pauseDialog.PauseDialog;
import de.pk.view.visuell.customControls.questLog.QuestLog;
import de.pk.view.visuell.customControls.untereDungeonLeiste.UntereDungeonAnzeige;
import de.pk.view.visuell.events.KachelPositionEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class TODO: An einen Dungeon anbinden und dessen Karte, Name,
 * Quests etc. "einlesen" und anzeigen.
 *
 * @author Dylan
 */
public class DungeonSzeneController implements Initializable, Lokalisierbar
{

	@FXML
	private BorderPane dungeonBorderPane;
	@FXML
	private PauseDialog pauseMenueDialogPane;
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

	private Dungeon aktiverDungeon = null;

	/**
	 * Wird zu Beginn aufgerufen, um gewisse Komponenten zu initialisieren.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		initObereAnzeigeButtonEvents();
		initPauseMenueDialogPaneButtonEvents();
		initKartenGridPane();
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

	private void kachelPositionAngeklickt(KachelPositionEvent event)
	{
		if (this.untereDungeonAnzeige.getAktiveAktion() > -1)
		{
			this.aktiverDungeon.getAktivePhase().verarbeiteKlickAufKachelPosition(event.getEventKachelPosition(),
					this.untereDungeonAnzeige.getAktiveAktion());
		}
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
					DungeonSzeneController.this.heldenStatusAnzeige.markiereAktuelleHeldenStatusHBox(0);
					break;
				}
				case ObereDungeonAnzeige.BEZEICHNER_MENUE_BUTTON_2: // zweiter MenueButton
				{
					DungeonSzeneController.this.heldenStatusAnzeige.markiereAktuelleHeldenStatusHBox(3);
					break;
				}
				case ObereDungeonAnzeige.BEZEICHNER_MENUE_BUTTON_3: // dritter MenueButton
				{
					DungeonSzeneController.this.dungeonBorderPane.setEffect(new GaussianBlur());
					DungeonSzeneController.this.karteGridPane.setEffect(new GaussianBlur());
					DungeonSzeneController.this.pauseMenueDialogPane.setVisible(true);
					break;
				}
				}
			}
		});
	}

	/**
	 * Es wird ein EventHandler fuer die ActionEvents des ZurueckButtons des
	 * PauseMenueDialogPanes hinzugefuegt.
	 */
	private void initPauseMenueDialogPaneButtonEvents()
	{
		this.pauseMenueDialogPane.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event)
			{
				// fx:id des jeweiligen Buttons, der das ActionEvent ausgeloest hat.
				if (((Control) event.getTarget()).getId().equals(PauseDialog.BEZEICHNER_ZURUECK_BUTTON)
						|| ((Control) event.getTarget()).getId().equals(PauseDialog.BEZEICHNER_BEENDEN_BUTTON))
				{
					DungeonSzeneController.this.karteGridPane.setEffect(null);
				}
			}
		});

	}

	public void setDungeon(Dungeon dungeon)
	{
		Anwendung.getInstanz().getAktivesSpiel().waehleDungeon(dungeon);
		this.aktiverDungeon = dungeon;
		this.karteGridPane.setSpielbrett(this.aktiverDungeon.getSpielbrett());
		this.heldenStatusAnzeige.setHelden(this.aktiverDungeon.getHelden());
		this.obereDungeonAnzeige.setAnzuzeigendenDungeonTitel(dungeon.getName());
		this.obereDungeonAnzeige.setAnzuzeigendenDungeonFortschritt(50);
		this.obereDungeonAnzeige.setAnzuzeigendeAnzahlFragmente(10);
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		this.pauseMenueDialogPane.aktualisiereTextKomponenten(sprachRessource);
		this.heldenStatusAnzeige.aktualisiereTextKomponenten(sprachRessource);
		this.untereDungeonAnzeige.aktualisiereTextKomponenten(sprachRessource);
		this.obereDungeonAnzeige.aktualisiereTextKomponenten(sprachRessource);
		this.questLog.aktualisiereTextKomponenten(sprachRessource);
		this.karteGridPane.aktualisiereTextKomponenten(sprachRessource);
		// TODO sonstige Lokalisierungen
	}

}
