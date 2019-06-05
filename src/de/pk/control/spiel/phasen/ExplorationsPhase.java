package de.pk.control.spiel.phasen;

import de.pk.control.app.Anwendung;
import de.pk.control.spiel.Dungeon;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.KachelPosition;

public class ExplorationsPhase extends Phase
{

	@Override
	public void startePhaseMit(Held held)
	{
		Dungeon aktiverDungeon = Anwendung.getInstanz().getAktivesSpiel().getAktiverDungeon();
		KachelPosition positionDesHelden = aktiverDungeon.getSpielbrett().findeSpielbrettObjekt(held);
		Richtung kantenRichtung = positionDesHelden.getKantenRichtungFallsAnKante();
		// Generiere eine neue Kachel falls der Held am Rand steht
		if (kantenRichtung != null && aktiverDungeon.getSpielbrett().getKachelBei(aktiverDungeon.getSpielbrett()
				.getPositionKachel(positionDesHelden.getKachel()).addiere(kantenRichtung.getVersatz())) == null)
		{
			aktiverDungeon.generiereUndFuegeNeueKachelZuSpielbrettHinzu(kantenRichtung,
					aktiverDungeon.getSpielbrett().getPositionKachel(positionDesHelden.getKachel()));
		}
		super.beendePhase();
	}

}
