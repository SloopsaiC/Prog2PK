package de.pk.model.spielbrett.spielbrettObjekte.container;

import de.pk.utils.Spielkonstanten;

public class Kiste extends Container
{
	public Kiste(int maximaleGroesse)
	{
		super(maximaleGroesse);
	}

	public Kiste()
	{
		super(Spielkonstanten.STANDARD_MAX_ANZAHL_INHALT_KISTE);
	}
	
}
