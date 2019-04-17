package de.pk.model.position;

public class Position
{
	private int xKoordinate = 0; // Die X-Koordinate der Position (kartesisches Koordinatensystem)
	private int yKoordinate = 0; // Die Y-Koordinate der Position (kartesisches Koordinatensystem)

	public Position(int x, int y)
	{
		this.xKoordinate = x;
		this.yKoordinate = y;
	}

	public int getX()
	{
		return this.xKoordinate;
	}

	public int getY()
	{
		return this.yKoordinate;
	}

	public Position addiere(int x, int y)
	{
		this.xKoordinate += x;
		this.yKoordinate += y;
		return this;
	}

	/**
	 * Gibt die Position zwischen zwei Punkten wieder
	 *
	 * @param pos1 Die erste Position
	 * @param pos2 Die zweite Position
	 */
	public static float getEntfernung(Position pos1, Position pos2)
	{
		int xEntfernung = pos1.getX() - pos2.getX();
		int yEntfernung = pos1.getY() - pos2.getY();
		if ((xEntfernung == 0) && (yEntfernung == 0))
		{
			return 0f;
		}
		// Pythagoras
		return (float) Math.sqrt(Math.pow(xEntfernung, 2) + Math.pow(yEntfernung, 2));
	}
}
