package de.pk.utils;

public class AusnahmeNachrichten
{
	/**
	 * Versteckter default Konstruktor, da eine Konstantenklasse nicht instanziiert
	 * werden sollte.
	 */
	private AusnahmeNachrichten()
	{
	}

	/**
	 * Nachrichten sollten nach folgendem Stil benannt werden ($ = Anfang einer
	 * "Variable")
	 * $NAME_DER_KLASSE_DIE_DIESE_EXCEPTION_WIRFT_$BESCHREIBUNG_WAS_PASSIERT_IST
	 */
	public static final String LEBENDIGES_OBJEKT_PUNKTE_INDEX_UEBERSETZUNG_FEHLGESCHLAGEN = "Konnte EffektIndex nicht in LebendigesObjektPunkteIndex uebersetzen";
}