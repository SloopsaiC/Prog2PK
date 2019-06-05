package de.pk.control.app;

import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import javafx.application.Platform;

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
		Platform.exit();
		System.exit(0);
	}

	/**
	 * Startet die Anwendung (Das Spiel insgesamt).
	 */
	private static void anwendungStarten(String[] args)
	{
		Anwendung.getInstanz().starteAnwendung(args);
	}

	/**
	 * Begruesst den Nutzer bei Programmstart.
	 */
	private static void begruessen()
	{
		DebugAusgabeKlasse.ausgeben(LokalisierungsKeys.BEGRUESSUNG_BEI_PROGRAMMSTART);
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
		// SpeicherUtils.speichere(new Position(1, 1), "posTest.txt");
		// Spiel spiel = new Spiel(new Held[0]);
		// spiel.getWeltkarte().fuegeDungeonHinzu(new Dungeon("TollerDungeon"));
		// SpeicherUtils.speichere(spiel, "spielTest.txt");
		// Spiel test = SpeicherUtils.ladeSpiel("spielTest.txt");
		Main.initialisieren();
		Main.begruessen();
		Main.anwendungStarten(args);

	}

}
