package de.pk.control.karte.generator;

import java.util.ArrayList;
import java.util.Arrays;

import de.pk.model.karte.generator.KartenGeneratorUntergrund;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.karte.generator.untergruende.Start;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.spielbrettTeile.Kachel;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.WahrscheinlichkeitsUtils;
import de.pk.utils.karte.generator.KartenGeneratorUtils;

public class KartenGenerator
{
	private ArrayList<KartenGeneratorUntergrund> registrierteKacheln = null;

	/**
	 * Erstellt einen KartenGenerator welcher keine registrierten Untergruende hat
	 */
	private KartenGenerator()
	{
		this(new ArrayList<>());
	}

	/**
	 * Erstellt einen Generator welcher die gegebenen Untergruende verwendet
	 *
	 * @param kacheln Die Untergruende die dieser Generator verwenden wird um neue
	 *                zu generieren
	 */
	public KartenGenerator(ArrayList<KartenGeneratorUntergrund> kacheln)
	{
		this.registrierteKacheln = kacheln;
	}

	/**
	 * Erstellt einen Generator welcher die gegebenen Untergruende verwendet
	 *
	 * @param kacheln Die Untergruende die dieser Generator verwenden wird um neue
	 *                zu generieren
	 */
	public KartenGenerator(KartenGeneratorUntergrund... generatorKacheln)
	{
		this();
		this.registrierteKacheln.addAll(Arrays.asList(generatorKacheln));
	}

	/**
	 * Generiert eine neue Kachel in gegebenener Richtung von gegebener Position aus
	 * gesehen
	 *
	 * @param anzahlKachelnX   Die maximale Anzahl an Kacheln auf dem Spielbrett in
	 *                         X-Richtung
	 * @param anzahlKachelnY   Die maximale Anzahl an Kacheln auf dem Spielbrett in
	 *                         Y-Richtung
	 * @param aktuellePosition Die aktuelle Position von der aus die Richtung
	 *                         gesehen wird
	 * @param richtung         Die Richtung in welche die Kachel generiert wird
	 * @param aktuelleKachel   Die Kachel welche zur aktuellen Position gehoert
	 */
	public Kachel generiereNeueKachel(int anzahlKachelnX, int anzahlKachelnY, Position aktuellePosition,
			Richtung richtung, Kachel aktuelleKachel)
	{
		KartenGeneratorUntergrund untergrund = this.generiereNeueUntergrundKachel(anzahlKachelnX, anzahlKachelnY,
				aktuellePosition, richtung, aktuelleKachel.getUntergrund());
		return new Kachel(untergrund);
	}

	/**
	 * Generiert einen Untergrund fuer eine Kachel passend zur gegebenen Kachel in
	 * der bestimmten Richtung. Die Kachelwahrscheinlichkeit ist abhaengig von der
	 * aktuellen Position
	 *
	 * @param anzahlKachelnX   Maximale Anzahl der Kacheln in X-Richtung
	 * @param anzahlKachelnY   Maximale Anzahl der Kacheln in Y-Richtung
	 * @param aktuellePosition Die Position in der Kachel
	 * @param richtung         Die Richtung in der die neue Kachel generiert wird
	 * @param aktuelleKachel   Die betroffende Kachel
	 *
	 * @return KartenGeneratorKachel: Die Kachel die generiert wurde
	 */
	public KartenGeneratorUntergrund generiereNeueUntergrundKachel(int anzahlKachelnX, int anzahlKachelnY,
			Position aktuellePosition, Richtung richtung, KartenGeneratorUntergrund aktuelleKachel)
	{
		if (this.registrierteKacheln.size() < 1)
		{
			// TODO: Exception Messages
			throw new IllegalStateException();
		}
		KartenGeneratorUntergrund generiert = this.getUntergrundKachelZumGenerieren(anzahlKachelnX, anzahlKachelnY,
				aktuellePosition.addiere(KartenGeneratorUtils.getVersatzVonRichtung(richtung)));
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

	public Kachel generiereStartKachel()
	{
		return new Kachel(new Start());
	}

	/**
	 * Bestimmt die Kachel die generiert werden soll, dies basiert auf den
	 * Wahrscheinlichkeiten
	 *
	 * @param anzahlKachelnX     Maximale Anzahl der Kacheln in X-Richtung
	 * @param anzahlKachelnY     Maximale Anzahl der Kacheln in Y-Richtung
	 * @param generierePositionX X-Position auf der die Kachel generiert werden
	 *                           sollte
	 * @param generierePositionY Y-Position auf der die Kachel generiert werden
	 *                           sollte
	 *
	 * @return KartenGeneratorKachel A tile fitting the current Position
	 */
	private KartenGeneratorUntergrund getUntergrundKachelZumGenerieren(int anzahlKachelnX, int anzahlKachelnY,
			Position generierePosition)
	{
		// Holt alle Wahrscheinlichkeiten von den Kacheln
		float[] wahrscheinlichkeiten = this.getWahrscheinlichkeitVonKacheln(anzahlKachelnX, anzahlKachelnY,
				generierePosition);
		if (KartenGeneratorUtils.getKachelDieGeneriertWerdenMuss(wahrscheinlichkeiten) >= 0)
		{
			return this.registrierteKacheln
					.get(KartenGeneratorUtils.getKachelDieGeneriertWerdenMuss(wahrscheinlichkeiten));
		}
		return this.registrierteKacheln
				.get(WahrscheinlichkeitsUtils.getIndexAusWahrscheinlichkeiten(wahrscheinlichkeiten));
	}

	/**
	 * Holt alle Wahrscheinlichkeiten der regestrierten Kacheln ein.
	 *
	 * @param anzahlKachelnX The maximum number tiles in X-Richtung
	 * @param anzahlKachelnY the maximum number tiles in Y-Richtung
	 * @param positionX      The X-Position to get the probability for
	 * @param positionY      The Y-Position to get the probability for
	 */
	private float[] getWahrscheinlichkeitVonKacheln(int anzahlKachelnX, int anzahlKachelnY, Position pos)
	{
		float[] wahrscheinlichkeit = new float[this.registrierteKacheln.size()];
		for (int i = 0; i < wahrscheinlichkeit.length; i++)
		{
			wahrscheinlichkeit[i] = this.registrierteKacheln.get(i).getVorkommensWahrscheinlichkeit(anzahlKachelnX,
					anzahlKachelnY, pos);
		}
		return wahrscheinlichkeit;
	}

	/**
	 * Regestriert die Kacheln die der Generator erzeugen soll.
	 *
	 * @param insRegister Die Kachel ins Register
	 */
	public void registriereKachel(KartenGeneratorUntergrund insRegister)
	{
		if (this.ueberpruefeRegistrierendeUntergrundKachel(insRegister))
		{
			this.registrierteKacheln.add(insRegister);
		} else
		{
			throw new IllegalArgumentException("Kacheln muessen mindestens ein begehbares Feld am Rand haben!");
		}
	}

	private boolean ueberpruefeFreiesRandFeld(KartenGeneratorUntergrund zuUeberpruefen)
	{
		for (int val = 0; val < Spielkonstanten.KACHEL_GROESSE_X; val++)
		{
			if (zuUeberpruefen.getInhalt()[val][0].istBetretbar()
					|| zuUeberpruefen.getInhalt()[Spielkonstanten.KACHEL_GROESSE_Y - 1][val].istBetretbar()
					|| zuUeberpruefen.getInhalt()[0][val].istBetretbar()
					|| zuUeberpruefen.getInhalt()[val][Spielkonstanten.KACHEL_GROESSE_X - 1].istBetretbar())
			{
				return true;
			}
		}
		return false;
	}

	private boolean ueberpruefeRegistrierendeUntergrundKachel(KartenGeneratorUntergrund zuUeberpruefen)
	{
		return this.ueberpruefeFreiesRandFeld(zuUeberpruefen);
	}
}