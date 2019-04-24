package de.pk.model.spielbrett.spielbrettTeile;

import java.util.HashMap;
import java.util.Observable;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
import de.pk.kartenGenerator.KartenGeneratorUntergrund;
import de.pk.kartenGenerator.untergruende.KachelUntergrundWertigkeit;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjekt;

public class Kachel extends Observable
{
	private HashMap<Position, SpielbrettObjektController> kachelObjekte = null;
	private KartenGeneratorUntergrund untergrund = null;

	public Kachel(HashMap<Position, SpielbrettObjektController> objekte, KartenGeneratorUntergrund untergrund)
	{
		this.kachelObjekte = objekte;
		this.untergrund = untergrund;
	}

	public Kachel(KartenGeneratorUntergrund untergrund)
	{
		this(new HashMap<Position, SpielbrettObjektController>(), untergrund);
	}

	public KachelUntergrundWertigkeit getUntergrundBei(Position pos)
	{
		return this.untergrund.getInhaltBei(pos);
	}

	public KartenGeneratorUntergrund getUntergrund()
	{
		return this.untergrund;
	}

	public SpielbrettObjektController getSpielbrettObjektBei(Position pos)
	{
		return this.kachelObjekte.get(pos);
	}

	public void entferneObjekt(SpielbrettObjektController zuEntfernen)
	{
		if (!this.kachelObjekte.containsValue(zuEntfernen))
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}
		for (Position pos : this.kachelObjekte.keySet())
		{
			if (this.kachelObjekte.get(pos).equals(zuEntfernen))
			{
				this.kachelObjekte.remove(pos);
				return;
			}
		}
	}

	public void stelleAufKachel(Position pos, SpielbrettObjektController obj)
	{
		this.kachelObjekte.put(pos, obj);
		this.notifyObservers(obj);
	}

}
