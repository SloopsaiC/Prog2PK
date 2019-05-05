package de.pk.model.interaktion.effekt;

import de.pk.model.position.Vektor;

/**
 * Ein Effekt kann die Attribute von LebendigenObjekten beeinflussen. Er hat
 * eine bestimmte Dauer (Anzahl an Runden), die er immer wieder aufs Neue wirkt,
 * bevor er schliesslich abklingt.
 */
public class Effekt
{

	/**
	 * Die Aenderung der BewegungsPunkte auf das Ziel dieses Effekts.
	 */
	private int bewegungsPunkteAenderung = 0;
	/**
	 * Die Aenderung der AngriffsPunkte auf das Ziel dieses Effekts.
	 */
	private int angriffsPunkteAenderung = 0;
	/**
	 * Die Aenderung der RuestungsPunkte auf das Ziel dieses Effekts.
	 */
	private int ruestungsPunkteAenderung = 0;
	/**
	 * Die Aenderung der LebensPunkte auf das Ziel dieses Effekts.
	 */
	private int lebensPunkteAenderung = 0;
	/**
	 * Die Haeufigkeit (Runden), die dieser Effekt wirkt, bevor er abklingt.
	 */
	private int anzahlWirkTicks = 0;
	/**
	 * Die Aenderung der Position auf das Ziel dieses Effekts.
	 */
	private Vektor positionsAenderung = null;

	/**
	 * Erstellt einen Effekt, der keine Auswirkungen hat.
	 */
	public Effekt()
	{
	}

	/**
	 * Erstellt einen neuen Effekt mit den folgenden Moeglichkeiten zur Aenderung /
	 * Beeinflussung auf sein Ziel, sowie der Anzahl an Runden, die der Effekt
	 * wirkt, bevor er abklingt.
	 *
	 * @param bewegungsPunkteAenderung Die Aenderung der BewegungsPunkte auf das
	 *                                 Ziel dieses Effekts.
	 * @param angriffsPunkteAenderung  Die Aenderung der AngriffsPunkte auf das Ziel
	 *                                 dieses Effekts.
	 * @param ruestungsPunkteAenderung Die Aenderung der RuestungsPunkte auf das
	 *                                 Ziel dieses Effekts.
	 * @param lebensPunkteAenderung    Die Aenderung der LebensPunkte auf das Ziel
	 *                                 dieses Effekts.
	 * @param anzahlWirkTicks          Die Haeufigkeit (Runden), die dieser Effekt
	 *                                 wirkt, bevor er abklingt.
	 */
	public Effekt(int bewegungsPunkteAenderung, int angriffsPunkteAenderung, int ruestungsPunkteAenderung,
			int lebensPunkteAenderung, int anzahlWirkTicks)
	{
		this(bewegungsPunkteAenderung, angriffsPunkteAenderung, ruestungsPunkteAenderung, lebensPunkteAenderung,
				anzahlWirkTicks, null);
	}

	/**
	 * Erstellt einen neuen Effekt mit den folgenden Moeglichkeiten zur Aenderung /
	 * Beeinflussung auf sein Ziel, sowie der Anzahl an Runden, die der Effekt
	 * wirkt, bevor er abklingt.
	 *
	 * @param bewegungsPunkteAenderung Die Aenderung der BewegungsPunkte auf das
	 *                                 Ziel dieses Effekts.
	 * @param angriffsPunkteAenderung  Die Aenderung der AngriffsPunkte auf das Ziel
	 *                                 dieses Effekts.
	 * @param ruestungsPunkteAenderung Die Aenderung der RuestungsPunkte auf das
	 *                                 Ziel dieses Effekts.
	 * @param lebensPunkteAenderung    Die Aenderung der LebensPunkte auf das Ziel
	 *                                 dieses Effekts.
	 * @param anzahlWirkTicks          Die Haeufigkeit (Runden), die dieser Effekt
	 *                                 wirkt, bevor er abklingt.
	 * @param positionsAenderung       Die Aenderung der Position auf das Ziel
	 *                                 dieses Effekts.
	 */
	public Effekt(int bewegungsPunkteAenderung, int angriffsPunkteAenderung, int ruestungsPunkteAenderung,
			int lebensPunkteAenderung, int anzahlWirkTicks, Vektor positionsAenderung)
	{
		this.bewegungsPunkteAenderung = bewegungsPunkteAenderung;
		this.angriffsPunkteAenderung = angriffsPunkteAenderung;
		this.ruestungsPunkteAenderung = ruestungsPunkteAenderung;
		this.lebensPunkteAenderung = lebensPunkteAenderung;
		this.anzahlWirkTicks = anzahlWirkTicks;
		this.positionsAenderung = positionsAenderung;
	}

	/**
	 * Gibt die angriffsPunkteAenderung, die dieser Effekt hervorrufen kann zurueck.
	 *
	 * @return die angriffsPunkteAenderung
	 */
	public int getAngriffsPunkteAenderung()
	{
		return this.angriffsPunkteAenderung;
	}

	/**
	 * Gibt die bewegungsPunkteAenderung, die dieser Effekt hervorrufen kann
	 * zurueck.
	 *
	 * @return die bewegungsPunkteAenderung
	 */
	public int getBewegungsPunkteAenderung()
	{
		return this.bewegungsPunkteAenderung;
	}

	/**
	 * Gibt die lebensPunkteAenderung, die dieser Effekt hervorrufen kann zurueck.
	 *
	 * @return die lebensPunkteAenderung
	 */
	public int getLebensPunkteAenderung()
	{
		return this.lebensPunkteAenderung;
	}

	/**
	 * Gibt die positionsAenderung, die dieser Effekt hervorrufen kann zurueck.
	 *
	 * @return die positionsAenderung
	 */
	public Vektor getPositionsAenderung()
	{
		return this.positionsAenderung;
	}

	/**
	 * Gibt die ruestungsPunkteAenderung, die dieser Effekt hervorrufen kann
	 * zurueck.
	 *
	 * @return die ruestungsPunkteAenderung
	 */
	public int getRuestungsPunkteAenderung()
	{
		return this.ruestungsPunkteAenderung;
	}

	/**
	 * Gibt an, ob der Effekt bereits abgeklungen ist (Wenn die WirkTicks 0 sind).
	 *
	 * @return true, wenn der Effekt abgeklungen ist und in der naechsten Runde
	 *         nicht mehr beruecksichtigt werden muss.
	 */
	public boolean istAbgeklungen()
	{
		return this.anzahlWirkTicks < 1;
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
		if (this.anzahlWirkTicks < Integer.MAX_VALUE)
		{
			this.anzahlWirkTicks--;
		}
	}

}
