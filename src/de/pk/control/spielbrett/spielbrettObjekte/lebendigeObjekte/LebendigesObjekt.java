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
			this.sterben(this.getModell().getVerursacherVonEffekt(zuUeberpruefen));
			return true;
		}
		return false;
	}

	private void entferneAuswirkungenFallsNichtTickend(Effekt zuEntfernen)
	{
		if (!zuEntfernen.istTickend())
		{
			this.wendeEffektAufModellAn(zuEntfernen.getNegation());
		}
	}

	/**
	 * Entfernt einen Effekt aus den registrierten Effekten dieses Objektes und
	 * macht seine Wirkung rueckgaengig falls der Effekt nicht "tickend" ist
	 *
	 * @param zuEntfernen Der Objekt der entfernt werden soll
	 */
	public void entferneEffekt(Effekt zuEntfernen)
	{
		if ((zuEntfernen != null) && this.getModell().getEffekte().contains(zuEntfernen))
		{
			this.entferneAuswirkungenFallsNichtTickend(zuEntfernen);
			this.getModell().entferneEffekt(zuEntfernen);
		}
	}

	public void fuegeAktionHinzu(String name, Aktion hinzufuegen)
	{
		this.getModell().fuegeAktionHinzu(name.toLowerCase(), hinzufuegen);
	}

	@Override
	public void fuegeEffekteHinzu(SpielbrettObjekt verursacher, Effekt... hinzufuegen)
	{
		if (hinzufuegen != null)
		{
			for (Effekt effekt : hinzufuegen)
			{
				this.getModell().fuegeEffektHinzu(effekt, verursacher);
			}
		}
	}

	/**
	 * Generiert die Items die dieses lebendige Objekt zum Beispiel beim Sterben an
	 * den Grund fuer dieses uebergibt.
	 *
	 * @return Container, ein Container der die Gegenstaende enthaelt welche durch
	 *         das Sterben von diesem Objekt "fallen gelassen" werden
	 */
	protected abstract Container generiereAuswurf();

	public Aktion getAktionMitNamen(String name)
	{
		return this.getModell().getAktionMitNamen(name);
	}

	public Set<String> getAktionsNamen()
	{
		return this.getModell().getAktionen().keySet();
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
		return this.getModell().getAnzahlPunkteVon(LebendigesObjektPunkteIndex.IST_GESCHUETZT) > 0;
	}

	@Override
	public boolean istLebendig()
	{
		return this.getModell().getAnzahlPunkteVon(LebendigesObjektPunkteIndex.LEBENS_PUNKTE) < 1;
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
		for (Effekt momentanerEffekt : this.modell.getEffekte())
		{
			this.updateMomentanenEffekt(momentanerEffekt);
			if (momentanerEffekt.istAbgeklungen())
			{
				this.entferneEffekt(momentanerEffekt);// wenn der Effekt abgeklungen ist, wird er entfernt
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
				this.modell.aenderePunkteVon(index, zuAnwenden.getWertAusBeschreibung(effektBeschreibung));
			}
		}
		zuAnwenden.wurdeGewirkt();
	}

}
