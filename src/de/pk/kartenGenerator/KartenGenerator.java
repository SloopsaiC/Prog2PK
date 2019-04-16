package de.pk.kartenGenerator;

import java.util.ArrayList;

public class KartenGenerator
{
	private ArrayList<KartenGeneratorKachel> registrierteKacheln = null;

	public KartenGenerator()
	{
		this.registrierteKacheln = new ArrayList<>();
	}

	/**
	 * Generiert eine Kachel passend zur gegebenen Kachel in der bestimmten Richtung.
	 * Die Kachelwahrscheinlichkeit ist abhaengig von der aktuellen Position
	 *
	 * @param anzahlKachelnX    Maximale Anzahl der Kacheln in X-Richtung
	 * @param anzahlKachelnY    Maximale Anzahl der Kacheln in Y-Richtung
	 * @param aktuellePositionX Aktuelle Position in X-Richtung
	 * @param aktuellePositionY Aktuelle Position in Y-Richtung
	 * @param richtung          Die Richtung in der die neue Kachel generiert wird
	 * @param aktuelleKarte     Die Karte fuer die, die Kachel generiert (aber noch nicht gesetzt) wird
	 *
	 * @return KartenGeneratorKachel: Die Kachel die generiert wurde
	 */
	public KartenGeneratorKachel generiereNeueKachel(int anzahlKachelnX, int anzahlKachelnY, int aktuellePositionX,
			int aktuellePositionY, Richtung richtung, KartenGeneratorKachel aktuelleKachel)
	{
		int[] versatz = KartenGeneratorUtils.getVersatzVonRichtung(richtung);
		KartenGeneratorKachel generiert = this.getKachelZumGenerieren(anzahlKachelnX, anzahlKachelnY,
				aktuellePositionX + versatz[0], aktuellePositionY + versatz[1]);
		if (!KartenGeneratorUtils.pruefeVerbindung(aktuelleKachel, generiert, richtung))
		{
			generiert = generiert.clone();
			while (!KartenGeneratorUtils.pruefeVerbindung(aktuelleKachel, generiert, richtung))
			{
				generiert.drehe(Richtung.OSTEN);
			}
		}
		return generiert;
	}

	/**
	 * Bestimmt die Kachel die generiert werden soll, dies basiert auf den
         * Wahrscheinlichkeiten
	 *
	 * @param anzahlKachelnX     Maximale Anzahl der Kacheln in X-Richtung
	 * @param anzahlKachelnY     Maximale Anzahl der Kacheln in Y-Richtung
	 * @param generierePositionX X-Position auf der die Kachel generiert werden sollte
	 * @param generierePositionY Y-Position auf der die Kachel generiert werden sollte
	 *
	 * @return KartenGeneratorKachel A tile fitting the current Position
	 */
	private KartenGeneratorKachel getKachelZumGenerieren(int anzahlKachelnX, int anzahlKachelnY, int generierePositionX,
			int generierePositionY)
	{
		// Holt alle Wahrscheinlichkeiten von den Kacheln
		float[] wahrscheinlichkeiten = this.getWahrscheinlichkeitVonKacheln(anzahlKachelnX, anzahlKachelnY, generierePositionX,
				generierePositionY);
		if (KartenGeneratorUtils.getKachelDieGeneriertWerdenMuss(wahrscheinlichkeiten) >= 0)
		{
			return this.registrierteKacheln.get(KartenGeneratorUtils.getKachelDieGeneriertWerdenMuss(wahrscheinlichkeiten));
		}
		return this.registrierteKacheln.get(KartenGeneratorUtils.getIndexVonWahrscheinlichkeit(wahrscheinlichkeiten));

	}

	/**
	 * Holt alle Wahrscheinlichkeiten der regestrierten Kacheln ein.
	 *
	 * @param anzahlKachelnX The maximum number tiles in X-Richtung
	 * @param anzahlKachelnY the maximum number tiles in Y-Richtung
	 * @param positionX      The X-Position to get the probability for
	 * @param positionY      The Y-Position to get the probability for
	 */
	private float[] getWahrscheinlichkeitVonKacheln(int anzahlKachelnX, int anzahlKachelnY, int positionX,
			int positionY)
	{
		float[] wahrscheinlichkeit = new float[this.registrierteKacheln.size()];
		for (int i = 0; i < wahrscheinlichkeit.length; i++)
		{
			wahrscheinlichkeit[i] = this.registrierteKacheln.get(i).getVorkommensWahrscheinlichkeit(anzahlKachelnX,
					anzahlKachelnY, positionX, positionY);
		}
		return wahrscheinlichkeit;
	}

	private boolean ueberpruefeFreiesRandFeld(KartenGeneratorKachel zuUeberpruefen)
	{
		for (int val = 0; val < KartenGeneratorKachelInterface.KACHEL_GROESSE_X; val++)
		{
			if (zuUeberpruefen.getInhalt()[val][0].istBetretbar()
					|| zuUeberpruefen.getInhalt()[KartenGeneratorKachelInterface.KACHEL_GROESSE_Y - 1][val]
							.istBetretbar()
					|| zuUeberpruefen.getInhalt()[0][val].istBetretbar()
					|| zuUeberpruefen.getInhalt()[val][KartenGeneratorKachelInterface.KACHEL_GROESSE_X - 1]
							.istBetretbar())
			{
				return true;
			}
		}
		return false;
	}

	private boolean ueberpruefeRegistrierendeKachel(KartenGeneratorKachel zuUeberpruefen)
	{
		return ueberpruefeFreiesRandFeld(zuUeberpruefen);   // Wir sollten vielleicht auch pruefen ob die Kachel sinnvolle
                                                                    // Werte fuer ihre Wahrscheinlichkeit wieder gibt, falls man
                                                                    // Kacheln von ausserhalb zulassen moechte (Modding etc.)
	}

	/**
	 * Regestriert die Kacheln die der Generator erzeugen soll.
	 *
	 * @param insRegister Die Kachel ins Register
	 */
	public void registriereKachel(KartenGeneratorKachel insRegister)
	{
		if (ueberpruefeRegistrierendeKachel(insRegister))
		{
			this.registrierteKacheln.add(insRegister);
		} else
		{
			throw new IllegalArgumentException("Kacheln muessen mindestens ein begehbares Feld am Rand haben!");
		}
	}

}
