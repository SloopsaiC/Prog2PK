package de.pk.control.spiel.einstellungen;

import java.util.Locale;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.view.visuell.AnwendungFX;

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

	public static final Sprache STANDARD_SPRACHE = Sprache.de;

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
	private Sprache anwendungsSprache = Einstellungen.STANDARD_SPRACHE;

	private ResourceBundle sprachRessource = null;

	private Einstellungen()
	{
		this.sprachRessource = ResourceBundle.getBundle(Spielkonstanten.LOKALISIERUNG_PFAD,
				new Locale(this.anwendungsSprache.toString()));
	}

	public Aufloesung getAnwendungsAufloesung()
	{
		return this.anwendungsAufloesung;
	}

	public Sprache getAnwendungsSprache()
	{
		return this.anwendungsSprache;
	}

	public ResourceBundle getSprachRessource()
	{
		return this.sprachRessource;
	}

	public void setAnwendungsAufloesung(Aufloesung anwendungsAufloesung)
	{
		this.anwendungsAufloesung = anwendungsAufloesung;
	}

	public void setAnwendungsSprache(Sprache anwendungsSprache)
	{
		this.anwendungsSprache = anwendungsSprache;
		this.sprachRessource = ResourceBundle.getBundle(Spielkonstanten.LOKALISIERUNG_PFAD,
				new Locale(this.anwendungsSprache.toString()));
		AnwendungFX.aktualisiereSzenenSprache(this.sprachRessource);
	}

}
