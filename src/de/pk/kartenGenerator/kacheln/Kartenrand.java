package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;

public class Kartenrand extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.0f;
	private static final float STANDART_WAHRSCHEINLICHKEIT_WENN_AM_RAND = Float.MAX_VALUE;
        
        private static final KachelWertigkeit[][] KARTENRAND_GROSS_FREI =
	{               /*
                        8 8 8 8 8 
                        8 2 2 2 8 
                        3 2 1 1 3
                        0 0 0 0 0 
                        0 0 0 0 0
                        */
			{ KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.ENDE, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.HELD_VERAENDERBAR, KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.HELD_VERAENDERBAR },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI } 
        };
        private static final float KARTENRAND_GROSS_FREI_WAHRSCHEINLICHKEIT = 0.3f;
        
	private static final KachelWertigkeit[][] KARTENRAND_KLEIN_FREI =
	{               /*
                        8 8 8 8 8 
                        8 7 7 7 8 
                        6 1 1 1 6
                        1 1 1 1 1 
                        0 0 0 0 0
                        */
			{ KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.ENDE, KachelWertigkeit.FELS, KachelWertigkeit.FELS, KachelWertigkeit.FELS,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.BAUM, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.BAUM },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI } 
        };
        private static final float KARTENRAND_KLEIN_FREI_WAHRSCHEINLICHKEIT = 0.1f;
        
        private static final KachelWertigkeit[][] KARTENRAND_BEWACHSEN =
	{               /*
                        8 8 8 8 8 
                        7 6 6 6 7
                        5 5 5 5 5
                        2 2 2 2 2 
                        1 1 1 6 1
                        */
			{ KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE, KachelWertigkeit.ENDE,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.FELS, KachelWertigkeit.BAUM, KachelWertigkeit.FELS, KachelWertigkeit.BAUM,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.BUSCH, KachelWertigkeit.BUSCH, KachelWertigkeit.BUSCH, KachelWertigkeit.BUSCH,
					KachelWertigkeit.BUSCH },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.ENDE },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.BAUM,
					KachelWertigkeit.LEICHT } 
        };
        private static final float KARTENRAND_BEWACHSEN_WAHRSCHEINLICHKEIT = 0.1f;

	public Kartenrand()
	{
		super(Kartenrand.KARTENRAND_KLEIN_FREI);
	}

	@Override
	public Kartenrand clone()
	{
		return new Kartenrand();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, Position pos)
	{
		if (this.pruefeObAmRand(maximalGroesseX, maximalGroesseY, pos))
		{
			return Kartenrand.STANDART_WAHRSCHEINLICHKEIT_WENN_AM_RAND;
		}
		return Kartenrand.STANDART_WAHRSCHEINLICHKEIT;

	}

	private boolean pruefeObAmRand(int maximaleGroesseX, int maximaleGroesseY, Position pos)
	{
		return ((maximaleGroesseX - 1) == pos.getX()) || ((maximaleGroesseY - 1) == pos.getY())
				|| (pos.getX() == 0) || (pos.getY() == 0);
	}

}
