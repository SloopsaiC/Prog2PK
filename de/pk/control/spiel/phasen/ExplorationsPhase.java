package de.pk.control.spiel.phasen;

import de.pk.control.spiel.Dungeon;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.KachelPosition;

public class ExplorationsPhase extends Phase
{
	private boolean istFertig = false;

	public ExplorationsPhase()
	{
		super();
	}

	/**
	 * Gibt true zurueck, falls die Phase als fertig erachtet wird
	 */
	@Override
	public boolean istFertig()
	{
		return this.istFertig;
	}

	/**
	 * @see de.pk.control.spiel.phasen.Phase#phasenSchritt(Dungeon, Held)
	 */
	@Override
	public void phasenSchritt(Dungeon aktiverDungeon, Held aktiverHeld)
	{
		KachelPosition aktuellePosition = aktiverDungeon.getSpielbrett().findeSpielbrettObjekt(aktiverHeld);
		Richtung kantenRichtung = aktuellePosition.getKantenRichtungFallsAnKante();
		if (kantenRichtung != null)
		{
			aktiverDungeon.generiereUndfuegeNeueKachelZuSpielbrettHinzu(kantenRichtung,
					aktiverDungeon.getSpielbrett().getPositionKachel(aktuellePosition.getKachel()));
		}
		this.istFertig = true;
	}
}
