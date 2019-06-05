package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.gegner;

import de.pk.model.position.KachelPosition;
import de.pk.model.spielbrett.Spielbrett;

public interface GegnerStrategie
{
	public void naechsterSchritt(Spielbrett spielbrett, KachelPosition eigenePosition);
}
