package de.pk.view.visuell.customControls.kachelGridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.model.position.Position;
import de.pk.model.spielbrett.Kachel;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class KachelGridPane extends GridPane implements Initializable, Lokalisierbar
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "KachelGridPane.fxml";

	private static final double GLUEHEN_INTENSITAET = 0.75;

	private StackPane[][] untergruende = null;

	/**
	 * Erstellt eine neue KachelGridPane, indem die fxml-Datei geladen wird und
	 * diese Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 *
	 * @param kachel Die Kachel, die dieses KachelGridPane als view repraesentiert
	 */
	public KachelGridPane(Kachel kachel)
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(KachelGridPane.FXML_PFAD));
		try
		{
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
		this.setKachelUntergruende(kachel);
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO vernuenftig initialisieren und konstante
		this.untergruende = new StackPane[Spielkonstanten.KACHEL_GROESSE_Y][Spielkonstanten.KACHEL_GROESSE_X];
		for (Node node : this.getChildren())
		{
			try
			{
				this.untergruende[GridPane.getRowIndex(node).intValue()][GridPane.getColumnIndex(node)
						.intValue()] = (StackPane) node;
			} catch (NullPointerException e)
			{
//
			}
		}
	}

	/**
	 * Legt die Untergruende dieses KachelGridPanes je nach Kachel kachel fest.
	 *
	 * @param kachel Die Kachel, dessen Untergruende gesetzt werden sollen
	 */
	private void setKachelUntergruende(Kachel kachel)
	{
		for (int y = 0; y < this.untergruende.length; y++)
		{
			for (int x = 0; x < this.untergruende[y].length; x++)
			{
				int wert = kachel.getUntergrundBei(new Position(x, y)).getIntegerWert();
				this.untergruende[y][x].setStyle("-fx-background-image: "
						+ "url('/de/pk/ressourcen/bildDateien/kachelUntergruende/KachelUntergrund_2.png'), "
						+ "url('/de/pk/ressourcen/bildDateien/kachelUntergruende/KachelUntergrund_" + wert + ".png')");
			}
		}
	}

	/**
	 * Umrandet den Untergrund an der Position pos auf der Kachel in einem
	 * standardmaessigem dunkel rot.
	 *
	 * @param pos Position des zu umrundenden Untergrunds auf der Kachel
	 */
	public void setUmrandungBeiUntergrund(Position pos)
	{
		// TODO Konstanten
		this.setUmrandungBeiUntergrund(pos, new Color(0.4, 0.1, 0.1, 1.0));
	}

	/**
	 * Umrandet den Untergrund an der Position pos auf der Kachel in der Farbe
	 * umrandungsFarbe.
	 *
	 * @param pos             Position des zu umrundenden Untergrunds auf der Kachel
	 * @param umrandungsFarbe Farbe der Umrandung (z.B. im rgba-Format als "new
	 *                        Color(0.4, 0.1, 0.1, 1.0)")
	 */
	public void setUmrandungBeiUntergrund(Position pos, Color umrandungsFarbe)
	{
		// TODO Konstanten
		this.untergruende[pos.getY()][pos.getX()].setBorder(new Border(
				new BorderStroke(umrandungsFarbe, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(3))));
	}

	/**
	 * Entfernt alle Umrundungen von allen Untergruenden dieser Kachel.
	 */
	public void entferneAlleUmrandungen()
	{
		for (StackPane[] stackPanes : this.untergruende)
		{
			for (StackPane untergrund : stackPanes)
			{
				untergrund.setBorder(Border.EMPTY);
			}
		}
	}

	/**
	 * Laestt den Untergrund an der Position pos auf der Kachel gluehen bzw. hell
	 * aufleuchten.
	 *
	 * @param pos Position des zu gluehenden Untergrunds auf der Kachel
	 */
	public void setGluehenBeiKachel(Position pos)
	{
		this.setGluehenBeiKachel(pos, KachelGridPane.GLUEHEN_INTENSITAET);
	}

	/**
	 * Laestt den Untergrund an der Position pos auf der Kachel gluehen bzw. hell
	 * aufleuchten.
	 *
	 * @param pos         Position des zu gluehenden Untergrunds auf der Kachel
	 * @param intensitaet Die Intensitaet des Gluehens (zwischen 0.0 und 0.1)
	 */
	public void setGluehenBeiKachel(Position pos, double intensitaet)
	{
		this.untergruende[pos.getY()][pos.getX()].setEffect(new Glow(intensitaet));
	}

	/**
	 * Entfernt jegliches Gluehen von allen Untergruenden dieser Kachel.
	 */
	public void entferneJeglichesGluehen()
	{
		for (StackPane[] stackPanes : this.untergruende)
		{
			for (StackPane untergrund : stackPanes)
			{
				untergrund.setEffect(null);
			}
		}
	}

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		//
	}

}
