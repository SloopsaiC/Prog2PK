package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import de.pk.model.interaktion.effekt.EffektBeschreibungsIndex;
import de.pk.utils.AusnahmeNachrichten;

public enum LebendigesObjektPunkteIndex
{
	ANGRIFF, RUESTUNG, LEBENS_PUNKTE, BEWEGUNGS_PUNKTE, AKTION_REICHWEITE_AENDERUNG, IST_GESCHUETZT;

	public static LebendigesObjektPunkteIndex uebersetzeAusEffektIndex(EffektBeschreibungsIndex zuUebersetzen)
	{
		try
		{
			return LebendigesObjektPunkteIndex.valueOf(zuUebersetzen.toString());
		} catch (IllegalArgumentException nichtZuUebersetzen)
		{
			throw new IllegalArgumentException(
					AusnahmeNachrichten.LEBENDIGES_OBJEKT_PUNKTE_INDEX_UEBERSETZUNG_FEHLGESCHLAGEN);
		}
	}

}
