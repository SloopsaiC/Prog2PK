package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;

public class SchlauchKachelKlein extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.3f;
	private static final KachelWertigkeit[][] STANDART =
	{
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.SCHWER } };

	public SchlauchKachelKlein()
	{
		super(SchlauchKachelKlein.STANDART);
	}

	@Override
	public SchlauchKachelKlein clone()
	{
		return new SchlauchKachelKlein();
	}

	@Override // Die Wahrscheinlichkeit noch anpassen
	public float getVorkommensWahrscheinlichkeit(int maxSizeX, int maxSizeY, Position pos)
	{
		return SchlauchKachelKlein.STANDART_WAHRSCHEINLICHKEIT;
	}
}