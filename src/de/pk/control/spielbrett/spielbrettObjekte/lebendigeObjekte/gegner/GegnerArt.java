package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.gegner;

public enum GegnerArt
{
	ZOMBIE(10, 1);

	private int maxLeben;
	private int bewegungsPunkte;

	private GegnerArt(int maxLeben, int bewegungsPunkte)
	{
		this.maxLeben = maxLeben;
		this.bewegungsPunkte = bewegungsPunkte;
	}

	/**
	 * @return the bewegungsPunkte
	 */
	public int getBewegungsPunkte()
	{
		return this.bewegungsPunkte;
	}

	/**
	 * @return the maxLeben
	 */
	public int getMaxLeben()
	{
		return this.maxLeben;
	}

}
