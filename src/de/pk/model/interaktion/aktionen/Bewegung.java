package de.pk.model.interaktion.aktionen;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.model.interaktion.Anzielbar;
import de.pk.model.position.KachelPosition;

public class Bewegung extends Aktion
{

	public Bewegung(int reichweite)
	{
		super(1f, reichweite);
	}

	@Override
	public void fuehreAus(LebendigesObjekt wirker, Anzielbar... ziele)
	{
		
	}

}
