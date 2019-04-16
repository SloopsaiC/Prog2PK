package de.pk.model.spielbrett.spielbrettObjekte.container;

import de.pk.control.gegenstaende.GegenstandsHaufen;

public abstract class Container
{
	private GegenstandsHaufen[] inhalt = null; // Der Inhalt dieses Containers

	protected Container(int maximaleGroesse)
	{
		this.inhalt = new GegenstandsHaufen[maximaleGroesse];
	}

	private boolean ueberpruefeIndex(int index, boolean werfeAusnahme)
	{
		if (index > 0 && index < this.inhalt.length)
		{
			return true;
		}
		if (werfeAusnahme)
		{
			// TODO: Exception messages
			throw new IllegalArgumentException();
		}
		return false;
	}

	public void hinzufuegen(GegenstandsHaufen haufen, int bei)
	{
		ueberpruefeIndex(bei, true);
		this.inhalt[bei] = haufen;
	}

	public GegenstandsHaufen getInhalt(int bei)
	{
		ueberpruefeIndex(bei, true);
		return this.inhalt[bei];

	}

	public GegenstandsHaufen entferneInhalt(int bei)
	{
		ueberpruefeIndex(bei, true);
		GegenstandsHaufen alterInhalt = this.getInhalt(bei);
		this.inhalt[bei] = null;
		return alterInhalt;
	}

}
