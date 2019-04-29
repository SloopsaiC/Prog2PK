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
    static final boolean AUSRUESTBARES_IST_AUSRUESTBAR = true;
    /**
     * Gibt an, dass ausruestbare Gegenstaende keine konsumierbaren Gegenstaende sind.
     */
    static final boolean AUSRUESTBARES_IST_KONSUMIERBAR = false;


    /**
     * Gibt an, dass ausruestbare Gegenstaende ausruestbar sind.
     *
     * @return true
     */
    @Override
    public default boolean istAusruestbar ()
    {
        return AUSRUESTBARES_IST_AUSRUESTBAR;
    }


    /**
     * Gibt an, dass ausruestbare Gegenstaende nicht konsumierbar sind.
     *
     * @return false
     */
    @Override
    public default boolean istKonsumierbar ()
    {
        return AUSRUESTBARES_IST_KONSUMIERBAR;
    }


    /**
     * Gibt die Effekte dieser Ausruestung wieder.
     *
     * @return Den Effekt der Ausruestung.
     */
    public abstract StatusEffekt getAusruestungsEffekt ();


    /**
     * Gibt die Voraussetzungen, um diese Ausruestung zu tragen, wieder.
     *
     * @return Array mit Faehigkeiten, die als Voraussetzung notwenig sind, um Gegenstand auszuruesten.
     */
    public abstract Faehigkeit[] getVoraussetzungen ();


}
