package de.pk.model.karte;

import de.pk.model.dungeon.Dungeon;

/**
 * Modell der Weltkarte des Spiels
 */
public class Weltkarte
{
	private Dungeon[] dungeons = null;

	public Weltkarte()
	{
		this.dungeons = new Dungeon[1];
	}

	public Dungeon getDungeonBei(int index)
	{
		if (!(index < this.dungeons.length && index > -1))
		{
			// TODO: Exception message
			throw new IllegalArgumentException();
		}
		return this.dungeons[index];
	}
}
