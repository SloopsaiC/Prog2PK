package de.pk.control.karte;

import de.pk.control.spiel.Dungeon;
import de.pk.model.karte.WeltkarteModell;
import de.pk.utils.AusnahmeNachrichten;

/**
 * Speichert die Weltkarte und bietet Methoden an um mit ihr zu interagieren.
 *
 * @see de.pk.model.karte.Weltkarte
 *
 * @author Mattheo
 */
public class Weltkarte
{
	private final WeltkarteModell modell;

	/**
	 * Erstellt eine Weltkarte mit den gegebenen Dungeons
	 *
	 * @param Die Dungeons aus der diese Weltkarte besteht
	 */
	public Weltkarte(Dungeon... dungeons)
	{
		this.modell = new WeltkarteModell(dungeons);
	}

	/**
	 * Fuegt einen Dungeon zur Weltkarte hinzu
	 *
	 * @param hinzufuegen Der Dungeon der hinzugefuegt wird
	 */
	public void fuegeDungeonHinzu(Dungeon hinzufuegen)
	{
		this.modell.fuegeDungeonHinzu(hinzufuegen);
	}

	/**
	 * Gibt den Dungeon mit dem spezifizierten Index wieder
	 *
	 * @param index Der Index des Dungeons der gewollt ist
	 *
	 * @return Der Dungeon mit gegebenem Index
	 */
	public Dungeon getDungeonBei(int index)
	{
		if (!this.hatDungeon(index))
		{
			throw new IllegalArgumentException(AusnahmeNachrichten.WELTKARTE_DUNGEON_NICHT_ENTHALTEN + index);
		}
		return this.modell.getDungeons().get(index);
	}

	/**
	 * Ueberprueft ob ein Index ein gueltiger Index eines Dungeons dieser Weltkarte
	 * ist
	 *
	 * @param Der zu ueberpruefende Index
	 *
	 * @return true, sollte der Index gueltig sein, sonst false
	 */
	public boolean hatDungeon(int index)
	{
		return (index >= 0) && (index < this.modell.getDungeons().size())
				&& (this.modell.getDungeons().get(index) != null);
	}

}
