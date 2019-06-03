package de.pk.view.visuell.customControls.heldenStatusAnzeige;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.view.visuell.customControls.heldenStatusAnzeige.heldStatusHBox.HeldStatusHBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class HeldenStatusAnzeige extends VBox implements Initializable, Lokalisierbar
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "HeldenStatusAnzeige.fxml";

	/**
	 * Bis zu vier Statusanzeigen koennen dargestellt werden (fuer jeden Helden
	 * eine). Dieses Array beinhaltet alle vier.
	 */
	private HeldStatusHBox[] heldStatusHBoxen = null;

	// erste Helden-Anzeige:
	@FXML
	private HeldStatusHBox heldStatusHBox1;
	// zweite Helden-Anzeige:
	@FXML
	private HeldStatusHBox heldStatusHBox2;
	// dritte Helden-Anzeige:
	@FXML
	private HeldStatusHBox heldStatusHBox3;
	// vierte Helden-Anzeige:
	@FXML
	private HeldStatusHBox heldStatusHBox4;

	/**
	 * Erstellt eine neue HeldenStatusAnzeige, indem die fxml-Datei geladen wird und
	 * diese Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public HeldenStatusAnzeige()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HeldenStatusAnzeige.FXML_PFAD));
		try
		{
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.setClassLoader(getClass().getClassLoader());
			fxmlLoader.load();
		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	/**
	 * Legt fest, wie viele der Helden-Anzeigen angezeigt werden sollen. Es koennen
	 * maximal so viele angezeigt werden, wie dieser Klasse Helden hinzugefuegt
	 * wurden, nie jedoch mehr als 4.
	 *
	 * @param anzahlAnzuzeigenderHeldenAnzeigen anzahl der Helden-Anzeigen, die
	 *                                          angezeigt werden sollen.
	 */
	public void setAnzahlHeldenAnzeigen(int anzahlAnzuzeigenderHeldenAnzeigen)
	{
		for (int i = 0; i < this.heldStatusHBoxen.length; i++)
		{
			if (anzahlAnzuzeigenderHeldenAnzeigen > i)
			{
				this.heldStatusHBoxen[i].setVisible(true);
			} else
			{
				this.heldStatusHBoxen[i].setVisible(false);
			}
		}
	}

	/**
	 * Legt die Helden fest, die von dieser Anzeige "ueberwacht" werden sollen. Es
	 * werden somit automatisch immer die aktuellen Werte ihrer Attribute auf die
	 * entsprechenden Anzeigen dieser StatusAnzeige gelegt.
	 *
	 * @param helden Die Helden, dessen Attribute von dieser StatusAnzeige
	 *               ueberwacht und angezeigt werden sollen.
	 */
	public void setHelden(Held[] helden)
	{
		for (int i = 0; i < helden.length; i++)
		{
			this.heldStatusHBoxen[i].setHeld(helden[i]);
		}
		this.setAnzahlHeldenAnzeigen(helden.length);
	}

	/**
	 * Markiert die aktuelle HeldenStatusHBox an der Stelle index, indem diese
	 * umrahmt wird. Setzt die Rahmen aller anderen Boxen wieder zurueck.
	 */
	public void markiereAktuelleHeldenStatusHBox(int index)
	{
		for (HeldStatusHBox heldStatusHBox : this.heldStatusHBoxen)
		{
			heldStatusHBox.entferneUmrandung();
		}
		this.heldStatusHBoxen[index].umrandeFarbig();
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.heldStatusHBoxen = new HeldStatusHBox[]
		{ this.heldStatusHBox1, this.heldStatusHBox2, this.heldStatusHBox3, this.heldStatusHBox4 };
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		for (HeldStatusHBox heldStatusHBox : this.heldStatusHBoxen)
		{
			heldStatusHBox.aktualisiereTextKomponenten(sprachRessource);
		}
	}

}
