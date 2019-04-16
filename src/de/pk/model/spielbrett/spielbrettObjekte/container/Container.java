package de.pk.model.spielbrett.spielbrettObjekte.container;

import de.pk.control.gegenstaende.GegenstandsHaufen;

public abstract class Container
{
	private GegenstandsHaufen[] inhalt = null; // Der Inhalt dieses Containers

	protected Container(int maximaleGroesse)
	{
		this.inhalt = new GegenstandsHaufen[maximaleGroesse];
	}

	public GegenstandsHaufen entferneInhalt(int bei)
	{
		this.ueberpruefeIndex(bei, true);
		GegenstandsHaufen alterInhalt = this.getInhalt(bei);
		this.inhalt[bei] = null;
		return alterInhalt;
	}

	public GegenstandsHaufen getInhalt(int bei)
	{
		this.ueberpruefeIndex(bei, true);
		return this.inhalt[bei];

	}

	public void hinzufuegen(GegenstandsHaufen haufen, int bei)
	{
		this.ueberpruefeIndex(bei, true);
		this.inhalt[bei] = haufen;
	}

	private boolean ueberpruefeIndex(int index, boolean werfeAusnahme)
	{
		if ((index > 0) && (index < this.inhalt.length))
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

}
