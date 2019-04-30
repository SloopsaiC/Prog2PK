package de.pk.control.karte;

import de.pk.control.spiel.Dungeon;
import de.pk.model.karte.WeltkarteModell;

public class WeltkarteController
{
	private WeltkarteModell weltkarteModell = null;

	/**
	 * Erstellt eine Weltkarte mit den gegebenen Dungeons
	 * 
	 * @param Die Dungeons aus der diese Weltkarte besteht
	 * */
	public WeltkarteController(Dungeon... dungeons)
	{
		this.weltkarteModell = new WeltkarteModell(dungeons);
	}

	/**
	 * Fuegt einen Dungeon zur Weltkarte hinzu
	 * 
	 * @param hinzufuegen Der Dungeon der hinzugefuegt wird
	 * */
	public void fuegeDungeonHinzu(Dungeon hinzufuegen)
	{
		this.weltkarteModell.fuegeDungeonHinzu(hinzufuegen);
	}

	/**
	 * Gibt den Dungeon mit dem spezifizierten Index wieder
	 * 
	 * @param index Der Index des Dungeons der gewollt ist
	 * 
	 * @return Der Dungeon mit gegebenem Index
	 * */
	public Dungeon getDungeonBei(int index)
	{
		if (!this.hatDungeon(index))
		{
			// TODO: Exception messages
			throw new IllegalArgumentException();
		}
		return this.getDungeons()[index];
	}

	/**
	 * Wrapper-Methode fuer den internen Gebrauch des Modells
	 * */
	private Dungeon[] getDungeons()
	{
		return this.weltkarteModell.getDungeons();
	}

	/**
	 * Ueberprueft ob ein Index ein gueltiger Index eines Dungeons dieser Weltkarte ist
	 * 
	 * @param Der zu ueberpruefende Index
	 * 
	 * @return true, sollte der Index gueltig sein, sonst false
	 * */
	public boolean hatDungeon(int index)
	{
		return (index >= 0) && (index < this.getDungeons().length) && (this.getDungeons()[index] != null);
	}

}
