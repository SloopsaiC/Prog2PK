package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;

public class SackgasseKachel extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.1f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_ERHOEHUNG_PRO_ZENTEL = 0.04f;
	private static final KachelWertigkeit[][] STANDART =
	{
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI, KachelWertigkeit.FREI },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.SCHWER } };

	public SackgasseKachel()
	{
		super(SackgasseKachel.STANDART);
	}

	@Override
	public SackgasseKachel clone()
	{
		return new SackgasseKachel();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, int auktuellePositionX,
			int aktuellePositionY)
	{
		float distanzZurMitte = KartenGeneratorKachel.getEntfernung(maximalGroesseX / 2, maximalGroesseY / 2,
				auktuellePositionX, aktuellePositionY);
		float einZentel = distanzZurMitte / 10;
		if (distanzZurMitte == 0f)
		{
			return STANDART_WAHRSCHEINLICHKEIT;
		}
		return STANDART_WAHRSCHEINLICHKEIT
				+ distanzZurMitte / einZentel * STANDART_WAHRSCHEINLICHKEITS_ERHOEHUNG_PRO_ZENTEL;
	}
}
