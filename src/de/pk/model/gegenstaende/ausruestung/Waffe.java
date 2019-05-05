package de.pk.model.gegenstaende.ausruestung;

import de.pk.model.faehigkeiten.Faehigkeit;
import de.pk.model.gegenstaende.spezifikationen.Ausruestbar;
import de.pk.model.interaktion.effekt.StatusEffekt;

/**
 * Waffen sind Gegenstaende und koennen ausgeruestet werden. Sie werden im Kampf
 * eingesetzt, um Schaden zu verursachen.
 *
 * @author Dylan
 */
public enum Waffe implements Ausruestbar
{

	// TO-DO: sinnvolle Effekte einfuegen
	SCHWERT(new StatusEffekt(0, 5, 0, 0), Faehigkeit.HAUEN),
	BOGEN(new StatusEffekt(0, 0, -1, 0), Faehigkeit.STIL, Faehigkeit.AUSDAUER);

	/**
	 * Alle Effekte die diese Waffe auf den Traeger hervorruft.
	 */
	private StatusEffekt ausruestungsEffekt = null;

	/**
	 * Die Vorraussetzungen die der Traeger dieser Waffe haben muss.
	 */
	private Faehigkeit[] vorraussetzungen = null;

	/**
	 * Konstruktor fuer eine Waffe mit AusruestungsEffekt und Voraussetzungen.
	 *
	 * @param ausruestungsEffekt Effekt, den die Waffe hervorruft.
	 * @param vorraussetzungen   Array mit Faehigkeiten, die Voraussetzung sind, die
	 *                           Waffe zu tragen.
	 */
	private Waffe(StatusEffekt ausruestungsEffekt, Faehigkeit... vorraussetzungen)
	{
		this.ausruestungsEffekt = ausruestungsEffekt;
		this.vorraussetzungen = vorraussetzungen;
	}

	/**
	 * Gibt den Effekt dieser Waffe wieder.
	 *
	 * @return Der Effekt der Waffe.
	 */
	@Override
	public StatusEffekt getAusruestungsEffekt()
	{
		return this.ausruestungsEffekt;
	}

	/**
	 * Gibt die Voraussetzungen, um diese Waffe zu tragen, wieder.
	 *
	 * @return Array mit Faehigkeiten, die als Voraussetzung notwenig sind, um die
	 *         Waffe auszuruesten.
	 */
	@Override
	public Faehigkeit[] getVoraussetzungen()
	{
		return this.vorraussetzungen;
	}

}
