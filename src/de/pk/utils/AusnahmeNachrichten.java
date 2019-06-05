package de.pk.utils;

public class AusnahmeNachrichten
{
	/**
	 * Nachrichten sollten nach folgendem Stil benannt werden ($ = Anfang einer
	 * "Variable")
	 * $NAME_DER_KLASSE_DIE_DIESE_EXCEPTION_WIRFT_$BESCHREIBUNG_WAS_PASSIERT_IST
	 */
	public static final String LEBENDIGES_OBJEKT_PUNKTE_INDEX_UEBERSETZUNG_FEHLGESCHLAGEN = "Konnte EffektIndex nicht in LebendigesObjektPunkteIndex uebersetzen";

	public static final String KARTEN_GENERATOR_UNTERGRUND_MIT_RICHTUNG_DREHUNG_NICHT_NACH_RECHTS_ODER_LINKS = "Kann nur nach \"Osten\" oder \"Westen\" drehen";

	public static final String AKTION_FALSCHE_ANZAHL_ZIELE = "Nicht genug, oder zu viele Ziele fuer diese Aktion";

	public static final String OBJEKT_REFERENZ_TRENNER = ": ";

	public static final String WUERFEL_NICHT_GUELTIGER_LISTENER = "Der Listener ist nicht gueltig";

	public static final String KACHEL_POSITION_NICHT_GUELTIGES_ZIEL_FUER_EFFEKT = "Kachel Positionen koennen nur von Bewegungseffekten angezielt werden";

	public static final String KACHEL_POSITION_NICHT_GUELTIGE_POSITION = "Diese Position ist nicht gueltig, liegt also vermutlich nicht auf der Kachel bzw. Spielbrett";

	public static final String GEGENSTANDS_HAUFEN_HINZUTUEN_NICHT_RICHTIGER_INHALT = "Der Inhalt von zwei GegenstandsHaufen muss gleich sein um sie ineinander tuen zu koennen";

	public static final String GEGENSTANDS_HAUFEN_MENGE_IST_NICHT_GUELTIG = "Neue Menge ist entweder kleiner null, oder groesser der Maximalen Groesse: ";

	public static final String WELTKARTE_DUNGEON_NICHT_ENTHALTEN = "Am angegebenen Index befindet sich kein Dungeon: ";

	public static final String KARTEN_GENERATOR_KEINE_REGISTRIERTEN_KACHELN = "Dieser KartenGenerator hat keine registrierten Kacheln";

	public static final String KARTEN_GENERATOR_KANN_KEINE_VERBINDUNG_HERSTELLEN = "Es kann keine Verbindung zwischen diesen Kacheln hergestellt werden";

	public static final String DUNGEON_PHASEN_INDEX_NICHT_GUELTIG = "Der gegebene Phasenindex ist nicht gueltig";

	public static final String KARTEN_GENERATOR_UNTERGRUND_ANFRAGE_AUSSERHALB_VON_KACHEL = "Position ist groesser als eine Kachel";
	
	public static final String KARTEN_GENERATOR_KACHEL_KEIN_FREIES_FELD = "Kacheln muessen mindestens ein begehbares Feld am Rand haben!";
	/**
	 * Versteckter default Konstruktor, da eine Konstantenklasse nicht instanziiert
	 * werden sollte.
	 */
	private AusnahmeNachrichten()
	{
	}
}
