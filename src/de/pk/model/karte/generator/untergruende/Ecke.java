package de.pk.model.karte.generator.untergruende;

import de.pk.model.karte.generator.KartenGeneratorUntergrund;
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
	public Ecke()
	{
		super(Ecke.ECKE_GROSS_NORMAL);
		
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
