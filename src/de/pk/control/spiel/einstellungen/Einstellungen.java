package de.pk.control.spiel.einstellungen;

/**
 * 
 * */
public class Einstellungen
{
	
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
