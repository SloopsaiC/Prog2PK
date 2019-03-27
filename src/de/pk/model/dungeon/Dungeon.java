package de.pk.model.dungeon;

import de.pk.model.spielbrett.Spielbrett;

public class Dungeon
{
	private Spielbrett spielbrett = null;
	private String name = null;

	public Dungeon()
	{
		this.spielbrett = new Spielbrett();
		this.name = "Test";
	}
}
