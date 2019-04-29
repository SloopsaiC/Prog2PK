package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte;

import de.pk.model.interaktion.Aktion;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class HeldController extends LebendigesObjektController
{
	private Held modell = (Held) super.getModell();

	public HeldController(String name, int lebensPunkte, int bewegungsPunkte, Aktion... aktionen)
	{
		super(new Held(name, lebensPunkte, bewegungsPunkte));
	}

}
