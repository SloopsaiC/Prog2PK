package de.pk.control.app;

import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.DebugAusgabeKlasse;

/**
 * Main Klasse startet die Anwendung.
 *
 * @author Dylan
 */
public class Main
{

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
