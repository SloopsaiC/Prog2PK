package de.pk.model.spiel;

import java.util.InputMismatchException;
import java.util.Scanner;

import de.pk.control.karte.WeltkarteController;
import de.pk.control.spiel.DungeonController;
import de.pk.control.spiel.phasen.ExplorationsPhase;
import de.pk.control.spiel.phasen.HeldenPhase;
import de.pk.model.karte.Weltkarte;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.DebugAusgabeKlasse;

public class Spiel
{

	private WeltkarteController weltkarte = null;
	private DungeonController aktiverDungeonController = null; // Der Controller des momentan aktiven Dungeons,
//null falls sich der Spieler auf der "Weltkarte" befindet

	/**
	 * Erstellt ein neues Spiel mit der uebergebenen Weltkarte.
	 *
	 * @param weltkarte Die Weltkarte mit Dungeons fuer das neue Spiel.
	 */
	public Spiel(WeltkarteController weltkarte)
	{
		this.weltkarte = weltkarte;
	}

	/**
	 * Aendert den aktiven dungeon auf das Argument.
	 *
	 * @param dungeonController Der Dungeon der von nun an der im Spiel aktive
	 *                          Dungeon ist.
	 */
	public void aendereAktivenDungeon(DungeonController dungeonController)
	{
		this.aktiverDungeonController = dungeonController;
	}

	/**
	 * @return Der in diesem Spiel momentan aktive Dungeon
	 */
	public DungeonController getAktivenDungeonController()
	{
		return this.aktiverDungeonController;
	}

	/**
	 * @return Die Weltkarte dieses Spiels
	 */
	public WeltkarteController getWeltkarte()
	{
		return this.weltkarte;
	}

}
