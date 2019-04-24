package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;

public class Schlucht extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.3f;
	private static final KachelWertigkeit[][] SCHLUCHT_GROSS_LEICHT =
	{               /*
                        7 7 7 7 7
                        1 1 1 1 1
                        0 0 0 0 0 
                        1 1 1 1 1
                        7 7 7 7 7
                        */
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS } 
        };
        private static final float SCHLUCHT_GROSS_LEICHT_WAHRSCHEINLICHKEIT = 0.1f;
        
        private static final KachelWertigkeit[][] SCHLUCHT_GROSS_SCHWER =
	{               /*
                        7 7 7 7 7
                        1 5 2 2 2
                        0 2 2 2 1 
                        1 2 2 2 5
                        7 7 7 7 7
                        */
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.BUSCH, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.FREI, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.BUSCH },
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS } 
        };
        private static final float SCHLUCHT_GROSS_SCHWER_WAHRSCHEINLICHKEIT = 0.1f;
        
        private static final KachelWertigkeit[][] SCHLUCHT_KLEIN_LEICHT =
	{               /*
                        7 7 7 7 7
                        6 7 7 6 5
                        0 1 1 1 0 
                        6 7 7 7 6
                        7 7 7 7 7
                        */
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.BAUM,
					KachelWertigkeit.BUSCH },
			{ KachelWertigkeit.FREI, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.BAUM },
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS } 
        };
        private static final float SCHLUCHT_KLEIN_LEICHT_WAHRSCHEINLICHKEIT = 0.1f;
        
        private static final KachelWertigkeit[][] SCHLUCHT_KLEIN_SCHWER =
	{               /*
                        7 7 7 7 7
                        5 7 7 6 2
                        2 2 2 2 2 
                        6 7 7 7 6
                        7 7 7 7 7
                        */
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS },
			{ KachelWertigkeit.BUSCH, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.BAUM,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.BAUM },
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS } 
        };
        private static final float SCHLUCHT_KLEIN_SCHWER_WAHRSCHEINLICHKEIT = 0.1f;
        
        private static final KachelWertigkeit[][] SCHLUCHT_KLEIN_MACHBAR =
	{               /*
                        7 7 7 7 7
                        5 6 7 7 5
                        2 2 3 3 2 
                        6 6 7 6 6
                        7 7 7 7 6
                        */
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS },
			{ KachelWertigkeit.BUSCH, KachelWertigkeit.BAUM, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.BUSCH },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.HELD_VERAENDERBAR, KachelWertigkeit.HELD_VERAENDERBAR,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.BAUM, KachelWertigkeit.FELS, KachelWertigkeit.BAUM,
					KachelWertigkeit.BAUM },
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.BAUM } 
        };
        private static final float SCHLUCHT_KLEIN_MACHBAR_WAHRSCHEINLICHKEIT = 0.1f;
        
        private static final KachelWertigkeit[][] SCHLUCHT_KLEIN_MACHBAR_KARTE =
	{               /*
                        7 7 7 7 7
                        2 6 7 7 5
                        2 4 4 7 2 
                        6 7 4 4 2
                        7 7 7 7 7
                        */
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.BAUM, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.BUSCH },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.KARTEN_EFFEKT_VERAENDERBAR, KachelWertigkeit.KARTEN_EFFEKT_VERAENDERBAR, KachelWertigkeit.FELS,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.FELS, KachelWertigkeit.KARTEN_EFFEKT_VERAENDERBAR, KachelWertigkeit.KARTEN_EFFEKT_VERAENDERBAR,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.FELS } 
        };
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
