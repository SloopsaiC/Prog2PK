package de.pk.kartenGenerator.untergruende;

import de.pk.kartenGenerator.KartenGeneratorUntergrund;
import de.pk.model.position.Position;
import de.pk.utils.WahrscheinlichkeitsUtils;

public class EckUntergrund extends KartenGeneratorUntergrund
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.1f;
	private static final float STANDART_WAHRSCHEINLICHKEIT_ERHOEUNG_WENN_IN_ECKE = 0.5f;
	private static final KachelUntergrundWertigkeit[][] GROSS =
	{
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.LEICHT } };
	private static final float GROSS_WAHRSCHEINLICHKEIT = 0.3f;

	private static final KachelUntergrundWertigkeit[][] KLEIN =
	{
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI } };
	private static final float KLEIN_WAHRSCHEINLICHKEIT = 0.7f;

	public EckUntergrund()
	{
		super(EckUntergrund.GROSS);
		if (WahrscheinlichkeitsUtils.getIndexAusWahrscheinlichkeiten(GROSS_WAHRSCHEINLICHKEIT,
				KLEIN_WAHRSCHEINLICHKEIT) == 1)
		{
			super.setInhalt(KLEIN);
		}
	}

	@Override
	public EckUntergrund clone()
	{
		return new EckUntergrund();
	}

	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, Position aktuellePosition)
	{
		// Increase corner probability if near to a corner
		if (istInEcke(aktuellePosition, maximalGroesseX, maximalGroesseY))
		{
			return EckUntergrund.STANDART_WAHRSCHEINLICHKEIT
					+ EckUntergrund.STANDART_WAHRSCHEINLICHKEIT_ERHOEUNG_WENN_IN_ECKE;
		}
		return EckUntergrund.STANDART_WAHRSCHEINLICHKEIT;
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
