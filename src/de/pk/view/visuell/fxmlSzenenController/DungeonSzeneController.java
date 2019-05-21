package de.pk.view.visuell.fxmlSzenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.view.visuell.fxmlSzenenLayouts.AnwendungFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class DungeonSzeneController implements Initializable
{

	@Override
	public void initialize (URL location, ResourceBundle resources)
	{
		//
	}


	// Event Listener on Button.onAction
	@FXML
	public void zumHauptmenueButtonAction (ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

}
