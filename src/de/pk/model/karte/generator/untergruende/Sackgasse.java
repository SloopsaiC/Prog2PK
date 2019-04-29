package de.pk.model.karte.generator.untergruende;

import de.pk.model.karte.generator.KartenGeneratorUntergrund;
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
	private static final float SACKGASSE_GROSS_WAHRSCHEINLICHKEIT = 0.3f;

	private static final KachelUntergrundWertigkeit[][] SACKGASSE_KLEIN =
	{ /*
		 * 7 7 7 6 6 7 6 5 5 2 7 6 2 1 1 7 6 5 2 2 7 7 7 6 5
		 */
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH,
					KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM } };
	private static final float SACKGASSE_KLEIN_WAHRSCHEINLICHKEIT = 0.3f;

	private static final KachelUntergrundWertigkeit[][] SACKGASSE_HELD_SCHATZTRUHE =
	{ /*
		 * - x = TRUHE (muss noch implementiert werden) 7 7 7 7 6 7 6 6 6 5 7 6 X 1 3 7
		 * 6 6 6 5 7 7 7 7 6
		 */
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.HELD_VERAENDERBAR },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM } };
	private static final float SACKGASSE_HELD_SCHATZTRUHE_WAHRSCHEINLICHKEIT = 0.1f;

	private static final KachelUntergrundWertigkeit[][] SACKGASSE_KARTEN_SCHATZTRUHE =
	{ /*
		 * - x = TRUHE (muss noch implementiert werden) 7 7 7 7 6 7 6 6 6 5 7 6 X 1 4 7
		 * 6 6 6 5 7 7 7 7 6
		 */
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.KARTEN_EFFEKT_VERAENDERBAR },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM } };
	private static final float SACKGASSE_KARTEN_SCHATZTRUHE_WAHRSCHEINLICHKEIT = 0.1f;

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
