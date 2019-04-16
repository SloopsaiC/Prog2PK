package de.pk.control.karte;

import de.pk.control.spiel.DungeonController;
import de.pk.model.karte.Weltkarte;

public class WeltkarteController
{
	private Weltkarte weltkarteModell = null;

	public WeltkarteController(DungeonController... dungeons)
	{
		this.weltkarteModell = new Weltkarte(dungeons);
	}

	public void fuegeDungeonHinzu(DungeonController hinzufuegen)
	{
		this.weltkarteModell.fuegeDungeonHinzu(hinzufuegen);
	}

	public DungeonController getDungeonBei(int index)
	{
		if (!this.hatDungeon(index))
		{
			// TODO: Exception messages
			throw new IllegalArgumentException();
		}
		return this.getDungeons()[index];
	}

	private DungeonController[] getDungeons()
	{
		return this.weltkarteModell.getDungeons();
	}

	public boolean hatDungeon(int index)
	{
		return (index >= 0) && (index < this.getDungeons().length) && (this.getDungeons()[index] != null);
	}

}
