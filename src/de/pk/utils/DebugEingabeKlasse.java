package de.pk.utils;

import java.util.Scanner;

/**
 * Die DebugEIngabeKlasse besitzt einen Scanner, der einheitlich fuer alle
 * Konsoleneingaben im Rahmen des Debugs und Testings verwendet werden soll. Die
 * Klasse verwaltet die Scanner-Ressource und sorgt ebenso fuer das schliessen
 * der Ressource.
 *
 * @author Dylan
 */
public abstract class DebugEingabeKlasse
{

	/**
	 * Haelt den Scanner als Konstante.
	 */
	private static class DebugEingabeScannerHolder
	{

		private static final Scanner DEBUG_EINGABE_SCANNER = new Scanner(System.in);
	}

	/**
	 * Liest mit einem Scanner die naechste Zeile in der Konsole aus.
	 *
	 * @return Die eingelesene Zeile als String
	 */
	public static String leseZeileEin()
	{
		String zeile = "";
		while ((zeile == null) || zeile.isEmpty())
		{
			zeile = DebugEingabeScannerHolder.DEBUG_EINGABE_SCANNER.nextLine();
		}
		return zeile;
	}

	/**
	 * Schliesst den Scanner.
	 */
	public static void schliesseScanner()
	{
		DebugEingabeScannerHolder.DEBUG_EINGABE_SCANNER.close();
	}
}
