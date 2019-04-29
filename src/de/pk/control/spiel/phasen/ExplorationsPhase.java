package de.pk.control.spiel.phasen;

import de.pk.control.spiel.DungeonController;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.HeldController;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.KachelPosition;

public class ExplorationsPhase extends Phase
{

	@Override
	public void phasenTick(DungeonController aktiverDungeonController, HeldController aktiverHeld)
	{
		KachelPosition aktuellePosition = aktiverDungeonController.getSpielbrett().findeSpielbrettObjekt(aktiverHeld);
		Richtung kantenRichtung = aktuellePosition.getKantenRichtungFallsAnKante();
		if (kantenRichtung != null)
		{
			aktiverDungeonController.fuegeNeueKachelZuSpielbrettHinzu(kantenRichtung,
					aktiverDungeonController.getSpielbrett().getPositionKachel(aktuellePosition.getKachel()));
		}
		super.fertig();
	}
}
