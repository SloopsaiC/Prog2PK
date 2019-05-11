package de.pk.model.spielbrett;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.stream.Collectors;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.karte.generator.untergruende.KachelUntergrundWertigkeit;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrund;
import de.pk.model.position.Position;

public class Kachel
{
	private HashMap<Position, SpielbrettObjekt> kachelObjekte = null;
	private KartenGeneratorUntergrund untergrund = null;

	public Kachel(HashMap<Position, SpielbrettObjekt> objekte, KartenGeneratorUntergrund untergrund)
	{
		this.kachelObjekte = objekte;
		this.untergrund = untergrund;
	}

	public Kachel(KartenGeneratorUntergrund untergrund)
	{
		this(new HashMap<Position, SpielbrettObjekt>(), untergrund);
	}

	/**
	 * Sucht mit Hilfe der Stream API ein SpielbrettObjekt auf der Kachel
	 *
	 * @param spielbrettObjekt Das zu suchende Objekt
	 *
	 * @return Die Position des Objektes, sollte sich dieses auf der Kachel befinden
	 */
	public Position getPosition(SpielbrettObjekt spielbrettObjekt)
	{
		if (!this.kachelObjekte.containsValue(spielbrettObjekt))
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}
		return this.kachelObjekte.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))
				.get(spielbrettObjekt);
	}

	public SpielbrettObjekt getSpielbrettObjektBei(Position pos)
	{
		return this.kachelObjekte.get(pos);
	}

	public KartenGeneratorUntergrund getUntergrund()
	{
		return this.untergrund;
	}

	public HashMap<Position, SpielbrettObjekt> getSpielbrettObjekteMitPos()
	{
		return this.kachelObjekte;
	}

	public KachelUntergrundWertigkeit getUntergrundBei(Position pos)
	{
		return this.untergrund.getInhaltBei(pos);
	}

	public boolean objektIstAufKachel(SpielbrettObjekt zuUeberpruefen)
	{
		return this.kachelObjekte.containsValue(zuUeberpruefen);
	}

	public void stelleAufKachel(Position pos, SpielbrettObjekt obj)
	{
		this.kachelObjekte.put(pos, obj);
	}
	
	void entferneBeiPosition(Position zuEntfernen)
	{
		this.kachelObjekte.remove(zuEntfernen);
	}

	boolean ueberpruefePosition(Position pos)
	{
		return this.kachelObjekte.containsKey(pos);
	}

}
