package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import de.pk.view.visuell.AnwendungFX;
import de.pk.view.visuell.customControls.einstellungenControlPane.EinstellungenControlPane;
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
public class OptionenSzeneController implements Initializable, Lokalisierbar
{

	@FXML
	private Button zurueckZumHauptmenueButton;
	@FXML
	private Label einstellungenLabel;
	@FXML
	private EinstellungenControlPane einstellungenPane;

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		this.einstellungenLabel.setText(sprachRessource.getString(LokalisierungsKeys.EINSTELLUNGEN_KEY));
		this.zurueckZumHauptmenueButton.setText(sprachRessource.getString(LokalisierungsKeys.ZURUECK_KEY)
				+ sprachRessource.getString(LokalisierungsKeys.ZUM_HAUPTMENUE_KEY));
		this.einstellungenPane.aktualisiereTextKomponenten(sprachRessource);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		//
	}

	@FXML
	private void zumHauptmenueButtonAction(ActionEvent event)
	{
		AnwendungFX.zeigeSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

}