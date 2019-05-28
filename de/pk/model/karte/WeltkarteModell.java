package de.pk.model.karte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.pk.control.spiel.Dungeon;

/**
 * Modell der Weltkarte des Spiels
 */
public class WeltkarteModell
{

	private List<Dungeon> dungeons = null;

	public WeltkarteModell(Dungeon[] dungeons)
	{
		// Liste von Arrays hat eine fixe Groesse (Groesse des Arrays) und muss deshalb
		// so "kopiert" werden.
		List<Dungeon> liste = Arrays.asList(dungeons);
		this.dungeons = new ArrayList<>();
		this.dungeons.addAll(liste);
	}

	public void fuegeDungeonHinzu(Dungeon hinzufuegen)
	{
		this.dungeons.add(hinzufuegen);
	}

	public Dungeon[] getDungeons()
	{
		return this.dungeons.toArray(new Dungeon[]
		{});
	}

}
