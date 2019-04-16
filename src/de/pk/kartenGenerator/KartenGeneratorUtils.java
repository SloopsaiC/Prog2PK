package de.pk.kartenGenerator;

public class KartenGeneratorUtils
{

	static boolean pruefeObenZuUntenVerbindung(KartenGeneratorKachel von, KartenGeneratorKachel zu, Richtung richtung)
	{
		// Gleiches Verfahren wie bei OSTEN/WESTEN, nur jetzt fuer NORDEN/SUEDEN
		int vonY = 0;
		int zuY = KartenGeneratorKachelInterface.KACHEL_GROESSE_Y - 1;
		if (richtung == Richtung.SUEDEN)
		{
			int puffer = vonY;
			vonY = zuY;
			zuY = puffer;
		}
		// Wiederholen des Vorgangs mit den X-Werten um alle zu pruefen
		for (int x = 0; x < KartenGeneratorKachelInterface.KACHEL_GROESSE_X; x++)
		{
			if (von.getInhalt()[vonY][x].istBetretbar() && zu.getInhalt()[zuY][x].istBetretbar())
			{
				return true;
			}
		}
		return false;
	}

	static boolean pruefeLinksZuRechtsVerbindung(KartenGeneratorKachel von, KartenGeneratorKachel zu,
			Richtung richtung)
	{
		// Der X-Wert der Kachel, von der aus geguckt wird
		// Wenn die Richtung "WESTEN" ist, wird die linke Seite (0) der "vom-Kachel" 
		// mit der OSTEN Seite (maximum Wert) der "zu-Kachel" verglichen
		int vonX = 0;
		int zuX = KartenGeneratorKachelInterface.KACHEL_GROESSE_X - 1;
		// Tauschen der beiden Werte wenn die Verbindung OSTEN ist
		if (richtung == Richtung.OSTEN)
		{
			int puffer = vonX;
			vonX = zuX;
			zuX = puffer;
		}
		// Wiederholen des Vorgangs mit den Y-Werten um alle zu pruefen
		for (int y = 0; y < KartenGeneratorKachelInterface.KACHEL_GROESSE_Y; y++)
		{
			if (von.getInhalt()[y][vonX].istBetretbar() && zu.getInhalt()[y][zuX].istBetretbar())
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Prueft ob zwei bestimmte Kacheln eine Verbindung haben und gibt die Richtung an
	 *
	 * @param von      Die Kachel "von der" aus geguckt wird
	 * @param zu       die Kachel "zu der" geguckt wird
	 * @param richtung The direction
	 *
	 * @return "true" wenn eine Verbindung besteht, anderfalls "false"
	 */
	static boolean pruefeVerbindung(KartenGeneratorKachel von, KartenGeneratorKachel zu, Richtung richtung)
	{
	
		switch (richtung)
		{
	                case NORDEN:
	                case SUEDEN:
			return pruefeObenZuUntenVerbindung(von, zu, richtung);
	                case OSTEN:
	                case WESTEN:
			return pruefeLinksZuRechtsVerbindung(von, zu, richtung);
	                default:
			return false;
		}
	}

	/**
	 * Bestimmt ein Verzeichnis, basierend auf den Werten in dem Argument.
	 * Das Argument beinhaltet Werte, die auf 100% skaliert und dann "verzufaelligt" werden
	 * Basiert auf der Gewichtung der Wahrscheinlichkeiten
	 */
	static int getIndexVonWahrscheinlichkeit(float[] wahrscheinlichkeit)
	{
		// Summiert alle Werte
		float gesamtWahrscheinlichkeit = 0f;
		for (Float f : wahrscheinlichkeit)
		{
			gesamtWahrscheinlichkeit += f;
		}
		// Generiert einen Wert der > 0 aber < der Summe der Werte ist.
		float zufall = (float) (Math.random() * gesamtWahrscheinlichkeit);
		float aktuelleSumme = 0f;
		// Addiert alle Werte, bis die Summe groesser ist als die ZufallsWerte
		// Die Zufallswerte betonen die dann die aktuellen Werte
		for (int i = 0; i < wahrscheinlichkeit.length; i++)
		{
			aktuelleSumme += wahrscheinlichkeit[i];
			if (aktuelleSumme >= zufall)
			{
				// Gibt das Verzeichnis zurueck
				return i;
			}
		}
		// falls etwas fehlschlaegt wird es allen zurueckgegeben (sollte nicht passieren)
		return -1;
	}

	/**
	 * Prueft ob eine Kachel den hoechst moeglichen Wert wiedergibt (1), dies wird
	 * in jedem Fall generiert.
	 *
	 * @param wahrscheinlichkeit All probabilities to be checked
	 */
	static int getKachelDieGeneriertWerdenMuss(float[] wahrscheinlichkeit)
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
	     * Bekommt eienn Versatz, der zu der Position addiert wird, um eine
	     * Position in der bestimmten Richtung zu bekommen.
	 *
	 * @param richtung Die Richtung
	 *
	 * @return Array mit laenge 2 (2 dimensionen) um die Position in der
	 *         gegebenen Richtung zu Generieren
	 */
	static int[] getVersatzVonRichtung(Richtung richtung)
	{
		switch (richtung)
		{
		case NORDEN:
			return new int[]
			{ 0, -1 };
		case OSTEN:
			return new int[]
			{ 1, 0 };
		case SUEDEN:
			return new int[]
			{ 0, 1 };
		case WESTEN:
			return new int[]
			{ -1, 0 };
		default:
			return new int[]
			{ 0, 0 };
		}
	}

}
