package de.pk.kartenGenerator.untergruende;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;

public class SchlauchUntergrundKlein extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.3f;
	private static final KachelUntergrundWertigkeit[][] STANDART =
	{
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER } };

	public SchlauchUntergrundKlein()
	{
		super(SchlauchUntergrundKlein.STANDART);
	}

	@Override
	public SchlauchUntergrundKlein clone()
	{
		return new SchlauchUntergrundKlein();
	}

	@Override // Die Wahrscheinlichkeit noch anpassen
	public float getVorkommensWahrscheinlichkeit(int maxSizeX, int maxSizeY, Position pos)
	{
		return SchlauchUntergrundKlein.STANDART_WAHRSCHEINLICHKEIT;
	}
}