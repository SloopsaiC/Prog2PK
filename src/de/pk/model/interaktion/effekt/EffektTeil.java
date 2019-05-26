package de.pk.model.interaktion.effekt;

/**
 * Beschreibt einen Teil eines Effektes, also eine Aenderung eines Wertes des
 * Zieles auf welches der, aus EffektTeilen bestehende, Effekt angewendet wird
 * 
 * @author Mattheo
 */
public class EffektTeil
{
	private EffektBeschreibungsIndex index = null;
	private int wert = 0;

	/**
	 * Erstellt einen neuen EffektTeil.
	 * 
	 * @param index     Der EffektBeschreibungsIndex der beschreibt welcher Wert von
	 *                  diesem Teil verandert werden soll
	 * @param aenderung Die Aenderung des Wertes welcher durch den Index
	 *                  spezifiziert wird
	 */
	public EffektTeil(EffektBeschreibungsIndex index, int aenderung)
	{
		this.index = index;
		this.wert = aenderung;
	}

	/**
	 * @return the index
	 */
	public EffektBeschreibungsIndex getIndex()
	{
		return this.index;
	}

	/**
	 * @return the wert
	 */
	public int getWert()
	{
		return this.wert;
	}

	/**
	 * @param wert the wert to set
	 */
	public void setWert(int wert)
	{
		this.wert = wert;
	}
}
