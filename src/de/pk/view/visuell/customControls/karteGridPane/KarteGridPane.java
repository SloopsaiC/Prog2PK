package de.pk.view.visuell.customControls.karteGridPane;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import de.pk.model.position.Position;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.view.visuell.customControls.kachelGridPane.KachelGridPane;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
	 * Erstellt eine neue KarteGridPane, indem die fxml-Datei geladen wird und diese
	 * Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public KarteGridPane()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(KarteGridPane.FXML_PFAD));
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
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO inti?
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		//
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
		double skalierungsFaktor = SKALIERUNGS_FAKTOR;
		if (event.getDeltaY() < SKALIERUNGS_ZOOM_GRENZE)
		{
			skalierungsFaktor = 1 / SKALIERUNGS_FAKTOR;
		} else if (event.getDeltaY() == SKALIERUNGS_ZOOM_GRENZE)
		{
			skalierungsFaktor = SKALIERUNGS_FAKTOR / SKALIERUNGS_FAKTOR;
		}
		if (event.isControlDown() && (this.getScaleX() * skalierungsFaktor) > SKALIERUNG_MINIMUM
				&& (this.getScaleX() * skalierungsFaktor) < SKALIERUNG_MAXIMUM)
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
		if (event.getButton() == MouseButton.PRIMARY)
		{
			this.setTranslateX(this.getTranslateX() + ((event.getX() - oldX) * VERSCHIEBUNGS_FAKTOR));
			this.setTranslateY(this.getTranslateY() + ((event.getY() - oldY) * VERSCHIEBUNGS_FAKTOR));
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
				if (GridPane.getColumnIndex(node).intValue() == pos.getX()
						&& GridPane.getRowIndex(node).intValue() == pos.getY())
				{
					throw new InputMismatchException();
				}
			} catch (NullPointerException e)
			{
//
			}
		}
		this.add(kachelGridPane, pos.getX(), pos.getY());
	}

	@Override
	public void invalidated(Observable observable)
	{
		Spielbrett spielbrett = (Spielbrett) observable;
		for (Position position : spielbrett.getAlleKachelPositionen())
		{
			if (!this.contains(position.getX(), position.getY()))
			{
				KachelGridPane kachelPane = new KachelGridPane();
				kachelPane.setKachel(spielbrett.getKachelBei(position));
				this.addKachelGridPane(kachelPane, position);
			}
		}
	}

}
