package de.pk.control.spiel.phasen;

import de.pk.model.dungeon.Dungeon;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class HeldenPhase extends Phase
{

	@Override
	public void fuerePhaseAus(Dungeon aktiverDungeon)
	{
		for (Held held : aktiverDungeon.getHelden())
		{
			System.out.println(held);
			// Do something with each hero
		}
	}

	/**
	 * @see de.pk.control.spiel.phasen.Phase#brauchtEingabe()
	 */
	@Override
	public boolean brauchtEingabe()
	{
		return true;
	}
	
	

}
