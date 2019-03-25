package de.pk.model.spielbrett;

import java.util.HashMap;

import de.pk.model.spielbrett.spielbrettTeile.Kachel;
import de.pk.utils.Position;

public abstract class Spielbrett
{
	private HashMap<Position, Kachel> spielbrettTeile = null;
	private String name = null;
	
	public abstract boolean pruefeZielbedingung();
}
