package de.pk.control.spiel.phasen;

import de.pk.control.spiel.Dungeon;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.Spielkonstanten;

public class HeldenPhase extends Phase
{

	private final static boolean BRAUCHT_EINGABE = true;
	private int anzahlAktionenDieserPhase = 0;

	/**
	 * @return true
	 * @see de.pk.control.spiel.phasen.Phase#brauchtEingabe()
	 */
	@Override
	public boolean brauchtEingabe()
	{
		return HeldenPhase.BRAUCHT_EINGABE;
	}

	/**
	 * @see de.pk.control.spiel.phasen.Phase#phasenSchritt(Dungeon, Held)
	 */
	@Override
	public void phasenSchritt(Dungeon aktiverDungeonController, Held aktiverHeld)
	{
		aktiverHeld.fuehreAktionAus("Bewegen", null);
		this.anzahlAktionenDieserPhase++;
		if (this.anzahlAktionenDieserPhase >= Spielkonstanten.MAX_AKTIONEN_HELDEN_PHASE)
		{
			super.fertig();
		}
	}

	/**
	 * @see de.pk.control.spiel.phasen.Phase#reset()
	 */
	@Override
	public void reset()
	{
		super.reset();
		this.anzahlAktionenDieserPhase = 0;
	}

}
