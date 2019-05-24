package de.pk.model.interaktion.effekt;

public class EffektTeil
{
	private EffektBeschreibungsIndex index = null;
	private int wert = 0;

	public EffektTeil(EffektBeschreibungsIndex index, int wert)
	{
		this.index = index;
		this.wert = wert;
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
