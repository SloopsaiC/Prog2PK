package de.pk.control.app;

import de.pk.control.karte.Weltkarte;
import de.pk.control.spiel.CraftingController;
import de.pk.control.spiel.Dungeon;
import de.pk.control.spiel.Spiel;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.model.interaktion.Aktion;
import de.pk.model.interaktion.bewegung.BewegungsAktion;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.position.Vektor;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.DE_de;
import javafx.application.Application;
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
	 * Die Anwendungsschleife fuehrt den Nutzer in das Hauptmenue und ruft je nach
	 * Eingabe die entsprechenden Optionen auf.
	 */
	private void anwendungsSchleife()
	{
		boolean amLeben = true;
		while (amLeben)
		{
			// An sich braucht man so eine Schleife mit JavaFX denke ich nicht mehr
		}
	}

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

	/**
	 * Initialisiert zunaechst die Anwendung und startet dann die
	 * Anwendungsschleife.
	 */
	public void starteAnwendung()
	{
		this.initAnwendung();
		this.anwendungsSchleife();
	}

	@Override
	public void start(Stage arg0) throws Exception
	{
		// TODO Auto-generated method stub
		
	}


}
