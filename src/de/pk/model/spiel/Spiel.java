package de.pk.model.spiel;

import de.pk.model.dungeon.Dungeon;
import de.pk.model.karte.Weltkarte;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class Spiel
{
	private Weltkarte weltkarte = null;
	private Dungeon aktiverDungeon = null; // Der momentan aktive Dungeon, null falls sich der Spieler auf der
											// "Weltkarte" befindet

	public Spiel()
	{
		//TODO: Konstanten
		this(new Weltkarte(1));
	}

	public Spiel(Weltkarte weltkarte)
	{
		this.weltkarte = weltkarte;
	}

	/**
	 * @return Die Weltkarte dieses Spiels
	 */
	public Weltkarte getWeltkarte()
	{
		return this.weltkarte;
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

	/**
	 * @return Der in diesem Spiel momentan aktive Dungeon
	 */
	public Dungeon getAktiverDungeon()
	{
		return this.aktiverDungeon;
	}

}
