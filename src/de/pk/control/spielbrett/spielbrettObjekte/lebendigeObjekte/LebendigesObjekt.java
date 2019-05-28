package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.ArrayList;
import java.util.Set;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
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

<<<<<<< HEAD
	/**
	 * Prueft ob ein Effekt den Zustand dieses Objektes so veraendert hat, dass es
	 * jetzt als "tot" angesehen werden soll. Falls dies so ist wird auch das
	 * "Sterben" ausgeloest
	 *
	 * @param zuUeberpruefen Der Effekt welcher ueberprueft werden soll
	 */
	private boolean effektWarToedlich(Effekt zuUeberpruefen)
	{
		if (!this.istLebendig())
		{
			this.sterben(this.modell.getVerursacherVonEffekt(zuUeberpruefen));
			return true;
		}
		return false;
	}

	private void entferneAuswirkungenFallsTickend(Effekt zuEntfernen)
	{
		if (!zuEntfernen.istTickend())
		{
			this.wendeEffektAufModellAn(zuEntfernen, true);
		}
	}

	/**
	 * Entfernt einen Effekt aus den registrierten Effekten dieses Objektes
	 * 
	 * @param zuEntfernen Der Objekt der entfernt werden soll
	 */
=======
>>>>>>> refs/heads/Phillip
	public void entferneEffekt(Effekt zuEntfernen)
	{
<<<<<<< HEAD
		if ((zuEntfernen != null) && this.getModell().getEffekte().contains(zuEntfernen))
=======
		if (zuEntfernen != null)
>>>>>>> refs/heads/Phillip
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

<<<<<<< HEAD
=======
	private void hatGetoetet(LebendigesObjekt opfer)
	{
		this.getModell().aenderePunkteVon(LebendigesObjektPunkteIndex.ERFAHRUNGSPUNKTE,
				opfer.getAnzahlPunkteVon(LebendigesObjektPunkteIndex.ERFAHRUNGSPUNKTE_WERT));
		// Hier sollten am besten noch die Drops integriert werden mache ich morgen und
		// so
		// TODO
	}

>>>>>>> refs/heads/Phillip
	@Override
	public boolean fuegeEffekteHinzu(SpielbrettObjekt verursacher, Effekt... hinzufuegen)
	{
		if (hinzufuegen != null)
		{
			for (Effekt effekt : hinzufuegen)
			{
				this.modell.fuegeEffektHinzu(effekt, verursacher);
			}
<<<<<<< HEAD
			// Ueberpruefen ob das lebendige Objekt auf Grund der Effekte gestorben ist
=======
			if (this.istTot())
			{
				if (verursacher.istLebendig())
				{
					((LebendigesObjekt) verursacher).hatGetoetet(this);
				}
			}
>>>>>>> refs/heads/Phillip
			return true;
		}
		return false;
	}

<<<<<<< HEAD
	/**
	 * Generiert die Items die dieses lebendige Objekt zum Beispiel beim Sterben an
	 * den Grund fuer dieses uebergibt.
	 *
	 * @return Container, ein Container der die Gegenstaende enthaelt welche durch
	 *         das Sterben von diesem Objekt "fallen gelassen" werden
	 */
	protected abstract Container generiereAuswurf();
=======
	public boolean istTot()
	{
		return this.getModell().getAnzahlPunkteVon(LebendigesObjektPunkteIndex.LEBENS_PUNKTE) < 1;
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
>>>>>>> refs/heads/Phillip

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

	@Override
	public void hatGetoetet(LebendigesObjekt opfer)
	{
		this.getModell().aenderePunkteVon(LebendigesObjektPunkteIndex.ERFAHRUNGSPUNKTE,
				opfer.getAnzahlPunkteVon(LebendigesObjektPunkteIndex.ERFAHRUNGSPUNKTE_WERT));
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
	 * Wird aufgerufen wenn dieses Objekt auf Grund seines Statuses als "tot"
	 * angesehen wird
	 *
	 * @param verursacher Der Grund des Todes
	 */
	protected void sterben(SpielbrettObjekt verursacher)
	{
		verursacher.hatGetoetet(this);
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
<<<<<<< HEAD
			return;
		}
		for (Effekt momentanerEffekt : this.modell.getEffekte())
		{
			this.updateMomentanenEffekt(momentanerEffekt);
=======
			this.wendeEffektAufModellAn(momentanerEffekt);
>>>>>>> refs/heads/Phillip
			if (momentanerEffekt.istAbgeklungen())
			{
				this.modell.getEffekte().remove(momentanerEffekt); // wenn der Effekt abgeklungen ist, wird er
																	// entfernt.
			}
			if (this.effektWarToedlich(momentanerEffekt))
			{
				break;
			}
		}
	}

	/**
	 * Hier wird geschaut ob ein Effekt tickend ist, also eine Aenderung bei dem
	 * Modell im naechsten Tick erzeugen soll, ist dies der Fall wird die durch ihn
	 * definierte Aenderung ausgefuehrt, sonst wird dem Effekt nur mitgeteilt, dass
	 * ein Schritt verstrichen ist.
	 *
	 * @param momentanerEffekt Der zu behandelne Effekt
	 */
	private void updateMomentanenEffekt(Effekt momentanerEffekt)
	{
		if (momentanerEffekt.istTickend())
		{
			this.wendeEffektAufModellAn(momentanerEffekt);

		} else
		{
			momentanerEffekt.wurdeGewirkt();
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

	private void wendeEffektAufModellAn(Effekt zuAnwenden, boolean negiert)
	{
		if (negiert)
		{
			this.wendeEffektAufModellAn(zuAnwenden.getNegation());
		} else
		{
			this.wendeEffektAufModellAn(zuAnwenden);
		}
	}

}
