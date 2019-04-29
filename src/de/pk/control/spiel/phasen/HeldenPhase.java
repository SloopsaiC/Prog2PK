package de.pk.control.spiel.phasen;

import de.pk.control.spiel.DungeonController;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.HeldController;
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
	public void phasenTick(DungeonController aktiverDungeonController, HeldController aktiverHeld)
	{
		aktiverHeld.fuehreAktionAus(0, null);
		DebugAusgabeKlasse.ausgeben("Heldenphase:");
		
	}

}
