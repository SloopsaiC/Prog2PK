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

	@FXML
	private ToggleButton musikAnAusToggleButton;


	public static AudioSchnipsel getAudio ()
	{
		return audio;
	}


	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize (URL url, ResourceBundle rb)
	{
		audio = new AudioSchnipsel("src\\de\\pk\\ressourcen\\audioDateien\\Overworld.wav", 100);
	}


	@FXML
	private void neuesSpielButtonAction (ActionEvent event)
	{
		//
	}


	@FXML
	private void spielLadenButtonAction (ActionEvent event)
	{
		//
	}


	@FXML
	private void optionenButtonAction (ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_OPTIOEN_SZENE);
	}


	@FXML
	private void credtisButtonAction (ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_CREDIT_SZENE);
	}


	@FXML
	private void zumTitelbildschirmButtonAction (ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_TITEL_SZENE);
	}


	@FXML
	private void spielBeendenButtonAction (ActionEvent event)
	{
		Main.anwendungBeenden();
	}


	@FXML
	private void musikAnAusToggleButtonAction (ActionEvent event)
	{
		if (this.musikAnAusToggleButton.isSelected())
		{
			audio.abspielen(false);
			this.musikAnAusToggleButton.setText("Musik pausieren");
		} else
		{
			audio.pausieren(false);
			this.musikAnAusToggleButton.setText("Musik abspielen");
		}
	}

}
