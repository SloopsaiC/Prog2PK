package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;

public class FreieKachelGross extends KartenGeneratorKachel
{
	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.6f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL = 0.02f;
	private static final KachelWertigkeit[][] STANDART =
	{
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI } };

	public FreieKachelGross()
	{
		super(FreieKachelGross.STANDART);
	}

	@Override
	public FreieKachelGross clone()
	{
		return new FreieKachelGross();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximaleGroesseY, int aktuellePositionX,
			int aktuellePositionY)
	{
		float distanzZurMitte = KartenGeneratorKachel.getEntfernung(maximalGroesseX / 2, maximaleGroesseY / 2,
				aktuellePositionX, aktuellePositionY);
		if (distanzZurMitte == 0f)
		{
			return FreieKachelGross.STANDART_WAHRSCHEINLICHKEIT;
		}
		// Berechnet die Zentel
		float einZentel = distanzZurMitte / 10;
		// Get the default probability and minus it to with how many tenths it moved
		// towards the outside times the specified decrease
		return FreieKachelGross.STANDART_WAHRSCHEINLICHKEIT - ((distanzZurMitte / einZentel)
				* FreieKachelGross.STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL);
	}
}
