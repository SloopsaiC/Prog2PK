package de.pk.kartenGenerator.untergruende;

import de.pk.kartenGenerator.KartenGeneratorUntergrund;
import de.pk.model.position.Position;
import de.pk.utils.WahrscheinlichkeitsUtils;

public class Ecke extends KartenGeneratorUntergrund
{
	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.1f;
	private static final float STANDART_WAHRSCHEINLICHKEIT_ERHOEUNG_WENN_IN_ECKE = 0.5f;
	private static final KachelUntergrundWertigkeit[][] ECKE_GROSS_NORMAL =
	{ /*
		 * 2 2 2 2 2 2 1 1 1 1 2 1 0 0 0 2 1 0 0 0 2 1 0 0 0
		 */
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI } };
	private static final float ECKE_GROSS_NORMAL_WAHRSCHEINLICHKEIT = 0.3f;

	private static final KachelUntergrundWertigkeit[][] ECKE_KLEIN_NORMAL =
	{ /*
		 * 3 3 3 3 3 3 2 2 2 2 3 2 1 1 1 3 2 1 0 0 3 2 1 0 0
		 */
			{ KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.HELD_VERAENDERBAR,
					KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.HELD_VERAENDERBAR,
					KachelUntergrundWertigkeit.HELD_VERAENDERBAR },
			{ KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.LEICHT } };
	private static final float ECKE_KLEIN_NORMAL_WAHRSCHEINLICHKEIT = 0.5f;

	private static final KachelUntergrundWertigkeit[][] ECKE_GROSS_RAND =
	{ /*
		 * 8 8 8 8 8 8 7 6 6 6 8 6 5 1 1 8 6 1 1 1 8 6 1 1 1
		 */
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT }, };
	private static final float ECKE_GROSS_RAND_WAHRSCHEINLICHKEIT = 0.1f;

	private static final KachelUntergrundWertigkeit[][] ECKE_KLEIN_RAND =
	{ /*
		 * 8 8 8 8 8 8 7 6 6 6 8 6 5 3 3 8 6 3 2 2 8 6 3 2 1
		 */
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH,
					KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.HELD_VERAENDERBAR },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT }, };
	private static final float ECKE_KLEIN_RAND_WAHRSCHEINLICHKEIT = 0.1f;

	public Ecke()
	{
		super(Ecke.ECKE_GROSS_NORMAL);
		if (WahrscheinlichkeitsUtils.getIndexAusWahrscheinlichkeiten(Ecke.ECKE_GROSS_NORMAL_WAHRSCHEINLICHKEIT,
				Ecke.ECKE_KLEIN_NORMAL_WAHRSCHEINLICHKEIT) == 1)
		{
			super.setInhalt(Ecke.ECKE_KLEIN_NORMAL);
		}
	}

	@Override
	public Ecke clone()
	{
		return new Ecke();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, Position aktuellePosition)
	{
		// Erhoeht die Wahrscheinlichkeit wenn die Kachel naeher in einer Ecke ist
		if (this.istInEcke(aktuellePosition, maximalGroesseX, maximalGroesseY))
		{
			return Ecke.STANDART_WAHRSCHEINLICHKEIT + Ecke.STANDART_WAHRSCHEINLICHKEIT_ERHOEUNG_WENN_IN_ECKE;
		}
		return Ecke.STANDART_WAHRSCHEINLICHKEIT;
	}

	private boolean istInEcke(Position zuUeberpruefen, int maximalGroesseX, int maximalGroesseY)
	{
		int einViertelDerMaximalgroesseX = maximalGroesseX / 6;
		int einViertelDerMaximalgroesseY = maximalGroesseY / 6;
		return this.pruefenObInRechteck(zuUeberpruefen, new Position(0, 0), einViertelDerMaximalgroesseX,
				einViertelDerMaximalgroesseY)
				|| this.pruefenObInRechteck(zuUeberpruefen, new Position(0, maximalGroesseY - 1),
						einViertelDerMaximalgroesseX, einViertelDerMaximalgroesseY)
				|| this.pruefenObInRechteck(zuUeberpruefen, new Position(maximalGroesseX - 1, 0),
						einViertelDerMaximalgroesseX, einViertelDerMaximalgroesseY)
				|| this.pruefenObInRechteck(zuUeberpruefen, new Position(maximalGroesseX - 1, maximalGroesseY - 1),
						einViertelDerMaximalgroesseX, einViertelDerMaximalgroesseY);
	}

	/**
	 * Prueft ob die gegebene Position innerhalb eines Rechtecks in der gegebenen
	 * Position liegt (NORDEN/WESTEN/ECKE)
	 */
	private boolean pruefenObInRechteck(Position zuUeberpruefen, Position rechteckPosition, int groesseX, int groesseY)
	{
		return ((rechteckPosition.getX() - groesseX) < zuUeberpruefen.getX())
				&& ((rechteckPosition.getX() + groesseX) > zuUeberpruefen.getX())
				&& ((rechteckPosition.getY() - groesseY) < zuUeberpruefen.getY())
				&& ((rechteckPosition.getY() + groesseY) > zuUeberpruefen.getY());
	}

}
