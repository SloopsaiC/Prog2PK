package de.pk.model.spiel;

import de.pk.model.dungeon.Dungeon;
import de.pk.model.karte.Weltkarte;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class Spiel
{
	private Weltkarte weltkarte = null;
	private Held[] helden = null;
	private int anzahlAktiverHelden = 0;
	private Dungeon aktiverDungeon = null;

	public Spiel(int maxHelden)
	{
		this(maxHelden, new Weltkarte());
	}

	public Spiel(int maxHelden, Weltkarte weltkarte)
	{
		this.weltkarte = weltkarte;
		this.helden = new Held[maxHelden];
	}

	public int getMaxAnzahlHelden()
	{
		return this.helden.length;
	}

	/**
	 * Fuegt einen Helden zu diesem Spiel hinzu
	 * 
	 * @param held Der Held welcher hinzugefuegt werden soll.
	 */
	public void heldHinzufuegen(Held held)
	{
		if (this.anzahlAktiverHelden < this.getMaxAnzahlHelden())
		{
			// Synchronized da es sonst zu IndexOutOfBounds Exceptions kommen koennte
			synchronized (this)
			{
				this.helden[this.anzahlAktiverHelden++] = held;
			}
		} else
		{
			// TODO: Exception message
			throw new IllegalStateException();
		}
	}

	/**
	 * @return Die Weltkarte
	 */
	public Weltkarte getWeltkarte()
	{
		return this.weltkarte;
	}

	/**
	 * @return Die Helden
	 */
	public Held[] getHelden()
	{
		return this.helden;
	}

	/**
	 * Aendert den aktiven dungeon auf das Argument.
	 * 
	 * @param dungeon Der Dungeon der von nun an der im Spiel aktive Dungeon ist.
	 */
	public void aendereAktivenDungeon(Dungeon dungeon)
	{
		this.aktiverDungeon = dungeon;
	}

}
