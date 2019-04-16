package de.pk.control.spiel.phasen;

import de.pk.control.spiel.DungeonController;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.DebugAusgabeKlasse;

public class ExplorationsPhase extends Phase
{

	@Override
	public void fuerePhaseAus(DungeonController aktiverDungeonController, Held aktiverHeld)
	{
		DebugAusgabeKlasse.ausgeben("Explorationsphase");
		for (Held held : aktiverDungeonController.getHelden())
		{
//            if(aktiverDungeon.getSpielbrett().istPositionAmKachelrand(held.getPosition())) {
//                aktiverDungeon.getSpielbrett().deckeKachelAuf(held.getPosition());
//            }
		}
	}

}
