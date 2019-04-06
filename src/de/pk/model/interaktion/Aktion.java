package de.pk.model.interaktion;

import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.utils.DebugAusgabeKlasse;

public class Aktion
{

	private Effekt selbstEffekt = null; // Der Effekt welcher auf das ausfuehrende Objekt angewendet wird
	private Effekt zielEffekt = null; // Der Effekt welcher auf das von dieser Aktion angezielte Objekt angewendet
										// wird

	public void wendeAn(LebendigesObjekt selbst, LebendigesObjekt ziel)
	{
		try
		{
			this.selbstEffekt.wirke(selbst);
		} catch (NullPointerException e)
		{
			DebugAusgabeKlasse.ausgeben("Aktion hat keinen Selbsteffekt");
		}
		try
		{
			this.zielEffekt.wirke(ziel);
		} catch (NullPointerException e)
		{
			DebugAusgabeKlasse.ausgeben("Aktion hat keinen Zieleffekt");
		}
	}

}
