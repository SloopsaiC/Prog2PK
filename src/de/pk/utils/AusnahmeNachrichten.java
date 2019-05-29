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

	/**
	 * Versteckter default Konstruktor, da eine Konstantenklasse nicht instanziiert
	 * werden sollte.
	 */
	private AusnahmeNachrichten()
	{
	}
}
