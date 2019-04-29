package de.pk.control.spiel.phasen;

import de.pk.control.spiel.DungeonController;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.HeldController;
import de.pk.utils.DebugAusgabeKlasse;

public class ExplorationsPhase extends Phase
{

	@Override
	public void phasenTick(DungeonController aktiverDungeonController, HeldController aktiverHeld)
	{
		DebugAusgabeKlasse.ausgeben("Explorationsphase");
		
		super.fertig();
	}
}
