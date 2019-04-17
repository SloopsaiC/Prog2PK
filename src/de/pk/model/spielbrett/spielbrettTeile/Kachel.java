package de.pk.model.spielbrett.spielbrettTeile;

import java.util.HashMap;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.kartenGenerator.kacheln.KachelWertigkeit;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjekt;

public class Kachel
{
	private HashMap<Position, SpielbrettObjekt> kachelObjekte = null;
	private KartenGeneratorKachel untergrund = null;

	public Kachel(HashMap<Position, SpielbrettObjekt> objekte, KartenGeneratorKachel untergrund)
	{
		this.kachelObjekte = objekte;
		this.untergrund = untergrund;
	}

	public Kachel(KartenGeneratorKachel untergrund)
	{
		this(new HashMap<Position, SpielbrettObjekt>(), untergrund);
	}

	public KachelWertigkeit getUntergrundBei(Position pos)
	{
		return this.untergrund.getInhaltBei(pos);
	}
}
