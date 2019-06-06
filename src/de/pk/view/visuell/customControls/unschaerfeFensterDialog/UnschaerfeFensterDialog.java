package de.pk.view.visuell.customControls.unschaerfeFensterDialog;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import de.pk.utils.lokalisierung.Lokalisierbar;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DialogPane;
import javafx.scene.effect.GaussianBlur;

public class UnschaerfeFensterDialog extends DialogPane implements Initializable, Lokalisierbar
{
	/**
	 * Pfad zur fxml-Datei, fuer die diese Klasse der Controller ist.
	 */
	private static final String FXML_PFAD = "UnschaerfeFensterDialog.fxml";

	private ArrayList<Node> unscharfeNodes = null;

	/**
	 * Erstellt einen neuen UnschaerfeFensterDialog, indem die fxml-Datei geladen
	 * wird und diese Klasse dieser sich selbst als ihr Controller hinzufuegt.
	 */
	public UnschaerfeFensterDialog()
	{
		FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(UnschaerfeFensterDialog.FXML_PFAD));
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
		// nicht benoetigt
	}

	/**
	 * Initialisiert diesen Controller.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		this.unscharfeNodes = new ArrayList<>();
	}

	/**
	 * Setzt diesen Dialog wieder auf nicht sichtbar und entfernt die Unschaerfe der
	 * unscharfZuSetzendenNodes wieder.
	 */
	public void setUnsichtbar()
	{
		this.setVisible(false);
		for (Node node : this.unscharfeNodes)
		{
			node.setEffect(null);
			node.applyCss();
		}
		this.unscharfeNodes.clear();
	}

	/**
	 * Setzt diesen Dialog sichtbar und dabei alle unscharfZuSetzendeNodes im
	 * Hintergruns unscharf.
	 *
	 * @param unscharfZuSetzendeNodes unscharf zu setzende Nodes
	 */
	public void setSichtbar(Node... unscharfZuSetzendeNodes)
	{
		this.unscharfeNodes.addAll(Arrays.asList(unscharfZuSetzendeNodes));
		this.setVisible(true);
		for (Node node : this.unscharfeNodes)
		{
			node.setEffect(new GaussianBlur());
		}
	}

}
