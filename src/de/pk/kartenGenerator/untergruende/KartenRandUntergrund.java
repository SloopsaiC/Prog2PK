package de.pk.kartenGenerator.untergruende;

import de.pk.kartenGenerator.KartenGeneratorUntergrund;
import de.pk.model.position.Position;

public class KartenRandUntergrund extends KartenGeneratorUntergrund
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.0f;
	private static final float STANDART_WAHRSCHEINLICHKEIT_WENN_AM_RAND = Float.MAX_VALUE;
	private static final KachelUntergrundWertigkeit[][] STANDART =
	{
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.ENDE } };

	public KartenRandUntergrund()
	{
		super(KartenRandUntergrund.STANDART);
	}

	@Override
	public KartenRandUntergrund clone()
	{
		return new KartenRandUntergrund();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, Position pos)
	{
		if (this.pruefeObAmRand(maximalGroesseX, maximalGroesseY, pos))
		{
			return KartenRandUntergrund.STANDART_WAHRSCHEINLICHKEIT_WENN_AM_RAND;
		}
		return KartenRandUntergrund.STANDART_WAHRSCHEINLICHKEIT;

	}

	private boolean pruefeObAmRand(int maximaleGroesseX, int maximaleGroesseY, Position pos)
	{
		return ((maximaleGroesseX - 1) == pos.getX()) || ((maximaleGroesseY - 1) == pos.getY())
				|| (pos.getX() == 0) || (pos.getY() == 0);
	}

}
