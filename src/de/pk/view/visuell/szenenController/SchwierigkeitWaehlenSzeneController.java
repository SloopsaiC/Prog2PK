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
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import de.pk.control.app.Anwendung;
import de.pk.control.spiel.einstellungen.Einstellungen;

/**
 * FXML Controller class
 *
 * @author Philipp
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
	private Label Neuling;
	@FXML
	private Label Dickkopf;
	@FXML
	private Label Draufgaenger;
	@FXML
	private Label Blutduerster;
	@FXML
	private Button schwierigkeitsWahlDialogStart;
	@FXML
	private Button schwierigkeitsWahlDialogZurueck;
	@FXML
	private DialogPane schwierigkeitsWahlDialog;
	@FXML
	private Text schwierigkeitsWahlDialogText;

	// fuer blutduerster
	@FXML
	public void blutduersterButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(true);
		this.schwierigkeitsWahlDialogText.setText(Einstellungen.getEinstellungen().getSprachRessource()
				.getString(LokalisierungsKeys.BLUTDUERSTER_DIALOG_TEXT_KEY));
	}

	// fuer Dickkopf
	@FXML
	public void dickkopfButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(true);
		this.schwierigkeitsWahlDialogText.setText(Einstellungen.getEinstellungen().getSprachRessource()
				.getString(LokalisierungsKeys.DICKKOPF_DIALOG_TEXT_KEY));
	}

	// fuer Draufgaenger
	@FXML
	public void draufgaengerButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(true);
		this.schwierigkeitsWahlDialogText.setText(Einstellungen.getEinstellungen().getSprachRessource()
				.getString(LokalisierungsKeys.DRAUFGAENGER_DIALOG_TEXT_KEY));
	}

	// fuer Neuling
	@FXML
	public void neulingButtonPressed(ActionEvent event)
	{
		this.schwierigkeitsWahlDialog.setVisible(true);
		this.schwierigkeitsWahlDialogText.setText(Einstellungen.getEinstellungen().getSprachRessource()
				.getString(LokalisierungsKeys.NEULING_DIALOG_TEXT_KEY));

	}

	// Allgemeine Funktionen
	@FXML
	public void zumHauptmenueButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
		this.schwierigkeitsWahlDialog.setVisible(false);
		this.schwierigkeitsWahlDialogText.setText(null);
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
		this.zurueckZumHauptmenue.setText(sprachRessource.getString(LokalisierungsKeys.ZURUECK_KEY)
				+ sprachRessource.getString(LokalisierungsKeys.ZUM_HAUPTMENUE_KEY));
		this.Neuling.setText(sprachRessource.getString(LokalisierungsKeys.NEULING_KEY));
		this.Dickkopf.setText(sprachRessource.getString(LokalisierungsKeys.NEULING_KEY));
		this.Draufgaenger.setText(sprachRessource.getString(LokalisierungsKeys.NEULING_KEY));
		this.Blutduerster.setText(sprachRessource.getString(LokalisierungsKeys.NEULING_KEY));
		this.schwierigkeitsWahlDialogZurueck.setText(sprachRessource.getString(LokalisierungsKeys.ZURUECK_KEY));
		this.schwierigkeitsWahlDialogStart.setText(sprachRessource.getString(LokalisierungsKeys.START_KEY));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO Auto-generated method stub

	}
}
