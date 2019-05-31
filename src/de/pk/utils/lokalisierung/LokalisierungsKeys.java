package de.pk.utils.lokalisierung;

/**
 * Konstanten-Klasse mit deutschen Texten und Zeichen zur Ausgabe.
 *
 * @author Dylan
 */
public class LokalisierungsKeys
{

	/**
	 * Begruessungstext bei Start der Anwendung. Vorlaeufiger Arbeitstitel!
	 */
	public static final String BEGRUESSUNG_BEI_PROGRAMMSTART = "Herzlich willkommen im Spiel \"KI - Katastrophe auf Iava\".";

	/**
	 * Informiert darueber, dass die getaetigte Eingabe nicht mit den Erwartungen
	 * und den aufgelisteten Moeglichkeiten uebereinstimmt.
	 */
	public static final String MENUE_INKORREKTE_KONSOLEN_EINGABE = "\nInkorrekte Eingabe\n\n";

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
	 * Splitter von Eingabe, die im Code getrennt werden sollen, wie die
	 * Materialieneingabe in einer Zeile beim Craften.
	 */
	public static final String STANDARD_SPLITTER = ", ";

	/**
	 * sinnfreie Testausgabe anstelle der Dungeon Namen.
	 */
	public static final String[] TESTAUSGABE_DUNGEON_NAME =
	{ "TestDungeonEins", "TestDungeonZwei" };

	/**
	 * KEYS FUER DIE SPRACH-PROPERTIES ZUM AUSLESEN
	 *
	 */
	public static final String ANWENDUNGS_TITEL = "anwendungsTitel";

	public static final String ZUM_HAUPTMENUE = "zumHauptmenue";

	public static final String AUFLOESUNG_ANWENDEN = "aufloesungAnwenden";

	public static final String AUFLOESUNG = "aufloesung";

	public static final String EINSTELLUNGEN = "einstellungen";

	public static final String LAUTSTAERKE = "lautstaerke";

	public static final String MUSIK = "musik";

	public static final String SOUND = "sound";

	public static final String SPRACHE = "sprache";

	public static final String ZURUECK = "zurueck";

	public static final String TOOLTIP_AUFLOESUNG = "tooltipAufloesung";

	public static final String TOOLTIP_SPRACHE = "tooltipSprache";

	public static final String CREDTITS = "credits";

	public static final String HAUPTMENUE = "hauptmenue";

	public static final String NEUES_SPIEL = "neuesSpiel";

	public static final String OPTIONEN = "optionen";

	public static final String BEENDEN = "beenden";

	public static final String SPIEL_LADEN = "spielLaden";

	public static final String ZUM_TITELBILDSCHIRM = "zumTitelbildschrim";

}
