package de.pk.kartenGenerator.untergruende;

import de.pk.kartenGenerator.KartenGeneratorUntergrund;
import de.pk.model.position.Position;

public class FreierUntergrundGross extends KartenGeneratorUntergrund
{
	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.6f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL = 0.02f;
	private static final KachelUntergrundWertigkeit[][] STANDART =
	{
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI } };

	public FreierUntergrundGross()
	{
		super(FreierUntergrundGross.STANDART);
	}

	@Override
	public FreierUntergrundGross clone()
	{
		return new FreierUntergrundGross();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximaleGroesseX, int maximaleGroesseY, Position aktuellePosition)
	{
		float distanzZurMitte = Position.getEntfernung(new Position(maximaleGroesseX / 2, maximaleGroesseY / 2), aktuellePosition);
		if (distanzZurMitte == 0f)
		{
			return FreierUntergrundGross.STANDART_WAHRSCHEINLICHKEIT;
		}
		// Berechnet die Zentel
		float einZentel = distanzZurMitte / 10;
		// Get the default probability and minus it to with how many tenths it moved
		// towards the outside times the specified decrease
		return FreierUntergrundGross.STANDART_WAHRSCHEINLICHKEIT - ((distanzZurMitte / einZentel)
				* FreierUntergrundGross.STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL);
	}
}
