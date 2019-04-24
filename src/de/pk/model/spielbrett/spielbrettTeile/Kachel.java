package de.pk.model.spielbrett.spielbrettTeile;

import java.util.HashMap;
import java.util.Observable;

<<<<<<< HEAD
=======
import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
>>>>>>> refs/heads/Mattheo
import de.pk.kartenGenerator.KartenGeneratorUntergrund;
import de.pk.kartenGenerator.untergruende.KachelUntergrundWertigkeit;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjekt;

public class Kachel extends Observable
{
<<<<<<< HEAD
	private HashMap<Position, SpielbrettObjekt> kachelObjekte = null;
=======
	private HashMap<Position, SpielbrettObjektController> kachelObjekte = null;
>>>>>>> refs/heads/Mattheo
	private KartenGeneratorUntergrund untergrund = null;

<<<<<<< HEAD
	public Kachel(HashMap<Position, SpielbrettObjekt> objekte, KartenGeneratorUntergrund untergrund)
=======
	public Kachel(HashMap<Position, SpielbrettObjektController> objekte, KartenGeneratorUntergrund untergrund)
>>>>>>> refs/heads/Mattheo
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
