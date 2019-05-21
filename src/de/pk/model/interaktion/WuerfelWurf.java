package de.pk.model.interaktion;

/**
 * Datenhaltungsklasse welche einen expliziten Wurf eines Wuerfels beschreibt.
 *
 * @author Mattheo
 */
public class WuerfelWurf
{
	private float erfolgsWahrscheinlichkeit = 0f;
	private float ergebnis = 0f;

	public WuerfelWurf(float erfolgsWahrscheinlichkeit, float ergebnis)
	{
		this.erfolgsWahrscheinlichkeit = erfolgsWahrscheinlichkeit;
		this.ergebnis = ergebnis;
	}

	/**
	 * @return the erfolgsWahrscheinlichkeit
	 */
	public float getErfolgsWahrscheinlichkeit()
	{
		return this.erfolgsWahrscheinlichkeit;
	}

	/**
	 * @return the ergebnis
	 */
	public float getErgebnis()
	{
		return this.ergebnis;
	}

	/**
	 * Bestimmt ob dieser Wurf erfolgreich war indem ueberprueft wird ob das
	 * Ergebnis (ein Float zwischen 0 und 1) kleiner als die
	 * Erfolgswahrscheinlichkeit ist.
	 *
	 * @return True, falls der Wurf erfolgreich war, sonst false.
	 */
	public boolean warErfolgreich()
	{
		return this.ergebnis < this.erfolgsWahrscheinlichkeit;
	}

}
