package de.pk.view.visuell.fxmlSzenenController;

import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spiel.einstellungen.Aufloesung;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.Spielkonstanten;
import de.pk.view.visuell.fxmlSzenenLayouts.AnwendungFX;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.input.ScrollEvent;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class OptionenSzeneController implements Initializable
{

	@FXML
	private Button zurueckZumHauptmenue;
	@FXML
	private Slider soundVolumeSlider;
	@FXML
	private Slider musikVolumeSlider;
	@FXML
	private ChoiceBox<Aufloesung> aufloesungChoiceBox;

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



	private void choiceBoxInit ()
	{
		this.aufloesungChoiceBox.setItems(FXCollections.observableArrayList(Aufloesung.values()));
		this.aufloesungChoiceBox.setTooltip(new Tooltip("Waehle eine Aufloesung"));
		this.aufloesungChoiceBox.setValue(Einstellungen.getEinstellungen().getAnwendungsAufloesung());
		this.aufloesungChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Aufloesung>()
		{

			@Override
			public void changed (ObservableValue<? extends Aufloesung> observable, Aufloesung oldValue,
					Aufloesung newValue)
			{
				Einstellungen.getEinstellungen().setAnwendungsAufloesung(newValue);
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

}
