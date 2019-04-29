package de.pk.model.gegenstaende;

import de.pk.model.gegenstaende.spezifikationen.Stapelbar;


/**
 * Materialien bilden die Grundlage fuer das Craften von neuen Gegenstaenden. Materialien sind Stapelbar, koennen jedoch
 * weder ausgeruestet noch konsumiert werden.
 *
 * @author Dylan
 */
public enum Material implements Stapelbar
{
    /**
     * Das Material LEER symbolisiert ein leeres Feld beim Crafting.
     */
    LEER,
    HOLZ,
    SEHNE,
    STOFF,
    EISEN,
    STEIN;

    /**
     * Gibt an, dass Materialien keine ausruestbaren Gegenstaende sind.
     */
    private static final boolean MATERIALIEN_SIND_AUSRUESTBAR = false;

    /**
     * Gibt an, dass Materialien nicht ausruestbar sind.
     *
     * @return false
     */
    @Override
    public boolean istAusruestbar ()
    {
        return MATERIALIEN_SIND_AUSRUESTBAR;
    }


    /**
     * Gibt an, dass Materialien keine konsumierbaren Gegenstaende sind.
     */
    private static final boolean MATERIALIEN_SIND_KONSUMIERBAR = false;

    /**
     * Gibt an, dass Materialien nicht konsumierbar sind.
     *
     * @return false
     */
    @Override
    public boolean istKonsumierbar ()
    {
        return MATERIALIEN_SIND_KONSUMIERBAR;
    }


}
