package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;
import de.pk.model.position.Position;
import de.pk.utils.WahrscheinlichkeitsUtils;

public class EckKachel extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.1f;
	private static final float STANDART_WAHRSCHEINLICHKEIT_ERHOEUNG_WENN_IN_ECKE = 0.5f;
	private static final KachelWertigkeit[][] GROSS =
	{
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER, KachelWertigkeit.SCHWER,
					KachelWertigkeit.SCHWER },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.SCHWER, KachelWertigkeit.FREI, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.LEICHT } };
	private static final float GROSS_WAHRSCHEINLICHKEIT = 0.3f;

	private static final KachelWertigkeit[][] KLEIN =
	{
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT,
					KachelWertigkeit.LEICHT },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI },
			{ KachelWertigkeit.LEICHT, KachelWertigkeit.LEICHT, KachelWertigkeit.FREI, KachelWertigkeit.FREI,
					KachelWertigkeit.FREI } };
	private static final float KLEIN_WAHRSCHEINLICHKEIT = 0.7f;

	public EckKachel()
	{
		super(EckKachel.GROSS);
		if (WahrscheinlichkeitsUtils.getIndexAusWahrscheinlichkeiten(GROSS_WAHRSCHEINLICHKEIT,
				KLEIN_WAHRSCHEINLICHKEIT) == 1)
		{
			super.setInhalt(KLEIN);
		}
	}

	@Override
	public EckKachel clone()
	{
		return new EckKachel();
	}

	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, Position aktuellePosition)
	{
		// Increase corner probability if near to a corner
		if (istInEcke(aktuellePosition, maximalGroesseX, maximalGroesseY))
		{
			return EckKachel.STANDART_WAHRSCHEINLICHKEIT
					+ EckKachel.STANDART_WAHRSCHEINLICHKEIT_ERHOEUNG_WENN_IN_ECKE;
		}
		return EckKachel.STANDART_WAHRSCHEINLICHKEIT;
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
