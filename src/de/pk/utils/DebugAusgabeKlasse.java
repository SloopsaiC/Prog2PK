package de.pk.utils;

/**
 *
 * @author Dylan
 */
public abstract class DebugAusgabeKlasse
{

	private static boolean ausgabeAktiv = false;

	public static void ausgeben(String info)
	{
		if (DebugAusgabeKlasse.ausgabeAktiv)
		{
			System.out.println(info);
		}
	}

	public static void setAusgabeAktiv(boolean setzeAusgabeAktiv)
	{
		DebugAusgabeKlasse.ausgabeAktiv = setzeAusgabeAktiv;
	}

}
