package de.pk.kartenGenerator.untergruende;

import de.pk.kartenGenerator.KartenGeneratorUntergrund;
import de.pk.model.position.Position;
import de.pk.utils.WahrscheinlichkeitsUtils;

public class Frei extends KartenGeneratorUntergrund
{
	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.6f;
	private static final float STANDART_WAHRSCHEINLICHKEITS_REDUZIERUNG_PRO_ZENTEL = 0.02f;
	private static final KachelUntergrundWertigkeit[][] FREIEKACHEL =
	{               /*
                        0 0 0 0 0 
                        0 0 0 0 0 
                        0 0 0 0 0 
                        0 0 0 0 0
                        0 0 0 0 0  
                        */
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI } 
        };
        private static final float FREIEKACHEL_WAHRSCHEINLICHKEIT = 0.3f;
        
        private static final KachelUntergrundWertigkeit[][] FREIEKACHEL_BEWACHSEN =
	{               /*
                        0 1 1 0 0 
                        0 2 1 1 0 
                        1 1 6 6 1 
                        0 1 6 1 0
                        0 0 1 0 0  
                        */
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI } 
        };
        private static final float FREIEKACHEL_BEWACHSEN_WAHRSCHEINLICHKEIT = 0.3f;
        
        private static final KachelUntergrundWertigkeit[][] FREIEKACHEL_FREIMACHBAR =
	{               /*
                        1 3 2 1 0 
                        1 2 3 3 2 
                        1 3 3 2 1 
                        0 1 3 6 2
                        0 1 2 3 1  
                        */
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.HELD_VERAENDERBAR,
					KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.HELD_VERAENDERBAR,
					KachelUntergrundWertigkeit.LEICHT } 
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
