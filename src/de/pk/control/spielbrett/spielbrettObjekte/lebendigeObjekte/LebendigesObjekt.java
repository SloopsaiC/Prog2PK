package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Set;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.interaktion.Aktion;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.interaktion.effekt.EffektBeschreibungsIndex;
import de.pk.model.position.Vektor;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektModell;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektPunkteIndex;
import de.pk.utils.Spielkonstanten;

public abstract class LebendigesObjekt extends SpielbrettObjekt
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

	public void fuegeEffekteHinzu(Effekt... hinzufuegen)
	{
		if (hinzufuegen != null)
		{
			for (Effekt effekt : hinzufuegen)
			{
				this.modell.fuegeEffektHinzu(effekt);
			}
		}
	}

	public void fuehreAktionAus(String name, LebendigesObjekt ziel)
	{
		try
		{
			this.modell.getAktionMitNamen(name.toLowerCase()).wendeAn(this, ziel, Spielkonstanten.WUERFEL);
		} catch (NullPointerException nichtVorhanden)
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}

	}

	public Set<String> getAktionsNamen()
	{
		return this.modell.getAktionen().keySet();
	}

	protected LebendigesObjektModell getModell()
	{
		return this.modell;
	}

	@Override
	public boolean istLebendig()
	{
		return true;
	}

	public boolean kannSichUmXBewegen(int x)
	{
		return !(x > this.modell.getAnzahlPunkteVon(LebendigesObjektPunkteIndex.BEWEGUNGS_PUNKTE));
	}

	private Vektor generiereAenderungsVektorAusEffekt(Effekt enthaltenerEffekt)
	{
		return new Vektor(enthaltenerEffekt.getWertAusBeschreibung(EffektBeschreibungsIndex.BEWEGUNG_X),
				enthaltenerEffekt.getWertAusBeschreibung(EffektBeschreibungsIndex.BEWEGUNG_Y));
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

	private void wendeEffektAufModellAn(Effekt zuAnwenden)
	{
		for (LebendigesObjektPunkteIndex index : LebendigesObjektPunkteIndex.values())
		{
			this.modell.aenderePunkteVon(index, zuAnwenden
					.getWertAusBeschreibung(EffektBeschreibungsIndex.uebersetzeAusLebendigesObjektPunkteIndex(index)));
		}
	}

	/**
	 * Wendet alle auf dieses lebendige Objekt registrierten Effekte auf dieses an.
	 * Die Positionsaenderung die durch diese verursacht werden wuerde wird an den
	 * Aufrufer zurueckgegeben.
	 * 
	 * @return Die Positionsaenderung die durch die Effekte verursacht werden wuerde
	 */
	public Vektor update()
	{
		Vektor positionsAenderung = new Vektor(0, 0);
		// While und List Iterator da hier ein Element waehrend des Iterierens aus der
		// Liste entfernt werden kann (Abgeklungene Effekte)
		for (Effekt momentanerEffekt : generiereListeVonTickendenEffektenAus(this.modell.getEffekte()))
		{
			wendeEffektAufModellAn(momentanerEffekt);
			// Update die Positionsaenderung die von allen Effekten
			// in Summe "gefordert" wird
			positionsAenderung = positionsAenderung.addiere(generiereAenderungsVektorAusEffekt(momentanerEffekt));
			momentanerEffekt.wurdeGewirkt();
			if (momentanerEffekt.istAbgeklungen())
			{
				this.modell.getEffekte().remove(momentanerEffekt); // wenn der Effekt abgeklungen ist, wird er
																	// entfernt.
			}
		}
		return positionsAenderung;
	}
}
