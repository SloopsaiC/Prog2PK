package de.pk.control.spiel.phasen;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.model.interaktion.Anzielbar;
import de.pk.model.position.KachelPosition;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektPunkteIndex;

public class HeldenPhase extends Phase
{
	public HeldenPhase()
	{
		super();
	}

	private void beendePhaseFallsHeldKeineAktionsPunkte(Held held)
	{
		held.hatAktionAusgefuehrt();
		if (held.getAnzahlPunkteVon(LebendigesObjektPunkteIndex.AKTIONS_PUNKTE) < 1)
		{
			super.beendePhase();
		}
	}

	@Override
	public void startePhaseMit(Held held)
	{
		super.startePhaseMit(held);
	}

	@Override
	public void verarbeiteKlickAufKachelPosition(KachelPosition position, int aktiveAktionIndex)
	{
		Held aktiverHeld = super.getAktivenHeld();
		Anzielbar ziel = (LebendigesObjekt) position.getKachel()
				.getSpielbrettObjektBei(position.getPositionAufDerKachel());
		if (ziel == null)
		{
			// Es steht kein Objekt auf der Position, also ist sie selber das Ziel
			ziel = position;
		}
		aktiverHeld.getAktionMitNamen(aktiverHeld.getAktionsNamen().get(aktiveAktionIndex)).fuehreAus(aktiverHeld,
				ziel);
		this.beendePhaseFallsHeldKeineAktionsPunkte(aktiverHeld);
	}

}
