package de.pk.control.spiel.einstellungen;

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
	/**
	 * Standard Aufloesung bei erstem Start des Spiels.
	 */
	public static final Aufloesung STANDARD_AUFLOESUNG = Aufloesung.FULL_HD;

	/**
	 * Gibt die Instanz der Einstellungs-Klasse zurueck.
	 *
	 * @return die Instanz dieser Klasse
	 */
	public static Einstellungen getEinstellungen()
	{
		return EinstellungsBehaelter.EINSTELLUNGEN;
	}

	private Aufloesung anwendungsAufloesung = Einstellungen.STANDARD_AUFLOESUNG;

	private Einstellungen()
	{
	}

	public Aufloesung getAnwendungsAufloesung()
	{
		return this.anwendungsAufloesung;
	}

	public void setAnwendungsAufloesung(Aufloesung anwendungsAufloesung)
	{
		this.anwendungsAufloesung = anwendungsAufloesung;
	}

}
