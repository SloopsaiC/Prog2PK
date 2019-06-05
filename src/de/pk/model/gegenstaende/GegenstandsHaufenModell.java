package de.pk.model.gegenstaende;

import de.pk.model.gegenstaende.spezifikationen.Stapelbar;
import de.pk.utils.AusnahmeNachrichten;

/**
 * Modell (Datenhaltungsklasse) eines GegenstandsHaufens.
 * 
 * @see de.pk.control.gegenstaende.GegenstandsHaufen
 *
 * @author Mattheo
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
		this.pruefeMengeAufPlausibilitaet(menge, maximaleAnzahl);
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
	 * Prueft, ob die Menge groesser als das Maximum oder kleiner 0 ist.
	 *
	 * @param menge   zu ueberpruefende Menge
	 * @param maximum maximale Anzahl, die menge nicht ueberschreiten darf
	 *
	 * @throws IllegalArgumentException wenn menge < maximum oder menge < 0
	 */
	private void pruefeMengeAufPlausibilitaet(int menge, int maximum) throws IllegalArgumentException
	{
		if ((menge > maximum) || (menge < 0))
		{
			throw new IllegalArgumentException(
					AusnahmeNachrichten.GEGENSTANDS_HAUFEN_MENGE_IST_NICHT_GUELTIG + maximum);
		}
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
		this.pruefeMengeAufPlausibilitaet(neueMenge, this.maximaleAnzahl);
		this.menge = neueMenge;
	}

}
