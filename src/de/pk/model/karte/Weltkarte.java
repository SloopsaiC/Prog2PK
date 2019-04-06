package de.pk.model.karte;

import de.pk.control.spiel.DungeonController;

/**
 * Modell der Weltkarte des Spiels
 */
public class Weltkarte
{

	private DungeonController[] dungeons = null;
	private int enhalteneDungeons = 0;

	public Weltkarte(int groesse)
	{
		this.dungeons = new DungeonController[groesse];
	}

	public void fuegeDungeonHinzu(DungeonController hinzufuegen)
	{
		this.dungeons[this.enhalteneDungeons++] = hinzufuegen;
	}

	public DungeonController getDungeonBei(int index)
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
