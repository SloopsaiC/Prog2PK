package de.pk.control.app;

import java.util.Scanner;

import de.pk.control.karte.WeltkarteController;
import de.pk.control.spiel.DungeonController;
import de.pk.control.spiel.SpielController;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.DebugAusgabeKlasse;

/**
 * Die Anwendung verwaltet die Auswahl eines Spielstandes, die Bearbeitung von
 * Optionen und das Starten eines Spiels.
 *
 * @author Dylan
 */
public class Anwendung
{

	private SpielController aktivesSpiel = null;
	private Einstellungen anwendungsEinstellungen = null;

	/**
	 * Die Anwendungsschleife fuehrt den Nutzer in das Hauptmenue und ruft je nach
	 * Eingabe die entsprechenden Optionen auf.
	 */
	private void anwendungsSchleife()
	{
		Scanner s = null;
		while (true)
		{
			DebugAusgabeKlasse.ausgeben("\n\nHauptmenue ^^");
			DebugAusgabeKlasse.ausgeben("Was wollen Sie tun?");
			s = new Scanner(System.in);
			DebugAusgabeKlasse.ausgeben("\tn = neues Spiel starten " + "\n\ts = gespeichertes Spiel laden "
					+ "\n\to = Optionen und Einstellungen \n\tx = beenden");
			switch (s.nextLine().charAt(0))
			{
			case 'n':
				this.neuesSpiel();
				break;
			case 's':
				this.spielLaden();
				break;
			case 'o':
				this.anwendungsEinstellungen.einstellungenBearbeiten();
				break;
			case 'x':
				System.exit(0);
				break;
			default:
				DebugAusgabeKlasse.ausgeben("Inkorrekte Eingabe\n\n");
			}
		}

	}

	/**
	 * Die Anwendung wird initialisiert, Einstellungen uebernommen.
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
		WeltkarteController weltkarte = new WeltkarteController(2);
		weltkarte.fuegeDungeonHinzu(new DungeonController("TestDungeonEins", 2));
		weltkarte.fuegeDungeonHinzu(new DungeonController("TestDungeonZwei", 2));
		this.aktivesSpiel = new SpielController(weltkarte);
		this.aktivesSpiel.starteSpiel();
	}

	/**
	 * Wird im Hauptmenue die Option "Spiel Laden" gewaehlt, wird dies hier
	 * behandelt.
	 */
	private void spielLaden()
	{
		DebugAusgabeKlasse.ausgeben("Spiel laden^^");
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

}
