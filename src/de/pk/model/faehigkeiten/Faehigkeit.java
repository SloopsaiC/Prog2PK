package de.pk.model.faehigkeiten;


/**
 * Helden koennen Faehigkeiten besitzen und mit der Zeit neue erwerben. Faehigkeiten sind Voraussetzungen fuer
 * Ausruestungen.
 *
 * @author Dylan
 */
public enum Faehigkeit
{
    /**
     * Ist fuer eine Ausruestung keine gesonderte Faehigkeit als Voraussetzung noetig, so ist die Vorausetzung KEINE.
     */
    KEINE,
    AUSDAUER,
    HAUEN,
    STIL;
}
