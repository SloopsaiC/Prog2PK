package de.pk.model.interaktion.effekt;

/**
 * Ein Status Effekt kann die Attribute von LebendigenObjekten dauerhaft
 * beeinflussen, wobei er nur einmal wirkt und danach so lange die Wirkung bei
 * dem LebendigenObjekt erzielt, bis er wieder entfernt wird.
 *
 * @author Dylan
 */
public class StatusEffekt extends Effekt
{

	/**
	 * Gibt an, ob der Effekt tickt. Da StatusEffekte nur einmal gewirkt werden,
	 * wird somit indiziert, dass der Effekt nur zu Beginn ein mal tickt und beim
	 * Wirken beachtet wird.
	 */
	private boolean tickt = false;

	/**
	 * Erstellt einen neuen StatusEffekt mit den folgenden dauerhaften
	 * Aenderungungen / Beeinflussungen auf sein Ziel.
	 *
	 * @param bewegungsPunkteAenderung Die Aenderung der BewegungsPunkte auf das
	 *                                 Ziel dieses StatusEffekts.
	 * @param angriffsPunkteAenderung  Die Aenderung der AngriffsPunkte auf das Ziel
	 *                                 dieses StatusEffekts.
	 * @param ruestungsPunkteAenderung Die Aenderung der RuestungsPunkte auf das
	 *                                 Ziel dieses StatusEffekts.
	 * @param lebensPunkteAenderung    Die Aenderung der LebensPunkte auf das Ziel
	 *                                 dieses StatusEffekts.
	 */
	public StatusEffekt(EffektTyp typ, EffektTeil... effektTeile)
	{
		super(typ, effektTeile);
		this.tickt = Boolean.TRUE;
	}

	/**
	 * Gibt an, ob der Effekt bereits abgeklungen ist.
	 *
	 * @return immer false, da StatusEffekte niemals abklingen. Sie koenne lediglich
	 *         explizit entfernt werden.
	 */
	@Override
	public boolean istAbgeklungen()
	{
		return Boolean.FALSE;
	}

	/**
<<<<<<< HEAD
	 * Erst true, da der Effekt ein Mal angewendet werden soll, sonst false.
	 *
	 * @see de.pk.model.interaktion.effekt.Effekt#istTickend()
=======
	 * Gibt an, ob dieser Effekt gerade tickt und somit beim Wirken beruecksichtigt
	 * werden soll. Da dies ein StatusEffekt ist, wird hier nur beim ersten ticken
	 * true zurueck gegeben.
>>>>>>> refs/heads/Phillip
	 *
	 * @return Nur zu Beginn true, da hier dauerhafte StatusEffekte modelliert
	 *         werden. Fuer kurzlebige Effekte siehe {@link Effekt}.
	 */
	@Override
	public boolean istTickend()
	{
		try
		{
			return this.tickt;
		} finally
		{
			this.tickt = Boolean.FALSE;
		}
	}

	/**
	 * Soll jedes Mal aufgerufen werden, wenn der Effekt gewirkt wurde. Hier also
	 * nur einmal, wobei dabei das Ticken des Effekts wieder auf false gesetzt wird,
	 * sodass der StatusEffekt kein zweites Mal gewirkt werden kann.
	 */
	@Override
	public void wurdeGewirkt()
	{
		this.tickt = Boolean.FALSE;
	}

}
