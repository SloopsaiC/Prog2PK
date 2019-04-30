package de.pk.control.app;

import de.pk.control.karte.WeltkarteController;
import de.pk.control.spiel.CraftingController;
import de.pk.control.spiel.Dungeon;
import de.pk.control.spiel.Spiel;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.model.interaktion.Aktion;
import de.pk.model.interaktion.Effekt;
import de.pk.model.position.Vektor;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.DE_de;

/**
 * Die Anwendung verwaltet die Auswahl eines Spielstandes, die Bearbeitung von
 * Optionen und das Starten eines Spiels.
 *
 * @author Dylan
 */
public class Anwendung
{

	/**
	 * Der Spiel-Controller dieser Anwendung.
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
			DebugAusgabeKlasse.ausgeben(DE_de.HAUPTMENUE);
			DebugAusgabeKlasse.ausgeben(DE_de.MENUE_WAS_TUN);
			DebugAusgabeKlasse.ausgeben(DE_de.HAUPTMENUE_AKTIONSAUSWAHL);
			switch (DebugEingabeKlasse.leseZeileEin().charAt(0))
			{
			case DE_de.EINGABESYMBOL_HAUPTMENUE_NEUES_SPIEL:
				this.neuesSpiel();
				break;
			case DE_de.EINGABESYMBOL_HAUPTMENUE_SPIEL_LADEN:
				this.spielLaden();
				break;
			case DE_de.EINGABESYMBOL_HAUPTMENUE_CRAFTING:
				this.starteCrafting();
				break;
			case DE_de.EINGABESYMBOL_HAUPTMENUE_OPTIONEN:
				this.anwendungsEinstellungen.einstellungenBearbeiten();
				break;
			case DE_de.EINGABESYMBOL_MENUE_BEENDEN_ODER_ZURUECK:
				amLeben = false;
				break;
			default:
				DebugAusgabeKlasse.ausgeben(DE_de.MENUE_INKORREKTE_KONSOLEN_EINGABE);
			}
		}
	}

	/**
	 * Die Anwendung (Dieses aktuelle Objekt) wird initialisiert, Einstellungen
	 * werden uebernommen.
	 */
	private void initAnwendung()
	{
		this.anwendungsEinstellungen = Einstellungen.getEinstellungen();
		// Init den Dummy Helden mit "Bewegen" Aktion, nur zu Testzwecken
		Spielkonstanten.STANDARD_HELDEN[0].fuegeAktionHinzu("Bewegen",
				new Aktion(new Effekt(1, 0, 0, 0, 1, new Vektor(-1, 0)), null, 1f));
	}

	/**
	 * Wird im Hauptmenue der Punkt "Neues Spiel" gewaehlt, wird hier ein neues
	 * Spiel initialisiert.
	 */
	private void neuesSpiel()
	{
		WeltkarteController weltkarte = new WeltkarteController(new Dungeon(DE_de.TESTAUSGABE_DUNGEON_NAME[0]),
				new Dungeon(DE_de.TESTAUSGABE_DUNGEON_NAME[1]));
		this.aktivesSpiel = new Spiel(weltkarte, Spielkonstanten.STANDARD_HELDEN);
		this.aktivesSpiel.starteSpiel();
	}

	/**
	 * Wird im Hauptmenue die Option "Spiel Laden" gewaehlt, wird dies hier
	 * behandelt.
	 */
	private void spielLaden()
	{
		DebugAusgabeKlasse.ausgeben(DE_de.TESTAUSGABE_HAUPTMENUE_SPIEL_LADEN);
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

	/**
	 * Startet das Crafting Menue.
	 */
	private void starteCrafting()
	{
		CraftingController craftingController = new CraftingController();
		craftingController.craftingMenue();
	}

}
