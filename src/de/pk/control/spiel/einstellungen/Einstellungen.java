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

	public void einstellungenBearbeiten()
	{
		boolean amLeben = true;
		while (amLeben)
		{
			DebugAusgabeKlasse.ausgeben(DE_de.OPTIONSMENUE);
			DebugAusgabeKlasse.ausgeben(DE_de.MENUE_WAS_TUN);
			DebugAusgabeKlasse.ausgeben(DE_de.OPTIONSMENUE_AKTIONSAUSWAHL);

			switch (Integer.valueOf(DebugEingabeKlasse.leseZeileEin()))
			{
			case 1:
				DebugAusgabeKlasse.ausgeben(DE_de.TESTAUSGABE_OPTIONSMENUE_SCHWIERIGKEIT); // sinnlose Testausgabe
				break;
			case 2:
				DebugAusgabeKlasse.ausgeben(DE_de.TESTAUSGABE_OPTIONSMENUE_SOUND); // sinnlose Testausgabe
				break;
			case 3:
				DebugAusgabeKlasse.ausgeben(DE_de.TESTAUSGABE_OPTIONSMENUE_SPRACHE); // sinnlose Testausgabe
				break;
			case 4:
				amLeben = false;
				break;
			default:
				DebugAusgabeKlasse.ausgeben(DE_de.MENUE_INKORREKTE_KONSOLEN_EINGABE);
			}
		}
	}

}
