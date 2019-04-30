package de.pk.control.spiel.phasen;

import de.pk.control.spiel.Dungeon;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.KachelPosition;

public class ExplorationsPhase extends Phase
{

	/**
	 * @see de.pk.control.spiel.phasen.Phase#phasenTick(Dungeon, Held)
	 * */
	@Override
	public void phasenTick(Dungeon aktiverDungeonController, Held aktiverHeld)
	{
		KachelPosition aktuellePosition = aktiverDungeonController.getSpielbrett().findeSpielbrettObjekt(aktiverHeld);
		Richtung kantenRichtung = aktuellePosition.getKantenRichtungFallsAnKante();
		if (kantenRichtung != null)
		{
			aktiverDungeonController.generiereUndfuegeNeueKachelZuSpielbrettHinzu(kantenRichtung,
					aktiverDungeonController.getSpielbrett().getPositionKachel(aktuellePosition.getKachel()));
		}
		super.fertig();
	}
}
