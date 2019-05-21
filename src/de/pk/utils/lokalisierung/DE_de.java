package de.pk.utils.lokalisierung;

/**
 * Konstanten-Klasse mit deutschen Texten und Zeichen zur Ausgabe.
 *
 * @author Dylan
 */
public class DE_de extends Lokalisierung
{

	/**
	 * Begruessungstext bei Start der Anwendung. Vorlaeufiger Arbeitstitel!
	 */
	public static final String BEGRUESSUNG_BEI_PROGRAMMSTART = "Herzlich willkommen im Spiel \"KI - Katastrophe auf Iava\".";

	/**
	 * Fragt, was als naechstes getan werden soll. Meistens vor der Auflistung von
	 * moeglichen Optionen zur Eingabe.
	 */
	public static final String MENUE_WAS_TUN = "Was wollen Sie tun?";

	/**
	 * Informiert darueber, dass die getaetigte Eingabe nicht mit den Erwartungen
	 * und den aufgelisteten Moeglichkeiten uebereinstimmt.
	 */
	public static final String MENUE_INKORREKTE_KONSOLEN_EINGABE = "\nInkorrekte Eingabe\n\n";

	/**
	 * Informiert den Anwender darueber, dass er sich im Hauptmenue befindet.
	 */
	public static final String HAUPTMENUE = "\n\n---Hauptmenue---";

	/**
	 * Listet die unterschiedlichen Optionen bzw. Aktionsmoeglichkeiten mit
	 * zugehoerigem Eingabesymbol fuer das Hauptmenue auf.
	 */
	public static final String HAUPTMENUE_AKTIONSAUSWAHL = "\tn = neues Spiel starten "
			+ "\n\ts = gespeichertes Spiel laden " + "\n\tc = Crafting"
			+ "\n\to = Optionen und Einstellungen \n\tx = beenden";

	/**
	 * Informiert den Anwender darueber, dass er sich im Menue der Einstellungen /
	 * Optionen befindet.
	 */
	public static final String OPTIONSMENUE = "\n\n---Optionsmenue---";

	/**
	 * Listet die unterschiedlichen Optionen bzw. Aktionsmoeglichkeiten mit
	 * zugehoerigem Eingabesymbol fuer das Optionsmenue auf.
	 */
	public static final String OPTIONSMENUE_AKTIONSAUSWAHL = "\t1 = Schwierigkeitsgrad " + "\n\t2 = Sound "
			+ "\n\t3 = Sprache \n\t4 = zurueck zum Hauptmenue";

	/**
	 * Informiert den Anwender darueber, dass er sich im Crafting-Menue befindet.
	 */
	public static final String CRAFTINGMENUE = "\n\n---Crafting-Menue---";

	/**
	 * Listet die unterschiedlichen Optionen bzw. Aktionsmoeglichkeiten mit
	 * zugehoerigem Eingabesymbol fuer das Crafting-Menue auf.
	 */
	public static final String CRAFTINGMENUE_AKTIONSAUSWAHL = "\tn = versuchen neuen Gegenstand zu craften"
			+ "\n\tx = abbrechen";

	/**
	 * Zeigt das vorgehen und die Eingabesyntax mit zugehoerigem Eingabesymbol fuer
	 * das Craften auf.
	 */
	public static final String CRAFTEN_INFO = "Gib deine Materialien in 3x3 Form ein (3 Zeilen mit je 3 Materialien durch \", \" getrennt), x = abbrechen";

	/**
	 * Fordert den Anwender auf, seine Materialien nachfolgend zu taetigen.
	 */
	public static final String CRAFTEN_EINGABEAUFFORDERUNG = "\nKombiniere einen neuen Gegenstand aus folgenden Materialen:\n";

	/**
	 * Informiert ueber einen Syntaxfehler bei der Materialeingabe beim Craften.
	 */
	public static final String CRAFTEN_ZU_KURZE_EINGABE = "\n\n\nGib 3 Materialien pro Zeile ein.\n\n\n";

	/**
	 * Informiert ueber einen Syntaxfehler beim Craften.
	 */
	public static final String CRAFTEN_SONSTIGER_SYNTAXFEHLER = "\n\n\nHoppla, da hat sich wohl ein Syntaxfehler eingeschlichen. "
			+ "Vergiss nicht deine Eingaben mit \", \" zu trennen.\n\n\n";

	/**
	 * Fuer die erneute Ausgabe der Materialieneingabe beim Craften zur
	 * Ueberprufeung.
	 */
	public static final String CRAFTEN_MATERIALAUSGABE = "\nDeine Materialien-Eingabe: ";

	/**
	 * Informiert ueber einen erfolgreich gecrafteten Gegenstand.
	 */
	public static final String CRAFTEN_ERFOLG = "\nGlueckwunsch! Du hast soeben folgenden Gegenstand gecraftet: ";

	/**
	 * Informiert ueber ein nicht erfolgreiches Craften.
	 */
	public static final String CRAFTEN_KEIN_GEGENSTAND = "\tist leider kein gueltiger Gegenstand.\n\n";

	/**
	 * Fordert zur Eingabe von Input waehrend des Spielablaufs im Dungeon auf.
	 */
	public static final String DUNGEON_ABLAUF_INPUT_AUFFORDERUNG = "Geben Sie Input ein. (x = beenden)";

	/**
	 * Informiert darueber, dass man sich auf der Weltkarte befindet.
	 */
	public static final String WELTKARTE = "\n\n---Weltkarte des Spiels---";

	/**
	 * Fordert auf, einen Dungeon auszuwaehlen.
	 */
	public static final String WELTKARTE_DUNGEONWAHL = "Welchen Dungeon wollen wie waehlen?";

	/**
	 * Fuer die Ausgabe der Dungeons.
	 */
	public static final String WELTKARTE_DUNGEON = " = Dungeon ";

	/**
	 * Eingabeoption mit Symbol um zum Hauptmenue zurueck zu kehren.
	 */
	public static final String WELTKARTE_ZURUECK = "\t0 = zurueck zum Hauptmenue\n";

	/**
	 * sinnfreie Testausgabe anstelle der implementierten Methode "Spiel laden".
	 */
	public static final String TESTAUSGABE_HAUPTMENUE_SPIEL_LADEN = "^^Spiel laden^^";

	/**
	 * sinnfreie Testausgabe anstelle der Einstellungen fuer den Schwierigkeitsgrad.
	 */
	public static final String TESTAUSGABE_OPTIONSMENUE_SCHWIERIGKEIT = "^^sehr schwer^^";

	/**
	 * sinnfreie Testausgabe anstelle der Einstellungen fuer Soundeinstellungen.
	 */
	public static final String TESTAUSGABE_OPTIONSMENUE_SOUND = "^^fetter Sound^^";

	/**
	 * sinnfreie Testausgabe anstelle der Einstellungen fuer die Sprache im Spiel.
	 */
	public static final String TESTAUSGABE_OPTIONSMENUE_SPRACHE = "^^Denglisch^^";

	/**
	 * sinnfreie Testausgabe anstelle der eigentlichen Implementierung der
	 * Heldenphase.
	 */
	public static final String TESTAUSGABE_PHASEN_HELDENPHASE = "^^Heldenphase^^";

	/**
	 * sinnfreie Testausgabe anstelle der eigentlichen Implementierung der
	 * Explorationsphase.
	 */
	public static final String TESTAUSGABE_PHASEN_EXPLORATIONSPHASE = "^^Explorationsphase^^";

	/**
	 * Splitter von Eingabe, die im Code getrennt werden sollen, wie die
	 * Materialieneingabe in einer Zeile beim Craften.
	 */
	public static final String STANDARD_SPLITTER = ", ";

	/**
	 * sinnfreie Testausgabe anstelle der Dungeon Namen.
	 */
	public static final String[] TESTAUSGABE_DUNGEON_NAME = { "TestDungeonEins", "TestDungeonZwei" };

	/**
	 * Eingabsymbol zum Beenden oder Zurueckkehren in das vorherige / uebergeordnete
	 * Menue.
	 */
	public static final char EINGABESYMBOL_MENUE_BEENDEN_ODER_ZURUECK = 'x';

	/**
	 * Eingabsymbol zum Starten eines neuen Spiels im Hauptmenue.
	 */
	public static final char EINGABESYMBOL_HAUPTMENUE_NEUES_SPIEL = 'n';

	/**
	 * Eingabsymbol zum Laden eines gespeicherten Spiels im Hauptmenue.
	 */
	public static final char EINGABESYMBOL_HAUPTMENUE_SPIEL_LADEN = 's';

	/**
	 * Eingabsymbol zum Oeffnen der Einstellungen / Optionen.
	 */
	public static final char EINGABESYMBOL_HAUPTMENUE_OPTIONEN = 'o';

	/**
	 * Eingabsymbol zum Oeffnen des Crafting-Menues.
	 */
	public static final char EINGABESYMBOL_HAUPTMENUE_CRAFTING = 'c';

	/**
	 * Eingabsymbol zum Oeffnen des Crafting-Menues.
	 */
	public static final char EINGABESYMBOL_CRAFTINGMENUE_NEU_CRAFTEN = 'n';

	public static final String ANWENDUNG_FENSTER_TITEL = "KI-Katastrophe auf Iava";

}
