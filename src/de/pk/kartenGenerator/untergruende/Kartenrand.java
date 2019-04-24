package de.pk.kartenGenerator.untergruende;

import de.pk.kartenGenerator.KartenGeneratorUntergrund;
import de.pk.model.position.Position;

public class Kartenrand extends KartenGeneratorUntergrund
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.0f;
	private static final float STANDART_WAHRSCHEINLICHKEIT_WENN_AM_RAND = Float.MAX_VALUE;
        
        private static final KachelUntergrundWertigkeit[][] KARTENRAND_GROSS_FREI =
	{               /*
                        8 8 8 8 8 
                        8 2 2 2 8 
                        3 2 1 1 3
                        0 0 0 0 0 
                        0 0 0 0 0
                        */
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.HELD_VERAENDERBAR },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI } 
        };
        private static final float KARTENRAND_GROSS_FREI_WAHRSCHEINLICHKEIT = 0.3f;
        
	private static final KachelUntergrundWertigkeit[][] KARTENRAND_KLEIN_FREI =
	{               /*
                        8 8 8 8 8 
                        8 7 7 7 8 
                        6 1 1 1 6
                        1 1 1 1 1 
                        0 0 0 0 0
                        */
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI } 
        };
        private static final float KARTENRAND_KLEIN_FREI_WAHRSCHEINLICHKEIT = 0.1f;
        
        private static final KachelUntergrundWertigkeit[][] KARTENRAND_BEWACHSEN =
	{               /*
                        8 8 8 8 8 
                        7 6 6 6 7
                        5 5 5 5 5
                        2 2 2 2 2 
                        1 1 1 6 1
                        */
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.BUSCH,
					KachelUntergrundWertigkeit.BUSCH },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.LEICHT } 
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
