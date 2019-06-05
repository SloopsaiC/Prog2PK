package de.pk.view.visuell.customControls.kachelGridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.Kachel;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.view.visuell.events.PositionEvent;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class KachelGridPane extends GridPane implements Initializable, Lokalisierbar, InvalidationListener
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "KachelGridPane.fxml";

	private static final double GLUEHEN_INTENSITAET = 0.75;

	private StackPane[][] untergruende = null;
	private Kachel darstellendeKachel = null;

	/**
	 * Erstellt eine neue KachelGridPane, indem die fxml-Datei geladen wird und
	 * diese Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 *
	 * @param darstellendeKachel Die Kachel, die dieses KachelGridPane als view
	 *                           repraesentiert
	 */
	public KachelGridPane()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(KachelGridPane.FXML_PFAD));
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

	@Override
	public void aktualisiereTextKomponenten(ResourceBundle sprachRessource)
	{
		//
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

	public Kachel getDarstellendeKachel()
	{
		return this.darstellendeKachel;
	}

	/**
	 * Fuegt dem untergrund einen EventHandler hinzu. Wird auf den Untergrund mit
	 * der primaeren Maustaste geklickt, so soll dieser mit seiner Position ein
	 * neues PositionEvent ausloesen.
	 *
	 * @param untergrund Der Untergrund, dem der EventHandler hinzugefuegt werden
	 *                   soll
	 * @param pos        Die Position des Untergrunds auf der Kachel
	 */
	private void initEventHandler(StackPane untergrund, Position pos)
	{
		untergrund.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent event)
			{
				if (event.getButton() == MouseButton.PRIMARY)
				{
					KachelGridPane.this.fireEvent(new PositionEvent(PositionEvent.UNTERGRUND_ANGELICKT, pos));
				}
			}
		});
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.untergruende = new StackPane[Spielkonstanten.KACHEL_GROESSE_Y][Spielkonstanten.KACHEL_GROESSE_X];
		for (Node node : this.getChildren())
		{
			try
			{
				final int xKoordinate = GridPane.getColumnIndex(node).intValue();
				final int yKoordinate = GridPane.getRowIndex(node).intValue();
				StackPane untergrund = (StackPane) node;
				this.untergruende[yKoordinate][xKoordinate] = untergrund;
				this.initEventHandler(untergrund, new Position(xKoordinate, yKoordinate));
			} catch (NullPointerException e)
			{
				//
			}
		}
	}

	@Override
	public void invalidated(Observable observable)
	{
		this.setKachelUntergruende((Kachel) observable);
	}

	public void setDarstellendeKachel(Kachel kachel)
	{
		kachel.addListener(this);
		this.darstellendeKachel = kachel;
		this.setKachelUntergruende(kachel);
	}

	/**
	 * Laesst den Untergrund an der Position pos auf der Kachel gluehen bzw. hell
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
	 * Legt die Untergruende dieses KachelGridPanes je nach Kachel
	 * darstellendeKachel fest.
	 *
	 * @param darstellendeKachel Die Kachel, dessen Untergruende gesetzt werden
	 *                           sollen
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
				SpielbrettObjekt objekt = kachel.getSpielbrettObjektBei(new Position(x, y));
				if (objekt != null)
				{
					if (objekt.istLebendig())
					{
						LebendigesObjekt lebendigesObjekt = (LebendigesObjekt) objekt;
						if (!lebendigesObjekt.istFreundlich())
						{
							this.untergruende[y][x].getChildren().add(new Rectangle(10, 10, Color.RED));
						} else
						{
							this.untergruende[y][x].getChildren().add(new Rectangle(10, 10, Color.BLUE));
						}
					}

				} else
				{
					this.untergruende[y][x].getChildren().clear();
				}
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

}
