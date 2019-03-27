package de.pk.control.spiel.phasen;

import de.pk.model.spiel.Spiel;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class HeldenPhase extends Phase
{

	@Override
	public void fuerePhaseAus(Spiel aktivesSpiel)
	{
		for (Held held : aktivesSpiel.getHelden())
		{
			System.out.println(held);
			// Do something with each hero
		}
	}

}
