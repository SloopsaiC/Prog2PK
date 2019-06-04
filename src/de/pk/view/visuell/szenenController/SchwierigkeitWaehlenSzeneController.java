package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.app.Anwendung;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.view.visuell.AnwendungFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;

/**
 * FXML Controller class
 *
 * @author Phillip
 */
public class SchwierigkeitWaehlenSzeneController implements Initializable, Lokalisierbar
{
	@FXML
	private Button zurueckZumHauptmenue;
	@FXML
	private Button neulingButton;
	@FXML
	private Button dickkopfButton;
	@FXML
	private Button draufgaengerButton;
	@FXML
	private Button blutduersterButton;
	@FXML
	private Button schwierigkeitsWahlDialogStart;
	@FXML
	private Button schwierigkeitsWahlDialogZurueck;
	@FXML
	private DialogPane schwierigkeitsWahlDialog;

	// fuer blutduerster
	@FXML
	public void blutduersterButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(true);
	}

	// fuer Dickkopf
	@FXML
	public void dickkopfButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(true);
	}

	// fuer Draufgaenger
	@FXML
	public void draufgaengerButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO Auto-generated method stub

	}

	// fuer Neuling
	@FXML
	public void neulingButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(true);
	}

	// Allgemeine Funktionen
	@FXML
	public void zumHauptmenueButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

	@FXML
	public void schwierigkeitsWahlDialogStartButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(false);
		((WeltkarteSzeneController) AnwendungFX.getSzenenController().get(Spielkonstanten.ANWENDUNG_WELTKARTE_SZENE))
				.setWeltkarte(Anwendung.getInstanz().getAktivesSpiel().getWeltkarte());
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_WELTKARTE_SZENE);
	}

	@FXML
	public void schwierigkeitsWahlDialogZurueckButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(false);
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		// TODO Auto-generated method stub

	}
}
