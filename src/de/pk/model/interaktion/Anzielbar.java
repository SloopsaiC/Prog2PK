package de.pk.model.interaktion;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.interaktion.effekt.Effekt;

/**
 * Alles was von einer Aktion angezielt werden kann ist "Anzielbar".
 *
 * @author Mattheo
 */
public interface Anzielbar
{
	/**
	 * Fuegt einem Ziel Effekte hinzu welches diese dann verarbeiten kann
	 *
	 * @param verursacher Der Verursacher dieses Effektes
	 * @param hinzufuegen Alle Effekte die diesem Ziel hinzugefuegt werden sollen
	 */
	boolean fuegeEffekteHinzu(SpielbrettObjekt verursacher, Effekt... hinzufuegen);

	/**
	 * Berechnet die Trefferwahrscheinlichkeit auf ein bestimmtes Ziel.
	 *
	 * @return float, eine Zahl zwischen 0.0 und 1.0 welche die Wahrscheinlichkeit
	 *         repraesentiert mit der das momentane Ziel getroffen werden kann.
	 *         Hierbei entspricht 1.0 "100%" und 0.0 "0%".
	 */
	float getTrefferWahrscheinlichkeit();

	/**
	 * Ist ein Ziel geschuetzt kann es nicht von einer Aktion angezielt werden.
	 *
	 * @return true, falls das momentane Ziel momentan nicht angezielt werden kann.
	 */
	boolean istGeschuetzt();
}
