package de.pk.model.spiel;

import de.pk.control.karte.Weltkarte;
import de.pk.control.spiel.Dungeon;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class SpielModell
{

	private Weltkarte weltkarte = null;
	private Dungeon aktiverDungeon = null; // Der Controller des momentan aktiven Dungeons,
//null falls sich der Spieler auf der "Weltkarte" befindet
	private Held[] helden = null;
	private int goldAnzahl = 0;
	private int fragmentAnzahl = 0;

	/**
	 * Erstellt ein neues Spiel mit der uebergebenen Weltkarte.
	 *
	 * @param weltkarte Die Weltkarte mit Dungeons fuer das neue Spiel.
	 */
	public SpielModell(Weltkarte weltkarte, Held[] helden)
	{
		this.weltkarte = weltkarte;
		this.helden = helden;
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

	public void aendereFragmentAnzahl(int aenderung)
	{
		this.fragmentAnzahl += aenderung;
	}

	public void aendereGoldAnzahl(int aenederung)
	{
		this.goldAnzahl += aenederung;
	}

	/**
	 * @return Der in diesem Spiel momentan aktive Dungeon
	 */
	public Dungeon getAktivenDungeon()
	{
		return this.aktiverDungeon;
	}

	/**
	 * @return the fragmentAnzahl
	 */
	public int getFragmentAnzahl()
	{
		return this.fragmentAnzahl;
	}

	/**
	 * @return the goldAnzahl
	 */
	public int getGoldAnzahl()
	{
		return this.goldAnzahl;
	}

	public Held[] getHelden()
	{
		return this.helden;
	}

	/**
	 * @return Die Weltkarte dieses Spiels
	 */
	public Weltkarte getWeltkarte()
	{
		return this.weltkarte;
	}

	public void setHelden(Held[] helden)
	{
		this.helden = helden;
	}

}
