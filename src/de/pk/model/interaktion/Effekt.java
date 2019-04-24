package de.pk.model.interaktion;

import de.pk.model.position.Vektor;

public class Effekt
{
	private int bewegungsPunkteAenderung = 0;
	private int ruestungsPunkteAenderung = 0;
	private int lebensPunkteAenderung = 0;
	private int anzahlWirkTicks = 0;
	private Vektor positionsAenderung = null;

	public Effekt(int bewegungsPunkteAenderung, int ruestungsPunkteAenderung, int lebensPunkteAenderung,
			int anzahlWirkTicks, Vektor positionsAenderung)
	{
		this.bewegungsPunkteAenderung = bewegungsPunkteAenderung;
		this.ruestungsPunkteAenderung = ruestungsPunkteAenderung;
		this.lebensPunkteAenderung = lebensPunkteAenderung;
		this.anzahlWirkTicks = anzahlWirkTicks;
		this.positionsAenderung = positionsAenderung;
	}

	public Effekt(int bewegungsPunkteAenderung, int ruestungsPunkteAenderung, int lebensPunkteAenderung,
			int anzahlWirkTicks)
	{
		this(bewegungsPunkteAenderung, ruestungsPunkteAenderung, lebensPunkteAenderung, anzahlWirkTicks, null);
	}

	/**
	 * @return the bewegungsPunkteAenderung
	 */
	public int getBewegungsPunkteAenderung()
	{
		return this.bewegungsPunkteAenderung;
	}

	/**
	 * @return the ruestungsPunkteAenderung
	 */
	public int getRuestungsPunkteAenderung()
	{
		return this.ruestungsPunkteAenderung;
	}

	/**
	 * @return the lebensPunkteAenderung
	 */
	public int getLebensPunkteAenderung()
	{
		return this.lebensPunkteAenderung;
	}

	public boolean istAbgeklungen()
	{
		return this.anzahlWirkTicks < 1;
	}

	public void wurdeGewirkt()
	{
		if (this.anzahlWirkTicks < Integer.MAX_VALUE)
		{
			this.anzahlWirkTicks--;
		}
	}

	/**
	 * @return the positionsAenderung
	 */
	public Vektor getPositionsAenderung()
	{
		return this.positionsAenderung;
	}

}
