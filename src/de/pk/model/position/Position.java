package de.pk.model.position;

import java.util.Objects;

public class Position
{
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

	private int x = 0; // Die X-Koordinate der Position (kartesisches Koordinatensystem)

	private int y = 0; // Die Y-Koordinate der Position (kartesisches Koordinatensystem)

	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Position addiere(int x, int y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Position addiere(Vektor vek)
	{
		if (vek != null)
		{
			return this.addiere(vek.getX(), vek.getY());
		}
		return this;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (this.getClass() != obj.getClass())
		{
			return false;
		}
		Position other = (Position) obj;
		return (this.x == other.x) && (this.y == other.y);
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.getX(), this.getY());
	}

}
