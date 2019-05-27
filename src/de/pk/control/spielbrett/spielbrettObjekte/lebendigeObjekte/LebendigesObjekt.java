package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.Set;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.gegenstaende.container.Container;
import de.pk.model.interaktion.Anzielbar;
import de.pk.model.interaktion.aktionen.Aktion;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.interaktion.effekt.EffektBeschreibungsIndex;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektModell;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektPunkteIndex;

public abstract class LebendigesObjekt extends SpielbrettObjekt implements Anzielbar
{

	private final LebendigesObjektModell modell;

	protected LebendigesObjekt(LebendigesObjektModell modell)
	{
		this.modell = modell;
	}

	private void entferneAuswirkungenFallsTickend(Effekt zuEntfernen)
	{
		if (!zuEntfernen.istTickend())
		{
			for (EffektBeschreibungsIndex index : EffektBeschreibungsIndex.values())
			{
				try
				{
					this.modell.aenderePunkteVon(LebendigesObjektPunkteIndex.uebersetzeAusEffektIndex(index),
							zuEntfernen.getWertAusBeschreibung(index));
				} catch (IllegalArgumentException nichtMoeglich)
				{
					// Passiert, falls die momentane Aenderung durch den Effekt nicht in einem
					// lebendigen Objekt gespeichert wird, dementsprechend ist dieser Index nicht in
					// LebendigesObjektPunkteIndex aufgefuehrt
					continue;
				}
			}
		}
	}

	/**
	 * Entfernt einen Effekt aus den registrierten Effekten dieses
	 */
	public void entferneEffekt(Effekt zuEntfernen)
	{
		if (zuEntfernen != null && this.getModell().getEffekte().contains(zuEntfernen))
		{
			this.entferneAuswirkungenFallsTickend(zuEntfernen);
			this.modell.entferneEffekt(zuEntfernen);
		}
	}

	public void fuegeAktionHinzu(String name, Aktion hinzufuegen)
	{
		this.modell.fuegeAktionHinzu(name.toLowerCase(), hinzufuegen);
	}

	protected void hatGetoetet(LebendigesObjekt opfer)
	{
		this.getModell().aenderePunkteVon(LebendigesObjektPunkteIndex.ERFAHRUNGSPUNKTE,
				opfer.getAnzahlPunkteVon(LebendigesObjektPunkteIndex.ERFAHRUNGSPUNKTE_WERT));
	}

	/**
	 * Generiert die Items die dieses lebendige Objekt zum Beispiel beim Sterben an
	 * den Grund fuer dieses uebergibt.
	 * 
	 * @return Container, ein Container der die Gegenstaende enthaelt welche durch
	 *         das Sterben von diesem Objekt "fallen gelassen" werden
	 */
	protected abstract Container generiereAuswurf();

	/**
	 * Wird aufgerufen wenn dieses Objekt auf Grund seines Statuses als "tot"
	 * angesehen wird
	 * 
	 * @param verursacher Der Grund des Todes
	 */
	protected void sterben(LebendigesObjekt verursacher)
	{
		verursacher.hatGetoetet(this);

	}

	@Override
	public boolean fuegeEffekteHinzu(SpielbrettObjekt verursacher, Effekt... hinzufuegen)
	{
		if (hinzufuegen != null)
		{
			for (Effekt effekt : hinzufuegen)
			{
				this.modell.fuegeEffektHinzu(effekt);
			}
			// Ueberpruefen ob das lebendige Objekt auf Grund der Effekte gestorben ist
			if (!this.istLebendig())
			{
				if (verursacher.istLebendig())
				{
					this.sterben((LebendigesObjekt) verursacher);
				}
			}
			return true;
		}
		return false;
	}

	public Aktion getAktionMitNamen(String name)
	{
		return this.getModell().getAktionMitNamen(name);
	}

	public Set<String> getAktionsNamen()
	{
		return this.modell.getAktionen().keySet();
	}

	public int getAnzahlPunkteVon(LebendigesObjektPunkteIndex index)
	{
		return this.getModell().getAnzahlPunkteVon(index);
	}

	protected LebendigesObjektModell getModell()
	{
		return this.modell;
	}

	/*
	 *
	 * @see de.pk.model.interaktion.Anzielbar#getTrefferWahrscheinlichkeit()
	 */
	@Override
	public float getTrefferWahrscheinlichkeit()
	{
		return 1f;
	}

	/*
	 * @see de.pk.model.interaktion.Anzielbar#istGeschuetzt()
	 */
	@Override
	public boolean istGeschuetzt()
	{
		return this.getModell().getAnzahlPunkteVon(LebendigesObjektPunkteIndex.IST_GESCHUETZT) > 0;

	}

	@Override
	public boolean istLebendig()
	{
		return this.getModell().getAnzahlPunkteVon(LebendigesObjektPunkteIndex.LEBENS_PUNKTE) < 1;
	}

	/**
	 * Wendet alle auf dieses lebendige Objekt registrierten Effekte auf dieses an.
	 * Die Positionsaenderung die durch diese verursacht werden wuerde wird an den
	 * Aufrufer zurueckgegeben.
	 *
	 * @return Die Positionsaenderung die durch die Effekte verursacht werden wuerde
	 */
	public void update()
	{
		// Nur lebendige Objekte koennen von Effekten und so weiter beeinflusst werden
		if (!this.istLebendig())
		{
			return;
		}
		for (Effekt momentanerEffekt : this.modell.getEffekte())
		{
			// Hier wird geschaut ob ein Effekt tickend ist, also eine Aenderung bei dem
			// Modell im naechsten Tick erzeugen soll, ist dies der Fall wird die durch ihn
			// definierte Aenderung ausgefuehrt, sonst wird dem Effekt nur mitgeteilt, dass
			// ein Schritt verstrichen ist
			if (momentanerEffekt.istTickend())
			{
				this.wendeEffektAufModellAn(momentanerEffekt);
			} else
			{
				momentanerEffekt.wurdeGewirkt();
			}
			if (momentanerEffekt.istAbgeklungen())
			{
				this.entferneEffekt(momentanerEffekt); // wenn der Effekt abgeklungen ist, wird er
														// entfernt.
			}
		}
	}

	/**
	 * Wendet einen Effekt auf das Modell dieses Objektes an.
	 * 
	 * @param zuAnwenden Der Effekt welcher auf das Modell angewendet werden soll
	 */
	private void wendeEffektAufModellAn(Effekt zuAnwenden)
	{
		for (LebendigesObjektPunkteIndex index : LebendigesObjektPunkteIndex.values())
		{
			try
			{
				this.modell.aenderePunkteVon(index, zuAnwenden.getWertAusBeschreibung(
						EffektBeschreibungsIndex.uebersetzeAusLebendigesObjektPunkteIndex(index)));
			} catch (IllegalArgumentException nichtMoeglich)
			{
				// Passiert wenn ein Teil der LebendigesObjekt Beschreibung nicht durch Effekte
				// veraendert werden kann, also nicht in deren Indizies auftritt, in diesem Fall
				// wird der Wert einfach ignoriert
				continue;
			}

		}
		zuAnwenden.wurdeGewirkt();
	}

}
