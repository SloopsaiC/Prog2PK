package de.pk.model.gegenstaende.spezifikationen;


/**
 * Gruppiert alle Gegenstaende als stapelbare Gegenstaende, wodurch Gegenstaende nur noch als Typ Stapelbar angesehen
 * werden. Es werden booolean-Methoden zur Erkennung der Gegenstandseigenschaften erzwungen.
 *
 * @author Dylan
 */
public interface Stapelbar
{

    /**
     * Gibt an, ob der Gegenstaend ausruestbar ist.
     *
     * @return true, wenn Gegenstand ausruestbar sein soll.
     */
    public abstract boolean istAusruestbar ();


    /**
     * Gibt an, ob der Gegenstaend konsumierbar ist.
     *
     * @return true, wenn Gegenstand konsumierbar sein soll.
     */
    public abstract boolean istKonsumierbar ();


}
