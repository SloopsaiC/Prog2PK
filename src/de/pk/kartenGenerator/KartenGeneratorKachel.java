package de.pk.kartenGenerator;

import de.pk.kartenGenerator.kacheln.KachelWertigkeit;

/**
 * Repraesentiert die Kachel zum Generieren
 */
public abstract class KartenGeneratorKachel
{
	/**
	 * Gibt die Position zwischen zwei Punkten wieder
	 *
	 * @param xPosition1 Die X-Position von position 1
	 * @param yPosition1 Die Y-Position von position 1
	 * @param xPosition2 Die X-Position von position 2
	 * @param yPosition2 Die Y-Position von position 2
	 */
	protected static float getEntfernung(int xPosition1, int yPosition1, int xPosition2, int yPosition2)
	{
		int xEntfernung = xPosition1 - xPosition2;
		int yEntfernung = yPosition1 - yPosition2;
		if ((xEntfernung == 0) && (yEntfernung == 0))
		{
			return 0f;
		}
		float entfernung = (float) Math.sqrt(Math.pow(xEntfernung, 2) + Math.pow(yEntfernung, 2));
		return entfernung;
	}

	private KachelWertigkeit[][] inhalt = null;

	/**
	 * Content is determined in child class, that gives the inhalt to it's super
	 * constructor
	 */
	protected KartenGeneratorKachel(KachelWertigkeit[][] inhalt)
	{
		this.inhalt = inhalt;
	}

	/**
	 * Checks if a tile has a connection in a direction
	 *
	 * @param dir The direction to check in
	 *
	 * @return true if a connection exists, else false
	 */
	public boolean checkIfConnection(Richtung dir)
	{
		// Variables in order to use one for loop
		// The offset on the X-Scale / Y-Scale to start on
		int xOffset = 0;
		int yOffset = 0;
		// Multipliers for the for loop so it iterates over the dimension needed to
		// check the direction that should be checked.
		int xVarMult = 0;
		int yVarMult = 0;
		int range = 0;
		switch (dir)
		{
		// Setting the values for the current direction
		case NORDEN:
			xVarMult = 1;
			range = this.inhalt[0].length;
			break;
		case OSTEN:
			xOffset = this.inhalt[0].length - 1;
			yVarMult = 1;
			range = this.inhalt[0].length;
			break;
		case SUEDEN:
			yOffset = this.inhalt.length - 1;
			xVarMult = 1;
			range = this.inhalt.length;
			break;
		case WESTEN:
			yVarMult = 1;
			range = this.inhalt.length;
			break;
		}

		for (int var = 0; var < range; var++)
		{
			if (this.inhalt[(var * yVarMult) + yOffset][(var * xVarMult) + xOffset].istBetretbar())
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public abstract KartenGeneratorKachel clone();

	/**
	 * Turns this tile in the given direction
	 *
	 * @param dir The direction to drehe in
	 */
	public void drehe(Richtung dir)
	{
		// Generate the new inhalt
		KachelWertigkeit[][] newContent = new KachelWertigkeit[this.inhalt.length][this.inhalt[0].length];
		for (int x = 0; x < this.inhalt[0].length; x++)
		{
			for (int y = 0; y < this.inhalt.length; y++)
			{
				if (dir == Richtung.OSTEN)
				{
					// Flip X and Y and whether turning right or left change one to the max minus
					// the value before turning
					// Geometry
					newContent[x][this.inhalt.length - 1 - y] = this.inhalt[y][x];
				} else if (dir == Richtung.WESTEN)
				{
					newContent[this.inhalt[0].length - 1 - x][y] = this.inhalt[y][x];
				}
			}
		}
		this.inhalt = newContent;
	}

	public KachelWertigkeit[][] getInhalt()
	{
		return this.inhalt;
	}

	/**
	 * Get the probability of this tile generating at any given positon (Args look
	 * others with same argument structure)
	 */
	public abstract float getVorkommensWahrscheinlichkeit(int maxSizeX, int maxSizeY, int currentPosX, int currentPosY);

}
