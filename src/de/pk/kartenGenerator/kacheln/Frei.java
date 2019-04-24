package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;
import de.pk.utils.WahrscheinlichkeitsUtils;

public class Frei extends KartenGeneratorKachel
{
	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.6f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL = 0.02f;
	private static final KachelWertigkeit[][] FREIEKACHEL =
	{               /*
                        0 0 0 0 0 
                        0 0 0 0 0 
                        0 0 0 0 0 
                        0 0 0 0 0
                        0 0 0 0 0  
                        */
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI } 
        };
        private static final float FREIEKACHEL_WAHRSCHEINLICHKEIT = 0.3f;
        
        private static final KachelWertigkeit[][] FREIEKACHEL_BEWACHSEN =
	{               /*
                        0 1 1 0 0 
                        0 2 1 1 0 
                        1 1 6 6 1 
                        0 1 6 1 0
                        0 0 1 0 0  
                        */
			{ KachelWertigkeit.FREI, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.BAUM, KachelWertigkeit.BAUM,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.FREI, KachelWertigkeit.LEICHT, KachelWertigkeit.BAUM, KachelWertigkeit.LEICHT,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI } 
        };
        private static final float FREIEKACHEL_BEWACHSEN_WAHRSCHEINLICHKEIT = 0.3f;
        
        private static final KachelWertigkeit[][] FREIEKACHEL_FREIMACHBAR =
	{               /*
                        1 3 2 1 0 
                        1 2 3 3 2 
                        1 3 3 2 1 
                        0 1 3 6 2
                        0 1 2 3 1  
                        */
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.HELD_VERAENDERBAR, KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.SCHWER, KachelWertigkeit.HELD_VERAENDERBAR, KachelWertigkeit.HELD_VERAENDERBAR,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.HELD_VERAENDERBAR, KachelWertigkeit.HELD_VERAENDERBAR, KachelWertigkeit.SCHWER,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.FREI, KachelWertigkeit.LEICHT, KachelWertigkeit.HELD_VERAENDERBAR, KachelWertigkeit.BAUM,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.FREI, KachelWertigkeit.LEICHT, KachelWertigkeit.SCHWER, KachelWertigkeit.HELD_VERAENDERBAR,
					KachelWertigkeit.LEICHT } 
        };
        private static final float FREIEKACHEL_FREIMACHBAR_WAHRSCHEINLICHKEIT = 0.3f;
        
	public Frei()
	{
		super(Frei.FREIEKACHEL);
                if (WahrscheinlichkeitsUtils.getIndexAusWahrscheinlichkeiten(FREIEKACHEL_WAHRSCHEINLICHKEIT,
                        FREIEKACHEL_BEWACHSEN_WAHRSCHEINLICHKEIT) == 1)
		{
			super.setInhalt(FREIEKACHEL_BEWACHSEN);
		}
	}

	@Override
	public Frei clone()
	{
		return new Frei();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximaleGroesseX, int maximaleGroesseY, Position aktuellePosition)
	{
		float distanzZurMitte = Position.getEntfernung(new Position(maximaleGroesseX / 2, maximaleGroesseY / 2), aktuellePosition);
		if (distanzZurMitte == 0f)
		{
			return Frei.STANDART_WAHRSCHEINLICHKEIT;
		}
		// Berechnet die Zentel
		float einZentel = distanzZurMitte / 10;
                // Bekommt die Ausgangswahrscheinlichkeit und zieht so viel ab, wie sie zentel bewegt wurde
		return Frei.STANDART_WAHRSCHEINLICHKEIT - ((distanzZurMitte / einZentel)
				* Frei.STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL);
	}
}
