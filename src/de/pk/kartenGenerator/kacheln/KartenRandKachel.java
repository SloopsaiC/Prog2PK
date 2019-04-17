package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;

public class KartenRandKachel extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.0f;
	private static final float STANDART_WAHRSCHEINLICHKEIT_WENN_AM_RAND = Float.MAX_VALUE;
	private static final KachelWertigkeit[][] STANDART =
	{
			{ KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.ENDE, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.ENDE } };

	public KartenRandKachel()
	{
		super(KartenRandKachel.STANDART);
	}

	@Override
	public KartenRandKachel clone()
	{
		return new KartenRandKachel();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, Position pos)
	{
		if (this.pruefeObAmRand(maximalGroesseX, maximalGroesseY, pos))
		{
			return KartenRandKachel.STANDART_WAHRSCHEINLICHKEIT_WENN_AM_RAND;
		}
		return KartenRandKachel.STANDART_WAHRSCHEINLICHKEIT;

	}

	private boolean pruefeObAmRand(int maximaleGroesseX, int maximaleGroesseY, Position pos)
	{
		return ((maximaleGroesseX - 1) == pos.getX()) || ((maximaleGroesseY - 1) == pos.getY())
				|| (pos.getX() == 0) || (pos.getY() == 0);
	}

}
