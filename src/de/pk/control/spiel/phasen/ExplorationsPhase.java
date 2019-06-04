package de.pk.control.spiel.phasen;

import de.pk.control.app.Anwendung;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.karte.generator.Richtung;

public class ExplorationsPhase extends Phase
{

	@Override
	public void startePhaseMit(Held held)
	{
		Richtung kantenRichtung = Anwendung.getInstanz().getAktivesSpiel().getAktiverDungeon().getSpielbrett()
				.findeSpielbrettObjekt(held).getKantenRichtungFallsAnKante();
		if (kantenRichtung != null)
		{
			
		}
	}

}
