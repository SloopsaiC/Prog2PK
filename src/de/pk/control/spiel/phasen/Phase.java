package de.pk.control.spiel.phasen;

import de.pk.control.app.Anwendung;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.position.KachelPosition;

public abstract class Phase
{
	private Held aktiverHeld = null;

	protected Phase()
	{
	}

	protected void beendePhase()
	{
		Anwendung.getInstanz().getAktivesSpiel().getAktiverDungeon().naechstePhase();
	}

	public Held getAktivenHeld()
	{
		return this.aktiverHeld;
	}

	public void startePhaseMit(Held held)
	{
		this.aktiverHeld = held;
	}

	public void verarbeiteKlickAufKachelPosition(KachelPosition eingabe, int aktiveAktionIndex)
	{
		// Normalerweise reagiert eine Phase auf nichts
	}
}
