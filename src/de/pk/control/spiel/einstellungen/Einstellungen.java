package de.pk.control.spiel.einstellungen;

import java.util.Locale;
import java.util.ResourceBundle;

import de.pk.utils.Spielkonstanten;
import de.pk.view.visuell.AnwendungFX;
import de.pk.view.visuell.szenenController.HauptmenueSzeneController;

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
	private static final int STANDARD_LAUTSTAERKE = 0;

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
	private boolean vollbild = false;
	private int musikLautstaerke = Einstellungen.STANDARD_LAUTSTAERKE;
	private int soundLautstaerke = Einstellungen.STANDARD_LAUTSTAERKE;

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

	public void setVollbild(boolean vollbild)
	{
		this.vollbild = vollbild;
	}

	public boolean getVollbild()
	{
		return this.vollbild;
	}

	public int getMusikLautstaerke()
	{
		return this.musikLautstaerke;
	}

	public void setMusikLautstaerke(int musikLautstaerke)
	{
		this.musikLautstaerke = musikLautstaerke;
		// TODO Musik Volume / Musik in eigene Klasse auslagern
		HauptmenueSzeneController.getAudio().setProzentualeLautstaerke(this.musikLautstaerke, false);
	}

	public int getSoundLautstaerke()
	{
		return this.soundLautstaerke;
	}

	public void setSoundLautstaerke(int soundLautstaerke)
	{
		// TODO Sound Volume anbinden
		this.soundLautstaerke = soundLautstaerke;
	}

}
