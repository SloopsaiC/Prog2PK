package de.pk.control.spiel.phasen;

import de.pk.model.dungeon.Dungeon;

public abstract class Phase
{
	public abstract void fuerePhaseAus(Dungeon aktiverDungeon);

	/**
	 * Gibt an ob die Phase eine Eingabe vom Spieler braucht um sinnvoll umgesetzt
	 * zu werden. Der Standardwert ist in de.pk.control.spiel.phasen.Phase
	 * definiert.
	 * 
	 * @see de.pk.control.spiel.phasen.Phase
	 * @return True falls fuer die Phase eine Eingabe benoetigt wird, sonst false
	 */
	public boolean brauchtEingabe()
	{
		return false;
	}
}
