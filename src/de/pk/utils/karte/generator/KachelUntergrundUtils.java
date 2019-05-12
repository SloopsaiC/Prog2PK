package de.pk.utils.karte.generator;

import de.pk.model.position.Position;

public class KachelUntergrundUtils
{
	private KachelUntergrundUtils()
	{
	}

	/**
	 * Prueft ob eine Position in einer Ecke ist
	 */
	public static boolean istInEcke(Position zuUeberpruefen, int maximalGroesseX, int maximalGroesseY)
	{
		int eckenAnfangX = maximalGroesseX
				/ KartenGeneratorUntergrundKonstanten.XTEL_AB_WELCHEM_ETWAS_IN_DER_ECKE_IST_X_KOORD;
		int eckenAnfangY = maximalGroesseY
				/ KartenGeneratorUntergrundKonstanten.XTEL_AB_WELCHEM_ETWAS_IN_DER_ECKE_IST_Y_KOORD;
		return KachelUntergrundUtils.pruefenObInRechteck(zuUeberpruefen, new Position(0, 0), eckenAnfangX, eckenAnfangY)
				|| KachelUntergrundUtils.pruefenObInRechteck(zuUeberpruefen, new Position(0, maximalGroesseY - 1),
						eckenAnfangX, eckenAnfangY)
				|| KachelUntergrundUtils.pruefenObInRechteck(zuUeberpruefen, new Position(maximalGroesseX - 1, 0),
						eckenAnfangX, eckenAnfangY)
				|| KachelUntergrundUtils.pruefenObInRechteck(zuUeberpruefen,
						new Position(maximalGroesseX - 1, maximalGroesseY - 1), eckenAnfangX, eckenAnfangY);
	}

	/**
	 * Prueft ob die gegebene Position innerhalb eines Rechtecks in der gegebenen
	 * Position liegt (NORDEN/WESTEN/ECKE)
	 */
	public static boolean pruefenObInRechteck(Position zuUeberpruefen, Position rechteckPosition, int groesseX,
			int groesseY)
	{
		return ((rechteckPosition.getX() - groesseX) < zuUeberpruefen.getX())
				&& ((rechteckPosition.getX() + groesseX) > zuUeberpruefen.getX())
				&& ((rechteckPosition.getY() - groesseY) < zuUeberpruefen.getY())
				&& ((rechteckPosition.getY() + groesseY) > zuUeberpruefen.getY());
	}

	public static boolean istInDerMitteMitte(Position zuUeberpruefen, int maximalGroesseX, int maximalGroesseY)
	{
		float distanzZurMitte = Position.getEntfernung(new Position(maximalGroesseX / 2, maximalGroesseY / 2),
				zuUeberpruefen);
		return distanzZurMitte < (maximalGroesseX
				/ KartenGeneratorUntergrundKonstanten.XTEL_AB_WELCHEM_ETWAS_IN_DER_MITTE_IST)
				&& distanzZurMitte < (maximalGroesseY
						/ KartenGeneratorUntergrundKonstanten.XTEL_AB_WELCHEM_ETWAS_IN_DER_MITTE_IST);
	}
}
