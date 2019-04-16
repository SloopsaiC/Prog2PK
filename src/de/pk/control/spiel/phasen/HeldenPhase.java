package de.pk.control.spiel.phasen;

import de.pk.control.spiel.DungeonController;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.DebugAusgabeKlasse;

public class HeldenPhase extends Phase
{

	private final static boolean BRAUCHT_EINGABE = true;

	/**
	 * @return true
	 * @see de.pk.control.spiel.phasen.Phase#brauchtEingabe()
	 */
	@Override
	public boolean brauchtEingabe()
	{
		return HeldenPhase.BRAUCHT_EINGABE;
	}

	@Override
	public void fuerePhaseAus(DungeonController aktiverDungeonController, Held aktiverHeld)
	{
		DebugAusgabeKlasse.ausgeben("Heldenphase:");
		for (Held held : aktiverDungeonController.getHelden())
		{
			DebugAusgabeKlasse.ausgeben("Held");
			// Do something with each hero
		}
	}

}
