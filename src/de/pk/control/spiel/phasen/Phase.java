package de.pk.control.spiel.phasen;

import de.pk.control.spiel.DungeonController;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.HeldController;

public abstract class Phase
{

	private final static boolean BRAUCHT_EINGABE_DEFAULT_WERT = false;
	private boolean istFertig = false;

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
		return Phase.BRAUCHT_EINGABE_DEFAULT_WERT;
	}

	/**
	 * Wird aufgerufen, sollte eine Phase sich als "fertig" erachten
	 */
	protected void fertig()
	{
		this.istFertig = true;
	}

	/**
	 * Ist true, falls die Phase als fertig erachtet wird
	 */
	public boolean istFertig()
	{
		return this.istFertig;
	}

	/**
	 * Fuehrt die Phase um einen Tick weiter, dabei werden saemtliche Veraenderungen
	 * die diese Phase auf den Zustand des Spiels / Dungeons hat registriert um
	 * spaeter im DungeonController umgesetzt zu werden
	 */
	public abstract void phasenTick(DungeonController aktiverDungeonController, HeldController aktiverHeld);

	/**
	 * Setzt diese Phase zurueck
	 */
	public void reset()
	{
		this.istFertig = false;
	}

}
