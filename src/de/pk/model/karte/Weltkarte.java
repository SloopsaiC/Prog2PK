package de.pk.model.karte;

import de.pk.model.dungeon.Dungeon;

/**
 * Modell der Weltkarte des Spiels
 */
public class Weltkarte
{

	private Dungeon[] dungeons = null;
	private int enhalteneDungeons = 0;

	public Weltkarte(int groesse)
	{
		this.dungeons = new Dungeon[groesse];
	}

	public void fuegeDungeonHinzu(Dungeon hinzufuegen)
	{
		this.dungeons[this.enhalteneDungeons++] = hinzufuegen;
	}

	public Dungeon getDungeonBei(int index)
	{
		if (!((index < this.dungeons.length) && (index > -1)))
		{
			// TODO: Exception message
			throw new IllegalArgumentException();
		}
		return this.dungeons[index];
	}

	public int getEnhalteneDungeons()
	{
		return this.enhalteneDungeons;
	}

}
