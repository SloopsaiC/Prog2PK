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
	public static final String ANWENDUNGS_TITEL_KEY = "anwendungsTitel";
	public static final String ZUM_HAUPTMENUE_KEY = "zumHauptmenue";
	public static final String AUFLOESUNG_ANWENDEN_KEY = "aufloesungAnwenden";
	public static final String AUFLOESUNG_KEY = "aufloesung";
	public static final String EINSTELLUNGEN_KEY = "einstellungen";
	public static final String LAUTSTAERKE_KEY = "lautstaerke";
	public static final String MUSIK_KEY = "musik";
	public static final String SOUND_KEY = "sound";
	public static final String SPRACHE_KEY = "sprache";
	public static final String ZURUECK_KEY = "zurueck";
	public static final String TOOLTIP_AUFLOESUNG_KEY = "tooltipAufloesung";
	public static final String TOOLTIP_SPRACHE_KEY = "tooltipSprache";
	public static final String CREDTITS_KEY = "credits";
	public static final String HAUPTMENUE_KEY = "hauptmenue";
	public static final String NEUES_SPIEL_KEY = "neuesSpiel";
	public static final String OPTIONEN_KEY = "optionen";
	public static final String BEENDEN_KEY = "beenden";
	public static final String SPIEL_LADEN_KEY = "spielLaden";
	public static final String ZUM_TITELBILDSCHIRM_KEY = "zumTitelbildschrim";
	public static final String TOOLTIP_QUEST_LOG_OEFFNEN_KEY = "tooltipQuestLogOeffnen";
	public static final String TOOLTIP_QUEST_LOG_SCHLIESSEN_KEY = "tooltipQuestLogSchliessen";

}
