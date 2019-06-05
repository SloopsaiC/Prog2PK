package de.pk.model.interaktion.effekt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Ein Effekt kann die Attribute von LebendigenObjekten beeinflussen. Er hat
 * eine bestimmte Dauer (Anzahl an Runden), die er immer wieder aufs Neue wirkt,
 * bevor er schliesslich abklingt. Besteht aus "EffektTeilen", welche jeweils
 * eine Aenderung eines Wertes des Ziels ausdruecken
 */
public class Effekt
{

	private static Map<EffektBeschreibungsIndex, EffektTeil> generiereEffektBeschreibung(EffektTeil[] effektTeile)
	{
		Map<EffektBeschreibungsIndex, EffektTeil> beschreibung = new HashMap<>();
		for (EffektTeil teil : effektTeile)
		{
			beschreibung.put(teil.getIndex(), teil.clone());
		}
		return beschreibung;
	}

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
		this(typ, Effekt.generiereEffektBeschreibung(effektTeile));

	}

	public Effekt(EffektTyp typ, Map<EffektBeschreibungsIndex, EffektTeil> effektBeschreibung)
	{
		this.typ = typ;
		this.effektBeschreibung = Collections.synchronizedMap(new HashMap<>(effektBeschreibung));
	}

	@Override
	public Effekt clone()
	{
		return new Effekt(this.typ, this.effektBeschreibung.values().toArray(new EffektTeil[0]));
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass())
		{
			return false;
		}
		Effekt other = (Effekt) obj;
		return (this.typ == other.typ) && Objects.equals(this.effektBeschreibung, other.effektBeschreibung);
	}

	/**
	 * Erstellt einen Effekt der genau den gegenteiligen Effekt zu diesem hat.
	 *
	 * @return Ein Effekt der die Auswirkungen dieses Effektes aufhebt
	 */
	public Effekt getNegation()
	{
		Map<EffektBeschreibungsIndex, EffektTeil> neueEffektBeschreibung = new HashMap<>();
		for (EffektBeschreibungsIndex index : this.effektBeschreibung.keySet())
		{
			neueEffektBeschreibung.put(index, new EffektTeil(index, -this.effektBeschreibung.get(index).getWert()));
		}
		return new Effekt(this.typ, neueEffektBeschreibung);
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
		EffektTeil beschreibung = this.effektBeschreibung.get(index);
		if ((beschreibung == null) || this.istAbgeklungen())
		{
			return 0;
		}
		return beschreibung.getWert();
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.effektBeschreibung, this.typ);
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
		EffektTeil wirkTicks = this.effektBeschreibung.get(EffektBeschreibungsIndex.ANZAHL_WIRK_TICKS);
		wirkTicks.setWert(wirkTicks.getWert() - 1);
	}

}
