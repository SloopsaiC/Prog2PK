package de.pk.control.spielbrett.spielbrettObjekte;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;

/**
 * Repraesentiert ein Objekt auf dem Spielbrett.
 *
 * @author Mattheo
 */
public abstract class SpielbrettObjekt
{
	public abstract void hatGetoetet(LebendigesObjekt opfer);

	/**
	 * Stellt fest ob dieses SpielbrettObjekt lebendig ist. Objekte welche nicht
	 * lebendig sein koennen geben hier immer false zurueck, LebendigeObjekte
	 * ueberpruefen ihren Status selber
	 *
	 * @return true, dieses Objekt ist lebendig, sonst false
	 */

	public boolean istLebendig()
	{
		return false;
	}
}
