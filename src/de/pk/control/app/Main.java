package de.pk.control.app;

import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.HeldController;
import de.pk.kartenGenerator.KartenGenerator;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;

/**
 * Main Klasse startet die Anwendung.
 *
 * @author Dylan
 */
public class Main
{

	/**
	 * Beendet die Anwendung und schliest offene Ressourcen.
	 */
	public static void anwendungBeenden()
	{
		DebugEingabeKlasse.schliesseScanner();
		System.exit(0);
	}

	/**
	 * Startet die Anwendung (Das Spiel insgesamt).
	 */
	private static void anwendungStarten()
	{
		Anwendung spielAnwendung = new Anwendung();
		spielAnwendung.starteAnwendung();
	}

	/**
	 * Begruesst den Nutzer bei Programmstart.
	 */
	private static void begruessen()
	{
		DebugAusgabeKlasse.ausgeben("Herzlich willkommen im Spiel \"KI - Katastrophe auf Iava\".");
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
		Main.initialisieren();
		Main.begruessen();
		Main.anwendungStarten();
	}

}
