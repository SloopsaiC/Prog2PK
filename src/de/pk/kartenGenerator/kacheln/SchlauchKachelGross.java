package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;

public class SchlauchKachelGross extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.3f;
	private static final KachelWertigkeit[][] STANDART =
	{
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.SCHWER } };

	public SchlauchKachelGross()
	{
		super(SchlauchKachelGross.STANDART);
	}

	@Override
	public SchlauchKachelGross clone()
	{
		return new SchlauchKachelGross();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximaleGroesseY, Position pos)
	{
		return SchlauchKachelGross.STANDART_WAHRSCHEINLICHKEIT;
	}
}
