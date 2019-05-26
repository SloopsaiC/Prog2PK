package de.pk.view.visuell.fxmlSzenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.app.Main;
import de.pk.utils.Spielkonstanten;
import de.pk.view.audio.AudioSchnipsel;
import de.pk.view.visuell.fxmlSzenenLayouts.AnwendungFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class HauptmenueSzeneController implements Initializable
{

	private static AudioSchnipsel audio = null;

	public static AudioSchnipsel getAudio()
	{
		return HauptmenueSzeneController.audio;
	}

	@FXML
	private ToggleButton musikAnAusToggleButton;

	@FXML
	private void credtisButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_CREDIT_SZENE);
	}

	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		HauptmenueSzeneController.audio = new AudioSchnipsel("src\\de\\pk\\ressourcen\\audioDateien\\Overworld.wav",
				100);
	}

	@FXML
	private void musikAnAusToggleButtonAction(ActionEvent event)
	{
		if (this.musikAnAusToggleButton.isSelected())
		{
			HauptmenueSzeneController.audio.abspielen(false);
			this.musikAnAusToggleButton.setText("Musik pausieren");
		} else
		{
			HauptmenueSzeneController.audio.pausieren(false);
			this.musikAnAusToggleButton.setText("Musik abspielen");
		}
	}

	@FXML
	private void neuesSpielButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE);
	}

	@FXML
	private void optionenButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_OPTIOEN_SZENE);
	}

	@FXML
	private void spielBeendenButtonAction(ActionEvent event)
	{
		Main.anwendungBeenden();
	}

	@FXML
	private void spielLadenButtonAction(ActionEvent event)
	{
		//
	}

	@FXML
	private void zumTitelbildschirmButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_TITEL_SZENE);
	}

}