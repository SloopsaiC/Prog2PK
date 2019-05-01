package de.pk.utils.karte.generator;

import de.pk.model.karte.generator.KartenGeneratorUntergrund;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.karte.generator.untergruende.KachelUntergrundWertigkeit;
import de.pk.model.position.Position;
import de.pk.model.position.Vektor;
import de.pk.utils.PositionsUtils;
import de.pk.utils.Spielkonstanten;

public class KartenGeneratorUtils
{

	/**
	 * Prueft ob eine Kachel den hoechst moeglichen Wert wiedergibt
	 * (Float.MAX_VALUE), dies wird in jedem Fall generiert.
	 *
	 * @param wahrscheinlichkeit Alle Wahrscheinlichkeiten die ueberprueft werden
	 *                           sollen
	 */
	public static int getKachelDieGeneriertWerdenMuss(float[] wahrscheinlichkeit)
	{
		for (int i = 0; i < wahrscheinlichkeit.length; i++)
		{
			if (wahrscheinlichkeit[i] == Float.MAX_VALUE)
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * Bekommt einen Versatz, der zu der Position addiert wird, um eine Position in
	 * der bestimmten Richtung zu bekommen.
	 *
	 * @param richtung Die Richtung
	 *
	 * @return Array mit laenge 2 (2 dimensionen) um die Position in der gegebenen
	 *         Richtung zu Generieren
	 */
	public static Vektor getVersatzVonRichtung(Richtung richtung)
	{
		switch (richtung)
		{
		case NORDEN:
			return new Vektor(0, -1);
		case OSTEN:
			return new Vektor(1, 0);
		case SUEDEN:
			return new Vektor(0, 1);
		case WESTEN:
			return new Vektor(-1, 0);
		default:
			return new Vektor(0, 0);
		}
	}

	/**
	 * Iteriert solange die Position mit dem verschiebeVektor eine illegale Position
	 * erstellt wird. Es wird geprueft ob die danach aktuellePosition und ihr
	 * Gegenstueck, dass auf der Position ist, welche nach Verschiebung um den
	 * checkVektor entsteht, betretbar ist. Prueft somit die Verbindung zwischen
	 * zwei KartenGeneratorUntergruenden.
	 *
	 * @param verschiebeVektor Der Vektor um den die aktuelle Position pro Iteration
	 *                         verschoben wird
	 * @param checkVektor      Der Vektor um den die aktuelle Position verschoben
	 *                         wird welche den "Nachbarn" der Position definiert
	 * @param aktuellePos      Die Anfangsposition des Ueberpruefens
	 * @param von              Die Kachel von der aus geschaut wird
	 * @param zu               Die Kachel zu der geschaut wird
	 */
	private static boolean iteriereUndPruefeVerbindung(Vektor verschiebeVektor, Vektor checkVektor,
			Position aktuellePos, KartenGeneratorUntergrund von, KartenGeneratorUntergrund zu)
	{
		try
		{
			while (aktuellePos != null)
			{
				KachelUntergrundWertigkeit aktuellerUntergrund = von.getInhaltBei(aktuellePos);
				if (aktuellerUntergrund.istBetretbar() || zu
						.getInhaltBei(PositionsUtils
								.getPositionAufKachelAusAbsoluterPosition(aktuellePos.addiere(checkVektor)))
						.istBetretbar())
				{
					return true;
				}
				aktuellePos.addiere(verschiebeVektor);
			}
		} catch (IllegalArgumentException fertig)
		{
			// Wir sind fertig, denn die momentane Position ist nicht laenger gueltig
		}
		return false;
	}

	/**
	 * Prueft ob zwei bestimmte Kacheln eine Verbindung haben und gibt die Richtung
	 * an
	 *
	 * @param von      Die Kachel "von der" aus geguckt wird
	 * @param zu       die Kachel "zu der" geguckt wird
	 * @param richtung Die Richtung
	 *
	 * @return "true" wenn eine Verbindung besteht, anderfalls "false"
	 */
	public static boolean pruefeVerbindung(KartenGeneratorUntergrund von, KartenGeneratorUntergrund zu,
			Richtung richtung)
	{
		Vektor verschiebeVektor = null;
		Vektor checkVektor = null;
		Position aktuellePos = null;
		switch (richtung)
		{
		case NORDEN:
			checkVektor = new Vektor(0, 1);
			verschiebeVektor = new Vektor(1, 0);
			aktuellePos = new Position(0, 0);
			break;
		case SUEDEN:
			checkVektor = new Vektor(0, -1);
			verschiebeVektor = new Vektor(1, 0);
			aktuellePos = new Position(0, Spielkonstanten.KACHEL_GROESSE_Y - 1);
			break;
		case OSTEN:
			checkVektor = new Vektor(1, 0);
			verschiebeVektor = new Vektor(0, 1);
			aktuellePos = new Position(Spielkonstanten.KACHEL_GROESSE_X - 1, 0);
			break;
		case WESTEN:
			checkVektor = new Vektor(-1, 0);
			verschiebeVektor = new Vektor(0, 1);
			aktuellePos = new Position(0, 0);
			break;
		default:
			return false;
		}
		return KartenGeneratorUtils.iteriereUndPruefeVerbindung(verschiebeVektor, checkVektor, aktuellePos, von, zu);
	}
}
