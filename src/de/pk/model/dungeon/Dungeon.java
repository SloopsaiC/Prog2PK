package de.pk.model.dungeon;

import java.util.ArrayList;

import de.pk.control.kartekartenGenerator.KartenGenerator;
import de.pk.control.kartekartenGenerator.KartenGeneratorKachelInterface;
import de.pk.control.spiel.phasen.Phase;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.HeldController;
import de.pk.model.spielbrett.Spielbrett;

public class Dungeon
{

	private Spielbrett spielbrett = null;

	private String name = null;
	// Repraesentation der Phasen und der aktuell im Dungeon behandelten Phase
	private ArrayList<Phase> phasen = null;
	private int momentanePhaseIndex = 0;
	private HeldController[] helden = null;
	private int aktiverHeldIndex = 0;
	private KartenGenerator kartenGenerator = null;

	public Dungeon(String name)
	{
		this.spielbrett = new Spielbrett();
		this.name = name;
		this.phasen = new ArrayList<>();
		this.helden = new HeldController[0];
		this.kartenGenerator = new KartenGenerator(KartenGeneratorKachelInterface.ALLEKACHELN);
	}

	public boolean aufgabeIstErfuellt()
	{
		return false;
	}

	public HeldController getAktivenHeld()
	{
		return this.helden[this.aktiverHeldIndex];
	}

	/**
	 * @return the helden
	 */
	public HeldController[] getHelden()
	{
		return this.helden;
	}

	public KartenGenerator getKartenGenerator()
	{
		return this.kartenGenerator;
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

	public void setHelden(HeldController[] helden)
	{
		this.helden = helden;
	}

	public void setPhasen(ArrayList<Phase> phasen)
	{
		this.phasen = phasen;
	}
}
