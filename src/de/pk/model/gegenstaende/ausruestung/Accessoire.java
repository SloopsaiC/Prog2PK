package de.pk.model.gegenstaende.ausruestung;

import de.pk.model.faehigkeiten.Faehigkeit;
import de.pk.model.gegenstaende.spezifikationen.Ausruestbar;
import de.pk.model.interaktion.effekt.StatusEffekt;

/**
 * Accessoires sind Gegenstaende und koennen ausgeruestet werden. Sie werden
 * eingesetzt, um bestimmte, dauerhafte Effekte zu bewirken.
 *
 * @author Dylan
 */
public enum Accessoire implements Ausruestbar
{
	// TODO: sinnvolle Effekte einfuegen
	RING(new StatusEffekt(1, 1, 0, 1), Faehigkeit.STIL), AMULETT(new StatusEffekt(0, 2, 2, 2), Faehigkeit.KEINE);

	/**
	 * Alle Effekte die dieses Accessoire auf den Traeger hervorruft.
	 */
	private StatusEffekt ausruestungsEffekt = null;

	/**
	 * Die Vorraussetzungen die der Traeger dieses Accessoires haben muss.
	 */
	private Faehigkeit[] vorraussetzungen = null;

	/**
	 * Konstruktor fuer eine Accessoire mit AusruestungsEffekt und Voraussetzungen.
	 *
	 * @param ausruestungsEffekte Effekt, den das Accessoire hervorruft.
	 * @param vorraussetzungen    Array mit Faehigkeiten, die Voraussetzung sind,
	 *                            das Accessoire zu tragen.
	 */
	private Accessoire(StatusEffekt ausruestungsEffekt, Faehigkeit... vorraussetzungen)
	{
		this.ausruestungsEffekt = ausruestungsEffekt;
		this.vorraussetzungen = vorraussetzungen;
	}

	/**
	 * Gibt den Effekt dieses Accessoires wieder.
	 *
	 * @return Effekt des Accessoires.
	 */
	@Override
	public StatusEffekt getAusruestungsEffekt()
	{
		return this.ausruestungsEffekt;
	}

	/**
	 * Gibt die Voraussetzungen, um dieses Accessoire zu tragen, wieder.
	 *
	 * @return Array mit Faehigkeiten, die als Voraussetzung notwenig sind, um das
	 *         Accessoire auszuruesten.
	 */
	@Override
	public Faehigkeit[] getVoraussetzungen()
	{
		return this.vorraussetzungen;
	}

}
