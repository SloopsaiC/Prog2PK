package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.karte.Weltkarte;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import de.pk.view.visuell.AnwendungFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author Philipp
 */
public class WeltkarteSzeneController implements Initializable, Lokalisierbar
{
	@FXML
	private Button dungeon1Button;
	@FXML
	private Tooltip dungeon1Info;
	@FXML
	private Button dungeon2Button;
	@FXML
	private Button dungeon3Button;
	@FXML
	private Button dungeon4Button;
	@FXML
	private Button dungeon5Button;
	@FXML
	private Button weltkarteZurueckButton;
	@FXML
	private Button weltkarteInsHauptmenueButton;

	private Weltkarte weltkarte = null;

	private void aktiviereDungeonMitIndex(int index)
	{
		((DungeonSzeneController) AnwendungFX.getSzenenController().get(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE))
				.setDungeon(this.weltkarte.getDungeonBei(index));
		AnwendungFX.zeigeSzene(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE);
	}

	@FXML
	public void dungeon1ButtonPressed(ActionEvent event)
	{
		this.aktiviereDungeonMitIndex(0);
	}

	@FXML
	public void dungeon2ButtonPressed(ActionEvent event)
	{
		this.aktiviereDungeonMitIndex(1);
	}

	@FXML
	public void dungeon3ButtonPressed(ActionEvent event)
	{
		this.aktiviereDungeonMitIndex(2);
	}

	@FXML
	public void dungeon4ButtonPressed(ActionEvent event)
	{
		this.aktiviereDungeonMitIndex(3);
	}

	@FXML
	public void dungeon5ButtonPressed(ActionEvent event)
	{
		this.aktiviereDungeonMitIndex(4);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//

	}

	public void setWeltkarte(Weltkarte weltkarte)
	{
		this.weltkarte = weltkarte;
	}

	@FXML
	public void weltkarteInsHauptmenueButtonPressed(ActionEvent event)
	{
		AnwendungFX.zeigeSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

	@FXML
	public void weltkarteZurueckButtonPressed(ActionEvent event)
	{
		AnwendungFX.zeigeSzene(Spielkonstanten.ANWENDUNG_SCHWIERIGKEIT_WAEHLEN_SZENE);
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		this.weltkarteInsHauptmenueButton.setText(sprachRessource.getString(LokalisierungsKeys.ZUM_HAUPTMENUE_KEY));
		this.weltkarteZurueckButton.setText(sprachRessource.getString(LokalisierungsKeys.ZURUECK_KEY));
		this.dungeon1Button.setTooltip(new Tooltip(sprachRessource.getString(LokalisierungsKeys.DUNGEON1INFO_KEY)));
		this.dungeon2Button.setTooltip(new Tooltip(sprachRessource.getString(LokalisierungsKeys.DUNGEON2INFO_KEY)));
		this.dungeon3Button.setTooltip(new Tooltip(sprachRessource.getString(LokalisierungsKeys.DUNGEON3INFO_KEY)));
		this.dungeon4Button.setTooltip(new Tooltip(sprachRessource.getString(LokalisierungsKeys.DUNGEON4INFO_KEY)));
		this.dungeon5Button.setTooltip(new Tooltip(sprachRessource.getString(LokalisierungsKeys.DUNGEON5INFO_KEY)));

	}
}
