package de.pk.model.spielbrett;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.karte.generator.untergruende.KachelUntergrundWertigkeit;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrundMitRichtung;
import de.pk.model.position.Position;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class Kachel implements Observable
{
	private HashMap<Position, SpielbrettObjekt> kachelObjekte = null;
	private KartenGeneratorUntergrundMitRichtung untergrund = null;

	private ArrayList<InvalidationListener> listeners = null;

	public Kachel(HashMap<Position, SpielbrettObjekt> objekte, KartenGeneratorUntergrundMitRichtung untergrund)
	{
		this.kachelObjekte = objekte;
		this.untergrund = untergrund;
		this.listeners = new ArrayList<>();
	}

	public Kachel(KartenGeneratorUntergrundMitRichtung untergrund)
	{
		this(new HashMap<Position, SpielbrettObjekt>(), untergrund);
	}

	void entferneBeiPosition(Position zuEntfernen)
	{
		this.kachelObjekte.remove(zuEntfernen);
		this.verandert();
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

	public HashMap<Position, SpielbrettObjekt> getSpielbrettObjekteMitPos()
	{
		return this.kachelObjekte;
	}

	public KartenGeneratorUntergrundMitRichtung getUntergrund()
	{
		return this.untergrund;
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
		this.verandert();
	}

	public boolean ueberpruefePosition(Position pos)
	{
		return this.kachelObjekte.containsKey(pos);
	}

	private void verandert()
	{
		for (InvalidationListener listener : this.listeners)
		{
			listener.invalidated(this);
		}
	}

	@Override
	public void addListener(InvalidationListener listener)
	{
		this.listeners.add(listener);

	}

	@Override
	public void removeListener(InvalidationListener listener)
	{
		this.listeners.remove(listener);
	}

}
