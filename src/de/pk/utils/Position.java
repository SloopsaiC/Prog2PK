package de.pk.utils;

public class Position
{
	private int xKoordinate = 0; // Die X-Koordinate der Position (kartesisches Koordinatensystem)
	private int yKoordinate = 0; // Die Y-Koordinate der Position (kartesisches Koordinatensystem)

	public Position(int x, int y)
	{
		this.xKoordinate = x;
		this.yKoordinate = y;
	}

	public int bekommeXKoordinate()
	{
		return this.xKoordinate;
	}

	public int bekommeYKoordinate()
	{
		return this.yKoordinate;
	}
}
