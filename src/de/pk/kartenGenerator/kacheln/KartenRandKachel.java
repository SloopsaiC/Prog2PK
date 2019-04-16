package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;

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
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, int aktuellePositionX,
			int aktuellePositionY)
	{
		if (this.pruefeObAmRand(maximalGroesseX, maximalGroesseY, aktuellePositionX, aktuellePositionY))
		{
			return KartenRandKachel.STANDART_WAHRSCHEINLICHKEIT_WENN_AM_RAND;
		}
		return KartenRandKachel.STANDART_WAHRSCHEINLICHKEIT;

	}

	private boolean pruefeObAmRand(int maximaleGroesseX, int maximaleGroesseY, int aktuellePositionX,
			int aktuellePositionY)
	{
		return ((maximaleGroesseX - 1) == aktuellePositionX) || ((maximaleGroesseY - 1) == aktuellePositionY)
				|| (aktuellePositionX == 0) || (aktuellePositionY == 0);
	}

}
