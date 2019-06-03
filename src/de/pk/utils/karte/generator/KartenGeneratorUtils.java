package de.pk.utils.karte.generator;

import de.pk.model.karte.generator.Richtung;
import de.pk.model.karte.generator.untergruende.KachelUntergrundWertigkeit;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrundMitRichtung;
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
	 * @return Der Index der Kachel welche die maximale Wahrscheinlichkeit hat, oder
	 *         -1, falls keine solche Kachel existert
	 */
	public static int getIndexMitMaximalerWahrscheinlichkeit(float[] wahrscheinlichkeit)
	{
		for (int i = 0; i < wahrscheinlichkeit.length; i++)
		{
			if (wahrscheinlichkeit[i] >= KartenGeneratorUntergrundKonstanten.MAXIMALE_GENERIERUNGS_WAHRSCHEINLICHKEIT)
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * Iteriert solange die Position mit dem verschiebeVektor bis eine illegale
	 * Position erstellt wird. Es wird geprueft ob die danach aktuellePosition und
	 * ihr Gegenstueck, dass auf der Position ist, welche nach Verschiebung um den
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
			Position aktuellePos, KartenGeneratorUntergrundMitRichtung von, KartenGeneratorUntergrundMitRichtung zu)
	{
		try
		{
			while (aktuellePos != null)
			{
				KachelUntergrundWertigkeit vonUntergrund = von.getInhaltBei(aktuellePos);
				KachelUntergrundWertigkeit zuUntergrund = zu.getInhaltBei(PositionsUtils
						.getPositionAufKachelAusAbsoluterPosition(aktuellePos.addiere(checkVektor.getNegierung())));
				// Check Vektor wird negiert, da wir hier von der "zu" Kachel aus schauen
				if (vonUntergrund.istBetretbar() && zuUntergrund.istBetretbar())
				{
					// Zwei benachbarte Untergruende sind betretbar -> Verbindung
					return true;
				}
				// Position um den verschiebe Vektor verschieben
				aktuellePos.addiere(verschiebeVektor);
			}
		} catch (IllegalArgumentException fertig)
		{
			// Wir sind fertig, denn die momentane Position ist nicht laenger gueltig
		}
		return false;
	}

	/**
	 * Prueft ob zwei bestimmte Kacheln eine Verbindung haben.
	 *
	 * @param von      Die Kachel "von der" aus geguckt wird
	 * @param zu       die Kachel "zu der" geguckt wird
	 * @param richtung Die Richtung
	 *
	 * @return "true" wenn eine Verbindung besteht, anderfalls "false"
	 */
	public static boolean pruefeVerbindung(KartenGeneratorUntergrundMitRichtung von,
			KartenGeneratorUntergrundMitRichtung zu, Richtung richtung)
	{
		Vektor verschiebeVektor = richtung.getVerschiebeVektor();
		Vektor checkVektor = richtung.getVersatz();
		Position aktuellePos = null;
		switch (richtung)
		{
		case NORDEN:
			// Fallthrough, gleiche Startposition
		case WESTEN:
			aktuellePos = new Position(0, 0);
			break;
		case SUEDEN:
			aktuellePos = new Position(0, Spielkonstanten.KACHEL_GROESSE_Y - 1);
			break;
		case OSTEN:
			aktuellePos = new Position(Spielkonstanten.KACHEL_GROESSE_X - 1, 0);
			break;
		default:
			return false;
		}
		return KartenGeneratorUtils.iteriereUndPruefeVerbindung(verschiebeVektor, checkVektor, aktuellePos, von, zu);
	}
}
