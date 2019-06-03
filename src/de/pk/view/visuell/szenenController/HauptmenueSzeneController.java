package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.app.Main;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import de.pk.view.audio.AudioSchnipsel;
import de.pk.view.visuell.AnwendungFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class HauptmenueSzeneController implements Initializable, Lokalisierbar
{

	private static AudioSchnipsel audio = null;

	public static AudioSchnipsel getAudio()
	{
		return HauptmenueSzeneController.audio;
	}

	@FXML
	private Button neuesSpielButton;
	@FXML
	private Button spielLadenButton;
	@FXML
	private Button creditsButton;
	@FXML
	private Label hauptmenueLabel;
	@FXML
	private Button spielBeendenButton;
	@FXML
	private Button zumTitelbildschirmButton;
	@FXML
	private Button optionenButton;

	@FXML
	private void credtisButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_CREDIT_SZENE);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		HauptmenueSzeneController.audio = new AudioSchnipsel(
				"src\\de\\pk\\ressourcen\\audioDateien\\hintergrundMusik\\Overworld.wav", 0);
		HauptmenueSzeneController.audio.abspielen(false);
	}

	@FXML
	private void neuesSpielButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_SCHWIERIGKEIT_WAEHLEN_SZENE);
	}

	@FXML
	private void optionenButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_OPTIONEN_SZENE);
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

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		this.creditsButton.setText(sprachRessource.getString(LokalisierungsKeys.CREDTITS_KEY));
		this.hauptmenueLabel.setText(sprachRessource.getString(LokalisierungsKeys.HAUPTMENUE_KEY));
		this.neuesSpielButton.setText(sprachRessource.getString(LokalisierungsKeys.NEUES_SPIEL_KEY));
		this.optionenButton.setText(sprachRessource.getString(LokalisierungsKeys.OPTIONEN_KEY));
		this.spielBeendenButton.setText(sprachRessource.getString(LokalisierungsKeys.BEENDEN_KEY));
		this.spielLadenButton.setText(sprachRessource.getString(LokalisierungsKeys.SPIEL_LADEN_KEY));
		this.zumTitelbildschirmButton.setText(sprachRessource.getString(LokalisierungsKeys.ZUM_TITELBILDSCHIRM_KEY));
	}

}