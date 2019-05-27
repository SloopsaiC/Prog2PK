package de.pk.model.interaktion.effekt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Ein Effekt kann die Attribute von LebendigenObjekten beeinflussen. Er hat
 * eine bestimmte Dauer (Anzahl an Runden), die er immer wieder aufs Neue wirkt,
 * bevor er schliesslich abklingt. Besteht aus "EffektTeilen", welche jeweils
 * eine Aenderung eines Wertes des Ziels ausdruecken
 */
public class Effekt
{

	/**
	 * Spezifiziert die Aenderungen die dieser Effekt auf ein lebendiges Objekt hat,
	 * wenn er darauf angewandt wird. Indizies sind in
	 * {@link}EffektBeschreibungsIndex definiert
	 */
	private Map<EffektBeschreibungsIndex, EffektTeil> effektBeschreibung = null; // Alle EffektTeile welche ueber ihren
																					// EffektBeschreibungsIndex gesucht
																					// werden koennen um spaeteres
																					// Anwenden zu vereinfachen
	private EffektTyp typ = null; // Der Typ dieses Effektes

	/**
	 * Erstellt einen Effekt, der keine Auswirkungen hat.
	 */
	public Effekt()
	{
		this(null, new EffektTeil[0]);
	}

	/**
	 * Erstellt einen neuen Effekt mit den gegebenen Aenderungen. Welcher Index
	 * welche Aenderung beschreibt wird durch {@link}EffektIndex beschrieben.
	 *
	 * @param effektBeschreibung Die Aenderungen die dieser Effekt auf ein
	 *                           LebendigesObjekt hat, falls er auf dieses
	 *                           angewendet wird.
	 */
	public Effekt(EffektTyp typ, EffektTeil... effektTeile)
	{
		this.effektBeschreibung = this.generiereEffektBeschreibung(effektTeile);
		this.typ = typ;

	}

	private Map<EffektBeschreibungsIndex, EffektTeil> generiereEffektBeschreibung(EffektTeil[] effektTeile)
	{
		Map<EffektBeschreibungsIndex, EffektTeil> beschreibung = Collections
				.synchronizedMap(new HashMap<EffektBeschreibungsIndex, EffektTeil>());
		for (EffektTeil teil : effektTeile)
		{
			beschreibung.put(teil.getIndex(), teil);
		}
		return beschreibung;
	}

	/**
	 * @return the typ
	 */
	public EffektTyp getTyp()
	{
		return this.typ;
	}

	public int getWertAusBeschreibung(EffektBeschreibungsIndex index)
	{
		if (this.istAbgeklungen())
		{
			return 0;
		}
		return this.effektBeschreibung.get(index).getWert();
	}

	/**
	 * Gibt an, ob der Effekt bereits abgeklungen ist (Wenn die WirkTicks 0 sind).
	 *
	 * @return true, wenn der Effekt abgeklungen ist und in der naechsten Runde
	 *         nicht mehr beruecksichtigt werden muss.
	 */
	public boolean istAbgeklungen()
	{
		return this.effektBeschreibung.get(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS).getWert() < 1;
	}

	/**
	 * Gibt an, dass dieser Effekt ein tickender Effekt ist, also ob seine
	 * Auswirkungen beim naechsten anwenden angwendet werden sollen, oder er nur ein
	 * Mal eine Wirkung hat. Nur tickende Effekte werden beim Wirken
	 * beruecksichtigt. Die Auswirkungen von nicht tickenden Effekten werden beim
	 * Entfernen ausserdem rueckgaenig gemacht
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
		EffektTeil wirkTicks = this.effektBeschreibung.get(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS);
		wirkTicks.setWert(wirkTicks.getWert() - 1);
	}

}
