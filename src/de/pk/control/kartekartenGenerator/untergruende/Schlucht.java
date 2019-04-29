package de.pk.control.kartekartenGenerator.untergruende;

import de.pk.control.kartekartenGenerator.KartenGeneratorUntergrund;
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
	private static final float SCHLUCHT_GROSS_LEICHT_WAHRSCHEINLICHKEIT = 0.1f;

	private static final KachelUntergrundWertigkeit[][] SCHLUCHT_GROSS_SCHWER =
	{ /*
		 * 7 7 7 7 7 1 5 2 2 2 0 2 2 2 1 1 2 2 2 5 7 7 7 7 7
		 */
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.BUSCH },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS } };
	private static final float SCHLUCHT_GROSS_SCHWER_WAHRSCHEINLICHKEIT = 0.1f;

	private static final KachelUntergrundWertigkeit[][] SCHLUCHT_KLEIN_LEICHT =
	{ /*
		 * 7 7 7 7 7 6 7 7 6 5 0 1 1 1 0 6 7 7 7 6 7 7 7 7 7
		 */
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS } };
	private static final float SCHLUCHT_KLEIN_LEICHT_WAHRSCHEINLICHKEIT = 0.1f;

	private static final KachelUntergrundWertigkeit[][] SCHLUCHT_KLEIN_SCHWER =
	{ /*
		 * 7 7 7 7 7 5 7 7 6 2 2 2 2 2 2 6 7 7 7 6 7 7 7 7 7
		 */
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS },
			{ KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS } };
	private static final float SCHLUCHT_KLEIN_SCHWER_WAHRSCHEINLICHKEIT = 0.1f;

	private static final KachelUntergrundWertigkeit[][] SCHLUCHT_KLEIN_MACHBAR =
	{ /*
		 * 7 7 7 7 7 5 6 7 7 5 2 2 3 3 2 6 6 7 6 6 7 7 7 7 6
		 */
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS },
			{ KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BUSCH },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.HELD_VERAENDERBAR,
					KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM } };
	private static final float SCHLUCHT_KLEIN_MACHBAR_WAHRSCHEINLICHKEIT = 0.1f;

	private static final KachelUntergrundWertigkeit[][] SCHLUCHT_KLEIN_MACHBAR_KARTE =
	{ /*
		 * 7 7 7 7 7 2 6 7 7 5 2 4 4 7 2 6 7 4 4 2 7 7 7 7 7
		 */
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BUSCH },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.KARTEN_EFFEKT_VERAENDERBAR,
					KachelUntergrundWertigkeit.KARTEN_EFFEKT_VERAENDERBAR, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.KARTEN_EFFEKT_VERAENDERBAR,
					KachelUntergrundWertigkeit.KARTEN_EFFEKT_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS } };
	private static final float SCHLUCHT_KLEIN_MACHBAR_KARTE_WAHRSCHEINLICHKEIT = 0.1f;

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
