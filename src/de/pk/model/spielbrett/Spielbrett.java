package de.pk.model.spielbrett;

import java.util.HashMap;

import de.pk.model.position.Position;
import de.pk.model.spielbrett.spielbrettTeile.Kachel;

public class Spielbrett
{
	private HashMap<Position, Kachel> spielbrettTeile = null;

	public Spielbrett(HashMap<Position, Kachel> spielbrettTeile)
	{
		this.spielbrettTeile = spielbrettTeile;
	}

	public Spielbrett()
	{
		this(new HashMap<Position, Kachel>());
	}

	public Kachel getKachelBei(Position pos)
	{
		return this.spielbrettTeile.get(pos);
	}

	public void setzeKachel(Kachel kachel, Position pos)
	{
		this.spielbrettTeile.put(pos, kachel);
	}
}
