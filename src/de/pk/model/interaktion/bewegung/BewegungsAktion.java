package de.pk.model.interaktion.bewegung;

import de.pk.model.interaktion.Aktion;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.interaktion.effekt.EffektBeschreibungsIndex;
import de.pk.model.interaktion.effekt.EffektTeil;
import de.pk.model.position.Vektor;

/**
 * Definiert eine Bewegung auf dem Spielbrett. Einzige Aktion welche nicht
 * instanziiert im LebendigenObjekt gehalten wird, sondern fuer jede Bewegung
 * neu generiert wird, da diese Aktion jedes Mal anderes ist ( Nach oben, unten
 * etc.)
 */
public class BewegungsAktion extends Aktion
{
	private static Effekt generiereEffektAusBewegung(Vektor bewegung)
	{
		return new Effekt(new EffektTeil(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS, 1),
				new EffektTeil(EffektBeschreibungsIndex.BEWEGUNGSPUNKTE, bewegung.getX() + bewegung.getY()),
				new EffektTeil(EffektBeschreibungsIndex.BEWEGUNG_X, bewegung.getX()),
				new EffektTeil(EffektBeschreibungsIndex.BEWEGUNG_Y, bewegung.getY()));
	}

	public BewegungsAktion(Vektor bewegung)
	{
		super(BewegungsAktion.generiereEffektAusBewegung(bewegung), null, 1f);
	}
}
