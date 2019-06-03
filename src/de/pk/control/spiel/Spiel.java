package de.pk.control.spiel;

import de.pk.control.karte.Weltkarte;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.spiel.SpielModell;

public class Spiel
{
	private final SpielModell spielModell;

	/**
	 * Erstellt ein Spiel mit default Weltkarte
	 */
	public Spiel(Held[] helden)
	{
		this(new Weltkarte(), helden);
	}

	public Spiel(Weltkarte weltkarte, Held[] helden)
	{
		this.spielModell = new SpielModell(weltkarte, helden);
	}

	public Dungeon getAktiverDungeon()
	{
		return this.spielModell.getAktivenDungeon();
	}

	public Weltkarte getWeltkarte()
	{
		return this.spielModell.getWeltkarte();
	}

	/**
	 * Stellt ein Untermenue im Spiel dar, bei dem man sich auf der Weltkarte
	 * befindet und von welchem man die einzelnen Dungeons betreten kann.
	 */
	public void waehleDungeon(Dungeon zuWaehlen)
	{
		this.spielModell.aendereAktivenDungeon(zuWaehlen);
	}

	public void waehleDungeon(int index)
	{
		this.waehleDungeon(this.spielModell.getWeltkarte().getDungeonBei(index));
	}
}
