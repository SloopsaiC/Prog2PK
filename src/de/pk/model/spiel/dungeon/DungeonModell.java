package de.pk.model.spiel.dungeon;

import java.util.ArrayList;

import de.pk.control.karte.generator.KartenGenerator;
import de.pk.control.spiel.phasen.Phase;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrund;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.utils.Spielkonstanten;

public class DungeonModell
{

	private Spielbrett spielbrett = null;

	private String name = null;
	// Repraesentation der Phasen und der aktuell im Dungeon behandelten Phase
	private ArrayList<Phase> phasen = null;
	private int momentanePhaseIndex = 0;
	private Held[] helden = null;
	private int aktiverHeldIndex = 0;
	private KartenGenerator kartenGenerator = null;

	public DungeonModell(Spielbrett spielbrett, String name, ArrayList<Phase> phasen, int momentanePhaseIndex,
			Held[] helden, int aktiverHeldIndex, KartenGenerator kartenGenerator)
	{
		this.spielbrett = spielbrett;
		this.name = name;
		this.phasen = phasen;
		this.momentanePhaseIndex = momentanePhaseIndex;
		this.helden = helden;
		this.aktiverHeldIndex = aktiverHeldIndex;
		this.kartenGenerator = kartenGenerator;
	}

	public DungeonModell(String name)
	{
		this(new Spielbrett(), name, new ArrayList<Phase>(), 0, Spielkonstanten.STANDARD_HELDEN, 0,
				new KartenGenerator(KartenGeneratorUntergrund.values()));
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

	public KartenGenerator getKartenGenerator()
	{
		return this.kartenGenerator;
	}

	public Phase getMomentanePhase()
	{
		return this.phasen.get(this.momentanePhaseIndex);
	}

	public int getMomentanePhaseIndex()
	{
		return this.momentanePhaseIndex;
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
		if (this.momentanePhaseIndex == 0)
		{
			this.naechsterHeld();
		}
	}

	public void naechsterHeld()
	{
		this.aktiverHeldIndex = ++this.aktiverHeldIndex % this.helden.length;
		this.helden[this.aktiverHeldIndex].resetAktionsPunkte();
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
