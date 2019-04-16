package de.pk.model.karte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.pk.control.spiel.DungeonController;

/**
 * Modell der Weltkarte des Spiels
 */
public class Weltkarte
{

	private List<DungeonController> dungeons = null;

	public Weltkarte(DungeonController[] dungeons)
	{
		// Liste von Arrays hat eine fixe Groesse (Groesse des Arrays) und muss deshalb
		// so "kopiert" werden.
		List<DungeonController> liste = Arrays.asList(dungeons);
		this.dungeons = new ArrayList<>();
		this.dungeons.addAll(liste);
	}

	public void fuegeDungeonHinzu(DungeonController hinzufuegen)
	{
		this.dungeons.add(hinzufuegen);
	}

	public DungeonController[] getDungeons()
	{
		return this.dungeons.toArray(new DungeonController[]
		{});
	}

}
