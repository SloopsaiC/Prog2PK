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

	public Vektor addiere(Vektor zuAddieren)
	{
		this.x += zuAddieren.getX();
		this.y += zuAddieren.getY();
		return this;
	}

	/**
	 * Erstellt einen Vektor mit genau entgegen gesetzter Richtung indem alle Teile
	 * des Vektors mit -1 multipliziert werden.
	 *
	 * @return Ein Vektor der in die genau entgegen gesetzte Richtung dieses Vektors
	 *         zeigt
	 */
	public Vektor getNegierung()
	{
		return new Vektor(this.getX() * -1, this.getY() * -1);
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

	public float laenge()
	{
		return (float) Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}

}
