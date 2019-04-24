package de.pk.kartenGenerator.untergruende;

import de.pk.kartenGenerator.KartenGeneratorUntergrund;
import de.pk.model.position.Position;

public class SackgasseUntergrund extends KartenGeneratorUntergrund
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.1f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_ERHOEHUNG_PRO_ZENTEL = 0.04f;
	private static final KachelUntergrundWertigkeit[][] STANDART =
	{
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER } };

	public SackgasseUntergrund()
	{
		super(SackgasseUntergrund.STANDART);
	}

	@Override
	public SackgasseUntergrund clone()
	{
		return new SackgasseUntergrund();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, Position pos)
	{
		float distanzZurMitte = Position.getEntfernung(new Position(maximalGroesseX / 2, maximalGroesseY / 2), pos);
		float einZentel = distanzZurMitte / 10;
		if (distanzZurMitte == 0f)
		{
			return SackgasseUntergrund.STANDART_WAHRSCHEINLICHKEIT;
		}
		return SackgasseUntergrund.STANDART_WAHRSCHEINLICHKEIT + ((distanzZurMitte / einZentel)
				* SackgasseUntergrund.STANDART_WAHRSCHEINLICHKEITS_ERHOEHUNG_PRO_ZENTEL);
	}
}
