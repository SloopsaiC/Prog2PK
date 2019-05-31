package de.pk.view.visuell.szenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spiel.einstellungen.Aufloesung;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.control.spiel.einstellungen.Sprache;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import de.pk.view.visuell.AnwendungFX;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.input.ScrollEvent;

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
	private Slider soundVolumeSlider;
	@FXML
	private Slider musikVolumeSlider;
	@FXML
	private ChoiceBox<Aufloesung> aufloesungChoiceBox;
	@FXML
	private ChoiceBox<Sprache> spracheChoiceBox;
	@FXML
	private Label aufloesungsLabel;
	@FXML
	private Button aufloesungAnwendenButton;
	@FXML
	private Label spracheLabel;
	@FXML
	private Label lautstaerkeLabel;
	@FXML
	private Label musikLabel;
	@FXML
	private Label soundLabel;
	@FXML
	private Label einstellungenLabel;

	@FXML
	public void aufloesungAnwendenButtonAction()
	{
		AnwendungFX.aktualisiereFensterAufloesung();
	}

	private void choiceBoxInit()
	{
		this.aufloesungChoiceBox.setItems(FXCollections.observableArrayList(Aufloesung.values()));
		this.aufloesungChoiceBox.setValue(Einstellungen.getEinstellungen().getAnwendungsAufloesung());
		this.aufloesungChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Aufloesung>()
		{

			@Override
			public void changed(ObservableValue<? extends Aufloesung> observable, Aufloesung oldValue,
					Aufloesung newValue)
			{
				Einstellungen.getEinstellungen().setAnwendungsAufloesung(newValue);
			}
		});

		this.spracheChoiceBox.setItems(FXCollections.observableArrayList(Sprache.values()));
		this.spracheChoiceBox.setValue(Einstellungen.getEinstellungen().getAnwendungsSprache());
		this.spracheChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sprache>()
		{

			@Override
			public void changed(ObservableValue<? extends Sprache> observable, Sprache oldValue, Sprache newValue)
			{
				Einstellungen.getEinstellungen().setAnwendungsSprache(newValue);
			}
		});
	}

	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		this.lautstaerkeSliderInit();
		this.choiceBoxInit();
	}

	private void lautstaerkeSliderInit()
	{
		this.musikVolumeSlider.setValue(HauptmenueSzeneController.getAudio().getProzentualeLautstaerke());
		this.musikVolumeSlider.valueProperty().addListener(new ChangeListener<Number>()
		{

			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val)
			{
				HauptmenueSzeneController.getAudio().setProzentualeLautstaerke(new_val.intValue(), false);
			}

		});
		// TODO Sound Volume anbinden
		// this.soundVolumeSlider.setValue();
		this.soundVolumeSlider.valueProperty().addListener(new ChangeListener<Number>()
		{

			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val)
			{
				// HauptmenueSzeneController.getAudio().setProzentualeLautstaerke(new_val.intValue(),
				// false);
			}

		});
	}

	@FXML
	private void mausScrollMusikSliderEvent(ScrollEvent event)
	{
		this.musikVolumeSlider.setValue(this.musikVolumeSlider.getValue() + (event.getDeltaY() / 10));
	}

	@FXML
	private void mausScrollSoundSliderEvent(ScrollEvent event)
	{
		this.soundVolumeSlider.setValue(this.musikVolumeSlider.getValue() + (event.getDeltaY() / 10));
	}

	@FXML
	private void zumHauptmenueButtonAction(ActionEvent event)
	{
		AnwendungFX.wechselSzene(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		this.aufloesungAnwendenButton.setText(sprachRessource.getString(LokalisierungsKeys.AUFLOESUNG_ANWENDEN));
		this.aufloesungsLabel.setText(sprachRessource.getString(LokalisierungsKeys.AUFLOESUNG));
		this.einstellungenLabel.setText(sprachRessource.getString(LokalisierungsKeys.EINSTELLUNGEN));
		this.lautstaerkeLabel.setText(sprachRessource.getString(LokalisierungsKeys.LAUTSTAERKE));
		this.musikLabel.setText(sprachRessource.getString(LokalisierungsKeys.MUSIK));
		this.soundLabel.setText(sprachRessource.getString(LokalisierungsKeys.SOUND));
		this.spracheLabel.setText(sprachRessource.getString(LokalisierungsKeys.SPRACHE));
		this.zurueckZumHauptmenueButton.setText(sprachRessource.getString(LokalisierungsKeys.ZURUECK)
				+ sprachRessource.getString(LokalisierungsKeys.ZUM_HAUPTMENUE));
		this.aufloesungChoiceBox
				.setTooltip(new Tooltip(sprachRessource.getString(LokalisierungsKeys.TOOLTIP_AUFLOESUNG)));
		this.spracheChoiceBox.setTooltip(new Tooltip(sprachRessource.getString(LokalisierungsKeys.TOOLTIP_SPRACHE)));
	}

}