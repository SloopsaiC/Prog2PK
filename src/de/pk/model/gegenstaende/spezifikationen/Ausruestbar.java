package de.pk.model.gegenstaende.spezifikationen;

import de.pk.model.faehigkeiten.Faehigkeit;
import de.pk.model.interaktion.StatusEffekt;

/**
 * Gruppiert ausruestbare Gegenstaende und legt Verhalten fuer diese fest.
 *
 * @author Dylan
 */
public interface Ausruestbar extends Stapelbar
{

	/**
	 * Gibt an, dass ausruestbare Gegenstaende ausruestbare Gegenstaende sind.
	 */
	boolean AUSRUESTBARES_IST_AUSRUESTBAR = true;
	/**
	 * Gibt an, dass ausruestbare Gegenstaende keine konsumierbaren Gegenstaende
	 * sind.
	 */
	boolean AUSRUESTBARES_IST_KONSUMIERBAR = false;

	/**
	 * Gibt die Effekte dieser Ausruestung wieder.
	 *
	 * @return Den Effekt der Ausruestung.
	 */
	StatusEffekt getAusruestungsEffekt();

	/**
	 * Gibt die Voraussetzungen, um diese Ausruestung zu tragen, wieder.
	 *
	 * @return Array mit Faehigkeiten, die als Voraussetzung notwenig sind, um
	 *         Gegenstand auszuruesten.
	 */
	Faehigkeit[] getVoraussetzungen();

	/**
	 * Gibt an, dass ausruestbare Gegenstaende ausruestbar sind.
	 *
	 * @return true
	 */
	@Override
	default boolean istAusruestbar()
	{
		return Ausruestbar.AUSRUESTBARES_IST_AUSRUESTBAR;
	}

	/**
	 * Gibt an, dass ausruestbare Gegenstaende nicht konsumierbar sind.
	 *
	 * @return false
	 */
	@Override
	default boolean istKonsumierbar()
	{
		return Ausruestbar.AUSRUESTBARES_IST_KONSUMIERBAR;
	}

}
