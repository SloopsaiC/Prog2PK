package de.pk.model.karte.generator.untergruende;

import de.pk.model.position.Position;

public class Sackgasse extends KartenGeneratorUntergrund
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.1f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_ERHOEHUNG_PRO_ZENTEL = 0.04f;
	private static final KachelUntergrundWertigkeit[][] SACKGASSE_GROSS =
	{ /*
		 * 6 6 6 6 6 6 5 2 1 0 6 2 1 0 0 6 5 2 1 0 6 6 6 6 6
		 */
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM } };

	public Sackgasse()
	{
		super(Sackgasse.SACKGASSE_GROSS);
	}

	@Override
	public Sackgasse clone()
	{
		return new Sackgasse();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, Position pos)
	{
		float distanzZurMitte = Position.getEntfernung(new Position(maximalGroesseX / 2, maximalGroesseY / 2), pos);
		float einZentel = distanzZurMitte / 10;
		if (distanzZurMitte == 0f)
		{
			return Sackgasse.STANDART_WAHRSCHEINLICHKEIT;
		}
		return Sackgasse.STANDART_WAHRSCHEINLICHKEIT
				+ ((distanzZurMitte / einZentel) * Sackgasse.STANDART_WAHRSCHEINLICHKEITS_ERHOEHUNG_PRO_ZENTEL);
	}
}
