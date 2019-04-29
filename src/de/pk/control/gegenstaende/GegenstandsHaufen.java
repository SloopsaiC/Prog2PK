package de.pk.control.gegenstaende;

import de.pk.model.gegenstaende.GegenstandsHaufenModell;
import de.pk.model.gegenstaende.spezifikationen.Stapelbar;
import de.pk.utils.Spielkonstanten;

public class GegenstandsHaufen
{

	/**
	 * Prueft, ob die Menge groesser als das Maximum oder kleiner 0 ist.
	 *
	 * @param menge   zu ueberpruefende Menge
	 * @param maximum maximale Anzahl, die menge nicht ueberschreiten darf
	 *
	 * @throws IllegalArgumentException wenn menge < maximum oder menge < 0
	 */
	public static void pruefeMengeGegenMaximum(int menge, int maximum) throws IllegalArgumentException
	{
		if ((menge > maximum) || (menge < 0))
		{
			// TODO: Exception Message
			throw new IllegalArgumentException();
		}
	}

	/** Das Modell dieses Haufens */
	private final GegenstandsHaufenModell modell;

	public GegenstandsHaufen(Stapelbar inhalt, int menge) throws IllegalArgumentException
	{
		this(inhalt, menge, Spielkonstanten.STANDARD_MAX_ANZAHL_INHALT_GEGENSTANDS_HAUFEN);
	}

	public GegenstandsHaufen(Stapelbar inhalt, int menge, int maximaleAnzahl) throws IllegalArgumentException
	{
		this.modell = new GegenstandsHaufenModell(inhalt, menge, maximaleAnzahl);
	}

	/**
	 * Entnimmt eine bestimmte Menge aus diesem GegenstandsHaufen und gibt einen
	 * neuen mit der spezifizierten Anzahl zurueck.
	 * 
	 * @param anzahl Die Anzahl des Gegenstands im neuen Haufen
	 * 
	 * @return Ein GegenstandsHaufen mit der spezifizierten Anzahl, sollte dieser
	 *         Haufen genug Gegenstaende enthalten
	 */
	public GegenstandsHaufen entnehmen(int anzahl)
	{
		try
		{
			this.modell.setMenge(this.modell.getMenge() - anzahl);
		} catch (IllegalArgumentException nichtGenugMenge)
		{
			return null;
		}
		return new GegenstandsHaufen(this.modell.getInhalt(), anzahl, this.modell.getMaximaleAnzahl());
	}

	/**
	 * Gibt den Inhalt dieses Haufens wieder
	 * 
	 * @return Stapelbar Der Inhalt dieses Haufens
	 */
	public Stapelbar getInhalt()
	{
		return this.modell.getInhalt();
	}

	/**
	 * Gibt die Menge die in diesem Haufen gehalten wird wieder
	 * 
	 * @return Die Menge in diesem Haufen
	 */
	public int getMenge()
	{
		return this.modell.getMenge();
	}

	/**
	 * Fuegt einen GegenstandHaufen zu diesem hinzu, sollte der Inhalt gleich sein.
	 * Sollte dieser Haufen nicht die benoetigte maximal Groesse haben um alles
	 * aufzunehmen, wird der Rest zurueck an den Aufrufer gegeben Dem Parameter wird
	 * die hinzugetaende Menge entnommen
	 * 
	 * @param zusatzInhalt Der Inhalt der diesem Haufen hinzugefuegt wird
	 * 
	 * @return Das was ueberbleibt, sollte dieser Haufen voll sein
	 */
	public GegenstandsHaufen hinzutuen(GegenstandsHaufen zusatzInhalt) throws IllegalArgumentException
	{
		if (!(this.modell.getInhalt().equals(zusatzInhalt.getInhalt())))
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}
		try
		{
			this.modell.setMenge(this.getMenge() + zusatzInhalt.getMenge());
			zusatzInhalt.entnehmen(zusatzInhalt.getMenge());
		} catch (IllegalArgumentException ueberfluss)
		{
			return this.ueberflussBeimHinzutuen(zusatzInhalt);
		}
		return null;
	}

	/**
	 * Sollte beim hinzutuen von Gegenstaenden dieser Haufen ueberfuellt werden,
	 * wird das hier behandelt
	 * 
	 * @param Der Haufen der diesen Haufen ueberfuellt
	 * 
	 * @return Der Haufen mit der Menge die ueberbleibt, wenn dieser Haufen auf
	 *         Maximalgroesse aufgefuellt wird
	 */
	private GegenstandsHaufen ueberflussBeimHinzutuen(GegenstandsHaufen ueberfluss)
	{
		ueberfluss.entnehmen(this.modell.getMaximaleAnzahl() - this.modell.getMenge());
		this.modell.setMenge(this.modell.getMaximaleAnzahl());
		return ueberfluss;
	}

}
