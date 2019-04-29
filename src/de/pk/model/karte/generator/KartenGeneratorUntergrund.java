package de.pk.model.karte.generator;

import de.pk.model.karte.generator.untergruende.KachelUntergrundWertigkeit;
import de.pk.model.position.Position;

/**
 * Repraesentiert die Kachel zum Generieren
 */
public abstract class KartenGeneratorUntergrund
{
	private KachelUntergrundWertigkeit[][] inhalt = null;

	/**
	 * <<<<<<< HEAD Der Inhalt wird in der Unterklasse beschlossen und von dort in
	 * den super-Konstruktor weitergegeben.
	 *
	 * @param inhalt
	 */
	protected KartenGeneratorUntergrund(KachelUntergrundWertigkeit[][] inhalt)
	{
		this.inhalt = inhalt;
	}

	@Override
	public abstract KartenGeneratorUntergrund clone();

	/**
	 * Bewegt die Kachel in die gegebene Richtung
	 *
	 * @param richtung The direction to drehe in
	 */
	public void drehe(Richtung richtung)
	{
		// Generiert den neuen Inhalt
		KachelUntergrundWertigkeit[][] neuerInhalt = new KachelUntergrundWertigkeit[this.inhalt.length][this.inhalt[0].length];
		for (int x = 0; x < this.inhalt[0].length; x++)
		{
			for (int y = 0; y < this.inhalt.length; y++)
			{
				if (richtung == Richtung.OSTEN)
				{
					// Tauscht X und Y abhaengig davon, ob links oder rechts
					// geaendert wird. Eins bis Maximum, minus die Werte bevor gedreht wird.
					neuerInhalt[x][this.inhalt.length - 1 - y] = this.inhalt[y][x];
				} else if (richtung == Richtung.WESTEN)
				{
					neuerInhalt[this.inhalt[0].length - 1 - x][y] = this.inhalt[y][x];
				}
			}
		}
		this.inhalt = neuerInhalt;
	}

	public KachelUntergrundWertigkeit[][] getInhalt()
	{
		return this.inhalt;
	}

	public KachelUntergrundWertigkeit getInhaltBei(Position pos)
	{
		if (!(((pos.getY() > -1) && (pos.getY() < this.getInhalt().length))
				&& ((pos.getX() > -1) && (pos.getX() < this.getInhalt()[0].length))))
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}
		return this.getInhalt()[pos.getY()][pos.getX()];
	}

	/**
	 * Bekommt die Wahrscheinlichkeit der Kachel die an der gegeben Position
	 * generiert wird. (Argumente gucken nach anderen mit der gleichen Struktur)
	 *
	 * @param maxGroesseX
	 * @param maxGroesseY
	 * @param position
	 * @return
	 */
	public abstract float getVorkommensWahrscheinlichkeit(int maxGroesseX, int maxGroesseY, Position position);

	/**
	 * Prueft ob eine Kachel eine Verbindung in einer Richtung
	 *
	 * @param richtung Die Richtung in der geprueft werden soll
	 *
	 * @return true falls eine Verbindung besteht, false wenn nicht
	 */
	public boolean pruefeObVerbindung(Richtung richtung)
	{
		// Variablen in Ordnung um sie fuer den Loop zu nutzen
		// Der Versatz in X und X Richtung um zu starten
		int xVersatz = 0;
		int yVersatz = 0;
		// Multiplizierer fuer den Loop, sie wiederholt ueber die
		// Dimensionen die benoetigt werden um die Richtung zu pruefen,
		// die geprueft werden soll.
		int xVarMult = 0;
		int yVarMult = 0;
		int reichweite = 0;
		switch (richtung)
		{
		// Setzt die Werte fuer die aktuelle Richtung
		case NORDEN:
			xVarMult = 1;
			reichweite = this.inhalt[0].length;
			break;
		case OSTEN:
			xVersatz = this.inhalt[0].length - 1;
			yVarMult = 1;
			reichweite = this.inhalt[0].length;
			break;
		case SUEDEN:
			yVersatz = this.inhalt.length - 1;
			xVarMult = 1;
			reichweite = this.inhalt.length;
			break;
		case WESTEN:
			yVarMult = 1;
			reichweite = this.inhalt.length;
			break;
		}

		for (int var = 0; var < reichweite; var++)
		{
			if (this.inhalt[(var * yVarMult) + yVersatz][(var * xVarMult) + xVersatz].istBetretbar())
			{
				return true;
			}
		}
		return false;
	}

	protected void setInhalt(KachelUntergrundWertigkeit[][] inhalt)
	{
		this.inhalt = inhalt;
	}

}
