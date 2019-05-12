package de.pk.control.app;

import de.pk.control.spiel.Dungeon;
import de.pk.control.spiel.Spiel;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.control.spiel.speichern.SpeicherUtils;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.position.Position;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.lokalisierung.DE_de;

/**
 * Die Main Klasse startet die Anwendung.
 *
 * @author Dylan
 */
public class Main
{

	/**
	 * Beendet die Anwendung und schliesst offene Ressourcen.
	 */
	public static void anwendungBeenden()
	{
		DebugEingabeKlasse.schliesseScanner();
		System.exit(0);
	}

	/**
	 * Startet die Anwendung (Das Spiel insgesamt).
	 */
	private static void anwendungStarten(String[] args)
	{
		Anwendung spielAnwendung = new Anwendung();
		spielAnwendung.starteAnwendung(args);
	}

	/**
	 * Begruesst den Nutzer bei Programmstart.
	 */
	private static void begruessen()
	{
		DebugAusgabeKlasse.ausgeben(DE_de.BEGRUESSUNG_BEI_PROGRAMMSTART);
	}

	/**
	 * Initialisiert Einstellungen noch vor Anwendungsstart.
	 */
	private static void initialisieren()
	{
		DebugAusgabeKlasse.setAusgabeAktiv(Einstellungen.DEBUG_MODUS_AN);
	}

	/**
	 * main-Methode startet das gesamte Programm.
	 *
	 * @param args Argumente der Kommandozeile
	 */
	public static void main(String[] args)
	{
		SpeicherUtils.speichere(new Position(1, 1), "posTest.txt");
		Spiel spiel = new Spiel(new Held[0]);
		spiel.getWeltkarte().fuegeDungeonHinzu(new Dungeon("TollerDungeon"));
		SpeicherUtils.speichere(spiel, "spielTest.txt");
		Spiel test = SpeicherUtils.ladeSpiel("spielTest.txt");
		Main.initialisieren();
		Main.begruessen();
		Main.anwendungStarten(args);
	}

}
