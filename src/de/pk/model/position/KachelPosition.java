package de.pk.model.position;

import de.pk.model.karte.generator.Richtung;
import de.pk.model.spielbrett.Kachel;
import de.pk.utils.Spielkonstanten;

public class KachelPosition
{
	private static boolean ueberpruefePosition(Position pos)
	{
		return ((pos.getX() < Spielkonstanten.KACHEL_GROESSE_X) && (pos.getY() < Spielkonstanten.KACHEL_GROESSE_Y)
				&& (pos.getX() >= 0) && (pos.getY() >= 0));
	}

	private Kachel kachel = null;

	private Position positionAufDerKachel = null;

	public KachelPosition(Kachel kachel, Position positionAufDerKachel)
	{
		if (!KachelPosition.ueberpruefePosition(positionAufDerKachel))
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}
		this.kachel = kachel;
		this.positionAufDerKachel = positionAufDerKachel;
	}

	/**
	 * @return the kachel
	 */
	public Kachel getKachel()
	{
		return this.kachel;
	}

	/**
	 * Gibt die Richtung der Kante wieder, sollte die Position auf der Kachel an
	 * einer liegen
	 *
	 * @return Richtung, Die Richtung der Kante
	 */
	public Richtung getKantenRichtungFallsAnKante()
	{
		if (this.positionAufDerKachel.getX() == 0)
		{
			return Richtung.WESTEN;
		}
		if (this.positionAufDerKachel.getX() == (Spielkonstanten.KACHEL_GROESSE_X - 1))
		{
			return Richtung.OSTEN;
		}
		if (this.positionAufDerKachel.getY() == 0)
		{
			return Richtung.NORDEN;
		}
		if (this.positionAufDerKachel.getY() == (Spielkonstanten.KACHEL_GROESSE_Y - 1))
		{
			return Richtung.SUEDEN;
		}
		return null;
	}

	/**
	 * @return the positionAufDerKachel
	 */
	public Position getPositionAufDerKachel()
	{
		return this.positionAufDerKachel;
	}

}
