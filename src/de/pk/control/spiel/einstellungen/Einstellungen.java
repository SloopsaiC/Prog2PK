package de.pk.control.spiel.einstellungen;

/**
 * 
 * */
public class Einstellungen
{
	public static boolean DEBUG_MODUS = false;
	
	private static final class EinstellungsBehaelter
	{
		static final Einstellungen EINSTELLUNGEN = new Einstellungen();
	}

	Einstellungen()
	{
	}

	public static Einstellungen getEinstellungen()
	{
		return EinstellungsBehaelter.EINSTELLUNGEN;
	}

}
