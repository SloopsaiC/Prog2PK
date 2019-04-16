package de.pk.model.dungeon;

import java.util.ArrayList;

import de.pk.control.spiel.phasen.Phase;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class Dungeon
{

	private Spielbrett spielbrett = null;

	private String name = null;
	// Repraesentation der Phasen und der aktuell im Dungeon behandelten Phase
	private ArrayList<Phase> phasen = null;
	private int momentanePhaseIndex = 0;
	private Held[] helden = null;
	private int aktiverHeldIndex = 0;

	public Dungeon(String name)
	{
		this.spielbrett = new Spielbrett();
		this.name = name;
		this.phasen = new ArrayList<>();
		this.helden = new Held[0];
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
	public ArrayList<Phase> getPhasen()
	{
		return this.phasen;
	}

	public void setPhasen(ArrayList<Phase> phasen)
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

	public Held getAktivenHeld()
	{
		return this.helden[this.aktiverHeldIndex];
	}

	public void setHelden(Held[] helden)
	{
		this.helden = helden;
	}

	public void naechsterHeld()
	{
		this.aktiverHeldIndex = ++this.aktiverHeldIndex % this.helden.length;
	}

	public Phase getMomentanePhase()
	{
		return this.phasen.get(this.momentanePhaseIndex);
	}

	public void naechstePhaseAktivieren()
	{
		this.momentanePhaseIndex = ++this.momentanePhaseIndex % this.phasen.size();
	}
}
