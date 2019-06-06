package de.pk.view.visuell.customControls.einstellungenControlPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spiel.einstellungen.Aufloesung;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.control.spiel.einstellungen.Sprache;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import de.pk.view.visuell.AnwendungFX;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;

public class EinstellungenControlPane extends HBox implements Initializable, Lokalisierbar
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "EinstellungenControlPane.fxml";

	private static final double SLIDER_SCROLL_FAKTOR = 0.1d;

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
	private CheckBox vollbildCheckBox;
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

	/**
	 * Erstellt eine neue EinstellungenControlPane, indem die fxml-Datei geladen
	 * wird und diese Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public EinstellungenControlPane()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(EinstellungenControlPane.FXML_PFAD));
		try
		{
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.setClassLoader(this.getClass().getClassLoader());
			fxmlLoader.load();
		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		this.aufloesungAnwendenButton.setText(sprachRessource.getString(LokalisierungsKeys.AUFLOESUNG_ANWENDEN_KEY));
		this.aufloesungsLabel.setText(sprachRessource.getString(LokalisierungsKeys.AUFLOESUNG_KEY));
		this.vollbildCheckBox.setText(sprachRessource.getString(LokalisierungsKeys.VOLLBILD_KEY));
		this.aufloesungChoiceBox
				.setTooltip(new Tooltip(sprachRessource.getString(LokalisierungsKeys.TOOLTIP_AUFLOESUNG_KEY)));
		this.spracheChoiceBox
				.setTooltip(new Tooltip(sprachRessource.getString(LokalisierungsKeys.TOOLTIP_SPRACHE_KEY)));
		this.lautstaerkeLabel.setText(sprachRessource.getString(LokalisierungsKeys.LAUTSTAERKE_KEY));
		this.musikLabel.setText(sprachRessource.getString(LokalisierungsKeys.MUSIK_KEY));
		this.soundLabel.setText(sprachRessource.getString(LokalisierungsKeys.SOUND_KEY));
		this.spracheLabel.setText(sprachRessource.getString(LokalisierungsKeys.SPRACHE_KEY));
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.lautstaerkeSliderInit();
		this.choiceBoxInit();
	}

	private void lautstaerkeSliderInit()
	{

		this.musikVolumeSlider.setValue(Einstellungen.getEinstellungen().getMusikLautstaerke());
		this.musikVolumeSlider.valueProperty().addListener(new ChangeListener<Number>()
		{

			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val)
			{
				Einstellungen.getEinstellungen().setMusikLautstaerke(new_val.intValue());
			}

		});

		this.soundVolumeSlider.setValue(Einstellungen.getEinstellungen().getSoundLautstaerke());
		this.soundVolumeSlider.valueProperty().addListener(new ChangeListener<Number>()
		{

			@Override
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val)
			{
				Einstellungen.getEinstellungen().setSoundLautstaerke(new_val.intValue());
			}

		});
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

	@FXML
	private void mausScrollMusikSliderEvent(ScrollEvent event)
	{
		this.musikVolumeSlider.setValue(this.musikVolumeSlider.getValue()
				+ (event.getDeltaY() * EinstellungenControlPane.SLIDER_SCROLL_FAKTOR));
	}

	@FXML
	private void mausScrollSoundSliderEvent(ScrollEvent event)
	{
		this.soundVolumeSlider.setValue(this.musikVolumeSlider.getValue()
				+ (event.getDeltaY() * EinstellungenControlPane.SLIDER_SCROLL_FAKTOR));
	}

	@FXML
	private void vollbildCheckBoxAction(ActionEvent event)
	{
		Einstellungen.getEinstellungen().setVollbild(this.vollbildCheckBox.isSelected());
	}

	@FXML
	public void aufloesungAnwendenButtonAction()
	{
		AnwendungFX.aktualisiereFensterAufloesungUndStyleSheets();
	}

}
