package de.pk.control.spiel.phasen;

import de.pk.model.dungeon.Dungeon;

public class ExplorationPhase extends Phase
{

	@Override
	public void fuerePhaseAus(Dungeon aktiverDungeon)
	{
		System.out.println("Exp Phase");
	}

}
