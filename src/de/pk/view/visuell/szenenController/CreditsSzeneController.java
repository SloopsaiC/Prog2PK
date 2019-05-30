package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
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
public class CreditsSzeneController implements Initializable, Lokalisierbar
{

	@FXML
	private Label creditsLabel;
	@FXML
	private Button zurueckZumHauptmenueButton;

	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		// TODO
	}

	@FXML
	private void zumHauptmenueButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		this.creditsLabel.setText(sprachRessource.getString(LokalisierungsKeys.CREDTITS));
		this.zurueckZumHauptmenueButton.setText(sprachRessource.getString(LokalisierungsKeys.ZURUECK)
				+ sprachRessource.getString(LokalisierungsKeys.ZUM_HAUPTMENUE));
	}

}
