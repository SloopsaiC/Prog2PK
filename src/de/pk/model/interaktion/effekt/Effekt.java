package de.pk.model.interaktion.effekt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Ein Effekt kann die Attribute von LebendigenObjekten beeinflussen. Er hat
 * eine bestimmte Dauer (Anzahl an Runden), die er immer wieder aufs Neue wirkt,
 * bevor er schliesslich abklingt.
 */
public class Effekt
{

	/**
	 * Spezifiziert die Aenderungen die dieser Effekt auf ein lebendiges Objekt hat,
	 * wenn er darauf angewandt wird. Indizies sind in
	 * {@link}EffektBeschreibungsIndex definiert
	 */
	private HashMap<EffektBeschreibungsIndex, Integer> effektBeschreibung = null;

	/**
	 * Erstellt einen Effekt, der keine Auswirkungen hat.
	 */
	public Effekt()
	{
		this(new EffektTeil[0]);
	}

	/**
	 * Erstellt einen neuen Effekt mit den gegebenen Aenderungen. Welcher Index
	 * welche Aenderung beschreibt wird durch {@link}EffektIndex beschrieben.
	 *
	 * @param effektBeschreibung Die Aenderungen die dieser Effekt auf ein
	 *                           LebendigesObjekt hat, falls er auf dieses
	 *                           angewendet wird.
	 */
	public Effekt(EffektTeil... effektTeile)
	{
		this.effektBeschreibung = new HashMap<>();
		for (EffektTeil teil : effektTeile)
		{
			this.effektBeschreibung.put(teil.getIndex(), teil.getWert());
		}
	}

	public Map<EffektBeschreibungsIndex, Integer> getEffektBeschreibung()
	{
		return Collections.unmodifiableMap(this.effektBeschreibung);
	}

	public int getWertAusBeschreibung(EffektBeschreibungsIndex index)
	{
		return this.effektBeschreibung.get(index);
	}

	/**
	 * Gibt an, ob der Effekt bereits abgeklungen ist (Wenn die WirkTicks 0 sind).
	 *
	 * @return true, wenn der Effekt abgeklungen ist und in der naechsten Runde
	 *         nicht mehr beruecksichtigt werden muss.
	 */
	public boolean istAbgeklungen()
	{
		return this.effektBeschreibung.get(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS) < 1;
	}

	/**
	 * Gibt an, dass dieser Effekt ein tickender Effekt ist, also dass er nach einer
	 * bestimmten Zeit bzw. Anzahl an Runden verstreicht und abklingt. Nur tickende
	 * Effekte werden beim Wirken beruecksichtigt.
	 *
	 * @return immer true, da hier nur kurzlebige Effekte modelliert werden. Fuer
	 *         dauerhafte Effekte siehe {@link StatusEffekt}.
	 */
	public boolean istTickend()
	{
		return Boolean.TRUE;
	}

	/**
	 * Soll jedes Mal aufgerufen werden, wenn der Effekt gewirkt wurde. Es wird die
	 * verbleibden Anzahl an WirkTicks (Runden), die der Effekt noch wirkt, um 1
	 * reduziert.
	 */
	public void wurdeGewirkt()
	{
		// Die Anzahl der Wirkticks um einen vermindern
		this.effektBeschreibung.replace(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS,
				this.effektBeschreibung.get(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS) - 1);
	}

}
