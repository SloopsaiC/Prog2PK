package de.pk.kartenGenerator.kacheln;

import de.pk.kartenGenerator.KartenGeneratorKachel;

public class EckKachelGross extends KartenGeneratorKachel
{

	private static final float STANDART_WAHRSCHEINLICHKEIT = 0.1f;
	private static final float STANDART_WAHRSCHEINLICHKEIT_ERHOEUNG_WENN_IN_ECKE = 0.5f;
	private static final KachelWertigkeit[][] STANDART =
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

	public EckKachelGross()
	{
		super(EckKachelGross.STANDART);
	}

	@Override
	public EckKachelGross clone()
	{
		return new EckKachelGross();
	}

	@Override
	public float getVorkommensWahrscheinlichkeit(int maximalGroesseX, int maximalGroesseY, int aktuellePositionX,
			int aktuellePositionY)
	{
		// Check if in a map corner
		if (((aktuellePositionX == (maximalGroesseX - 1)) && (aktuellePositionY == (maximalGroesseY - 1)))
				|| ((aktuellePositionX == 0) && (aktuellePositionY == 0)))
		{
			return 1f;
		}
		// Increase corner probability if near to a corner
		int einZentelDerMaximalgroesseX = maximalGroesseX / 10;
		int einZentelDerMaximalgroesseY = maximalGroesseY / 10;
		if (this.pruefenObInRechteck(0, 0, einZentelDerMaximalgroesseX, einZentelDerMaximalgroesseY, aktuellePositionX,
				aktuellePositionY)
				|| this.pruefenObInRechteck(0, maximalGroesseY - 1, einZentelDerMaximalgroesseX,
						einZentelDerMaximalgroesseY, aktuellePositionX, aktuellePositionY)
				|| this.pruefenObInRechteck(maximalGroesseX - 1, 0, einZentelDerMaximalgroesseX,
						einZentelDerMaximalgroesseY, aktuellePositionX, aktuellePositionY)
				|| this.pruefenObInRechteck(maximalGroesseX - 1, maximalGroesseY - 1, einZentelDerMaximalgroesseX,
						einZentelDerMaximalgroesseY, aktuellePositionX, aktuellePositionY))
		{
			return EckKachelGross.STANDART_WAHRSCHEINLICHKEIT
					+ EckKachelGross.STANDART_WAHRSCHEINLICHKEIT_ERHOEUNG_WENN_IN_ECKE;
		}
		return EckKachelGross.STANDART_WAHRSCHEINLICHKEIT;
	}

	/**
	 * Prueft ob die gegebene Position innerhalb eines Rechtecks in der gegebenen
	 * Position liegt (NORDEN/WESTEN/ECKE)
	 */
	private boolean pruefenObInRechteck(int positionX, int positionY, int groesseX, int groesseY, int ueberpruefenX,
			int ueberpruefenY)
	{
		return ((positionX - groesseX) < ueberpruefenX) && ((positionX + groesseX) > ueberpruefenX)
				&& ((positionY - groesseY) < ueberpruefenY) && ((positionX + groesseY) > ueberpruefenX);
	}

}
