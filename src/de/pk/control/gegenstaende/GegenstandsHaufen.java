package de.pk.control.gegenstaende;

import de.pk.model.gegenstaende.GegenstandsHaufenModell;
import de.pk.model.gegenstaende.spezifikationen.Stapelbar;
import de.pk.utils.AusnahmeNachrichten;
import de.pk.utils.Spielkonstanten;

/**
 * Ein GegenstandsHaufen besteht aus mehreren Gegenstaenden gleicher Art als
 * "Haufen". Er beinhaltet also Stapelbares und realisiert die Eigenschaft des
 * stapelns, indem er sich merkt, aus wie vielen Gegenstaenden der Haufen
 * besteht.
 *
 * @see de.pk.model.gegenstaende.GegenstandsHaufenModell
 *
 * @author Mattheo
 */
public class GegenstandsHaufen
{

	/** Das Modell dieses Haufens */
	private final GegenstandsHaufenModell modell;

	public GegenstandsHaufen(Stapelbar inhalt, int menge)
	{
		this(inhalt, menge, Spielkonstanten.STANDARD_MAX_ANZAHL_INHALT_GEGENSTANDS_HAUFEN);
	}

	public GegenstandsHaufen(Stapelbar inhalt, int menge, int maximaleAnzahl)
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
			throw new IllegalArgumentException(AusnahmeNachrichten.GEGENSTANDS_HAUFEN_HINZUTUEN_NICHT_RICHTIGER_INHALT);
		}
		try
		{
			this.modell.setMenge(this.getMenge() + zusatzInhalt.getMenge());
			zusatzInhalt.entnehmen(zusatzInhalt.getMenge());
		} catch (IllegalArgumentException ueberfluss)
		{
			// Wenn "setMenge" eine IllegalArgumentException wirft konnte die Menge nicht
			// gesetzt werden, dies ist vermutlich der Fall, da die maximale Groesse nicht
			// ausreicht
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
		// Entnimmt die maximale Menge die in diesen GegenstandsHaufen passt und gibt
		// den Rest zurueck
		ueberfluss.entnehmen(this.modell.getMaximaleAnzahl() - this.modell.getMenge());
		this.modell.setMenge(this.modell.getMaximaleAnzahl());
		return ueberfluss;
	}

}
