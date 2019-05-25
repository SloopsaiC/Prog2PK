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
	/**
	 * Versteckter default Konstruktor, da eine Konstantenklasse nicht instanziiert
	 * werden sollte.
	 */
	private AusnahmeNachrichten()
	{
	}
}
