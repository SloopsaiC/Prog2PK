package de.pk.control.app;

import de.pk.control.karte.Weltkarte;
import de.pk.control.spiel.Dungeon;
import de.pk.control.spiel.Spiel;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import de.pk.view.visuell.AnwendungFX;

/**
 * Die Anwendung verwaltet die Auswahl eines Spielstandes, die Bearbeitung von
 * Optionen und das Starten eines Spiels.
 *
 * @author Dylan
 */
public class Anwendung
{

	// Einfache Singleton Struktur
	private static Anwendung INSTANZ = null;

	public static Anwendung getInstanz()
	{
		if (Anwendung.INSTANZ == null)
		{
			Anwendung.INSTANZ = new Anwendung();
		}
		return Anwendung.INSTANZ;
	}

	/**
	 * Das aktuelle Spiel dieser Anwendung.
	 */
	private Spiel aktivesSpiel = null;
	/**
	 * Die Einstellungen dieser Anwendung.
	 */
	private Einstellungen anwendungsEinstellungen = null;

	private Anwendung()
	{
	}

	/**
	 * @return the aktivesSpiel
	 */
	public Spiel getAktivesSpiel()
	{
		return this.aktivesSpiel;
	}

	/**
	 * Die Anwendung (Dieses aktuelle Objekt) wird initialisiert, Einstellungen
	 * werden uebernommen.
	 */
	private void initAnwendung()
	{
		this.anwendungsEinstellungen = Einstellungen.getEinstellungen();
		this.neuesSpiel();
	}

	/**
	 * Wird im Hauptmenue der Punkt "Neues Spiel" gewaehlt, wird hier ein neues
	 * Spiel initialisiert.
	 */
	private void neuesSpiel()
	{
		Weltkarte weltkarte = new Weltkarte(new Dungeon(LokalisierungsKeys.TESTAUSGABE_DUNGEON_NAME[0]),
				new Dungeon(LokalisierungsKeys.TESTAUSGABE_DUNGEON_NAME[1]));
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
	public void starteAnwendung(String[] args)
	{
		this.initAnwendung();
		AnwendungFX.starteAnwendung(args);
	}

}
