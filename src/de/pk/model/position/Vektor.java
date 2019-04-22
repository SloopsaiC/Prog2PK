package de.pk.model.position;

public class Vektor
{
	private int x = 0;
	private int y = 0;

	public Vektor(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX()
	{
		return this.x;
	}

	/**
	 * @return the y
	 */
	public int getY()
	{
		return this.y;
	}

	public Vektor addiere(Vektor zuAddieren)
	{
		this.x += zuAddieren.getX();
		this.y += zuAddieren.getY();
		return this;
	}

}
