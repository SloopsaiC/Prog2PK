package de.pk.model.spiel;

import de.pk.control.karte.WeltkarteController;
import de.pk.control.spiel.Dungeon;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class SpielModell
{

	private WeltkarteController weltkarte = null;
	private Dungeon aktiverDungeonController = null; // Der Controller des momentan aktiven Dungeons,
//null falls sich der Spieler auf der "Weltkarte" befindet
	private Held[] helden = null;
	private int goldAnzahl = 0;
	private int fragmentAnzahl = 0;

	/**
	 * Erstellt ein neues Spiel mit der uebergebenen Weltkarte.
	 *
	 * @param weltkarte Die Weltkarte mit Dungeons fuer das neue Spiel.
	 */
	public SpielModell(WeltkarteController weltkarte, Held[] helden)
	{
		this.weltkarte = weltkarte;
		this.helden = helden;
	}

	/**
	 * Aendert den aktiven dungeon auf das Argument.
	 *
	 * @param dungeonController Der Dungeon der von nun an der im Spiel aktive
	 *                          Dungeon ist.
	 */
	public void aendereAktivenDungeon(Dungeon dungeonController)
	{
		this.aktiverDungeonController = dungeonController;
	}

	/**
	 * @return Der in diesem Spiel momentan aktive Dungeon
	 */
	public Dungeon getAktivenDungeonController()
	{
		return this.aktiverDungeonController;
	}

	public Held[] getHelden()
	{
		return this.helden;
	}

	/**
	 * @return Die Weltkarte dieses Spiels
	 */
	public WeltkarteController getWeltkarte()
	{
		return this.weltkarte;
	}

	public void setHelden(Held[] helden)
	{
		this.helden = helden;
	}

}
