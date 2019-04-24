package de.pk.control.app;

import de.pk.control.karte.WeltkarteController;
import de.pk.control.spiel.CraftingController;
import de.pk.control.spiel.DungeonController;
import de.pk.control.spiel.SpielController;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.control.spiel.speichern.SpeicherUtils;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.Spielkonstanten;

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
		boolean amLeben = true;
		while (amLeben)
		{
			DebugAusgabeKlasse.ausgeben("\n\nHauptmenue ^^");
			DebugAusgabeKlasse.ausgeben("Was wollen Sie tun?");
			DebugAusgabeKlasse.ausgeben("\tn = neues Spiel starten " + "\n\ts = gespeichertes Spiel laden "
					+ "\n\tc = Crafting" + "\n\to = Optionen und Einstellungen \n\tx = beenden");
			switch (DebugEingabeKlasse.leseZeileEin().charAt(0))
			{
			case 'n':
				this.neuesSpiel();
				break;
			case 's':
				this.spielLaden();
				break;
			case 'c':
				this.crafting();
				break;
			case 'o':
				this.anwendungsEinstellungen.einstellungenBearbeiten();
				break;
			case 'x':
				amLeben = false;
				break;
			default:
				DebugAusgabeKlasse.ausgeben("Inkorrekte Eingabe\n\n");
			}
		}
	}

	private void crafting()
	{
		CraftingController cc = new CraftingController();
		cc.craftingMenue();
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
		WeltkarteController weltkarte = new WeltkarteController(new DungeonController("TestDungeonEins"),
				new DungeonController("TestDungeonZwei"));
		this.aktivesSpiel = new SpielController(weltkarte, Spielkonstanten.STANDARD_HELDEN);
		SpeicherUtils.speichere(this.aktivesSpiel, "speicherTest");
		// SpielController geladen = SpeicherUtils.ladeSpiel("speicherTest");
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
