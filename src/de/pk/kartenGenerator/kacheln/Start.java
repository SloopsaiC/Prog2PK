package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;

public class Start extends KartenGeneratorKachel
{
	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.0f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL = 0.00f;
	private static final KachelWertigkeit[][] STANDART =
	{               /*
                        0 0 0 0 0
                        0 0 0 0 0 
                        0 0 7 0 0 
                        0 0 0 0 0 
                        0 0 0 0 0
                         */
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FELS, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI } };

	public Start()
	{
		super(Start.STANDART);
	}

	@Override
	public Start clone()
	{
		return new Start();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximaleGroesseY, Position pos)
	{
		float distanzZurMitte = Position.getEntfernung(new Position(maximalGroesseX / 2, maximaleGroesseY / 2),
				pos);
		if (distanzZurMitte == 0f)
		{
			return Start.STANDART_WAHRSCHEINLICHKEIT;
		}
		// Berechnet die Zentel
		float einZentel = distanzZurMitte / 10;
		// Get the default probability and minus it to with how many tenths it moved
		// towards the outside times the specified decrease
		return Start.STANDART_WAHRSCHEINLICHKEIT
				- ((distanzZurMitte / einZentel) * Start.STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL);
	}
}