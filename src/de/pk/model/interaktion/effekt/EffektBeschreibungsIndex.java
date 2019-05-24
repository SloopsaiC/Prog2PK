package de.pk.model.interaktion.effekt;

import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektPunkteIndex;

/**
 * Gibt die Indizies an nach welchen die Auswirkungen welche in einem "Effekt"
 * gespeichert werden.
 *
 * @author Mattheo
 */
public enum EffektBeschreibungsIndex
{
	ANZAHL_WIRK_TICKS, ANGRIFF, RUESTUNG, LEBENS_PUNKTE, BEWEGUNGSPUNKTE, AKTION_REICHWEITE_AENDERUNG;

	public static EffektBeschreibungsIndex uebersetzeAusLebendigesObjektPunkteIndex(
			LebendigesObjektPunkteIndex zuUebersetzen)
	{
		return EffektBeschreibungsIndex.valueOf(zuUebersetzen.toString());
	}

}
