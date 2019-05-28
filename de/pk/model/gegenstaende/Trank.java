package de.pk.model.gegenstaende;

import de.pk.model.gegenstaende.spezifikationen.Konsumierbar;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.interaktion.effekt.EffektBeschreibungsIndex;
import de.pk.model.interaktion.effekt.EffektTeil;
import de.pk.model.interaktion.effekt.EffektTyp;

/**
 * Ein Trank ist ein konsumierbarer Gegenstand, der beim konsumieren einen
 * Effekt zurueckgibt.
 *
 * @author Dylan
 */
public enum Trank implements Konsumierbar
{

	/**
	 * Ein Schluck MOORWASSER hat noch niemandem geschadet. Es schmeckt komisch und
	 * belebt die natuerliche Darmflora, hat sonst aber keinen Effekt.
	 */
	MOORWASSER(new Effekt()),
	/**
	 * Wer heissen TEE trinkt, dem wird so schnell nicht wieder kalt. Wirkt gegen
	 * Kaelte-Effekte.
	 */
	HEISSER_TEE(new Effekt()),
	/**
	 * MEDIZIN ist der Retter in der Not. Wem es an Energie mangelt, kann hiermit
	 * seinen Vorrat wieder auffuellen.
	 */
	MEDIZIN(new Effekt(EffektTyp.NORMAL, new EffektTeil(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS, 1),
			new EffektTeil(EffektBeschreibungsIndex.LEBENS_PUNKTE, 10)));

	/**
	 * Effekt, der beim Konsumieren ausgeloest wird.
	 */
	private Effekt konsumierEffekt = null;

	/**
	 * Konstruktor fuer einen Trank mit Uebergabe eines Effekts, welcher beim
	 * Konsumieren ausgeloest werden soll.
	 *
	 * @param konsumierEffekt
	 */
	private Trank(Effekt konsumierEffekt)
	{
		this.konsumierEffekt = konsumierEffekt;
	}

	/**
	 * Beim Konsumieren des Tranks wird der freigesetzte Effekt zurueckgegeben.
	 *
	 * @return Effekt, der durch das Konsumieren des Tranks ausgeloest wird.
	 */
	@Override
	public Effekt konsumieren()
	{
		return this.konsumierEffekt;
	}

}
