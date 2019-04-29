package de.pk.model.gegenstaende;

import de.pk.control.gegenstaende.GegenstandsHaufen;
import de.pk.model.gegenstaende.spezifikationen.Stapelbar;

/**
 * Ein GegenstandsHaufen besteht aus mehreren Gegenstaenden gleicher Art als
 * "Haufen" (Stack). Er beinhaltet also Stapelbares und realisiert die
 * Eigenschaft des stapelns, indem er sich merkt, aus wie vielen Gegenstaenden
 * der Haufen besteht.
 */
public class GegenstandsHaufenModell
{

	private final Stapelbar inhalt;
	private int menge = 0;
	private final int maximaleAnzahl;

	/**
	 * Erstellt einen neuen GegenstandsHaufen mit inhalt als enthaltene Gegenstaende
	 * des Stapels der Anzahl menge und maximaler Menge maximaleAnzahl.
	 *
	 * @param inhalt         Die Art von Gegenstands (Stapelbares), aus dem der
	 *                       Haufen bestehen soll.
	 * @param menge          Die Menge von Gegenstaenden des Typs inhalt, mit der
	 *                       der Haufen erstellt werden soll.
	 * @param maximaleAnzahl Die maximale Anzahl an Gegenstaenden, aus denen der
	 *                       Haufen bestehen kann.
	 * @throws IllegalArgumentException wenn die gewuenschte Menge groesser ist, als
	 *                                  die maximale Anzahl.
	 */
	public GegenstandsHaufenModell(Stapelbar inhalt, int menge, int maximaleAnzahl) throws IllegalArgumentException
	{
		GegenstandsHaufen.pruefeMengeGegenMaximum(menge, maximaleAnzahl);
		this.inhalt = inhalt;
		this.menge = menge;
		this.maximaleAnzahl = maximaleAnzahl;
	}

	/**
	 * Gibt den Inhalt des Haufens wieder.
	 *
	 * @return Stapelbares (Gegenstand), aus dem der Haufen besteht.
	 */
	public Stapelbar getInhalt()
	{
		return this.inhalt;
	}

	/**
	 * Gibt die maximale Anzahl wieder, die der Haufen beinhalten kann.
	 *
	 * @return maximale Anzahl an Inhalt.
	 */
	public int getMaximaleAnzahl()
	{
		return this.maximaleAnzahl;
	}

	/**
	 * Gibt die aktuell vorhandene Menge an Inhalt wieder.
	 *
	 * @return Die aktuelle Anzahl an Inhalt.
	 */
	public int getMenge()
	{
		return this.menge;
	}

	/**
	 * Legt diesem Haufen eine neue Menge an Inhalt fest, wobei die Art des Inhalts
	 * unveraendert leibt.
	 *
	 * @param neueMenge Die neue Anzahl zu beinhaltender Gegenstaende.
	 * @throws IllegalArgumentException wenn die gewuenschte Menge groesser ist, als
	 *                                  die maximale Anzahl.
	 */
	public void setMenge(int neueMenge) throws IllegalArgumentException
	{
		GegenstandsHaufen.pruefeMengeGegenMaximum(neueMenge, this.maximaleAnzahl);
		this.menge = neueMenge;
	}

}
