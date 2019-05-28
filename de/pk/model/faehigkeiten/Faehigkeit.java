package de.pk.model.faehigkeiten;

/**
 * Helden koennen Faehigkeiten besitzen und mit der Zeit Neue erwerben.
 * Faehigkeiten sind Voraussetzungen fuer Ausruestungen.
 *
 * @author Dylan
 */
public enum Faehigkeit
{
	/**
	 * Ist fuer eine Ausruestung keine gesonderte Faehigkeit als Voraussetzung
	 * noetig, so ist die Vorausetzung KEINE.
	 */
	KEINE,
	/**
	 * Ausdauer wird benoetigt, um schwere Ausruestung zu tragen.
	 */
	AUSDAUER,
	/**
	 * Hauen wird benoetigt, um mit Nahkampfwaffen umgehen zu koennen.
	 */
	HAUEN,
	/**
	 * Stil wird benoetigt, um schicke Accessoires zu tragen.
	 */
	STIL;
}
