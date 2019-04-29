package de.pk.model.karte.generator.untergruende;

import de.pk.model.karte.generator.KartenGeneratorUntergrund;
import de.pk.model.position.Position;

public class Schlucht extends KartenGeneratorUntergrund
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.3f;
	private static final KachelUntergrundWertigkeit[][] SCHLUCHT_GROSS_LEICHT =
	{ /*
		 * 7 7 7 7 7 1 1 1 1 1 0 0 0 0 0 1 1 1 1 1 7 7 7 7 7
		 */
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS } };

	public Schlucht()
	{
		super(Schlucht.SCHLUCHT_GROSS_LEICHT);
	}

	@Override
	public Schlucht clone()
	{
		return new Schlucht();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximaleGroesseY, Position pos)
	{
		return Schlucht.STANDART_WAHRSCHEINLICHKEIT;
	}
}
