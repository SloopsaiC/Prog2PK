package de.pk.model.gegenstaende;

public class GegenstandsHaufenModell
{
	private final Gegenstand inhalt;
	private int menge = 0;
	private final int maximaleAnzahl;

	public GegenstandsHaufenModell(Gegenstand inhalt, int menge, int maximaleAnzahl)
	{
		this.inhalt = inhalt;
		this.menge = menge;
		this.maximaleAnzahl = maximaleAnzahl;
	}

	public Gegenstand getInhalt()
	{
		return this.inhalt;
	}

	public int getMaximaleAnzahl()
	{
		return this.maximaleAnzahl;
	}

	public int getMenge()
	{
		return this.menge;
	}

	public void setMenge(int neueMenge)
	{
		if ((neueMenge > this.maximaleAnzahl) || (neueMenge < 0))
		{
			// TODO: Exception Message
			throw new IllegalArgumentException();
		}
		this.menge = neueMenge;
	}
}
