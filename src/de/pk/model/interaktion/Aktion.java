package de.pk.model.interaktion;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektController;

public class Aktion
{

	private Effekt[] selbstEffekte = null; // Der Effekt welcher auf das ausfuehrende Objekt angewendet wird
	private Effekt[] zielEffekte = null; // Der Effekt welcher auf das von dieser Aktion angezielte Objekt angewendet
											// wird
	private float grundErfolgsWahrscheinlichkeit = 0.0f;

	public Aktion(Effekt[] selbstEffekt, Effekt[] zielEffekt, float erfolgsWahrscheinlichkeit)
	{
		this.selbstEffekte = selbstEffekt;
		this.zielEffekte = zielEffekt;
		this.grundErfolgsWahrscheinlichkeit = erfolgsWahrscheinlichkeit;
	}

	private boolean wuerfelWurfErfolgreich(Wuerfel wuerfel, float erfolgsWahrscheinlichkeit)
	{
		synchronized (wuerfel)
		{
			wuerfel.wuerfeln();
			return wuerfel.letzteAugenZahlAlsFloat() < erfolgsWahrscheinlichkeit;
		}
	}

	private float berechneErfolgsWahrscheinlichkeit(LebendigesObjektController wirker, LebendigesObjektController ziel)
	{
		return this.grundErfolgsWahrscheinlichkeit;
	}

	/**
	 * Wendet eine Aktion auf ein Ziel und auf den Ausfuehrenden an. Der Erfolg wird
	 * dabei durch einen Wuerfel bestimmt
	 * 
	 * @param wirker  Das ausfuehrende LebendigeObjekt
	 * @param ziel    Das Ziel dieser Aktion
	 * @param wuerfel Der Wuerfel der fuer diese Aktion genutzt wird
	 * 
	 * @return true, falls die Aktion erfolgreich ausgefuehrt wurde, sonst false
	 */
	public boolean wendeAn(LebendigesObjektController wirker, LebendigesObjektController ziel, Wuerfel wuerfel)
	{
		if (wuerfelWurfErfolgreich(wuerfel, berechneErfolgsWahrscheinlichkeit(wirker, ziel)))
		{
			wirker.fuegeEffekteHinzu(this.selbstEffekte);
			ziel.fuegeEffekteHinzu(this.zielEffekte);
			return true;
		}
		return false;
	}

}
