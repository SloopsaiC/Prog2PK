package de.pk.model.interaktion.aktionen;

import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.interaktion.effekt.EffektBeschreibungsIndex;
import de.pk.model.interaktion.effekt.EffektTeil;
import de.pk.model.interaktion.effekt.EffektTyp;

public enum AktionsVorlagen
{
	BEWEGUNG(new Aktion(1f, 10,
			new Effekt(EffektTyp.BEWEGUNG, new EffektTeil(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS, 1)))),
	AUA(new Aktion(0.5f, 10,
			new Effekt(EffektTyp.NORMAL, new EffektTeil(EffektBeschreibungsIndex.AKTUELLE_LEBENS_PUNKTE, -10),
					new EffektTeil(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS, 1))));

	private Aktion aktion = null;

	private AktionsVorlagen(Aktion aktion)
	{
		this.aktion = aktion;
	}

	public Aktion getAktion()
	{
		return this.aktion;
	}
}
