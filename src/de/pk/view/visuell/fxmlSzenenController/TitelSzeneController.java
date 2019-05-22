package de.pk.view.visuell.fxmlSzenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.view.visuell.fxmlSzenenLayouts.AnwendungFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class TitelSzeneController implements Initializable
{

	@FXML
	private Button startHauptmenue;
	@FXML
	private ImageView titelImageView;
	@FXML
	private ImageView hintergrundImageView;


	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize (URL url, ResourceBundle rb)
	{
		// this.animatedImageView.setImage(new Image(
		// this.getClass().getResource("..\\..\\..\\ressourcen\\bildDateien\\arcadeGif.gif").toExternalForm()));
	}


	@FXML
	private void startButtonAction (ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

}
