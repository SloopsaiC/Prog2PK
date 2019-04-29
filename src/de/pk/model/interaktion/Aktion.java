package de.pk.model.interaktion;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektController;

public class Aktion
{

	private Effekt[] selbstEffekte = null; // Der Effekt welcher auf das ausfuehrende Objekt angewendet wird
	private Effekt[] zielEffekte = null; // Der Effekt welcher auf das von dieser Aktion angezielte Objekt angewendet
											// wird
	private String name = null;
	private float grundErfolgsWahrscheinlichkeit = 0.0f;

	public Aktion(String name, Effekt[] selbstEffekt, Effekt[] zielEffekt, float erfolgsWahrscheinlichkeit)
	{
		this.name = name;
		this.selbstEffekte = selbstEffekt;
		this.zielEffekte = zielEffekt;
		this.grundErfolgsWahrscheinlichkeit = erfolgsWahrscheinlichkeit;
	}

	public Aktion(String name, Effekt selbstEffekt, Effekt zielEffekt, float erfolgsWahrscheinlichkeit)
	{
		this(name, new Effekt[]
		{ selbstEffekt }, new Effekt[]
		{ zielEffekt }, erfolgsWahrscheinlichkeit);
	}

	private float berechneErfolgsWahrscheinlichkeit(LebendigesObjektController wirker, LebendigesObjektController ziel)
	{
		return this.grundErfolgsWahrscheinlichkeit;
	}

	public String getName()
	{
		return this.name;
	}

	private boolean ueberpruefeAktion(LebendigesObjektController wirker)
	{
		int bewegungsPunkte = 0;
		for (Effekt e : this.selbstEffekte)
		{
			bewegungsPunkte += e.getBewegungsPunkteAenderung() * (-1);
		}
		return wirker.kannSichUmXBewegen(bewegungsPunkte);
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
		if (ueberpruefeAktion(wirker)
				&& this.wuerfelWurfErfolgreich(wuerfel, this.berechneErfolgsWahrscheinlichkeit(wirker, ziel)))
		{
			wirker.fuegeEffekteHinzu(this.selbstEffekte);
			if (ziel != null)
			{
				ziel.fuegeEffekteHinzu(this.zielEffekte);
			}
			return true;
		}
		return false;
	}

	private boolean wuerfelWurfErfolgreich(Wuerfel wuerfel, float erfolgsWahrscheinlichkeit)
	{
		synchronized (wuerfel)
		{
			wuerfel.wuerfeln();
			return wuerfel.letzteAugenZahlAlsFloat() < erfolgsWahrscheinlichkeit;
		}
	}

}
