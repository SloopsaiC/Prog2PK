package de.pk.utils;

/**
 * Hilfklasse stellt Methoden zur Konsolenausgabe bereit (z.B. zu Debug- oder
 * Testzwecken).
 *
 * @author Dylan
 */
public abstract class DebugAusgabeKlasse
{

	private static boolean ausgabeAktiv = false;

	/**
	 * Gibt den String info in der Konsole aus. Verhaelt sich exakt wie ein Aufruf
	 * von System.out.println(info).
	 *
	 * @param info In der Konsole auszugebender Text vom Typ String.
	 */
	public static void ausgeben(String info)
	{
		if (DebugAusgabeKlasse.ausgabeAktiv)
		{
			System.out.println(info);
		}
	}

	/**
	 * Gibt ein zweidimensionales Array aus, indem von jedem Objekt von array die
	 * toString()-Methode aufgerufen wird. Spalten von array werden mit " | "
	 * getrennt. Eine Beschriftung, Ueberschrift oder sonstige Info kann mit info
	 * eine Zeile ueber array ausgegeben werden.
	 *
	 * @param info  Beschriftung o.ae., wird in der Zeile vor array ausgegeben.
	 * @param array Ein zweidimensionales Array, welches in "Tabellenform"
	 *              ausgegeben wird. Spalten werden mit " | " getrennt.
	 */
	public static void ausgeben(String info, Object[][] array)
	{
		DebugAusgabeKlasse.ausgeben(info);
		for (Object[] objects : array)
		{
			String zeile = "";
			for (Object object : objects)
			{
				zeile += object.toString() + "\t| ";
			}
			DebugAusgabeKlasse.ausgeben("| " + zeile);
		}
	}

	/**
	 * Setzt die Ausgabe in der Konsole aktiv.
	 *
	 * @param setzeAusgabeAktiv setzt die Konsolenausgabe aktiv, wenn wahr.
	 */
	public static void setAusgabeAktiv(boolean setzeAusgabeAktiv)
	{
		DebugAusgabeKlasse.ausgabeAktiv = setzeAusgabeAktiv;
	}

}
