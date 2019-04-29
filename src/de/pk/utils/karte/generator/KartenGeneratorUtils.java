package de.pk.utils.karte.generator;

import de.pk.model.karte.generator.KartenGeneratorUntergrund;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.Vektor;
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

	private static boolean pruefeLinksZuRechtsVerbindung(KartenGeneratorUntergrund von, KartenGeneratorUntergrund zu,
			Richtung richtung)
	{
		// Der X-Wert der Kachel, von der aus geguckt wird
		// Wenn die Richtung "WESTEN" ist, wird die linke Seite (0) der "von-Kachel"
		// mit der OSTEN Seite (maximum Wert) der "zu-Kachel" verglichen
		int vonX = 0;
		int zuX = Spielkonstanten.KACHEL_GROESSE_X - 1;
		// Tauschen der beiden Werte wenn die Verbindung OSTEN ist
		if (richtung == Richtung.OSTEN)
		{
			int puffer = vonX;
			vonX = zuX;
			zuX = puffer;
		}
		// Wiederholen des Vorgangs mit den Y-Werten um alle zu pruefen
		for (int y = 0; y < Spielkonstanten.KACHEL_GROESSE_Y; y++)
		{
			if (von.getInhalt()[y][vonX].istBetretbar() && zu.getInhalt()[y][zuX].istBetretbar())
			{
				return true;
			}
		}
		return false;
	}

	private static boolean pruefeObenZuUntenVerbindung(KartenGeneratorUntergrund von, KartenGeneratorUntergrund zu,
			Richtung richtung)
	{
		// Gleiches Verfahren wie bei OSTEN/WESTEN, nur jetzt fuer NORDEN/SUEDEN
		int vonY = 0;
		int zuY = Spielkonstanten.KACHEL_GROESSE_Y - 1;
		if (richtung == Richtung.SUEDEN)
		{
			int puffer = vonY;
			vonY = zuY;
			zuY = puffer;
		}
		// Wiederholen des Vorgangs mit den X-Werten um alle zu pruefen
		for (int x = 0; x < Spielkonstanten.KACHEL_GROESSE_X; x++)
		{
			if (von.getInhalt()[vonY][x].istBetretbar() && zu.getInhalt()[zuY][x].istBetretbar())
			{
				return true;
			}
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

		switch (richtung)
		{
		case NORDEN:
		case SUEDEN:
			return KartenGeneratorUtils.pruefeObenZuUntenVerbindung(von, zu, richtung);
		case OSTEN:
		case WESTEN:
			return KartenGeneratorUtils.pruefeLinksZuRechtsVerbindung(von, zu, richtung);
		default:
			return false;
		}
	}
}
