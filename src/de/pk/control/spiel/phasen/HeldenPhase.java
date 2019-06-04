package de.pk.control.spiel.phasen;

import de.pk.control.app.Anwendung;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.position.KachelPosition;
import javafx.scene.input.MouseEvent;

public class HeldenPhase extends Phase
{
	public HeldenPhase()
	{
		super();
	}

	@Override
	public void verarbeiteKlickAufKachelPosition(KachelPosition position, int aktiveAktionIndex)
	{
		//
	}

	@Override
	public void startePhaseMit(Held held)
	{
		super.startePhaseMit(held);
	}

}
