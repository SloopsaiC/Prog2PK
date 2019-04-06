package de.pk.model.dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.pk.control.spiel.phasen.Phase;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class Dungeon
{

	private Spielbrett spielbrett = null;

	private String name = null;

	private List<Phase> phasen = null;
	private Held[] helden = null;
	private int anzahlAktiverHelden = 0;
	private int naechstePhaseIndex = 0;

	public Dungeon(String name, int maximaleAnzahlHelden)
	{
		this.spielbrett = new Spielbrett();
		this.name = name;
		this.phasen = Collections.synchronizedList(new ArrayList<Phase>());
		this.helden = new Held[maximaleAnzahlHelden];
	}

	public boolean aufgabeIstErfuellt()
	{
		return false;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @return the phasen
	 */
	public List<Phase> getPhasen()
	{
		return this.phasen;
	}

	public void setPhasen(List<Phase> phasen)
	{
		this.phasen = phasen;
	}

	/**
	 * @return the spielbrett
	 */
	public Spielbrett getSpielbrett()
	{
		return this.spielbrett;
	}

	/**
	 * @return the helden
	 */
	public Held[] getHelden()
	{
		return this.helden;
	}

	/**
	 * @return the anzahlAktiverHelden
	 */
	public int getAnzahlAktiverHelden()
	{
		return this.anzahlAktiverHelden;
	}

	/**
	 * @return the naechstePhaseIndex
	 */
	public int getNaechstePhaseIndex()
	{
		return this.naechstePhaseIndex;
	}

	public void naechstePhaseAktivieren()
	{
		this.naechstePhaseIndex = (this.naechstePhaseIndex + 1) % this.getPhasen().size();
	}

	public Phase getNaechstePhase()
	{
		return this.phasen.get(this.naechstePhaseIndex);
	}

	public void heldHinzufuegen(Held hinzufuegen)
	{
		// Synchronized -> IndexOutOfBounds nach Increment
		synchronized (this)
		{
			if (this.anzahlAktiverHelden < this.helden.length)
			{
				this.helden[this.anzahlAktiverHelden++] = hinzufuegen;
			} else
			{
				// TODO: Exception Messages
				throw new IllegalStateException();
			}
		}
	}

}
