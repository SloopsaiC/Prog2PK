package de.pk.model.gegenstaende.container;

import de.pk.control.gegenstaende.GegenstandsHaufen;

public class Container
{
	private GegenstandsHaufen[] inhalt = null; // Der Inhalt dieses Containers

	/**
	 * Erstellt einen Container mit gegebener Groesse
	 *
	 * @param maximaleGroesse Die maximale Groesse dieses Containers
	 */
	public Container(int maximaleGroesse)
	{
		this.inhalt = new GegenstandsHaufen[maximaleGroesse];
	}

	/**
	 * Entfernt den Inhalt bei gegebenem Index und gibt diesen wieder
	 *
	 * @param bei Der Index des zu entfernenden Inhalts
	 *
	 * @return GegestandsHaufen, der vorherige Inhalt
	 */
	public GegenstandsHaufen entferneInhalt(int bei)
	{
		this.ueberpruefeIndex(bei, true);
		GegenstandsHaufen alterInhalt = this.getInhalt(bei);
		this.inhalt[bei] = null;
		return alterInhalt;
	}

	/**
	 * Gibt den Inhalt bei gegebenem Index wieder
	 *
	 * @param bei Der Index
	 *
	 * @return Der Inhalt bei gegebenem Index
	 */
	public GegenstandsHaufen getInhalt(int bei)
	{
		this.ueberpruefeIndex(bei, true);
		return this.inhalt[bei];

	}

	/**
	 * Fuegt den gegebenen GegenstandsHaufen bei gegebenem Index hinzu
	 *
	 * @param haufen Der hinzuzufuegende Haufen
	 * @param bei    Der Index
	 */
	public void hinzufuegen(GegenstandsHaufen haufen, int bei)
	{
		this.ueberpruefeIndex(bei, true);
		this.inhalt[bei] = haufen;
	}

	/**
	 * Ueberprueft ob ein Index fuer diesen Container gueltig ist und wirft eine
	 * Ausnahme, falls gewuenscht und sollte der Index nicht war sein
	 *
	 * @param index         Der zu ueberpruefende Index
	 * @param werfeAusnahme True, sollte eine Ausnahme geworfen werden, wenn der
	 *                      Index ungueltig ist
	 *
	 * @return True, falls der Index gueltig ist, sonst false (Wenn nicht durch
	 *         Ausnahme abgebrochen)
	 */
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
