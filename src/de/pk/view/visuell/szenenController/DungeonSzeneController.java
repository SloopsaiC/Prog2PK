package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spiel.Dungeon;
import de.pk.model.position.KachelPosition;
import de.pk.model.position.Position;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.view.visuell.customControls.heldenStatusAnzeige.HeldenStatusAnzeige;
import de.pk.view.visuell.customControls.karteGridPane.KarteGridPane;
import de.pk.view.visuell.customControls.obereDungeonLeiste.ObereDungeonAnzeige;
import de.pk.view.visuell.customControls.pauseDialog.PauseDialog;
import de.pk.view.visuell.customControls.questLog.QuestLog;
import de.pk.view.visuell.customControls.untereDungeonLeiste.UntereDungeonAnzeige;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class TODO: An einen Dungeon anbinden und dessen Karte, Name,
 * Quests etc. "einlesen" und anzeigen.
 *
 * @author Dylan
 */
public class DungeonSzeneController implements Initializable, Lokalisierbar
{
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

	private KachelPosition erstelleKachelPositionAusMouseEvent(MouseEvent event)
	{
		Node quelle = ((Node) event.getSource());
		Integer test = GridPane.getColumnIndex(quelle);
		Position positionDerKachel = new Position(GridPane.getColumnIndex(quelle.getParent()).intValue(),
				GridPane.getRowIndex(quelle.getParent()).intValue());
		return null;
	}

	/**
	 * Wird aufgerufen, wenn mit der Maus ins Fenster geklickt wurde und waehrend
	 * dieses Klicken andauert.
	 *
	 * @param event MouseEvent des Mausklicks
	 */
	@FXML
	public void kartenGridPaneMousePressed(MouseEvent event)
	{
		this.oldX = event.getX();
		this.oldY = event.getY();
		if (this.untereDungeonAnzeige.getAktiveAktion() >= 0)
		{
			this.erstelleKachelPositionAusMouseEvent(event);
		}
	}

	public void setDungeon(Dungeon dungeon)
	{
		this.aktiverDungeon = dungeon;
		this.karteGridPane.setSpielbrett(this.aktiverDungeon.getSpielbrett());
		this.heldenStatusAnzeige.setHelden(this.aktiverDungeon.getHelden());
		this.obereDungeonAnzeige.setAnzuzeigendenDungeonTitel(dungeon.getName());
		this.obereDungeonAnzeige.setAnzuzeigendenDungeonFortschritt(50);
		this.obereDungeonAnzeige.setAnzuzeigendeAnzahlFragmente(10);
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
		this.karteGridPane.verschiebeBeiMouseEvent(event, this.oldX, this.oldY);
		this.oldX = event.getX();
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
		this.karteGridPane.skaliereBeiScrollEvent(event);
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
