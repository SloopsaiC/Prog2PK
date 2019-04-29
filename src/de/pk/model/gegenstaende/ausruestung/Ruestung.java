package de.pk.model.gegenstaende.ausruestung;

import de.pk.model.faehigkeiten.Faehigkeit;
import de.pk.model.gegenstaende.spezifikationen.Ausruestbar;
import de.pk.model.interaktion.StatusEffekt;


/**
 * Ruestungen sind Gegenstaende und koennen ausgeruestet werden. Sie werden eingesetzt, um sich vor Schaden zu
 * schuetzen.
 *
 * @author Dylan
 */
public enum Ruestung implements Ausruestbar
{
    //TO-DO: sinnvolle Effekte einfuegen
    BRUSTPANZER(new StatusEffekt(-1, 0, 5, 0), Faehigkeit.AUSDAUER, Faehigkeit.STIL),
    SCHILD(new StatusEffekt(0, 0, 3, 0), Faehigkeit.AUSDAUER);


    /**
     * Konstruktor fuer eine Ruestung mit AusruestungsEffekt und Voraussetzungen.
     *
     * @param ausruestungsEffekt Effekt, den die Ruestung hervorruft.
     * @param vorraussetzungen   Array mit Faehigkeiten, die Voraussetzung sind, die Ruestung zu tragen.
     */
    private Ruestung (StatusEffekt ausruestungsEffekt, Faehigkeit... vorraussetzungen)
    {
        this.ausruestungsEffekt = ausruestungsEffekt;
        this.vorraussetzungen = vorraussetzungen;
    }


    /**
     * Alle Effekte die diese Ruestung auf den Traeger hervorruft.
     */
    private StatusEffekt ausruestungsEffekt = null;

    /**
     * Gibt den Effekt dieser Ruestung wieder.
     *
     * @return Effekt der Ruestung.
     */
    @Override
    public StatusEffekt getAusruestungsEffekt ()
    {
        return this.ausruestungsEffekt;
    }


    /**
     * Die Vorraussetzungen die der Traeger dieser Ruestung haben muss.
     */
    private Faehigkeit[] vorraussetzungen = null;

    /**
     * Gibt die Voraussetzungen, um diese Ruestung zu tragen, wieder.
     *
     * @return Array mit Faehigkeiten, die als Voraussetzung notwenig sind, um die Ruestung auszuruesten.
     */
    @Override
    public Faehigkeit[] getVoraussetzungen ()
    {
        return this.vorraussetzungen;
    }


}
