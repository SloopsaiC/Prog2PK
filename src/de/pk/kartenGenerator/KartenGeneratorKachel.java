package de.pk.kartenGenerator;

import de.pk.kartenGenerator.untergruende.KachelUntergrundWertigkeit;
import de.pk.model.position.Position;

/**
 * Repraesentiert die Kachel zum Generieren
 */
public abstract class KartenGeneratorKachel
{
	private KachelUntergrundWertigkeit[][] inhalt = null;

	/**
	 * Content is determined in child class, that gives the inhalt to it's super
	 * constructor
	 */
	protected KartenGeneratorKachel(KachelUntergrundWertigkeit[][] inhalt)
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
		KachelUntergrundWertigkeit[][] newContent = new KachelUntergrundWertigkeit[this.inhalt.length][this.inhalt[0].length];
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

	public KachelUntergrundWertigkeit[][] getInhalt()
	{
		return this.inhalt;
	}
	
	protected void setInhalt(KachelUntergrundWertigkeit[][] inhalt)
	{
		this.inhalt = inhalt;
	}

	public KachelUntergrundWertigkeit getInhaltBei(Position pos)
	{
		return this.getInhalt()[pos.getY()][pos.getX()];
	}

	/**
	 * Get the probability of this tile generating at any given positon (Args look
	 * others with same argument structure)
	 */
	public abstract float getVorkommensWahrscheinlichkeit(int maxSizeX, int maxSizeY, Position pos);

}
