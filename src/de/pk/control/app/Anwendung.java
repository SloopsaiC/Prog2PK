package de.pk.control.app;

import de.pk.control.karte.Weltkarte;
import de.pk.control.spiel.Dungeon;
import de.pk.control.spiel.Spiel;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.DE_de;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Die Anwendung verwaltet die Auswahl eines Spielstandes, die Bearbeitung von
 * Optionen und das Starten eines Spiels.
 *
 * @author Dylan
 */
public class Anwendung extends Application
{

	/**
	 * Das aktuelle Spiel dieser Anwendung.
	 */
	private Spiel aktivesSpiel = null;
	/**
	 * Die Einstellungen dieser Anwendung.
	 */
	private Einstellungen anwendungsEinstellungen = null;

	/**
	 * Die Anwendung (Dieses aktuelle Objekt) wird initialisiert, Einstellungen
	 * werden uebernommen.
	 */
	private void initAnwendung()
	{
		this.anwendungsEinstellungen = Einstellungen.getEinstellungen();
	}

	/**
	 * Wird im Hauptmenue der Punkt "Neues Spiel" gewaehlt, wird hier ein neues
	 * Spiel initialisiert.
	 */
	private void neuesSpiel()
	{
		Weltkarte weltkarte = new Weltkarte(new Dungeon(DE_de.TESTAUSGABE_DUNGEON_NAME[0]),
				new Dungeon(DE_de.TESTAUSGABE_DUNGEON_NAME[1]));
		this.aktivesSpiel = new Spiel(weltkarte, Spielkonstanten.STANDARD_HELDEN);
	}

	/**
	 * Wird im Hauptmenue die Option "Spiel Laden" gewaehlt, wird dies hier
	 * behandelt.
	 */
	private void spielLaden()
	{
		this.aktivesSpiel = null;
	}

	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Hello World!");
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				System.out.println("Hello World!");
			}
		});
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

	/**
	 * Initialisiert zunaechst die Anwendung und startet dann die
	 * Anwendungsschleife.
	 */
	public void starteAnwendung(String[] args)
	{
		this.initAnwendung();
		Application.launch(args);
	}
}
