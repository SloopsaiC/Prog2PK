package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.view.visuell.AnwendungFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Phillip
 */
public class WeltkarteSzeneController implements Initializable, Lokalisierbar
{
	@FXML
	private Button dungeon1Button;
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

	@FXML
	public void dungeon1ButtonPressed(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE);
	}

	@FXML
	public void dungeon2ButtonPressed(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE);
	}

	@FXML
	public void dungeon3ButtonPressed(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE);
	}

	@FXML
	public void dungeon4ButtonPressed(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE);
	}

	@FXML
	public void dungeon5ButtonPressed(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO Auto-generated method stub

	}

	@FXML
	public void weltkarteInsHauptmenueButtonPressed(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

	@FXML
	public void weltkarteZurueckButtonPressed(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_SCHWIERIGKEIT_WAEHLEN_SZENE);
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		// TODO Auto-generated method stub

	}
}
