package de.pk.model.interaktion;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.interaktion.effekt.Effekt;

public interface Anzielbar
{
	/**
	 * Ist ein Ziel geschuetzt kann es nicht von einer Aktion angezielt werden.
	 * 
	 * @return true, falls das momentane Ziel momentan nicht angezielt werden kann.
	 */
	public boolean istGeschuetzt();

	/**
	 * Berechnet die Trefferwahrscheinlichkeit auf ein bestimmtes Ziel.
	 * 
	 * @return float, eine Zahl zwischen 0.0 und 1.0 welche die Wahrscheinlichkeit
	 *         repraesentiert mit der das momentane Ziel getroffen werden kann.
	 *         Hierbei entspricht 1.0 "100%" und 0.0 "0%".
	 */
	public float getTrefferWahrscheinlichkeit();
	
	public boolean fuegeEffekteHinzu(SpielbrettObjekt verursacher, Effekt... hinzufuegen);
}
