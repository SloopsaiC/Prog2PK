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
public class TitelSzeneController implements Initializable, Lokalisierbar
{

	@FXML
	private Button zumHauptmenueButton;
	@FXML
	private Label titelLabel;

	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		//
	}

	@FXML
	private void startButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		this.titelLabel.setText(sprachRessource.getString(LokalisierungsKeys.ANWENDUNGS_TITEL));
		this.zumHauptmenueButton.setText(sprachRessource.getString(LokalisierungsKeys.ZURUECK)
				+ sprachRessource.getString(LokalisierungsKeys.ZUM_HAUPTMENUE));
	}

}
