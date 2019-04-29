package de.pk.model.spielbrett.spielbrettTeile;

import java.util.HashMap;
import java.util.Observable;

import de.pk.control.kartekartenGenerator.KartenGeneratorUntergrund;
import de.pk.control.kartekartenGenerator.untergruende.KachelUntergrundWertigkeit;
import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
import de.pk.model.position.Position;

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

	public Position getPosition(SpielbrettObjektController spielbrettObjekt)
	{
		if (!this.kachelObjekte.containsValue(spielbrettObjekt))
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}
		for (Position pos : this.kachelObjekte.keySet())
		{
			if (this.kachelObjekte.get(pos).equals(spielbrettObjekt))
			{
				return pos;
			}
		}
		return null;
	}

	public boolean istAufKachel(Position pos)
	{
		try
		{
			this.untergrund.getInhaltBei(pos);
			return true;
		} catch (IllegalArgumentException exc)
		{
			return false;
		}
	}

	public void entferneObjekt(SpielbrettObjektController zuEntfernen)
	{
		if (!this.kachelObjekte.containsValue(zuEntfernen))
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}
		this.kachelObjekte.remove(this.getPosition(zuEntfernen));
	}

	public SpielbrettObjektController getSpielbrettObjektBei(Position pos)
	{
		return this.kachelObjekte.get(pos);
	}

	public KartenGeneratorUntergrund getUntergrund()
	{
		return this.untergrund;
	}

	public KachelUntergrundWertigkeit getUntergrundBei(Position pos)
	{
		return this.untergrund.getInhaltBei(pos);
	}

	public void stelleAufKachel(Position pos, SpielbrettObjektController obj)
	{
		this.kachelObjekte.put(pos, obj);
		this.notifyObservers(obj);
	}

}
