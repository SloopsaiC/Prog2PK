package de.pk.model.karte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.pk.control.spiel.Dungeon;

/**
 * Modell der Weltkarte des Spiels
 * 
 * @author Mattheo
 */
public class WeltkarteModell
{

	private List<Dungeon> dungeons = null;

	/**
	 * Erstellt ein Modell einer Weltkarte mit den gegebenen Dungeons.
	 * 
	 * @param dungeons Die Dungeons welche auf der Weltkarte sein sollen
	 */
	public WeltkarteModell(Dungeon... dungeons)
	{
		// Liste von Arrays hat eine fixe Groesse (Groesse des Arrays) und muss deshalb
		// so "kopiert" werden.
		this.dungeons = Collections.synchronizedList(new ArrayList<>(Arrays.asList(dungeons)));
	}

	/**
	 * Fuegt einen Dungeon zur Weltkarte hinzu
	 * 
	 * @param hinzufuegen Der hinzuzufuegende Dungeon
	 */
	public void fuegeDungeonHinzu(Dungeon hinzufuegen)
	{
		this.dungeons.add(hinzufuegen);
	}

	/**
	 * Erlaubt Zugriff auf alle Dungeons auf dieser Weltkarte. Diese Liste kann
	 * nicht bearbeitet werden.
	 * 
	 * @return Alle Dungeons auf dieser Weltkarte als Liste
	 */
	public List<Dungeon> getDungeons()
	{
		return Collections.unmodifiableList(this.dungeons);
	}

}
