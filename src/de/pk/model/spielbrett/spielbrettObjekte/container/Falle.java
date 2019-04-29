package de.pk.model.spielbrett.spielbrettObjekte.container;

import de.pk.control.gegenstaende.GegenstandsHaufen;
import de.pk.utils.Spielkonstanten;

public class Falle extends SpielbrettObjektContainer
{
	public Falle()
	{
		super(Spielkonstanten.MAX_ANZAHL_INHALT_FALLE);
	}

	/**
	 * Loest diese Falle aus, und gibt den GegenstandsHaufen wieder welcher ihren
	 * Effekt enthaelt
	 * 
	 * @return GegenstandsHaufen, Haufen mit dem Gegenstand der durch diese Falle
	 *         auf alle nahen Objekte wirkt
	 */
	public GegenstandsHaufen ausloesen()
	{
		return super.getInhalt().entferneInhalt(0);
	}

	/**
	 * Ist wahr, sollte diese Falle ausgeloest sein
	 * 
	 * @return True, diese Falle ist ausgeloest, false, diese Falle ist noch geladen
	 */
	public boolean istAusgeloest()
	{
		return super.getInhalt(0) == null;
	}
}
