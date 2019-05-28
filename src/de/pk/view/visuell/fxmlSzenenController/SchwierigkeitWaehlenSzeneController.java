package de.pk.view.visuell.fxmlSzenenController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.DialogPane;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.view.visuell.fxmlSzenenLayouts.AnwendungFX;
import javafx.event.ActionEvent;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;

public class SchwierigkeitWaehlenSzeneController implements Initializable
{
	@FXML
	private Button zurueckZumHauptmenue;
	@FXML
	private ToggleButton neulingButton;
	@FXML
	private ToggleButton dickkopfButton;
	@FXML
	private ToggleButton draufgaengerButton;
	@FXML
	private ToggleButton blutduersterButton;
	@FXML
	private DialogPane neulingDialog;
	@FXML
	private DialogPane dickkopfDialog;
	@FXML
	private DialogPane draufgaengerDialog;
	@FXML
	private DialogPane blutduersterDialog;
	@FXML
	private Button neulingDialogStart;
	@FXML
	private Button neulingDialogZurueck;
	@FXML
	private Button dickkopfDialogStart;
	@FXML
	private Button dickkopfDialogZurueck;
	@FXML
	private Button draufgaengerDialogStart;
	@FXML
	private Button draufgaengerDialogZurueck;
	@FXML
	private Button blutduersterDialogStart;
	@FXML
	private Button blutduersterDialogZurueck;
	
	
	// Allgemeine Funktionen
	@FXML
	public void zumHauptmenueButtonAction(ActionEvent event) 
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}
	
	
	// fuer Neuling
	@FXML
	public void neulingButtonPressed(ActionEvent event) 
	{
		if (this.neulingButton.isSelected())
		{
			this.neulingDialog.setVisible(true);
		} 
		else
		{
			this.neulingDialog.setVisible(false);
		}
	}
	
	@FXML
	public void neulingDialogStartButtonPressed(ActionEvent event) 
	{
		this.neulingButton.selectedProperty().set(false);
		this.neulingDialog.setVisible(false);
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_WELTKARTE_SZENE);
	}
	@FXML
	public void neulingDialogZurueckButtonPressed(ActionEvent event) 
	{
		this.neulingDialog.setVisible(false);
		this.neulingButton.selectedProperty().set(false);
	}
	
	
	
	// fuer Dickkopf
	@FXML
	public void dickkopfButtonPressed(ActionEvent event) 
	{
		if (this.dickkopfButton.isSelected())
		{
			this.dickkopfDialog.setVisible(true);
		} 
		else
		{
			this.dickkopfDialog.setVisible(false);
		}
	}
	@FXML
	public void dickkopfDialogStartButtonPressed(ActionEvent event) 
	{
		this.dickkopfButton.selectedProperty().set(false);
		this.dickkopfDialog.setVisible(false);
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_WELTKARTE_SZENE);
	}
	@FXML
	public void dickkopfDialogZurueckButtonPressed(ActionEvent event) 
	{
		this.dickkopfDialog.setVisible(false);
		this.dickkopfButton.selectedProperty().set(false);
	}
	
	
	// fuer Draufgaenger
	@FXML
	public void draufgaengerButtonPressed(ActionEvent event)
	{
		if (this.draufgaengerButton.isSelected())
		{
			this.draufgaengerDialog.setVisible(true);
		} 
		else
		{
			this.draufgaengerDialog.setVisible(false);
		}
	}
	@FXML
	public void draufgaengerDialogStartButtonPressed(ActionEvent event) 
	{
		this.draufgaengerButton.selectedProperty().set(false);
		this.draufgaengerDialog.setVisible(false);
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_WELTKARTE_SZENE);
	}
	@FXML
	public void draufgaengerDialogZurueckButtonPressed(ActionEvent event) 
	{
		this.draufgaengerDialog.setVisible(false);
		this.draufgaengerButton.selectedProperty().set(false);
	}
	
	
	// fuer blutduerster
	@FXML
	public void blutduersterButtonPressed(ActionEvent event)
	{
		if (this.blutduersterButton.isSelected())
		{
			this.blutduersterDialog.setVisible(true);
		} 
		else
		{
			this.blutduersterDialog.setVisible(false);
		}
	}
	@FXML
	public void blutduersterDialogStartButtonPressed(ActionEvent event) 
	{
		this.blutduersterButton.selectedProperty().set(false);
		this.blutduersterDialog.setVisible(false);
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_WELTKARTE_SZENE);
	}
	@FXML
	public void blutduersterDialogZurueckButtonPressed(ActionEvent event) 
	{
		this.blutduersterDialog.setVisible(false);
		this.blutduersterButton.selectedProperty().set(false);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// TODO Auto-generated method stub
		
	}
}
