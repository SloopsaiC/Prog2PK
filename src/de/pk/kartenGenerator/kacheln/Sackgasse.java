package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;

public class Sackgasse extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.1f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_ERHOEHUNG_PRO_ZENTEL = 0.04f;
	private static final KachelWertigkeit[][] SACKGASSE_GROSS =
	{               /*
                        6 6 6 6 6
                        6 5 2 1 0
                        6 2 1 0 0
                        6 5 2 1 0 
                        6 6 6 6 6
                        */
			{ KachelWertigkeit.BAUM, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM,
					KachelWertigkeit.BAUM },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.BUSCH, KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.BUSCH, KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM,
					KachelWertigkeit.BAUM } 
        };
        private static final float SACKGASSE_GROSS_WAHRSCHEINLICHKEIT = 0.3f;
        
        private static final KachelWertigkeit[][] SACKGASSE_KLEIN =
	{               /*
                        7 7 7 6 6
                        7 6 5 5 2
                        7 6 2 1 1
                        7 6 5 2 2 
                        7 7 7 6 5
                        */
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.BAUM,
					KachelWertigkeit.BAUM },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.BUSCH, KachelWertigkeit.BUSCH,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.BUSCH, KachelWertigkeit.SCHWER,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.BAUM,
					KachelWertigkeit.BAUM } 
        };
        private static final float SACKGASSE_KLEIN_WAHRSCHEINLICHKEIT = 0.3f;
        
        private static final KachelWertigkeit[][] SACKGASSE_HELD_SCHATZTRUHE =
	{               /* - x = TRUHE (muss noch implementiert werden)
                        7 7 7 7 6
                        7 6 6 6 5
                        7 6 X 1 3
                        7 6 6 6 5 
                        7 7 7 7 6
                        */
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.BAUM },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM,
					KachelWertigkeit.BUSCH },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.HELD_VERAENDERBAR },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM,
					KachelWertigkeit.BUSCH },
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.BAUM } 
        };
        private static final float SACKGASSE_HELD_SCHATZTRUHE_WAHRSCHEINLICHKEIT = 0.1f;
        
        private static final KachelWertigkeit[][] SACKGASSE_KARTEN_SCHATZTRUHE =
	{               /* - x = TRUHE (muss noch implementiert werden)
                        7 7 7 7 6
                        7 6 6 6 5
                        7 6 X 1 4
                        7 6 6 6 5 
                        7 7 7 7 6
                        */
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.BAUM },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM,
					KachelWertigkeit.BUSCH },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.KARTEN_EFFEKT_VERAENDERBAR },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM,
					KachelWertigkeit.BUSCH },
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.BAUM } 
        };
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
		float distanzZurMitte = Position.getEntfernung(new Position(maximalGroesseX / 2, maximalGroesseY / 2),
				pos);
		float einZentel = distanzZurMitte / 10;
		if (distanzZurMitte == 0f)
		{
			return Sackgasse.STANDART_WAHRSCHEINLICHKEIT;
		}
		return Sackgasse.STANDART_WAHRSCHEINLICHKEIT
				+ ((distanzZurMitte / einZentel) * Sackgasse.STANDART_WAHRSCHEINLICHKEITS_ERHOEHUNG_PRO_ZENTEL);
	}
}
