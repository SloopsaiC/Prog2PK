package de.pk.model.gegenstaende.spezifikationen;

import de.pk.model.interaktion.Effekt;


/**
 * Gruppiert konsumierbare Gegenstaende und legt Verhalten fuer diese fest.
 *
 * @author Dylan
 */
public interface Konsumierbar extends Stapelbar
{

    /**
     * Gibt an, dass konsumierbare Gegenstaende keine ausruestbaren Gegenstaende sind.
     */
    static final boolean KONSUMIERBARES_IST_AUSRUESTBAR = false;
    /**
     * Gibt an, dass konsumierbare Gegenstaende konsumierbare Gegenstaende sind.
     */
    static final boolean KONSUMIERBARES_IST_KONSUMIERBAR = true;


    /**
     * Gibt an, dass konsumierbare Gegenstaende nicht ausruestbar sind.
     *
     * @return false
     */
    @Override
    public default boolean istAusruestbar ()
    {
        return KONSUMIERBARES_IST_AUSRUESTBAR;
    }


    /**
     * Gibt an, dass konsumierbare Gegenstaende konsumierbar sind.
     *
     * @return true
     */
    @Override
    public default boolean istKonsumierbar ()
    {
        return KONSUMIERBARES_IST_KONSUMIERBAR;
    }


    /**
     * Beim Konsumieren des konsumierbaren Gegenstands wird diese Methode aufgerufen und gibt den Effekt zurueck, den
     * das Konsumieren bewirkt.
     *
     * @return Effekt, der durch das Konsumieren des Gegenstands wirkt.
     */
    public abstract Effekt konsumieren ();


}
