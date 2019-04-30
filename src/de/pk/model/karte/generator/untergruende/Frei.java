package de.pk.model.karte.generator.untergruende;

import de.pk.model.karte.generator.KartenGeneratorUntergrund;
import de.pk.model.position.Position;

public class Frei extends KartenGeneratorUntergrund
{
	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.6f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL = 0.02f;
	private static final KachelUntergrundWertigkeit[][] FREIEKACHEL =
	{ /*
		 * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
		 */
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI } };

	public Frei()
	{
		super(Frei.FREIEKACHEL);
	}

	@Override
	public Frei clone()
	{
		return new Frei();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximaleGroesseX, int maximaleGroesseY, Position aktuellePosition)
	{
		float distanzZurMitte = Position.getEntfernung(new Position(maximaleGroesseX / 2, maximaleGroesseY / 2),
				aktuellePosition);
		if (distanzZurMitte == 0f)
		{
			return Frei.STANDART_WAHRSCHEINLICHKEIT;
		}
		// Berechnet die Zentel
		float einZentel = distanzZurMitte / 10;
		// Bekommt die Ausgangswahrscheinlichkeit und zieht so viel ab, wie sie zentel
		// bewegt wurde
		return Frei.STANDART_WAHRSCHEINLICHKEIT
				- ((distanzZurMitte / einZentel) * Frei.STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL);
	}
}
