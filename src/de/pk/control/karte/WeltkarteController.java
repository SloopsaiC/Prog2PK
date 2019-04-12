package de.pk.control.karte;

import de.pk.control.spiel.DungeonController;
import de.pk.model.karte.Weltkarte;

public class WeltkarteController
{
	private Weltkarte weltkarteModell = null;

	public WeltkarteController(int groesse)
	{
		this.weltkarteModell = new Weltkarte(groesse);
	}

	public boolean hatDungeon(int index)
	{
		return index < this.getDungeons().length && this.getDungeons()[index] != null;
	}

	public DungeonController getDungeonBei(int index)
	{
		if (!((index < this.getDungeons().length) && (index > -1)))
		{
			// TODO: Exception messages
			throw new IllegalArgumentException();
		}
		return this.getDungeons()[index];
	}

	public void fuegeDungeonHinzu(DungeonController hinzufuegen)
	{
		// Synchronized -> IndexOutOfBounds check
		synchronized (this)
		{
			if (this.weltkarteModell.getDungeons().length < this.weltkarteModell.getEnthalteneDungeonsAnzahl())
			{
				this.weltkarteModell.fuegeDungeonHinzu(hinzufuegen);
			} else
			{
				// TODO: Exception messages
				throw new IllegalStateException();
			}
		}
	}

	public int getEnthalteneDungeonsAnzahl()
	{
		return this.weltkarteModell.getEnthalteneDungeonsAnzahl();
	}

	private DungeonController[] getDungeons()
	{
		return this.weltkarteModell.getDungeons();
	}

}
