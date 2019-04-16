package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;

public class StartKachel extends KartenGeneratorKachel
{
	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.0f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL = 0.00f;
	private static final KachelWertigkeit[][] STANDART =
	{
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.ENDE, KachelWertigkeit.FREI, KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI } };

	public StartKachel()
	{
		super(StartKachel.STANDART);
	}

	@Override
	public StartKachel clone()
	{
		return new StartKachel();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximaleGroesseY, int aktuellePositionX,
			int aktuellePositionY)
	{
		float distanzZurMitte = KartenGeneratorKachel.getEntfernung(maximalGroesseX / 2, maximaleGroesseY / 2,
				aktuellePositionX, aktuellePositionY);
		if (distanzZurMitte == 0f)
		{
			return StartKachel.STANDART_WAHRSCHEINLICHKEIT;
		}
		// Berechnet die Zentel
		float einZentel = distanzZurMitte / 10;
		// Get the default probability and minus it to with how many tenths it moved
		// towards the outside times the specified decrease
		return StartKachel.STANDART_WAHRSCHEINLICHKEIT
				- distanzZurMitte / einZentel * StartKachel.STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL;
	}
}