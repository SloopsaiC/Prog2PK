package de.pk.control.karte.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.gegner.Gegner;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.gegner.GegnerArt;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.karte.generator.untergruende.KachelUntergrundWertigkeit;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrund;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrundMitRichtung;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.Kachel;
import de.pk.utils.AusnahmeNachrichten;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.WahrscheinlichkeitsUtils;
import de.pk.utils.karte.generator.KartenGeneratorUntergrundKonstanten;
import de.pk.utils.karte.generator.KartenGeneratorUtils;

public class KartenGenerator
{
	public static final Richtung STANDARD_DREH_RICHTUNG = Richtung.OSTEN;
	public static final int MAX_DREHUNGEN_UNTERGRUND = 3; // Die vierte Drehung wuerde die Kachel wieder in den
															// Grundzustand versetzen
	private List<KartenGeneratorUntergrund> registrierteKacheln = null;

	/**
	 * Erstellt einen Generator welcher die gegebenen Untergruende verwendet
	 *
	 * @param kacheln Die Untergruende die dieser Generator verwenden wird um neue
	 *                zu generieren
	 */
	public KartenGenerator(ArrayList<KartenGeneratorUntergrund> kacheln)
	{
		this.registrierteKacheln = Collections.synchronizedList(kacheln);
	}

	/**
	 * Erstellt einen Generator welcher die gegebenen Untergruende verwendet
	 *
	 * @param kacheln Die Untergruende die dieser Generator verwenden wird um neue
	 *                zu generieren
	 */
	public KartenGenerator(KartenGeneratorUntergrund... generatorKacheln)
	{
		this(new ArrayList<>(Arrays.asList(generatorKacheln)));
	}

	/**
	 * Dreht einen KartenGeneratorUntergrundMitRichtung "zu" solange bis eine
	 * Verbindung zu "von" besteht.
	 *
	 * @param von      Der Untergrund zu dem eine Verbindung hergestellt werden soll
	 * @param zu       Der Untergrund welcher die Verbindung herstellen soll
	 * @param Richtung die Richtung in der "zu" von "von" aus gesehen ist
	 *
	 * @return Der gedrehte Untergrund
	 */
	private KartenGeneratorUntergrundMitRichtung dreheBisVerbindung(KartenGeneratorUntergrundMitRichtung von,
			KartenGeneratorUntergrundMitRichtung zu, Richtung richtung)
	{
		if (!KartenGeneratorUtils.pruefeVerbindung(von, zu, richtung))
		{
			// Solange drehen bis eine Verbindung besteht oder der Untergrund ein Mal
			// gedreht wurde
			for (int i = 0; i < KartenGenerator.MAX_DREHUNGEN_UNTERGRUND; i++)
			{
				if (!KartenGeneratorUtils.pruefeVerbindung(von, zu, richtung))
				{
					zu.drehe(KartenGenerator.STANDARD_DREH_RICHTUNG);
				} else
				{
					return zu;
				}
			}
		} else
		{
			return zu;
		}
		// Es konnte nach drei Mal drehen keine Verbindung hergstellt werden -> Es ist
		// fuer diese Methode nicht moeglich eine Verbindung herzustellen
		throw new IllegalStateException(AusnahmeNachrichten.KARTEN_GENERATOR_KANN_KEINE_VERBINDUNG_HERSTELLEN);
	}

	/**
	 * Generiert eine neue Kachel in gegebenener Richtung von gegebener Position aus
	 * gesehen. Hierbei wird zufaellig ein Untergrund bestimmt und dieser so lange
	 * gedreht bis er eine Verbindung zu dem vorherigen Untergrund (Der von dem aus
	 * generiert wird) hat. Ausserdem werden eventuell Gegner auf die Kachel
	 * gesetzt.
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
		KartenGeneratorUntergrundMitRichtung untergrund = this.generiereNeueUntergrundKachel(anzahlKachelnX,
				anzahlKachelnY, aktuellePosition, richtung, aktuelleKachel.getUntergrund());
		Kachel generiert = new Kachel(untergrund);
		if (ThreadLocalRandom.current().nextFloat() <= KartenGeneratorUntergrundKonstanten.WAHRSCHEINLICHKEIT_GEGNER)
		{
			Position zufaelligePosition = new Position(
					ThreadLocalRandom.current().nextInt(Spielkonstanten.KACHEL_GROESSE_X),
					ThreadLocalRandom.current().nextInt(Spielkonstanten.KACHEL_GROESSE_Y));
			if (generiert.getUntergrundBei(zufaelligePosition).istBetretbar())
			{
				generiert.stelleAufKachel(zufaelligePosition, new Gegner(GegnerArt.ZOMBIE, 1f));
			}
		}
		return generiert;
	}

	/**
	 * Generiert einen Untergrund fuer eine Kachel passend zur gegebenen Kachel in
	 * der bestimmten Richtung. Die Kachelwahrscheinlichkeit ist abhaengig von der
	 * aktuellen Position
	 *
	 * @param anzahlKachelnX      Maximale Anzahl der Kacheln in X-Richtung
	 * @param anzahlKachelnY      Maximale Anzahl der Kacheln in Y-Richtung
	 * @param aktuellePosition    Die Position in der Kachel
	 * @param richtung            Die Richtung in der die neue Kachel generiert wird
	 * @param aktuellerUntergrund Die betroffende Kachel
	 *
	 * @return KartenGeneratorKachel: Die Kachel die generiert wurde
	 */
	public KartenGeneratorUntergrundMitRichtung generiereNeueUntergrundKachel(int anzahlKachelnX, int anzahlKachelnY,
			Position aktuellePosition, Richtung richtung, KartenGeneratorUntergrundMitRichtung aktuellerUntergrund)
	{
		if (this.registrierteKacheln.size() < 1)
		{
			throw new IllegalStateException(AusnahmeNachrichten.KARTEN_GENERATOR_KEINE_REGISTRIERTEN_KACHELN);
		}
		// Generiert einen zufaelligen Untergrund
		KartenGeneratorUntergrundMitRichtung generiert = this.getUntergrundKachelZumGenerieren(anzahlKachelnX,
				anzahlKachelnY, aktuellePosition.addiere(richtung.getVersatz()));
		try
		{
			return this.dreheBisVerbindung(aktuellerUntergrund, generiert, richtung);
		} catch (IllegalStateException nichtMoeglich)
		{
			return this.generiereNeueUntergrundKachel(anzahlKachelnX, anzahlKachelnY, aktuellePosition, richtung,
					aktuellerUntergrund);
		}
	}

	/**
	 * Generiert eine vordefinierte Startkachel um ein sicheren Einstieg in den
	 * Dungeon zu erlauben.
	 *
	 * @return Die vordefinierte Startkachel.
	 */
	public Kachel generiereStartKachel()
	{
		return new Kachel(new KartenGeneratorUntergrundMitRichtung(KartenGeneratorUntergrund.START, Richtung.NORDEN));
	}

	private int getIndexDerZuGenerierendenKachel(float[] wahrscheinlichkeiten)
	{
		// Pruefen ob eine Kachel eine maximale Wahrscheinlichkeit angegeben hat
		int indexMitMaximalerWahrscheinlichkeit = KartenGeneratorUtils
				.getIndexMitMaximalerWahrscheinlichkeit(wahrscheinlichkeiten);
		if (indexMitMaximalerWahrscheinlichkeit >= 0)
		{
			return indexMitMaximalerWahrscheinlichkeit;
		}
		// Sonst per Zufall bestimmen
		return WahrscheinlichkeitsUtils.getIndexAusWahrscheinlichkeiten(wahrscheinlichkeiten);
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
	 * @return KartenGeneratorKachel Eine Kachel die auf die momentane Position
	 *         passt
	 */
	private KartenGeneratorUntergrundMitRichtung getUntergrundKachelZumGenerieren(int anzahlKachelnX,
			int anzahlKachelnY, Position generierePosition)
	{
		// Berechnet alle Wahrscheinlichkeiten der Kacheln
		float[] wahrscheinlichkeiten = this.getWahrscheinlichkeitVonKacheln(anzahlKachelnX, anzahlKachelnY,
				generierePosition);
		return new KartenGeneratorUntergrundMitRichtung(
				this.registrierteKacheln.get(this.getIndexDerZuGenerierendenKachel(wahrscheinlichkeiten)),
				Richtung.NORDEN);
	}

	/**
	 * Holt alle Wahrscheinlichkeiten der regestrierten Kacheln ein.
	 *
	 * @param anzahlKachelnX Die maximale Anzahl an Kacheln in X-Richtung
	 * @param anzahlKachelnY Die maximale Anzahl an Kacheln in Y-Richtung
	 * @param pos            Die Position fuer welche die Wahrscheinlichkeiten
	 *                       generiert werden sollen
	 * @return Die Wahrscheinlichkeiten der Kacheln fuer die gegebene Position
	 */
	private float[] getWahrscheinlichkeitVonKacheln(int anzahlKachelnX, int anzahlKachelnY, Position pos)
	{
		float[] wahrscheinlichkeiten = new float[this.registrierteKacheln.size()];
		for (int i = 0; i < wahrscheinlichkeiten.length; i++)
		{
			wahrscheinlichkeiten[i] = this.registrierteKacheln.get(i).getVorkommensWahrscheinlichkeit(pos,
					anzahlKachelnX, anzahlKachelnY);
		}
		return wahrscheinlichkeiten;
	}

	/**
	 * Registriert die Kacheln die der Generator erzeugen soll.
	 *
	 * @param zuRegistrieren Die Kachel welche registriert werden soll
	 */
	public void registriereKachel(KartenGeneratorUntergrund zuRegistrieren)
	{
		if (this.ueberpruefeRegistrierendeUntergrundKachel(zuRegistrieren))
		{
			this.registrierteKacheln.add(zuRegistrieren);
		} else
		{
			throw new IllegalArgumentException(AusnahmeNachrichten.KARTEN_GENERATOR_KACHEL_KEIN_FREIES_FELD);
		}
	}

	/**
	 * Ueberprueft ob ein Untergrund ein freies Randfeld hat. Dies ist noetig um ihn
	 * generieren zu koennen, da sonst kein Spieler ihn betreten koennte.
	 *
	 * @param zuUebepruefen Der zu ueberpruefende Untergrund
	 *
	 * @return true, falls der Untergrund ein freies Randfeld hat, sonst false
	 */
	private boolean ueberpruefeFreiesRandFeld(KartenGeneratorUntergrund zuUeberpruefen)
	{
		for (int val = 0; val < Spielkonstanten.KACHEL_GROESSE_X; val++)
		{
			KachelUntergrundWertigkeit[][] inhalt = zuUeberpruefen.getInhaltVonRichtung(Richtung.NORDEN);
			if (inhalt[val][0].istBetretbar() || inhalt[Spielkonstanten.KACHEL_GROESSE_Y - 1][val].istBetretbar()
					|| inhalt[0][val].istBetretbar()
					|| inhalt[val][Spielkonstanten.KACHEL_GROESSE_X - 1].istBetretbar())
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