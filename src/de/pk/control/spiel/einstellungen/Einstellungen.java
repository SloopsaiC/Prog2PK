package de.pk.control.spiel.einstellungen;

import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.lokalisierung.DE_de;

/**
 *
 *
 */
public class Einstellungen
{

	private static final class EinstellungsBehaelter
	{

		static final Einstellungen EINSTELLUNGEN = new Einstellungen();
	}

	/**
	 * Konstante zum Einschalten des Debug-Modus (Konsolenausgaben).
	 */
	public final static boolean DEBUG_MODUS_AN = true;

	public static Einstellungen getEinstellungen()
	{
		return EinstellungsBehaelter.EINSTELLUNGEN;
	}

	private Einstellungen()
	{
	}

	/**
	 * Bearbeitet die Einstellungen, nur zu Demonstrationszwecken
	 */
	public void einstellungenBearbeiten()
	{

	}

}
