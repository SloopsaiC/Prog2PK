package de.pk.control.spiel.einstellungen;

import java.util.Scanner;

import de.pk.utils.DebugAusgabeKlasse;

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
	 * Menue zum Auswaehlen der einzelnen Einstellungsoptionen.
	 */
	public void einstellungenBearbeiten()
	{
		zurHauptschleife: while (true)
		{
			DebugAusgabeKlasse.ausgeben("\n\nOptionsmenue ^^");
			DebugAusgabeKlasse.ausgeben("Welche Optionen moechten Sie bearbeiten?");
			Scanner s = new Scanner(System.in);
			DebugAusgabeKlasse.ausgeben(
					"\t1 = Schwierigkeitsgrad " + "\n\t2 = Sound " + "\n\t3 = Sprache \n\t4 = zurueck zum Hauptmenue");

			switch (s.nextInt())
			{
			case 1:
				DebugAusgabeKlasse.ausgeben("sehr schwer"); // sinnlose Testausgabe
				break;
			case 2:
				DebugAusgabeKlasse.ausgeben("fetter Sound"); // sinnlose Testausgabe
				break;
			case 3:
				DebugAusgabeKlasse.ausgeben("Denglisch"); // sinnlose Testausgabe
				break;
			case 4:
				break zurHauptschleife;
			default:
				DebugAusgabeKlasse.ausgeben("Inkorrekte Eingabe\n\n");
			}
		}
	}

}
