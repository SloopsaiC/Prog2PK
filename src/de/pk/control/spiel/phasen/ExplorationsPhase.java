package de.pk.control.spiel.phasen;

import de.pk.control.spiel.Dungeon;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.KachelPosition;

public class ExplorationsPhase extends Phase
{

	/**
	 * @see de.pk.control.spiel.phasen.Phase#phasenTick(Dungeon, Held)
	 */
	@Override
	public void phasenTick(Dungeon aktiverDungeon, Held aktiverHeld)
	{
		KachelPosition aktuellePosition = aktiverDungeon.getSpielbrett().findeSpielbrettObjekt(aktiverHeld);
		Richtung kantenRichtung = aktuellePosition.getKantenRichtungFallsAnKante();
		if (kantenRichtung != null)
		{
			aktiverDungeon.generiereUndfuegeNeueKachelZuSpielbrettHinzu(kantenRichtung,
					aktiverDungeon.getSpielbrett().getPositionKachel(aktuellePosition.getKachel()));
		}
		super.fertig();
	}
}
