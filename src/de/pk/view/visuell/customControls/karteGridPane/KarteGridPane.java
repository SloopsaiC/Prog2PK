package de.pk.view.visuell.customControls.karteGridPane;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import de.pk.model.position.KachelPosition;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.view.visuell.customControls.kachelGridPane.KachelGridPane;
import de.pk.view.visuell.events.KachelPositionEvent;
import de.pk.view.visuell.events.PositionEvent;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;

public class KarteGridPane extends GridPane implements Initializable, Lokalisierbar, InvalidationListener
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "KarteGridPane.fxml";

	/**
	 * Standard SkalierungsFaktor fuer das hineinzoomen. Soll herausgezoomt werden,
	 * kann der SkalierungsFaktor ^-1 genommen werden. (1 / SKALIERUNGS_FAKTOR)
	 */
	private static final double SKALIERUNGS_FAKTOR = 1.05d;
	/**
	 * Ab dieser Grenze (0) wird hineien bzw. herausgezoomt.
	 */
	private static final int SKALIERUNGS_ZOOM_GRENZE = 0;
	/**
	 * Bei einer Mausbewegung zum Verschieben der Karte, wird diese nur um den
	 * VERSCHIEBUNGS_FAKTOR * den bewegten Mausweg verschoben.
	 */
	private static final double VERSCHIEBUNGS_FAKTOR = 0.4d;
	/**
	 * Minimale Skalierung (mehr kann nicht weg gezoomt werden).
	 */
	private static final double SKALIERUNG_MINIMUM = 0.5d;
	/**
	 * Maximale Skalierung (mehr kann nicht heran gezoomt werden).
	 */
	private static final double SKALIERUNG_MAXIMUM = 1.5d;

	/**
	 * Beinhaltet die x-Koordinate einer alten Position der Maus zum Vergleich mit
	 * einer Aktuelleren.
	 */
	private double oldX = 0;
	/**
	 * Beinhaltet die y-Koordinate einer alten Position der Maus zum Vergleich mit
	 * einer Aktuelleren.
	 */
	private double oldY = 0;

	/**
	 * Erstellt eine neue KarteGridPane, indem die fxml-Datei geladen wird und diese
	 * Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public KarteGridPane()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(KarteGridPane.FXML_PFAD));
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

	/**
	 * Feugt dem KartenGridPane ein KachelGridPane an der Position pos hinzu.
	 *
	 * @param kachelGridPane einzufeugendes KachelGridPane
	 * @param pos            Position des einzufuegenden KachelGridPanes auf dem
	 *                       KartenGridPane. Dabei ist (0|0) in der oberen linken
	 *                       Ecke.
	 */
	public void addKachelGridPane(KachelGridPane kachelGridPane, Position pos)
	{
		for (Node node : this.getChildren())
		{
			try
			{
				if ((GridPane.getColumnIndex(node).intValue() == pos.getX())
						&& (GridPane.getRowIndex(node).intValue() == pos.getY()))
				{
					throw new InputMismatchException();
				}
			} catch (NullPointerException e)
			{
//
			}
		}
		this.add(kachelGridPane, pos.getX(), pos.getY());
		this.initEventHandler(kachelGridPane);
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		//
	}

	/**
	 * Fuegt dem kachelGridPane einen EventHandler hinzu. Wurde auf einen untergrund
	 * dieser Kachel geklickt, so soll diese mit seiner Position ein neues
	 * PositionEvent ausloesen.
	 *
	 * @param kachelGridPane Das kachelGridPane, dem der EventHandler hinzugefuegt
	 *                       werden soll
	 * @param pos            Die Position des kachelGridPanes auf der Karte
	 */
	private void initEventHandler(KachelGridPane kachelGridPane)
	{
		kachelGridPane.addEventHandler(PositionEvent.UNTERGRUND_ANGELICKT, new EventHandler<PositionEvent>()
		{

			@Override
			public void handle(PositionEvent event)
			{
				KarteGridPane.this.fireEvent(new KachelPositionEvent(KachelPositionEvent.KACHEL_ANGELICKT,
						new KachelPosition(kachelGridPane.getDarstellendeKachel(), event.getEventPosition())));
			}
		});
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO inti?

	}

	@Override
	public void invalidated(Observable observable)
	{
		Spielbrett spielbrett = (Spielbrett) observable;
		for (Position position : spielbrett.getAlleKachelPositionen())
		{
			try
			{
				KachelGridPane kachelPane = new KachelGridPane();
				kachelPane.setDarstellendeKachel(spielbrett.getKachelBei(position));
				this.addKachelGridPane(kachelPane, position);
			} catch (InputMismatchException schonVorhanden)
			{
			}
		}
	}

	/**
	 * Wird aufgerufen, wenn eine Maustaste heruntergedrueckt ist und die Maus dabei
	 * bewegt wird.
	 *
	 * @param event MouseEvent des Bewegens der gedrueckten Maus
	 */
	@FXML
	public void kartenGridPaneMouseDragged(MouseEvent event)
	{
		this.verschiebeBeiMouseEvent(event, this.oldX, this.oldY);
		this.oldX = event.getX();
		this.oldY = event.getY();
	}

	/**
	 * Wird aufgerufen, wenn mit der Maus ins Fenster geklickt wurde und waehrend
	 * dieses Klicken andauert.
	 *
	 * @param event MouseEvent des Mausklicks
	 */
	@FXML
	public void kartenGridPaneMousePressed(MouseEvent event)
	{
		this.oldX = event.getX();
		this.oldY = event.getY();
	}

	/**
	 * Wird Aufgerufen, wenn mit dem Mausrad im Fenster "gescroolt" wird.
	 *
	 * @param event ScrollEvent des Mausraddrehens
	 */
	@FXML
	public void kartenGridPaneScroll(ScrollEvent event)
	{
		this.skaliereBeiScrollEvent(event);
	}

	public void setSpielbrett(Spielbrett spielbrett)
	{
		spielbrett.addListener(this);
		this.invalidated(spielbrett);
	}

	/**
	 * Soll aufgerufen werden, wenn ein ScrollEvent vorliegt, dass die Karte zum
	 * Skalieren veranslassen soll.
	 *
	 * @param event ScrollEvent zum Zoomen
	 */
	public void skaliereBeiScrollEvent(ScrollEvent event)
	{
		// Ein skalierungsFaktor wird je nach Mausrad-Drehrichtung ausgewahlt.
		double skalierungsFaktor = KarteGridPane.SKALIERUNGS_FAKTOR;
		if (event.getDeltaY() < KarteGridPane.SKALIERUNGS_ZOOM_GRENZE)
		{
			skalierungsFaktor = 1 / KarteGridPane.SKALIERUNGS_FAKTOR;
		} else if (event.getDeltaY() == KarteGridPane.SKALIERUNGS_ZOOM_GRENZE)
		{
			skalierungsFaktor = KarteGridPane.SKALIERUNGS_FAKTOR / KarteGridPane.SKALIERUNGS_FAKTOR;
		}
		if (event.isControlDown() && ((this.getScaleX() * skalierungsFaktor) > KarteGridPane.SKALIERUNG_MINIMUM)
				&& ((this.getScaleX() * skalierungsFaktor) < KarteGridPane.SKALIERUNG_MAXIMUM))
		{
			// Skaliert die Karte in x- und y-Dimension durch Multiplikation der aktuellen
			// Skalierung mit dem skalierungsFaktor, wenn STRG gedreuckt ist.
			this.setScaleX(this.getScaleX() * skalierungsFaktor);
			this.setScaleY(this.getScaleY() * skalierungsFaktor);
		}
	}

	/**
	 * Soll aufgerufen werden, wenn ein MouseEvent vorliegt, dass die Karte
	 * verschieben soll.
	 *
	 * @param event MouseEvent zum Verschieben
	 * @param oldX  die vorherige xPosition der Maus beim Druecken des Maustaste
	 * @param oldY  die vorherige yPosition der Maus beim Druecken des Maustaste
	 */
	public void verschiebeBeiMouseEvent(MouseEvent event, double oldX, double oldY)
	{
		if (event.getButton() == MouseButton.SECONDARY)
		{
			this.setTranslateX(this.getTranslateX() + ((event.getX() - oldX) * KarteGridPane.VERSCHIEBUNGS_FAKTOR));
			this.setTranslateY(this.getTranslateY() + ((event.getY() - oldY) * KarteGridPane.VERSCHIEBUNGS_FAKTOR));
		}
	}

}
