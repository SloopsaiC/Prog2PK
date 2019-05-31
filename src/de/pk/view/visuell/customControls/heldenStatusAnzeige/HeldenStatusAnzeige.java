package de.pk.view.visuell.customControls.heldenStatusAnzeige;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HeldenStatusAnzeige extends VBox implements Initializable
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "HeldenStatusAnzeige.fxml";

	/**
	 * Bis zu vier Statusanzeigen koennen dargestellt werden (fuer jeden Helden
	 * eine). Dieses Array beinhaltet alle vier.
	 */
	private HBox[] heldenStatusAnzeigen = null;
	/**
	 * Die Helden, dessen Attribute von dieser StatusAnzeige ueberwacht und
	 * angezeigt werden sollen.
	 */
	private Held[] helden = null;

	// erste Helden-Anzeige:
	@FXML
	private HBox heldenStatusAnzeigeHBox1;
	@FXML
	private Label heldenAvatarLabel1;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar1;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar1;
	@FXML
	private Label aktuellerHeldenModusLabel1;
	@FXML
	private Label verbleibendePhasenLabel1;
	@FXML
	private Label verbleibendePhasenLabel2;
	@FXML
	private Label verbleibendePhasenLabel3;

	// zweite Helden-Anzeige:
	@FXML
	private HBox heldenStatusAnzeigeHBox2;
	@FXML
	private Label heldenAvatarLabel2;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar2;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar2;
	@FXML
	private Label aktuellerHeldenModusLabel2;

	// dritte Helden-Anzeige:
	@FXML
	private HBox heldenStatusAnzeigeHBox3;
	@FXML
	private Label heldenAvatarLabel3;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar3;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar3;
	@FXML
	private Label aktuellerHeldenModusLabel3;

	// vierte Helden-Anzeige:
	@FXML
	private HBox heldenStatusAnzeigeHBox4;
	@FXML
	private Label heldenAvatarLabel4;
	@FXML
	private ProgressBar kleineLebensPunkteAnzeigeProgressBar4;
	@FXML
	private ProgressBar kleineSpezialFaehigkeitsAnzeigeProgressBar4;
	@FXML
	private Label aktuellerHeldenModusLabel4;

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
		for (int i = 0; i < this.heldenStatusAnzeigen.length; i++)
		{
			if (anzahlAnzuzeigenderHeldenAnzeigen > i)
			{
				this.heldenStatusAnzeigen[i].setVisible(true);
			} else
			{
				this.heldenStatusAnzeigen[i].setVisible(false);
			}
		}
	}

	/**
	 * Legt die Helden fest, die von dieser Anzeige "ueberwacht" werden sollen. Es
	 * werden somit automatisch immer die aktuellen Werte ihrer Attribute auf die
	 * entsprechenden Anzeigen dieser StatusAnzeige gelegt. Aendert sich die
	 * Anzeige-Reihenfolge der hinzugefuegten Helden, muessen diese nicht neu
	 * hinzugefuegt werden, es reicht ein Aufruf der Methode
	 * schiebeHeldenEineRundeWeiter().
	 *
	 * @param helden Die Helden, dessen Attribute von dieser StatusAnzeige
	 *               ueberwacht und angezeigt werden sollen.
	 */
	public void setHelden(Held[] helden)
	{
		this.helden = helden;
		aktualisiereHeldenAnzeigen(this.helden);
		this.setAnzahlHeldenAnzeigen(this.helden.length);
	}

	/**
	 * Initialisiert die Helden, indem ihren Attributen ChangeListener hinzugefuegt
	 * werden, die automatisch dafuer sorgen, dass die aktuellen Werte ihrer
	 * Attribute stets auf die entsprechenden Anzeigen dieser StatusAnzeige gelegt
	 * werden.
	 *
	 * @param helden Die zu ueberwachenden Helden
	 */
	private void aktualisiereHeldenAnzeigen(Held[] helden)
	{
		// TODO ChangeListener (oder ähnliches) für LP, RP, etc. hinzufügen und Werte
		// auf
		// entsprechende Anzeigen (die ganzen Bilder-Labels und ProgressBars) legen.

		// Achtung! Beachte das Weiterschieben der Helden! Reicht es, beim
		// Weiterschieben, diese Methode erneut aufzurufen, sodass die Listener der
		// einzelnen Anzeigen auf den naechsten Helden aktualisiert werden?
	}

	/**
	 * Schiebt alle Helden um einen Index weiter nach hinten, der letzte Held wird
	 * an den Anfang geschoben.
	 */
	public void schiebeHeldenEineRundeWeiter()
	{
		Held[] alteHeldenReihenfolge = this.helden.clone();
		for (int i = 0; i < alteHeldenReihenfolge.length; i++)
		{
			if (i + 1 == this.helden.length)
			{
				this.helden[i - i] = alteHeldenReihenfolge[i];
			} else
			{
				this.helden[i + 1] = alteHeldenReihenfolge[i];
			}
		}
		aktualisiereHeldenAnzeigen(this.helden);
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.heldenStatusAnzeigen = new HBox[]
		{ this.heldenStatusAnzeigeHBox1, this.heldenStatusAnzeigeHBox2, this.heldenStatusAnzeigeHBox3,
				this.heldenStatusAnzeigeHBox4 };
	}

}
