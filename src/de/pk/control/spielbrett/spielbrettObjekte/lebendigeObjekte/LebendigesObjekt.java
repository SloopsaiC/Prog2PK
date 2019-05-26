package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.ArrayList;
import java.util.Set;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.interaktion.Anzielbar;
import de.pk.model.interaktion.aktionen.Aktion;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.interaktion.effekt.EffektBeschreibungsIndex;
import de.pk.model.position.KachelPosition;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektModell;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektPunkteIndex;

public abstract class LebendigesObjekt extends SpielbrettObjekt implements Anzielbar
{

	private final LebendigesObjektModell modell;

	protected LebendigesObjekt(LebendigesObjektModell modell)
	{
		this.modell = modell;
	}

	public void entferneEffekt(Effekt zuEntfernen)
	{
		if (zuEntfernen != null)
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
			this.modell.entferneEffekt(zuEntfernen);
		}
	}

	public void fuegeAktionHinzu(String name, Aktion hinzufuegen)
	{
		this.modell.fuegeAktionHinzu(name.toLowerCase(), hinzufuegen);
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
			return true;
		}
		return false;
	}

	/**
	 * Filtert aus einer Liste mit Effekten alle tickenden Effekte heraus.
	 *
	 * @param ausgangsListe Die Liste aus der gefiltert werden soll
	 *
	 * @return Eine Liste mit allen tickenden Effekten aus der Ausgangsliste
	 */
	private ArrayList<Effekt> generiereListeVonTickendenEffektenAus(ArrayList<Effekt> ausgangsListe)
	{
		ArrayList<Effekt> tickendeEffekte = new ArrayList<>(ausgangsListe);
		tickendeEffekte.removeIf(e -> !e.istTickend());
		return tickendeEffekte;
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
		if (this.getModell().getAnzahlPunkteVon(LebendigesObjektPunkteIndex.IST_GESCHUETZT) > 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean istLebendig()
	{
		return true;
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
		for (Effekt momentanerEffekt : this.generiereListeVonTickendenEffektenAus(this.modell.getEffekte()))
		{
			this.wendeEffektAufModellAn(momentanerEffekt);
			if (momentanerEffekt.istAbgeklungen())
			{
				this.modell.getEffekte().remove(momentanerEffekt); // wenn der Effekt abgeklungen ist, wird er
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
			EffektBeschreibungsIndex effektBeschreibung = EffektBeschreibungsIndex
					.uebersetzeAusLebendigesObjektPunkteIndex(index);
			if (effektBeschreibung != null)
			{
				this.modell.aenderePunkteVon(index, zuAnwenden.getWertAusBeschreibung(
						EffektBeschreibungsIndex.uebersetzeAusLebendigesObjektPunkteIndex(index)));
			}
		}
		zuAnwenden.wurdeGewirkt();
	}

}
