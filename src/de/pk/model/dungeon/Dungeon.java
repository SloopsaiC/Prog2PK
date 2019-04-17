package de.pk.model.dungeon;

import java.util.ArrayList;

import de.pk.control.spiel.phasen.Phase;
import de.pk.kartenGenerator.KartenGenerator;
import de.pk.kartenGenerator.KartenGeneratorKachelInterface;
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
	private KartenGenerator kartenGenerator = null;

	public Dungeon(String name)
	{
		this.spielbrett = new Spielbrett();
		this.name = name;
		this.phasen = new ArrayList<>();
		this.helden = new Held[0];
		this.kartenGenerator = new KartenGenerator(KartenGeneratorKachelInterface.alleKacheln);
	}

	public KartenGenerator getKartenGenerator()
	{
		return this.kartenGenerator;
	}

	public boolean aufgabeIstErfuellt()
	{
		return false;
	}

	public Held getAktivenHeld()
	{
		return this.helden[this.aktiverHeldIndex];
	}

	/**
	 * @return the helden
	 */
	public Held[] getHelden()
	{
		return this.helden;
	}

	public Phase getMomentanePhase()
	{
		return this.phasen.get(this.momentanePhaseIndex);
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

	/**
	 * @return the spielbrett
	 */
	public Spielbrett getSpielbrett()
	{
		return this.spielbrett;
	}

	public void naechstePhaseAktivieren()
	{
		this.momentanePhaseIndex = ++this.momentanePhaseIndex % this.phasen.size();
	}

	public void naechsterHeld()
	{
		this.aktiverHeldIndex = ++this.aktiverHeldIndex % this.helden.length;
	}

	public void setHelden(Held[] helden)
	{
		this.helden = helden;
	}

	public void setPhasen(ArrayList<Phase> phasen)
	{
		this.phasen = phasen;
	}
}
